package com.example.homeworker.model;//package com.example.worker.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Entity
//@Table(name = "users")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
//    private Long userId; //unique  in program
//
//    @Column(name = "user_token")
//    private String userToken; //token of telegram
//
//    @Column(name = "user_name")
//    private String userName; //name
//
//    @Column(name = "rating")
//    private int rating;  //0-20 - 20%, 21-40 - 10%, 40-60 - 5%
//
//    @Column(name = "price")
//    private String price; //150
//
//    @Column(name = "email1")
//    private String email1;   //mai@mail.com
//
//    @Column(name = "email2")
//    private String email2;   //mai@mail.com
//
//    @Column(name = "phone1")
//    private String phone1;  //+380...
//
//    @Column(name = "phone2")
//    private String phone2;  //+380...
//
//    @Column(name = "phone3")
//    private String phone3;  //+380...
//
//    @Column(name = "description")
//    private String description; // information
//
//    @Column(name = "profession")
//    private String profession; //builder, electrician, plumber, tiler, manicurist
//
//    @Column(name = "region")
//    private String region; //Vinnitsa
//}
