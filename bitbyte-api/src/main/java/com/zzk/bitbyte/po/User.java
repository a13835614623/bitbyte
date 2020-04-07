package com.zzk.bitbyte.po;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String userId;
    @NotBlank(message = "用户名不能为空!")
    private String userName;

    @NotBlank(message = "性别不能为空!")
    private String userSex;

    @Length(max = 11, min = 11, message = "手机号必须为11位!")
    private String userMobile;
    
    @NotNull(message = "用户生日不能为空!")
    @Past(message = "用户生日不合法!")
    private Date userBirthday;

    @NotBlank(message = "用户地址不能为空!")
    private String userAddress;

    @NotBlank(message = "密码不能为空!")
    @Length(min = 8, message = "密码长度不能少于8位!")
    private String userPassword;

    @Email(message = "用户邮箱格式不正确!")
    private String userEmail;

    private Integer userState;

    private Date createat;

    private Date updateat;

    private String userPic;

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Integer getUserState() {
        return userState;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public Date getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Date updateat) {
        this.updateat = updateat;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic == null ? null : userPic.trim();
    }
}