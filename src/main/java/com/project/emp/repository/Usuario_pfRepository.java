package com.project.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository; //Vivo
import org.springframework.stereotype.Repository;
import com.project.emp.modelo.Usuario_pf;

import java.util.Optional;
import java.util.UUID;

    /*
        Classe responsavel por se comunicar com o banco de dados: SALVAR, LER, ATUALIZAR E DELETAR
    */

@Repository
public interface Usuario_pfRepository extends JpaRepository<Usuario_pf, UUID> {
    /*
    A CLASSE DEVE SER ESCRITA DESSA MESMA FORMA E ESSA CLASSE JA POSSUI METODOS EXISTENTES MAS CASO VOCE
    QUEIRA CRIAR ALGO ESPECIFICO BASTA FAZER IGUAL A LINHA 24 SEGUE DOCUMENTAÇÃO DE APOIO
    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
     */
    Optional<Usuario_pf> findBynome(String nome);

    Optional<Usuario_pf> findBycpf(String cpf);

    Optional<Usuario_pf> findByemail(String email);


}
