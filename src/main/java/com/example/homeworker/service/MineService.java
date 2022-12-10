package com.example.homeworker.service;


import com.example.homeworker.buttons.*;
import com.example.homeworker.config.BotConfig;
import com.example.homeworker.model.Worker;
import com.example.homeworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

import static com.example.homeworker.buttons.Utilities.getButtons;
import static com.example.homeworker.buttons.Utilities.getMessage;

@Component
public class MineService extends TelegramLongPollingBot {
    private BotConfig botConfig;
    @Autowired
    private UniversalButtons universalButtons;
    @Autowired
    private WorkerButtons workerButtons;
    @Autowired
    private UserButtons userButtons;
    @Autowired
    private WorkerRegistration workerRegistration;
    @Autowired
    private WorkerRepository workerRepository;

    public MineService(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = getChatId(update);
            Worker worker = createUser(chatId);

            if (worker.getPosition() == null
                    || worker.getPosition().equals(Positions.MINE_MENU)
                    || messageText.equals(getButtons(Buttons.MINE_MENU))) {
                baseVisit(worker, messageText, chatId, update);

            } else if (worker.getPosition().equals(Positions.WORKER_REGISTRATION)) {
                updatePosition(worker, Positions.WORKER_REGISTRATION);
                workerRegistration.registration(worker, chatId, messageText, update);

            } else {
                sendMessage(chatId, "Вибачте даний запит не підтримується", universalButtons.mineMenu());
            }
        }
    }

    private void baseVisit(Worker worker, String messageText, long chatId, Update update) {
        if (messageText.equals("/start")) {
            sendMessage(chatId, getMessage(Messages.MINE_MESSAGE), universalButtons.mineMenu());
        } else if (messageText.equals(getButtons(Buttons.MINE_USER))) {
            updatePosition(worker, Positions.USER_REGISTRATION);
            sendMessage(chatId, getMessage(Messages.MINE_USER_REGISTRATION), userButtons.registration());
        } else if (messageText.equals(getButtons(Buttons.MINE_WORKER))) {
            updatePosition(worker, Positions.WORKER_REGISTRATION);
            workerRegistration.registration(worker, chatId, messageText, update);
        } else if (messageText.equals(getButtons(Buttons.MINE_MENU))) {
            updatePosition(worker, Positions.MINE_MENU);
            sendMessage(chatId, getMessage(Messages.REVERT_TO_MINE_MENU), universalButtons.mineMenu());
        }
    }

    private void updatePosition(Worker worker, Positions positions) {
        worker.setPosition(positions);
        workerRepository.save(worker);
    }

    private Worker createUser(long chatId) {
        Optional<Worker> byChatId = workerRepository.findByChatId(chatId);
        if (byChatId.isPresent()) {
            return byChatId.get();
        } else {
            Worker worker = new Worker();
            worker.setChatId(chatId);
            worker.setIsRegistry(false);
            workerRepository.save(worker);
            return worker;
        }
    }


    private long getChatId(Update update) {
        return update.getMessage().getChatId();
    }

    public void sendMessage(long chatId, String testToSend, ReplyKeyboardMarkup markup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(testToSend);
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
