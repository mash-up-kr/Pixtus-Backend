package com.mashup.pixtus.pixtus.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mashup.pixtus.pixtus.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
