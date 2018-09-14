package com.finalproject.FinalProject.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.finalproject.FinalProject.entity.User;

public interface LoginRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername (String username);
	Optional<User> findByPassword (String password);

	

}
