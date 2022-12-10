package com.example.homeworker.model;

import com.example.homeworker.buttons.Buttons;
import com.example.homeworker.buttons.Positions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId; //unique  in program

    @Column(name = "chat_id")
    private Long chatId; //chatId User of telegram

    @Column(name = "user_name")
    private String userName; //name

    @Column(name = "rating")
    private int rating;  //0-30 - 20% START, 31-70 - 10% PROFESSIONAL, 71-100 - 5% EXPERT

    @Column(name = "price")
    private String price; //150

    @Column(name = "email")
    private String email;   //mai@mail.com

    @Column(name = "phone")
    private String phone;  //+380...

    @Column(name = "description")
    private String description; // information

    @Column(name = "status")
    private String status; //worker or consumer

    @Column(name = "region")
    private String region; // область

    @Column(name = "district")
    private String district; // район

    @Column(name = "village")
    private String village; // населений пункт

    @Column(name = "is_registry")
    private Boolean isRegistry; //if user registry send all information - true

    @Column(name = "position")
    private Positions position; //in service

    @Column(name = "buttons")
    private Buttons buttons; //position on button

    @Column(name = "profession")
    private String profession; //profession of Worker
}
