package com.example.homeworker.buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static com.example.homeworker.buttons.Utilities.getButtons;

@Component
public class UniversalButtons {

    public ReplyKeyboardMarkup mineMenu() {
        ReplyKeyboardMarkup keyboardMarkup = createKeyboardMarkup(true, true, true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow firstRow = new KeyboardRow();
        firstRow.add(getButtons(Buttons.MINE_USER));
        KeyboardRow secondRow = new KeyboardRow();
        secondRow.add(getButtons(Buttons.MINE_WORKER));
        keyboard.add(firstRow);
        keyboard.add(secondRow);
        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }

    private ReplyKeyboardMarkup createKeyboardMarkup(Boolean selective, Boolean resizeKeyboard, Boolean oneTimeKeyboard) {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setSelective(selective);
        markup.setResizeKeyboard(resizeKeyboard);
        markup.setOneTimeKeyboard(oneTimeKeyboard);
        return markup;
    }
}
