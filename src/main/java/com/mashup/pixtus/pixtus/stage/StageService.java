package com.mashup.pixtus.pixtus.stage;

import com.mashup.pixtus.pixtus.Exception.BadRequestException;
import org.springframework.stereotype.Service;

import com.mashup.pixtus.pixtus.stage.entity.Stage;

@Service
public class StageService {

	private StageRepository stageRepository;

	public StageService(StageRepository stageRepository) {
		this.stageRepository = stageRepository;
	}

	private static final int MIN_LEVEL = 1;
	private static final int MAX_LEVEL = 5;

	public Stage getStage(int level) {
		return stageRepository.findById(level).orElseThrow(() -> new BadRequestException("올바르지 않은 레벨입니다."));
	}

	public Stage getPrevStage(int presentLevel) {
		if (presentLevel > MIN_LEVEL) {
			return getStage(presentLevel - 1);
//			return stageRepository.findById(presentLevel - 1).orElseThrow(() -> new BadRequestException("올바르지 않은 레벨입니다."));
		}
		throw new BadRequestException("가장 낮은 레벨입니다.");
	}

	public Stage getNextStage(int presentLevel) {
		if (presentLevel < MAX_LEVEL) {
			return getStage(presentLevel + 1);
		}
		throw new BadRequestException("가장 높은 레벨입니다.");
	}
}
