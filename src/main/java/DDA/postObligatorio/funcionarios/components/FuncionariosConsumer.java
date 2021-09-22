package DDA.postObligatorio.funcionarios.components;

import DDA.postObligatorio.common.messages.CompraMessage;
import DDA.postObligatorio.common.messages.ObserverMessage;
import DDA.postObligatorio.compras.services.ComprasService;
import DDA.postObligatorio.funcionarios.services.FuncionariosService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

import static DDA.postObligatorio.configuration.ActiveMQConfig.OBSERVER_QUEUE;

@Component
@Slf4j
@AllArgsConstructor
public class FuncionariosConsumer {
    private final FuncionariosService funcionariosService;

    @JmsListener(destination = OBSERVER_QUEUE)
    public void receiveMessage(@Payload ObserverMessage payload) {
        log.info("observer action: {}", payload);
        funcionariosService.notifyFuncionarios();
    }
}


