package com.Fit.track.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fit.track.Entity.ActivityLog;
import com.Fit.track.Entity.User;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

	List<ActivityLog> findByUser(User user);

	
}
