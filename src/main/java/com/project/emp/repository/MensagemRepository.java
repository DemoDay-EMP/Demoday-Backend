package com.project.emp.repository;

// MensagemRepository.java
import com.project.emp.modelo.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    // Métodos do repositório, se necessário
}
