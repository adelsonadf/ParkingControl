package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.UserGruposModel;
import com.api.parkingcontrol.repositories.UserGruposRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserGruposService {

    final UserGruposRepository userGruposRepository;


    public UserGruposService(UserGruposRepository userGruposRepository) {
        this.userGruposRepository = userGruposRepository;
    }


    @Transactional
    public UserGruposModel save(UserGruposModel userGruposModel) {
        return userGruposRepository.save(userGruposModel);
    }



    public boolean existsByuserGrupoNome(String userGrupoNome) {
        return userGruposRepository.existsByuserGrupoNome(userGrupoNome);
    }


    public Page<UserGruposModel> findAll(Pageable pageable) {
        return userGruposRepository.findAll(pageable);
    }

    public Optional<UserGruposModel> findById(UUID id) {
        return  userGruposRepository.findById(id);
    }

    @Transactional
    public void delete(UserGruposModel UserGruposModel) {
        userGruposRepository.delete(UserGruposModel);
    }


}
