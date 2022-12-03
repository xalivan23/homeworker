package com.example.homeworker.service;


import com.example.homeworker.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    private BotConfig botConfig;

    public TelegramBot(BotConfig botConfig) {
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

            long chatId = update.getMessage().getChatId();

            switch (messageText) {
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName(), replyKeyboardMarkup());
                    break;
                case "/menu":
                    startCommandReceived(chatId, "Good I sen you something", replyKeyboardMarkup2());
                    break;
                default:
                    sendMessage(chatId, "Sorry, command no used", replyKeyboardMarkup2());
            }
        }
    }

    private void startCommandReceived(long chatId, String name, ReplyKeyboardMarkup markup) {
        String answer = "Hi, " + name + ", nice to meet you!!!";
        sendMessage(chatId, answer, markup);
    }

    private void sendMessage(long chatId, String testToSend, ReplyKeyboardMarkup markup) {
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

    private ReplyKeyboardMarkup replyKeyboardMarkup() {
        // Создаем клавиатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add("Команда 1");
        keyboardFirstRow.add("Команда 2");

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add("Команда 3");
        keyboardSecondRow.add("Команда 4");

        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup replyKeyboardMarkup2() {
        // Создаем клавиатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(false);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add("Команда 5");
        keyboardFirstRow.add("Команда 6");

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add("Команда 7");
        keyboardSecondRow.add("Команда 8");

        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;

    }


    //    private ReplyKeyboardMarkup replyKeyboardMarkup() {
//        //Создаем объект будущей клавиатуры и выставляем нужные настройки
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//        replyKeyboardMarkup.setResizeKeyboard(true); //подгоняем размер
//        replyKeyboardMarkup.setOneTimeKeyboard(false); //скрываем после использования
//
//        //Создаем список с рядами кнопок
//        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();
//        //Создаем один ряд кнопок и добавляем его в список
//        KeyboardRow keyboardRow = new KeyboardRow();
//        keyboardRows.add(keyboardRow);
//        //Добавляем одну кнопку с текстом "Просвяти" наш ряд
//        keyboardRow.add(new KeyboardButton("GoGo"));
//        keyboardRow.add(new KeyboardButton("OooYes"));
//        keyboardRow.add(new KeyboardButton("OooYes"));
//        keyboardRow.add(new KeyboardButton("OooYes"));
//        keyboardRow.add(new KeyboardButton("OooYes"));
//        keyboardRow.add(new KeyboardButton("OooYes"));
//        //добавляем лист с одним рядом кнопок в главный объект
//        replyKeyboardMarkup.setKeyboard(keyboardRows);
//        return replyKeyboardMarkup;
//    }
}
