package com.Fit.track.controller;

import com.Fit.track.Entity.WorkoutPlan;
import com.Fit.track.Entity.User;
import com.Fit.track.service.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workoutplans")
public class WorkoutPlanController {

    private final WorkoutPlanService workoutPlanService;

    @Autowired
    public WorkoutPlanController(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
    }

    // Endpoint to create a new workout plan
    @PostMapping
    public ResponseEntity<String> createWorkoutPlan(@RequestBody WorkoutPlan workoutPlan) {
        workoutPlanService.createWorkoutPlan(workoutPlan);
        return ResponseEntity.ok("Workout plan created successfully");
    }

    // Endpoint to get all workout plans of a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkoutPlan>> getWorkoutPlansByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);  // Simplified, ideally fetch the user from the database
        List<WorkoutPlan> workoutPlans = workoutPlanService.getWorkoutPlansByUser(user);
        return ResponseEntity.ok(workoutPlans);
    }

    // Endpoint to get all workout plans
    @GetMapping
    public ResponseEntity<List<WorkoutPlan>> getAllWorkoutPlans() {
        List<WorkoutPlan> workoutPlans = workoutPlanService.getAllWorkoutPlans();
        return ResponseEntity.ok(workoutPlans);
    }

    // Endpoint to get a workout plan by its ID
    @GetMapping("/{id}")
    public ResponseEntity<WorkoutPlan> getWorkoutPlanById(@PathVariable Long id) {
        WorkoutPlan workoutPlan = workoutPlanService.getWorkoutPlanById(id);
        if (workoutPlan != null) {
            return ResponseEntity.ok(workoutPlan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to update a workout plan
    @PutMapping("/{id}")
    public ResponseEntity<String> updateWorkoutPlan(@PathVariable Long id, @RequestBody WorkoutPlan updatedWorkoutPlan) {
        workoutPlanService.updateWorkoutPlan(id, updatedWorkoutPlan);
        return ResponseEntity.ok("Workout plan updated successfully");
    }

    // Endpoint to delete a workout plan
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkoutPlan(@PathVariable Long id) {
        workoutPlanService.deleteWorkoutPlan(id);
        return ResponseEntity.ok("Workout plan deleted successfully");
    }
}
