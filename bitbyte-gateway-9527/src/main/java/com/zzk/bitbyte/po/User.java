package com.zzk.bitbyte.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String userId;

    private String userName;

    private String userMobile;

    private String userPassword;

    private String userEmail;

    private String userPic;

    private Integer userState;
}