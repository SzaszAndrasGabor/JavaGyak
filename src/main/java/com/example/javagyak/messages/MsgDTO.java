package com.example.javagyak.messages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MsgDTO {
    private String userName;
    private String message;
    private String formattedDate;

    public MsgDTO(String userName, String message, LocalDateTime createdAt) {
        this.userName = userName;
        this.message = message;
        this.formattedDate = createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}