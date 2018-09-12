package com.finalproject.FinalProject.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.FinalProject.entity.LoginUser;

public interface LoginRepository extends JpaRepository<LoginUser, Long>{
	List<LoginUser> findByUsername (String username);
	List<LoginUser> findByPassword (String password);

	

}
