/*
 * This class is for more informative response when no tours are found, 
 * we can create a custom response object that holds both a status and a message along with the list of tours. 
 * */

package com.example.models;

import java.util.List;

public class ApiResponse {
    private List<Tours> tours;
    private String message;

    public ApiResponse(List<Tours> tours, String message) {
        this.tours = tours;
        this.message = message;
    }

    // Getters and setters
    public List<Tours> getTours() {
        return tours;
    }

    public void setTours(List<Tours> tours) {
        this.tours = tours;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
