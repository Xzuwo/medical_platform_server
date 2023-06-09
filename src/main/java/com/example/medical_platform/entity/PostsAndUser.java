package com.example.medical_platform.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class PostsAndUser {
    private Integer postsId;

    private Integer userid;

    private String username;

    private String name;

    private String gender;

    private LocalDate birthdate;

    private String medicationHistory;

    private String introduction;

    private String headImage;

//    posts


    private String content;

    private LocalDateTime publishTime;

    private boolean followState;

    private boolean SocialRelationshipsState;

    private int likeCount;

    private int commentCount;

    private boolean likeState;

    private int userRole;

    private String a;

    private String b;

    public void setUser(Users user) {
        userid=user.getId();
        username=user.getUsername();
        name=user.getName();
        gender=user.getGender();
        birthdate=user.getBirthdate();
        medicationHistory=user.getMedicationHistory();
        introduction=user.getIntroduction();
        headImage=user.getHeadImage();

    }
}
