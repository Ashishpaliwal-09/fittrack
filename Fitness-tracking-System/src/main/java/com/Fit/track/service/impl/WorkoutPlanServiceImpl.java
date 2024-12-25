package com.Fit.track.service.impl;

import com.Fit.track.Entity.WorkoutPlan;
import com.Fit.track.Entity.User;
import com.Fit.track.repository.WorkoutPlanRepository;
import com.Fit.track.service.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutPlanServiceImpl implements WorkoutPlanService {

    private final WorkoutPlanRepository workoutPlanRepository;

    @Autowired
    public WorkoutPlanServiceImpl(WorkoutPlanRepository workoutPlanRepository) {
        this.workoutPlanRepository = workoutPlanRepository;
    }

    @Override
    public void createWorkoutPlan(WorkoutPlan workoutPlan) {
        workoutPlanRepository.save(workoutPlan);
    }

    @Override
    public List<WorkoutPlan> getWorkoutPlansByUser(User user) {
        return workoutPlanRepository.findByUser(user);
    }

    @Override
    public List<WorkoutPlan> getAllWorkoutPlans() {
        return workoutPlanRepository.findAll();
    }

    @Override
    public WorkoutPlan getWorkoutPlanById(Long id) {
        Optional<WorkoutPlan> workoutPlan = workoutPlanRepository.findById(id);
        return workoutPlan.orElse(null);  // Return null if the plan is not found
    }

    @Override
    public void updateWorkoutPlan(Long id, WorkoutPlan updatedWorkoutPlan) {
        if (workoutPlanRepository.existsById(id)) {
            updatedWorkoutPlan.setId(id);
            workoutPlanRepository.save(updatedWorkoutPlan);
        }
    }

    @Override
    public void deleteWorkoutPlan(Long id) {
        if (workoutPlanRepository.existsById(id)) {
            workoutPlanRepository.deleteById(id);
        }
    }
}
