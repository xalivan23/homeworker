package com.example.homeworker.buttons;

import com.example.homeworker.config.BotConfig;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
    private BotConfig botConfig;

    public static String getButtons(Buttons buttons) {
        return buttons.getButton();
    }

    public static String getMessage(Messages message) {
        return message.getMessage();
    }

    public static KeyboardRow createOneKeyboardRow(String one) {
        KeyboardRow oneKeyboardRow = new KeyboardRow();
        oneKeyboardRow.add(one);
        return oneKeyboardRow;
    }

    public static KeyboardRow createTwoKeyboardRow(String one, String two) {
        KeyboardRow twoKeyboardRow = new KeyboardRow();
        twoKeyboardRow.add(one);
        twoKeyboardRow.add(two);
        return twoKeyboardRow;
    }

    public static List<KeyboardRow> createOneRowKeyboardList(KeyboardRow oneRow) {
        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(oneRow);
        return keyboard;
    }

    public static List<KeyboardRow> createTwoRowKeyboardList(KeyboardRow oneRow, KeyboardRow two) {
        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(oneRow);
        keyboard.add(two);
        return keyboard;
    }

    public static List<KeyboardRow> createThreeRowKeyboardList(KeyboardRow oneRow, KeyboardRow two, KeyboardRow three) {
        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(oneRow);
        keyboard.add(two);
        keyboard.add(three);
        return keyboard;
    }

    public static ReplyKeyboardMarkup createKeyboardMarkup() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setSelective(true);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(false);
        return markup;
    }


}
