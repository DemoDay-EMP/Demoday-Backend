package com.project.emp.controller;

// ChatbotController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/chat") // Defina o caminho raiz para o controlador
public class ChatBotController {

    @CrossOrigin(origins = "*")
    @PostMapping("/sendMessage")
    public String receiveMessage(@RequestBody String message) {
        // Lógica para processar a mensagem e gerar uma resposta
        String response = generateResponse(message);
        return "Assistente: " + response;
    }

    private String generateResponse(String message) {
        // Lógica para gerar uma resposta com base na mensagem recebida
        // Este é um exemplo muito simples, ajuste conforme necessário
        if (message.equalsIgnoreCase("O que é fluxo de caixa?")) {
            return "O fluxo de caixa é o acompanhamento do dinheiro que entra e sai do seu negócio.";
        } else if (message.equalsIgnoreCase("Como gerenciar o fluxo de caixa?")) {
            return "Para gerenciar o fluxo de caixa, é importante registrar todas as receitas e despesas, atualizar regularmente e planejar suas finanças.";
        } else if (message.equalsIgnoreCase("O que é DRE?")) {
            return "A Demonstração do Resultado do Exercício (DRE) é um relatório financeiro que mostra as receitas, custos e despesas de uma empresa durante um período específico.";
        } else if (message.equalsIgnoreCase("Como interpretar uma DRE?")) {
            return "Ao interpretar uma DRE, você pode analisar a lucratividade do seu negócio, identificar áreas de custo elevado e tomar decisões estratégicas para melhorar o desempenho financeiro.";
        } else if (message.equalsIgnoreCase("Como posso melhorar a gestão financeira do meu negócio?")) {
            return "Algumas dicas para melhorar a gestão financeira incluem: manter um bom controle do fluxo de caixa, realizar análises financeiras periódicas, buscar redução de custos e investir em estratégias de crescimento sustentável.";
        } else if (message.equalsIgnoreCase("Olá")) {
            return "Olá! Como posso ajudar você hoje?";
        } else if (message.equalsIgnoreCase("Como você está")) {
            return "Estou bem, obrigado por perguntar!";
        } else if (message.equalsIgnoreCase("O que é gestão financeira?")) {
            return "Gestão financeira refere-se ao planejamento, controle e análise das atividades financeiras de uma empresa para garantir sua saúde financeira.";
        } else if (message.equalsIgnoreCase("Quais são as principais métricas de gestão financeira?")) {
            return "Algumas métricas importantes incluem liquidez, rentabilidade, margens de lucro, retorno sobre o investimento (ROI) e índices de endividamento.";
        } else if (message.equalsIgnoreCase("Como calcular a liquidez de uma empresa?")) {
            return "A liquidez pode ser calculada dividindo os ativos circulantes pelo passivo circulante. Isso indica a capacidade da empresa de pagar suas obrigações de curto prazo.";
        } else if (message.equalsIgnoreCase("O que são despesas fixas e variáveis?")) {
            return "Despesas fixas são custos constantes, como aluguel, salários. Despesas variáveis ​​flutuam com a produção ou vendas, como matéria-prima e comissões de vendas.";
        } else if (message.equalsIgnoreCase("Quais são as etapas para criar um plano de negócios?")) {
            return "As etapas incluem pesquisa de mercado, definição de metas, elaboração do plano de marketing, análise financeira, entre outras. Um plano de negócios é crucial para o sucesso a longo prazo.";
        } else if (message.equalsIgnoreCase("Como preparar minha empresa para períodos de crise?")) {
            return "É importante manter uma reserva de emergência, reduzir custos não essenciais, diversificar receitas e manter um relacionamento próximo com clientes e fornecedores.";
        } else {
            return "Desculpe, não entendi. Pode reformular sua pergunta?";
        }
    }
}
