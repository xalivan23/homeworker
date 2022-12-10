package com.example.homeworker.buttons;

public enum Messages {
    MINE_MESSAGE("Вітаємо Вас в сервісі з надання послуг з ремонту та будівництва"),
    MINE_WORKER_REGISTRATION("Для реєстрації в сервісі потрібно заповнити контактні дані, місце розташування та визначити послуги. Натисніть на кнопки меню для запонення потрібних полів"),
    MINE_USER_REGISTRATION("Для замовлення послуги потрібно пройти реєстрацію"),
    REVERT_TO_MINE_MENU("Виберіть потрібний пункт меню"),

    //WORKER_REGISTRATION
    WORKER_REGISTRATION_NAME("ВВедіть своє ім'я та прізвище"),
    WORKER_REGISTRATION_PHONE("ВВедіть свій телефон у форматі *+380123456789* або домашній телефон"),
    WORKER_REGISTRATION_LOCATION("Виберіть свій населений пункт"),
    WORKER_REGISTRATION_WORKS("Виберіть послуги");


    String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
