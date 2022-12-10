package com.example.homeworker.buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

import static com.example.homeworker.buttons.Utilities.*;

@Component
public class WorkerButtons {

    public ReplyKeyboardMarkup registration() {
        KeyboardRow firstRow = createTwoKeyboardRow(getButtons(Buttons.WORKER_REGISTRATION_NAME), getButtons(Buttons.WORKER_REGISTRATION_PHONE));
        KeyboardRow secondRow = createTwoKeyboardRow(getButtons(Buttons.WORKER_REGISTRATION_LOCATION),getButtons(Buttons.WORKER_REGISTRATION_WORKS));
        KeyboardRow threeRow = createOneKeyboardRow(getButtons(Buttons.MINE_MENU));

        List<KeyboardRow> threeRowKeyboardList = createThreeRowKeyboardList(firstRow, secondRow, threeRow);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboardMarkup();
        keyboardMarkup.setKeyboard(threeRowKeyboardList);
        return keyboardMarkup;
    }

}
