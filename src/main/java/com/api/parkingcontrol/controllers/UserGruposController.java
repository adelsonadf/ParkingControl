package com.api.parkingcontrol.controllers;
import com.api.parkingcontrol.dtos.UserGruposDto;
import com.api.parkingcontrol.models.UserGruposModel;
import com.api.parkingcontrol.models.UserModel;
import com.api.parkingcontrol.services.UserGruposService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/User_Grupo")
public class UserGruposController {

    final UserGruposService userGruposService;

    public UserGruposController(UserGruposService userGruposService) { this.userGruposService = userGruposService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUsuarioGrupo(@RequestBody @Valid UserGruposDto userGruposDto){
        if(userGruposService.existsByuserGrupoNome(userGruposDto.getUserGrupoNome())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: grupo is already in use!");
        }
        var userGruposModel = new UserGruposModel();
        BeanUtils.copyProperties(userGruposDto, userGruposModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(userGruposService.save(userGruposModel));
    }

    @GetMapping
    public ResponseEntity<Page<UserGruposModel>> getAllUserGrupos(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userGruposService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserGrupo(@PathVariable(value = "id") Long id){
        Optional<UserGruposModel> gruposModelOptional = userGruposService.findById(id);
        if (!gruposModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("grupo not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(gruposModelOptional.get());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserGrupos(@PathVariable(value = "id") Long id){
        Optional<UserGruposModel> gruposModelOptional = userGruposService.findById(id);
        if (!gruposModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("grupo not found.");
        }
        userGruposService.delete(gruposModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Grupo deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserGrupos(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid UserGruposDto userGruposDto){
        Optional<UserGruposModel> userGruposModelOptional = userGruposService.findById(id);
        if (!userGruposModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grupo not found.");
        }
        var userGruposModel = new UserGruposModel();
        BeanUtils.copyProperties(userGruposDto, userGruposModel);
        userGruposModel.setUserGrupoId(userGruposModelOptional.get().getUserGrupoId());
        return ResponseEntity.status(HttpStatus.OK).body(userGruposService.save(userGruposModel));
    }


}
