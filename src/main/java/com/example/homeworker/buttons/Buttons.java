package com.example.homeworker.buttons;

public enum Buttons {
    //MINE
    MINE_USER("Замовити майстра (користувачі)"), //0
    MINE_WORKER("Виконати роботу (майстри)"), //1
    MINE_MENU("Основне меню"), //2

    //WORKER_REGISTRATION
    WORKER_REGISTRATION_NAME("ВВести ім'я"), //3
    WORKER_REGISTRATION_PHONE("ВВести телефон"),  //4
    WORKER_REGISTRATION_LOCATION("ВВести населений пункт"), //5
    WORKER_REGISTRATION_WORKS("ВВести роботи"), //6

    //USER_REGISTRATION
    USER_REGISTRATION_NAME("ВВести ім'я"), //7
    USER_REGISTRATION_PHONE("ВВести телефон"), //8
    USER_REGISTRATION_LOCATION("ВВести населений пункт"); //9

    String button;

    Buttons(String button) {
        this.button = button;
    }

    public String getButton() {
        return button;
    }
}
