package com.example.Reviewrave.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TrackedProductDto {
       
    @NotBlank
    public String name;

    @NotNull
    public  String category;

}
