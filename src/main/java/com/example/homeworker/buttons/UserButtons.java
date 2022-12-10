package com.example.homeworker.buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

import static com.example.homeworker.buttons.Utilities.*;
import static com.example.homeworker.buttons.Utilities.createKeyboardMarkup;

@Component
public class UserButtons {
    public ReplyKeyboardMarkup registration() {
        KeyboardRow firstRow = createTwoKeyboardRow(getButtons(Buttons.USER_REGISTRATION_NAME), getButtons(Buttons.USER_REGISTRATION_PHONE));
        KeyboardRow secondRow = createTwoKeyboardRow(getButtons(Buttons.USER_REGISTRATION_LOCATION), getButtons(Buttons.MINE_MENU));

        List<KeyboardRow> threeRowKeyboardList = createTwoRowKeyboardList(firstRow, secondRow);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboardMarkup();
        keyboardMarkup.setKeyboard(threeRowKeyboardList);
        return keyboardMarkup;
    }
}
