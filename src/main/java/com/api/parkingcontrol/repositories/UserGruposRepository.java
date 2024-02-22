package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.UserGruposModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserGruposRepository extends JpaRepository<UserGruposModel, UUID> {
    boolean existsByuserGrupoNome(String userGrupoNome);

}
