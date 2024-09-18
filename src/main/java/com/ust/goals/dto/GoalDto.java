package com.ust.goals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoalDto {
    private String name;
    private Double value;
    private String description;
    private String priority;
}
