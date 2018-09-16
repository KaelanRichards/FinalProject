package com.finalproject.FinalProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.FinalProject.entity.Favorite;
import com.finalproject.FinalProject.entity.User;

public interface FavoriteRepo extends JpaRepository <Favorite, Long> {
	
	List<Favorite> findByUser (User user);
	//List<Favorite> findById (Favorite favid);

}
