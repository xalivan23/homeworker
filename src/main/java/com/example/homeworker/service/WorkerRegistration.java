package com.example.homeworker.service;

import com.example.homeworker.buttons.Buttons;
import com.example.homeworker.buttons.Messages;
import com.example.homeworker.buttons.Positions;
import com.example.homeworker.buttons.WorkerButtons;
import com.example.homeworker.model.Worker;
import com.example.homeworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.homeworker.buttons.Utilities.getButtons;
import static com.example.homeworker.buttons.Utilities.getMessage;

@Component
public class WorkerRegistration {
    @Autowired
    private WorkerRepository workerRegistration;
    @Autowired
    private WorkerButtons workerButtons;
    @Autowired
    private MineService mineService;


    public void registration(Worker worker, long chatId, String messageText, Update update) {
        if (worker.getPosition().equals(Positions.WORKER_REGISTRATION)) {
            if (checkMessageAndButtons(worker, messageText, Buttons.MINE_WORKER)) {
                mineService.sendMessage(chatId, getMessage(Messages.MINE_WORKER_REGISTRATION), workerButtons.registration());
            } else if (checkMessageAndButtons(worker, messageText, Buttons.WORKER_REGISTRATION_NAME)) {
                saveAndSendAnswer(worker, chatId, Messages.WORKER_REGISTRATION_NAME, Buttons.WORKER_REGISTRATION_NAME);
            } else if (checkMessageAndButtons(worker, messageText, Buttons.WORKER_REGISTRATION_PHONE)) {
                saveAndSendAnswer(worker, chatId, Messages.WORKER_REGISTRATION_PHONE, Buttons.WORKER_REGISTRATION_PHONE);
            } else if (checkMessageAndButtons(worker, messageText, Buttons.WORKER_REGISTRATION_LOCATION)) {
                saveAndSendAnswer(worker, chatId, Messages.WORKER_REGISTRATION_LOCATION, Buttons.WORKER_REGISTRATION_LOCATION);
            } else if (checkMessageAndButtons(worker, messageText, Buttons.WORKER_REGISTRATION_WORKS)) {
                saveAndSendAnswer(worker, chatId, Messages.WORKER_REGISTRATION_WORKS, Buttons.WORKER_REGISTRATION_WORKS);
            }
        }  else if (!messageText.isEmpty()) { //save to data
            if (worker.getButtons().equals(Buttons.WORKER_REGISTRATION_NAME)) {
                worker.setUserName(messageText);
                saveData(worker, "Saved you name");
            } else if (worker.getButtons().equals(Buttons.WORKER_REGISTRATION_PHONE)) {
                worker.setPhone(messageText);
                saveData(worker, "Saved you phone");
            }
        }
    }

    private void saveData(Worker worker, String answer) {
        workerRegistration.save(worker);
        mineService.sendMessage(worker.getChatId(), answer, workerButtons.registration());
        checkOrIsRegistry(worker);
    }

    private boolean checkMessageAndButtons(Worker worker, String messageText, Buttons buttons) {
        return worker.getPosition().equals(Positions.WORKER_REGISTRATION)
                && messageText.equals(getButtons(buttons));
    }

    private void saveAndSendAnswer(Worker worker, long chatId, Messages messages, Buttons buttons) {
        mineService.sendMessage(chatId, getMessage(messages), workerButtons.registration());
        worker.setButtons(buttons);
        workerRegistration.save(worker);
    }

    private void updatePosition(Worker worker, Positions positions) {
        worker.setPosition(positions);
        workerRegistration.save(worker);
    }

    private void checkOrIsRegistry(Worker worker) {
        if (!worker.getPhone().isEmpty()
                && !worker.getUserName().isEmpty()
                && !worker.getRegion().isEmpty()
                && !worker.getProfession().isEmpty()) {
            worker.setIsRegistry(true);
            workerRegistration.save(worker);
            mineService.sendMessage(worker.getChatId(), "Registration is done", workerButtons.registration());
        }
    }

//                WORKER_REGISTRATION_NAME("ВВедіть своє ім'я та прізвище"),
//                WORKER_REGISTRATION_PHONE("ВВедіть свій телефон у форматі *+380123456789* або домашній телефон"),
//                WORKER_REGISTRATION_LOCATION("Виберіть свій населений пункт"),
//                WORKER_REGISTRATION_WORKS("Виберіть послуги");
//        KeyboardRow firstRow = createTwoKeyboardRow(getButtons(Buttons.WORKER_REGISTRATION_NAME), getButtons(Buttons.WORKER_REGISTRATION_PHONE));
//        KeyboardRow secondRow = createTwoKeyboardRow(getButtons(Buttons.WORKER_REGISTRATION_LOCATION),getButtons(Buttons.WORKER_REGISTRATION_WORKS));
//        KeyboardRow threeRow = createOneKeyboardRow(getButtons(Buttons.MINE_MENU));

    //WORKER_REGISTRATION

//if (worker.getIsRegistry().equals(true)) {
//        System.out.println("Для зареєстрованих витягнути всі замовлення по його регіону і професії");
//
//    } else if (worker.getPosition().equals(Positions.WORKER_REGISTRATION) //mine message
//                && messageText.equals(getButtons(Buttons.MINE_WORKER))) {
//        mineService.sendMessage(chatId, getMessage(Messages.MINE_WORKER_REGISTRATION), workerButtons.registration());
//
//    } else if (worker.getPosition().equals(Positions.WORKER_REGISTRATION) //save name
//                && messageText.equals(getButtons(Buttons.WORKER_REGISTRATION_NAME))) {
//        mineService.sendMessage(chatId, getMessage(Messages.WORKER_REGISTRATION_NAME), workerButtons.registration());
//        worker.setButtons(Buttons.WORKER_REGISTRATION_NAME);
//        workerRegistration.save(worker);
//
//    } else if (messageText.equals(getButtons(Buttons.WORKER_REGISTRATION_PHONE)) //save phone
//            && worker.getPosition().equals(Positions.WORKER_REGISTRATION)) {
//        mineService.sendMessage(chatId, getMessage(Messages.WORKER_REGISTRATION_PHONE), workerButtons.registration());
//        worker.setButtons(Buttons.WORKER_REGISTRATION_PHONE);
//        workerRegistration.save(worker);
//
//    } else if (messageText.equals(getButtons(Buttons.WORKER_REGISTRATION_LOCATION))
//            && worker.getPosition().equals(Positions.WORKER_REGISTRATION)) {
//        mineService.sendMessage(chatId, getMessage(Messages.WORKER_REGISTRATION_LOCATION), workerButtons.registration());
//        worker.setButtons(Buttons.WORKER_REGISTRATION_LOCATION);
//        workerRegistration.save(worker);
//
//    } else if (messageText.equals(getButtons(Buttons.WORKER_REGISTRATION_WORKS))
//            && worker.getPosition().equals(Positions.WORKER_REGISTRATION)) {
//        mineService.sendMessage(chatId, getMessage(Messages.WORKER_REGISTRATION_WORKS), workerButtons.registration());
//        worker.setButtons(Buttons.WORKER_REGISTRATION_WORKS);
//        workerRegistration.save(worker);
//
//    } else if (!messageText.isEmpty()) { //save to data
//        if (worker.getButtons().equals(Buttons.WORKER_REGISTRATION_NAME)) {
//            worker.setUserName(messageText);
//            workerRegistration.save(worker);
//            mineService.sendMessage(chatId, "Saved you name", workerButtons.registration());
//            checkOrIsRegistry(worker);
//
//        } else if (worker.getButtons().equals(Buttons.WORKER_REGISTRATION_PHONE)) {
//            worker.setPhone(messageText);
//            workerRegistration.save(worker);
//            mineService.sendMessage(chatId, "Saved you phone", workerButtons.registration());
//            checkOrIsRegistry(worker);
//        }
//    }
}
