package com.Fit.track.service;

import com.Fit.track.Entity.ActivityLog;
import com.Fit.track.Entity.User;

import java.util.List;

public interface ActivityLogService {
    void logActivity(ActivityLog activityLog);
    
    List<ActivityLog> getActivitiesByUser(User user);
    
    List<ActivityLog> getAllActivities();
}
