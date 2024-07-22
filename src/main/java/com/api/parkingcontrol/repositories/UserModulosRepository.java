package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.Entidades.Tb_usuarios_modulos;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserModulosRepository extends JpaRepository<Tb_usuarios_modulos, Long> {
    Tb_usuarios_modulos findByUserModuloNome(String userModuloNome);

}


