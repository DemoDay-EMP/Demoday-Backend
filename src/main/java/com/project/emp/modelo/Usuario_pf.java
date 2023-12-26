package com.project.emp.modelo;

import lombok.Getter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
    As entidades são nossas tabelas no banco de dados, chamadas tambem de objetos, tudo que tem aqui é
criado da mesma forma em nosso banco.
*/


@Getter
@Entity //Mostra ao SPRING que é uma tabela
@Table(schema = "usuario_pf") //Da nome a uma tabela ou utiliza uma table existente, caso seja existente todos os campos - devem ser identicos (classe e tabela)
public class Usuario_pf {

    @Id //NECESSÁRIO MARCAR COMO ID (CHAVE PRIMARIA)
    //@GeneratedValue(strategy = GenerationType.AUTO) //GERADOR AUTOMATICO DE ID
    private String cpf;

    @Column(name = "nome_cliente")
    private String nome;

    private String email;

    private String senha;

    private String cnpj;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    private String telefone;

    private String cep;

    @Column(name = "status_usuario")
    private String status;

    @Column(name = "data_cadastro")
    private String dataCadastro;


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) { this.senha = senha; }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
