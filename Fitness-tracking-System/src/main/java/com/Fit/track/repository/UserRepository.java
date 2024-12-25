package com.Fit.track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fit.track.Entity.User;

@Repository
public  interface UserRepository extends JpaRepository<User,Long> {

}
