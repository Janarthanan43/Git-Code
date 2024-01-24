package com.task.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.task.employee.model.UserInfo;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<UserInfo, Integer>  {
	Optional<UserInfo> findByUsername(String username);
	
	@Query(value="select new com.task.employee.model.UserInfo(u.id, u.username, u.password, u.role) from UserInfo u where u.username= ?1 and u.password= ?2")
	public List<UserInfo> validateEmployee(@Param("username") String username, @Param("password") String password);
	
}
