package com.mashup.pixtus.pixtus.service;

import org.springframework.stereotype.Service;

import com.mashup.pixtus.pixtus.dto.UserSignUpRequest;
import com.mashup.pixtus.pixtus.entity.Stage;
import com.mashup.pixtus.pixtus.entity.User;
import com.mashup.pixtus.pixtus.repository.StageRepository;
import com.mashup.pixtus.pixtus.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private StageRepository stageRepository;

	private static final int SIGN_UP_LEVEL = 1;

	public UserService(UserRepository userRepository, StageRepository stageRepository) {
		this.userRepository = userRepository;
		this.stageRepository = stageRepository;
	}

	public boolean isExisted(String uid) {
		return userRepository.findById(uid).isPresent();
	}

	public void signUp(UserSignUpRequest requestBody) {
		// TODO 이미 회원일 경우 예외 추가하기
		if (isExisted(requestBody.getUid()))
			throw new RuntimeException();

		User user = User.from(requestBody);

		Stage stage = stageRepository.findById(SIGN_UP_LEVEL).get();
		user.setLevel(stage);

		userRepository.save(user);
	}

	public User get(String uid) {
		// TODO 유저 없을 때 예외 추가
		return userRepository.findById(uid).orElseThrow(RuntimeException::new);
	}

}
