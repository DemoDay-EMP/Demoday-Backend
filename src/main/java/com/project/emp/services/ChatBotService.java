package com.project.emp.services;

// ChatbotService.java
import com.project.emp.modelo.Mensagem;
import com.project.emp.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatBotService {

    private final MensagemRepository mensagemRepository;

    @Autowired
    public ChatBotService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public List<Mensagem> obterTodasMensagens() {
        return mensagemRepository.findAll();
    }

    public Mensagem salvarMensagem(Mensagem mensagem) {
        Mensagem saved;
        saved = mensagemRepository.save(mensagem);
        return saved;
    }
}
