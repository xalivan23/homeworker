package com.example.homeworker.model;

import javax.persistence.Column;

public enum Profession {
    builder("Будівельник"),
    electrician("Електрик"),
    plumber("Опалення"),
    tiler("Водопровід і каналізація"),
    manicurist("Манікюр");
    String name;

    Profession(String name) {
        this.name = name;
    }


}
