package DDA.postObligatorio.compras.services;


import DDA.postObligatorio.common.messages.Action;
import DDA.postObligatorio.common.messages.ObserverMessage;
import DDA.postObligatorio.funcionarios.components.FuncionariosPublisher;
import DDA.postObligatorio.compras.mappers.ComprasMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Slf4j
@Service
@AllArgsConstructor
public class ComprasService {

    private final FuncionariosPublisher funcionariosPublisher;
    private final ComprasSender comprasSender;
    private final ComprasMapper comprasMapper;

    public void crearCompra(BigInteger idVuelo, String documentoPasajero, float precioTotal) {
        comprasMapper.crearCompra(idVuelo, documentoPasajero, precioTotal);
        final ObserverMessage message = ObserverMessage.builder()
                .action(Action.NOTIFY_FUNCIONARIOS)
                .build();

        comprasSender.send(message);
    }
}
