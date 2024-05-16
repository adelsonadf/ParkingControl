package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.UserModel;
import com.api.parkingcontrol.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository parkingSpotRepository2) {
        this.userRepository = parkingSpotRepository2;
    }

    @Transactional
    public UserModel save(UserModel parkingSpotModel2) {
        return userRepository.save(parkingSpotModel2);
    }

    public boolean existsByUserEmail(String userEmail) {
        return userRepository.existsByUserEmail(userEmail);
    }

    public boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }


    public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Optional<UserModel> findById(Long id) {
        return  userRepository.findById(id);
    }

    @Transactional
    public void delete(UserModel parkingSpotModel2) {
        userRepository.delete(parkingSpotModel2);
    }
}
