package com.masterdev.demo.worker.consumer;

import com.masterdev.demo.worker.producer.NotificarMedicoErroProdutor;
import com.masterdev.demo.worker.producer.NotificarMedicoSucessoProdutor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NotificarMedicoRequestConsumidor {
    @Autowired private NotificarMedicoErroProdutor erroProdutor;
    @Autowired private NotificarMedicoSucessoProdutor sucessoProdutor;

    @RabbitListener(queues = { "notificar-request-queue"})
    public void receberMensagem (@Payload Message message) {
        System.out.println(message);
        if (new Random().nextBoolean()) {
            sucessoProdutor.gerarResposta("Mensagem de sucesso Notificação " + message);
        } else {
            erroProdutor.gerarResposta("ERRO na notificação " + message);
        }
    }
}
