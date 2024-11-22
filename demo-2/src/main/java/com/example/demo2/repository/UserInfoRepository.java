package com.example.demo2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.Entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
	
	Optional<UserInfo> findByName (String username);
}
