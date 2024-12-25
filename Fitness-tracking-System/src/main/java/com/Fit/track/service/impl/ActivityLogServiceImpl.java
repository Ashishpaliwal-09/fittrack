package com.Fit.track.service.impl;

import com.Fit.track.Entity.ActivityLog;
import com.Fit.track.Entity.User;
import com.Fit.track.repository.ActivityLogRepository;
import com.Fit.track.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    @Autowired
    public ActivityLogServiceImpl(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    @Override
    public void logActivity(ActivityLog activityLog) {
        activityLogRepository.save(activityLog);
    }

    @Override
    public List<ActivityLog> getActivitiesByUser(User user) {
        return activityLogRepository.findByUser(user);
    }

    @Override
    public List<ActivityLog> getAllActivities() {
        return activityLogRepository.findAll();
    }
}
