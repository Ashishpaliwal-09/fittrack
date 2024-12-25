package com.Fit.track.service;

import com.Fit.track.Entity.WorkoutPlan;
import com.Fit.track.Entity.User;

import java.util.List;

public interface WorkoutPlanService {
	
    void createWorkoutPlan(WorkoutPlan workoutPlan);
    
    List<WorkoutPlan> getWorkoutPlansByUser(User user);
    
    List<WorkoutPlan> getAllWorkoutPlans();
    
    WorkoutPlan getWorkoutPlanById(Long id);
    
    void updateWorkoutPlan(Long id, WorkoutPlan updatedWorkoutPlan);
    
    void deleteWorkoutPlan(Long id);
}
