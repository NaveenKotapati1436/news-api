package com.ust.goals.service;

import com.ust.goals.dto.GoalDto;
import com.ust.goals.model.Goal;
import com.ust.goals.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public Goal createGoal(GoalDto goalDto) {
        Goal goal = new Goal();
        goal.setName(goalDto.getName());
        goal.setValue(goalDto.getValue());
        goal.setDescription(goalDto.getDescription());
        goal.setPriority(goalDto.getPriority());
        return goalRepository.save(goal);
    }

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public Goal getGoalById(Long id) {
        return goalRepository.findById(id).orElse(null);
    }

    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }
}
