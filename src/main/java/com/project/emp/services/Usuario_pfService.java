package com.project.emp.services;

import com.project.emp.modelo.Usuario_pf;
import com.project.emp.repository.Usuario_pfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.Optional;

// A forma de trabalhar com Services é para gerar maior organização no projeto.

@Service
public class Usuario_pfService {

    @Autowired
    private Usuario_pfRepository usuario_pfRepository;

    public Optional<Usuario_pf> findBynome(String nome){
        return usuario_pfRepository.findBynome(nome);
    }

    public Optional<Usuario_pf> findAwardBycpf(String cpf){
        return usuario_pfRepository.findBycpf(cpf);
    }

    @Transactional //A Anotação Transactional serve para conectar e interagir com o banco.
    public Usuario_pf addAward(Usuario_pf prize){
        return usuario_pfRepository.save(prize);
    }

    @Transactional
    public void deleteAward(Usuario_pf prize){
        usuario_pfRepository.delete(prize);
    }

    public Usuario_pf updateAward(Usuario_pf prize){
        return usuario_pfRepository.save(prize);
    }


}
