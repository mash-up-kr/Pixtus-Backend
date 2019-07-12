package com.mashup.pixtus.pixtus.service;

import com.mashup.pixtus.pixtus.entity.Stage;
import com.mashup.pixtus.pixtus.repository.StageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StageService {

    private StageRepository stageRepository;

    public StageService(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 5;

    @Transactional
    public Stage getStage(int level){
        return stageRepository.findById(level).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public Stage getPrevStage(int presentLevel){
        if(presentLevel > MIN_LEVEL){
            return stageRepository.findById(presentLevel - 1).get();
        }
        throw new RuntimeException();
    }

    @Transactional
    public Stage getNextStage(int presentLevel){
        if(presentLevel <= MAX_LEVEL){
            return stageRepository.findById(presentLevel + 1).get();
        }
        throw new RuntimeException();
    }
}
