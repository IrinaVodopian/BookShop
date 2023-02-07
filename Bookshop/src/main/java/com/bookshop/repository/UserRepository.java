package com.bookshop.repository;

import com.bookshop.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	UserEntity findByUserName(String name);
	void deleteByUserName(String name);
}
