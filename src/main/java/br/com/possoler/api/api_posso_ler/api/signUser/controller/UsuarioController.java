package br.com.possoler.api.api_posso_ler.api.signUser.controller;

import br.com.possoler.api.api_posso_ler.api.signUser.dto.CheckUserDTO;
import br.com.possoler.api.api_posso_ler.api.signUser.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private HashMap<String, String> response;

    UsuarioController(
            UsuarioService usuarioService,
            HashMap<String, String> response
    ) {
        this.usuarioService = usuarioService;
        this.response = response;
    }

    @PostMapping("${signuser-api.endpoint.insertHashedUser}")
    public ResponseEntity<?> insertHashedUser() {
        var userHash = usuarioService.insereUsuario();
        response.put("user_hash", userHash);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }

    @PostMapping("${signuser-api.endpoint.checkUniqueUser}")
    public ResponseEntity<HashMap<String, String>> checkUniqueUser(@RequestBody @Valid CheckUserDTO checkUserDTO) {
        response = usuarioService.isUniqueUser(checkUserDTO.getUserHash());
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("${signuser-api.endpoint.activeUser}")
    public ResponseEntity<HashMap<String, String>> activeUser(@RequestBody @Valid CheckUserDTO checkUserDTO) {
        usuarioService.activeUser(checkUserDTO.getUserHash());
        response.put("status", "sucesso");
        response.put("message", "Extensão habilitada com sucesso");
        return ResponseEntity.ok().body(response);
    }
}
