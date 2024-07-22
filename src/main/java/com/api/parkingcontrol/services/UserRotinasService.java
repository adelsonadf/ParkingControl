package com.api.parkingcontrol.services;

import com.api.parkingcontrol.Entidades.Tb_usuarios_Rotinas;
import com.api.parkingcontrol.dtos.UserRotinasDto;
import com.api.parkingcontrol.repositories.UserRotinasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRotinasService {
    @Autowired
    private UserRotinasRepository userRotinasRepository;

    public UserRotinasDto salvarUserRotina(UserRotinasDto userRotinasDto) {
        // Verificar se a rotina já existe pelo nome (ou outro campo único)
        Tb_usuarios_Rotinas rotinaExistente = userRotinasRepository.findByUserRotinaNome(userRotinasDto.getUserRotinaNome());
        if (rotinaExistente != null) {
            // Produto já existe, não fazer nada ou lançar uma exceção
            return null;
        }

        // Converter DTO para entidade
        Tb_usuarios_Rotinas tb_usuarios_Rotinas = new Tb_usuarios_Rotinas();
        tb_usuarios_Rotinas.setUserRotinaNome(userRotinasDto.getUserRotinaNome());
        tb_usuarios_Rotinas.setUserRotinaDireitos(userRotinasDto.getUserRotinaDireitos());
        tb_usuarios_Rotinas.setUserModulo_id(userRotinasDto.getId_modulo());

        // Salvar a entidade
        Tb_usuarios_Rotinas savedTb_usuarios_Rotinas = userRotinasRepository.save(tb_usuarios_Rotinas);

        // Converter entidade salva de volta para DTO
        UserRotinasDto savedUserRotinasDto = new UserRotinasDto();
        savedUserRotinasDto.setId(savedUserRotinasDto.getId());
        savedUserRotinasDto.setUserRotinaNome(savedUserRotinasDto.getUserRotinaNome());
        savedUserRotinasDto.setUserRotinaDireitos(savedUserRotinasDto.getUserRotinaDireitos());
        savedUserRotinasDto.setId_modulo(savedUserRotinasDto.getId_modulo());
        return savedUserRotinasDto;
    }

    public List<UserRotinasDto> listarRotinas() {
        return userRotinasRepository.findAll().stream().map(tb_usuarios_Rotinas -> {
            UserRotinasDto userRotinasDto = new UserRotinasDto();
            userRotinasDto.setId(tb_usuarios_Rotinas.getId());
            userRotinasDto.setUserRotinaNome(tb_usuarios_Rotinas.getUserRotinaNome());
            userRotinasDto.setUserRotinaDireitos(tb_usuarios_Rotinas.getUserRotinaDireitos());
            userRotinasDto.setId_modulo(tb_usuarios_Rotinas.getUserModulo_id());
            return userRotinasDto;
        }).collect(Collectors.toList());
    }


}
