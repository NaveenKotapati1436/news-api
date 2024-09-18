package com.ust.goals.model;


import com.ust.goals.model.Priority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double value;
    private String description;
    @Enumerated(EnumType.STRING)
    private Priority priority; // Low, Medium, High
    private Integer durationInMonths;
}

