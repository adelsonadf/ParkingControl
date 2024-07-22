package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.UserModel2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository2 extends JpaRepository<UserModel2, UUID> {

    Optional<UserModel2> findByUsername(String username);

}
