package com.rajabmammadli.rockit.Models;

public class User {

    String userId;
    String userEmail;
    String userFirstName;
    String userLastName;
    String userAge;
    String userCity;
    String userState;
    String userZip;
    boolean userEmailVerified;
    String userRegistrationDate;
    String userVerificationCode;
    String userPhone;
    String userCountry;
    String userAddress;
    String userName;
    String userImageUrl;

    public User() {
    }

    public User(String userId, String userEmail, String userFirstName, String userLastName, String userAge, String userCity, String userState, String userZip,
                boolean userEmailVerified, String userRegistrationDate, String userVerificationCode, String userPhone, String userCountry, String userAddress, String userName, String userImageUrl) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAge = userAge;
        this.userCity = userCity;
        this.userState = userState;
        this.userZip = userZip;
        this.userEmailVerified = userEmailVerified;
        this.userRegistrationDate = userRegistrationDate;
        this.userVerificationCode = userVerificationCode;
        this.userPhone = userPhone;
        this.userCountry = userCountry;
        this.userAddress = userAddress;
        this.userName = userName;
        this.userImageUrl = userImageUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserZip() {
        return userZip;
    }

    public void setUserZip(String userZip) {
        this.userZip = userZip;
    }

    public boolean isUserEmailVerified() {
        return userEmailVerified;
    }

    public void setUserEmailVerified(boolean userEmailVerified) {
        this.userEmailVerified = userEmailVerified;
    }

    public String getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(String userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

    public String getUserVerificationCode() {
        return userVerificationCode;
    }

    public void setUserVerificationCode(String userVerificationCode) {
        this.userVerificationCode = userVerificationCode;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }
}
