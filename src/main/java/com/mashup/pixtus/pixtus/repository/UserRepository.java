package com.mashup.pixtus.pixtus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mashup.pixtus.pixtus.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
