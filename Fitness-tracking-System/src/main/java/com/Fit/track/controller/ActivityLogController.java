package com.Fit.track.controller;

import com.Fit.track.Entity.ActivityLog;
import com.Fit.track.Entity.User;
import com.Fit.track.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activitylogs")
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    @Autowired
    public ActivityLogController(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    // Endpoint to log a new activity
    @PostMapping("/log")
    public ResponseEntity<String> logActivity(@RequestBody ActivityLog activityLog) {
        activityLogService.logActivity(activityLog);
        return ResponseEntity.ok("Activity logged successfully");
    }

    // Endpoint to get all activities of a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ActivityLog>> getActivitiesByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId); // In real case, you might fetch the User from the DB
        List<ActivityLog> activities = activityLogService.getActivitiesByUser(user);
        return ResponseEntity.ok(activities);
    }

    // Endpoint to get all activities
    @GetMapping
    public ResponseEntity<List<ActivityLog>> getAllActivities() {
        List<ActivityLog> activities = activityLogService.getAllActivities();
        return ResponseEntity.ok(activities);
    }
}
