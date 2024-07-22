package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.UserGruposModel;
import com.api.parkingcontrol.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserGruposRepository extends JpaRepository<UserGruposModel, UUID> {
    boolean existsByUserGrupoNome(String userGrupoNome);
    Optional<UserGruposModel> findById(Long id);
    Optional<UserGruposModel> findByUserGrupoNome(String userGrupoNome);
}
