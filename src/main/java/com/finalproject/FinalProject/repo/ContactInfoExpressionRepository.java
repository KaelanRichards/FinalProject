package com.finalproject.FinalProject.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.FinalProject.entity.ContactInfoExpression;

public interface ContactInfoExpressionRepository extends JpaRepository<ContactInfoExpression, String> {
	
	Optional <ContactInfoExpression> findOne (String id);

}
