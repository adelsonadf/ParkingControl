package com.api.parkingcontrol.services;

import com.api.parkingcontrol.Entidades.Tb_usuarios_modulos;
import com.api.parkingcontrol.dtos.UserModulosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.parkingcontrol.repositories.UserModulosRepository;
    @Service
    public class UserModulosService {
        @Autowired
        private UserModulosRepository userModulosRepository;

        public UserModulosDto salvartb_usuarios_modulos(UserModulosDto userModulosDto) {
            Tb_usuarios_modulos tb_usuarios_modulosExistente = userModulosRepository.findByUserModuloNome(userModulosDto.getUserModuloNome());
            if (tb_usuarios_modulosExistente != null) {
                // Produto já existe, não fazer nada ou lançar uma exceção
                return null;
            }


            // Converter DTO para entidade
            Tb_usuarios_modulos tb_usuarios_modulos = new Tb_usuarios_modulos();
            tb_usuarios_modulos.setUserModuloNome(userModulosDto.getUserModuloNome());

            // Salvar a entidade
            Tb_usuarios_modulos savedtb_usuarios_modulos = userModulosRepository.save(tb_usuarios_modulos);

            // Converter entidade salva de volta para DTO
            UserModulosDto savedUserModulosDto = new UserModulosDto();
            savedUserModulosDto.setId(savedUserModulosDto.getId());
            savedUserModulosDto.setUserModuloNome(savedUserModulosDto.getUserModuloNome());
            return savedUserModulosDto;
        }
    }

