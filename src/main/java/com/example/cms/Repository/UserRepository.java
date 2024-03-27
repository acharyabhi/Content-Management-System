package com.example.cms.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cms.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	boolean existsByEmail(String email);
	
	Optional<User> findByEmail(String email);

}
