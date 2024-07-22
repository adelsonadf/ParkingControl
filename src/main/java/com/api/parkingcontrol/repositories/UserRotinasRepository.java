package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.Entidades.Tb_usuarios_Rotinas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRotinasRepository extends JpaRepository<Tb_usuarios_Rotinas, Long> {
    Tb_usuarios_Rotinas findByUserRotinaNome(String userRotinaNome);
}