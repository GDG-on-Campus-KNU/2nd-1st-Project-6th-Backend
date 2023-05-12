package com.gathering.gdsc1stproject6th.service;

import com.gathering.gdsc1stproject6th.domain.User;
import com.gathering.gdsc1stproject6th.dto.UserDto;
import com.gathering.gdsc1stproject6th.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    // 사용자 등록
    public Long saveUser(UserDto userDto) {
        User user = userDto.toEntity();
        userRepository.save(user);
        return user.getUserId();
    }


}
