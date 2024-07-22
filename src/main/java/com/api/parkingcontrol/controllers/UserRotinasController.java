package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ProdutoDTO;
import com.api.parkingcontrol.dtos.UserRotinasDto;
import com.api.parkingcontrol.services.ProdutoService;
import com.api.parkingcontrol.services.UserRotinasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


        import com.api.parkingcontrol.dtos.ProdutoDTO;
        import com.api.parkingcontrol.services.ProdutoService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/userrotinas")
public class UserRotinasController {

    @Autowired
    private UserRotinasService userRotinasService;

    @GetMapping
    public List<UserRotinasDto> listarTb_usuarios_Rotinas() {
        return userRotinasService.listarRotinas();
    }

    @PostMapping
    public UserRotinasDto criarTb_usuarios_Rotinas(@RequestBody UserRotinasDto userRotinasDto) {
        return userRotinasService.salvarUserRotina(userRotinasDto);
    }
}