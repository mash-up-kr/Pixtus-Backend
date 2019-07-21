package com.mashup.pixtus.pixtus.stage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mashup.pixtus.pixtus.stage.entity.Stage;

@Repository
public interface StageRepository extends JpaRepository<Stage, Integer> {

}
