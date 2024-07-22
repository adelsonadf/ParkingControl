package com.api.parkingcontrol.controllers;
import com.api.parkingcontrol.dtos.UserDto;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

//@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin("*")


@RequestMapping("/User_Grupo")
@RestController
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<Page<UserGruposModel>> getAllUserGrupos(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userGruposService.findAll(pageable));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
        Optional<UserGruposModel> userGruposModelOptional = userGruposService.findById(id);
        if (!userGruposModelOptional.isPresent()) {
            System.out.println("PASSEI AQUI TAMBÉM");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grupo não localizado !");
        }
        userGruposService.delete(userGruposModelOptional.get());
        System.out.println("PASSEIAQUI");
        return ResponseEntity.status(HttpStatus.OK).body("Grupo excluido com sucesso !");
    }



    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserGrupos(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid UserGruposDto userGruposDto){
        Optional<UserGruposModel> userGruposModelOptional = userGruposService.findById(id);
        if (!userGruposModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grupo not found.");
        }
        /*var userGruposModel =  new UserGruposModel(); */
        var userGruposModel =  userGruposModelOptional.get();
        BeanUtils.copyProperties(userGruposDto, userGruposModel);
        /*userGruposModel.setUserGrupoId(userGruposModelOptional.get().getUserGrupoId()); */
        return ResponseEntity.status(HttpStatus.OK).body(userGruposService.save(userGruposModel));
    }



}
