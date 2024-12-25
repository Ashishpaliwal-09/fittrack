package com.Fit.track.repository;

import com.Fit.track.Entity.WorkoutPlan;
import com.Fit.track.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {
    List<WorkoutPlan> findByUser(User user);
}
