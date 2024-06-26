package com.ritik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ritik.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
}
