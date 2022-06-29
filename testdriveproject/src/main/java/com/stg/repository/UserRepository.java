package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.stg.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public abstract User findByUserId(int userId);
	@Query(value = "SELECT * from user where user_name LIKE %?1%",nativeQuery = true)
	public abstract List<User> findByUserName(String userName);
}
