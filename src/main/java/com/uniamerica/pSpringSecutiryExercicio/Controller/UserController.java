package com.uniamerica.pSpringSecutiryExercicio.Controller;

import com.uniamerica.pSpringSecutiryExercicio.Entity.User;
import com.uniamerica.pSpringSecutiryExercicio.Repository.UserRepository;
import com.uniamerica.pSpringSecutiryExercicio.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public String user() {
        return "<h1>Passou</h1> <h2>Teste2</h2>";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final long id){
        final User usuario = this.userRepository.findById(id).orElse(null);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> lista(){
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @GetMapping ("/teste")
    public String teste(){
        System.out.println("entrou");
        return "<h1> OIII </h1>";
    }
    @GetMapping("/livre")
    public String testeRotaLivre() {
        return "<h1> Rota livre </h1>";
    }

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody final User usuario){
        try{
            this.userRepository.save(usuario);
            return ResponseEntity.ok("Cadastrou");

        }catch(Exception e){
            return ResponseEntity.internalServerError().body("Error: "+ e.getMessage());
        }
    }

}
