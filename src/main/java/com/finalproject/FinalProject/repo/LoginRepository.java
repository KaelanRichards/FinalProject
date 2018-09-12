package com.finalproject.FinalProject.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.FinalProject.entity.LoginUser;

public interface LoginRepository extends JpaRepository<LoginUser, Long>{
	Optional<LoginUser> findByUsername (String username);
	Optional<LoginUser> findByPassword (String password);

	

}
