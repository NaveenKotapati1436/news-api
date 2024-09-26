package com.ust.goals.service;

import com.ust.goals.dto.GoalDto;
import com.ust.goals.exceptions.GoalNotFoundException;
import com.ust.goals.exceptions.GoalServiceException;
import com.ust.goals.model.Goal;
import com.ust.goals.repository.GoalRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class GoalService {

    private static final Logger logger = LoggerFactory.getLogger(GoalService.class);
    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public Goal createGoal(GoalDto goalDto) {
        try {
            Goal goal = new Goal();
            goal.setName(goalDto.getName());
            goal.setValue(goalDto.getValue());
            goal.setDescription(goalDto.getDescription());
            goal.setPriority(goalDto.getPriority());
            goal.setDurationInMonths(goalDto.getDurationInMonths());
            return goalRepository.save(goal);
        } catch (Exception e) {
            logger.error("Error creating goal", e);
            throw new GoalServiceException("Failed to create goal", e);
        }
    }

//    public Goal createGoal(GoalDto goalDto) {
//        try {
//            Goal goal = new Goal();
//            goal.setName(goalDto.getName());
//            goal.setValue(goalDto.getValue());
//            goal.setDescription(goalDto.getDescription());
//            goal.setPriority(goalDto.getPriority());
//            goal.setDurationInMonths(goalDto.getDurationInMonths());
//            return goalRepository.save(goal);
//        } catch (Exception e) {
//            logger.error("Error creating goal: ", e);
//            throw new GoalServiceException("Failed to create goal", e);
//        }
//    }

//    public List<Goal> getAllGoals() {
//        return goalRepository.findAll();
//    }

    public List<Goal> getAllGoals() {
        try {
            List<Goal> goals = goalRepository.findAll();
            logger.info("Successfully fetched all goals, count: {}", goals.size());
            return goals;
        } catch (Exception e) {
            logger.error("Error occurred while fetching goals", e);
            throw new GoalServiceException("Failed to fetch goals", e);
        }
    }

    public Goal getGoalById(Long goalId) {
        return goalRepository.findById(goalId)
                .orElseThrow(() -> {
                    logger.error("Goal not found with id: {}", goalId);
                    return new GoalNotFoundException("Goal not found with id: " + goalId);
                });
    }

    public void deleteGoal(Long goalId) {
        if (!goalRepository.existsById(goalId)) {
            logger.error("Goal not found with id: {}", goalId);
            throw new GoalNotFoundException("Goal not found with id: " + goalId);
        }
        goalRepository.deleteById(goalId);
    }
}




//
//@Service
//public class GoalService {
//
//    private static final Logger logger = LoggerFactory.getLogger(GoalService.class);
//    private final GoalRepository goalRepository;
//
//    public GoalService(GoalRepository goalRepository) {
//        this.goalRepository = goalRepository;
//    }
//
//    public Goal createGoal(GoalDto goalDto) {
//        try {
//            Goal goal = new Goal();
//            goal.setName(goalDto.getName());
//            goal.setValue(goalDto.getValue());
//            goal.setDescription(goalDto.getDescription());
//            goal.setPriority(goalDto.getPriority());
//            goal.setDurationInMonths(goalDto.getDurationInMonths());
//            return goalRepository.save(goal);
//        } catch (Exception e) {
//            logger.error("Error creating goal: ", e);
//            throw new GoalServiceException("Failed to create goal", e);
//        }
//    }
//
//    public List<Goal> getAllGoals() {
//        return goalRepository.findAll();
//    }
//
//    public Goal getGoalById(Long id) {
//        return goalRepository.findById(id)
//                .orElseThrow(() -> {
//                    logger.error("Goal not found with id: {}", id);
//                    return new GoalNotFoundException("Goal not found with id: " + id);
//                });
//    }
//
//    public void deleteGoal(Long id) {
//        if (!goalRepository.existsById(id)) {
//            logger.error("Goal not found with id: {}", id);
//            throw new GoalNotFoundException("Goal not found with id: " + id);
//        }
//        goalRepository.deleteById(id);
//    }
//}
