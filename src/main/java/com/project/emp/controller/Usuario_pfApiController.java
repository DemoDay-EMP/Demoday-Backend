package com.project.emp.controller;

import com.project.emp.repository.Usuario_pfRepository;
import com.project.emp.modelo.Usuario_pf;
import com.project.emp.services.Usuario_pfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario_pf")
public class Usuario_pfApiController {

    @Autowired
    private Usuario_pfService empServices;

    @Autowired
    Usuario_pfRepository empBd;

    @CrossOrigin
    @PostMapping(value = "/create", produces = "application/json")
    public Usuario_pf create(@RequestBody Usuario_pf example){
        empBd.save(example);
        return example;
    }

    @CrossOrigin
    @GetMapping("/list")
    public List<Usuario_pf> findAllRecords(){
        return empBd.findAll();
    }

    @RequestMapping(value = "search/name/{name}", method = RequestMethod.GET)
    public Optional<Usuario_pf> searchBynome(@PathVariable String name) {
        return empBd.findBynome(name);
    }

    @RequestMapping(value = "search/cpf/{cpf}", method = RequestMethod.GET)
    public Optional<Usuario_pf> searchBycpf(@PathVariable String cpf) {
        return empBd.findBycpf(cpf);
    }

    @RequestMapping(value = "search/email/{email}", method = RequestMethod.GET)
    public Optional<Usuario_pf> searchByemail(@PathVariable String email) {
        return empBd.findByemail(email);
    }

    @CrossOrigin
    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<String> login(@RequestBody Usuario_pf loginRequest) {
        Optional<Usuario_pf> usuario_pfOptional = empBd.findByemail(loginRequest.getEmail());

        if (usuario_pfOptional.isPresent()) {
            Usuario_pf usuario_pf = usuario_pfOptional.get();
            if (usuario_pf.getSenha().equals(loginRequest.getSenha())) {
                // Credenciais válidas, redireciona para outra página ou retorna sucesso
                return ResponseEntity.ok("{\"message\": \"Login bem-sucedido\", \"usuario\": \"" + usuario_pf.getNome() + "\", \"cpf\": \"" + usuario_pf.getCpf() + "\"}");
            } else {
                // Senha incorreta
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Senha incorreta\"}");
            }
        } else {
            // Usuário não encontrado
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Usuário não encontrado\"}");
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update/cpf/{cpf}")
    public ResponseEntity<Usuario_pf> updateByCpf(@PathVariable String cpf, @RequestBody Usuario_pf movie) {
        Usuario_pf usuario_pf = empBd.findBycpf(cpf).orElse(null);

        if (usuario_pf != null) {
            usuario_pf.setNome(movie.getNome());
            usuario_pf.setSenha(movie.getSenha());
            usuario_pf.setEmail(movie.getEmail());
            usuario_pf.setCnpj(movie.getCnpj());
            usuario_pf.setDataNascimento(movie.getDataNascimento());
            usuario_pf.setTelefone(movie.getTelefone());
            usuario_pf.setCep(movie.getCep());
            empBd.save(usuario_pf);
            return ResponseEntity.ok(usuario_pf);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Adicione este método para tratar as solicitações OPTIONS
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/update/cpf/{cpf}", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok().allow(HttpMethod.PUT, HttpMethod.OPTIONS).build();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/cpf/{cpf}")
    public String deleteById(@PathVariable String cpf) {
        Usuario_pf emp = empBd.findBycpf(cpf).get();
        empBd.delete(emp);
        return "{deleted:"+cpf+"}";
    }
}
