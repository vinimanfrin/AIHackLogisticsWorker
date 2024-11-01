package com.masterdev.demo.worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificarMedicoSucessoProdutor {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void gerarResposta(String mensagem){
        amqpTemplate.convertAndSend(
            "notificar-response-sucesso-exchange",
            "admin",
            mensagem);
    }
}
