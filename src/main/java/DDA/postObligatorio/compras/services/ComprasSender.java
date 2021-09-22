package DDA.postObligatorio.compras.services;


import DDA.postObligatorio.common.messages.CompraMessage;
import DDA.postObligatorio.common.messages.ObserverMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static DDA.postObligatorio.configuration.ActiveMQConfig.COMPRAS_QUEUE;
import static DDA.postObligatorio.configuration.ActiveMQConfig.OBSERVER_QUEUE;

@Slf4j
@Service
@AllArgsConstructor
public class ComprasSender {

    private final JmsTemplate jmsTemplate;

    public void send(CompraMessage message) {
        log.info("msg: {}", message);
        jmsTemplate.convertAndSend(COMPRAS_QUEUE, message);
    }

    public void send(ObserverMessage message) {
        log.info("msg: {}", message);
        jmsTemplate.convertAndSend(OBSERVER_QUEUE, message);
    }
}
