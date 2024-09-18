package com.ust.goals.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoalDto {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Value cannot be null")
    private Double value;

    private String description;

    @NotBlank(message = "Priority cannot be blank")
    private String priority; // Consider using an enum for priority

    private Integer durationInMonths;
}