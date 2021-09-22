package DDA.postObligatorio.compras.components;


import DDA.postObligatorio.common.messages.CompraMessage;
import DDA.postObligatorio.compras.services.ComprasSender;
import DDA.postObligatorio.compras.services.ComprasService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

import static DDA.postObligatorio.configuration.ActiveMQConfig.COMPRAS_QUEUE;

@Component
@Slf4j
@AllArgsConstructor
public class ComprasConsumer {
    private final ComprasService comprasService;

    @JmsListener(destination = COMPRAS_QUEUE)
    public void receiveMessage(@Payload CompraMessage payload) {
        log.info("compra action: {}", payload);
        BigInteger idVuelo = payload.getIdVuelo();
        String documentoPasajero = payload.getDocumentoPasajero();
        float precioTotal = payload.getPrecioTotal();
        comprasService.crearCompra(idVuelo, documentoPasajero, precioTotal);
    }
}
