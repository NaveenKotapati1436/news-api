package com.ust.goals.controller;

import com.ust.goals.dto.GoalDto;
import com.ust.goals.model.Goal;
import com.ust.goals.service.GoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goals")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping("/create")
    public ResponseEntity<Goal> createGoal(@RequestBody GoalDto goalDto) {
        Goal goal = goalService.createGoal(goalDto);
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Goal>> getAllGoals() {
        List<Goal> goals = goalService.getAllGoals();
        return ResponseEntity.ok(goals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Long id) {
        Goal goal = goalService.getGoalById(id);
        return ResponseEntity.ok(goal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long id) {
        goalService.deleteGoal(id);
        return ResponseEntity.noContent().build();
    }
}
