package com.generalsuggestions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generalsuggestions.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
