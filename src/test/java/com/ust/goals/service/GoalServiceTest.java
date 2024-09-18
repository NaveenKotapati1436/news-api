package com.ust.goals.service;

import com.ust.goals.dto.GoalDto;
import com.ust.goals.exceptions.GoalNotFoundException;
import com.ust.goals.exceptions.GoalServiceException;
import com.ust.goals.model.Goal;
import com.ust.goals.repository.GoalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class GoalServiceTest {

    @Mock
    private GoalRepository goalRepository;

    @InjectMocks
    private GoalService goalService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetGoalByIdThrowsGoalNotFoundException() {
        Long id = 1L;
        when(goalRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(GoalNotFoundException.class, () -> goalService.getGoalById(id));
    }

    @Test
    public void testSaveGoalThrowsGoalServiceException() {
        GoalDto goalDto = new GoalDto();
        when(goalRepository.save(new Goal())).thenThrow(new RuntimeException("Database error"));

        assertThrows(GoalServiceException.class, () -> goalService.createGoal(goalDto));
    }
}