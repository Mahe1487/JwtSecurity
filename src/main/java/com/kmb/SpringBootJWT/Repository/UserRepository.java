package com.kmb.SpringBootJWT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmb.SpringBootJWT.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
