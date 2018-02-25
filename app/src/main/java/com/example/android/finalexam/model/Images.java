package com.example.android.finalexam.model;

import java.util.List;

/**
 * Created by TatianaM on 2/25/18.
 */

public class Images {
    private String status;
    private List<Message> message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
