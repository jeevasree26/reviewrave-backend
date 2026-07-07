package com.example.Reviewrave.Dto;

public class ResolutionRequestDto {

    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ResolutionRequestDto(){
        
    }

    public ResolutionRequestDto(String notes) {
        this.notes = notes;
    }

    
}