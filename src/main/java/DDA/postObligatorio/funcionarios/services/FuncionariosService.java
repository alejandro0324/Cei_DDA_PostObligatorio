package DDA.postObligatorio.funcionarios.services;

import DDA.postObligatorio.common.messages.Action;
import DDA.postObligatorio.common.messages.ObserverMessage;
import DDA.postObligatorio.compras.mappers.ComprasMapper;
import DDA.postObligatorio.compras.services.ComprasSender;
import DDA.postObligatorio.funcionarios.components.FuncionariosPublisher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Slf4j
@Service
@AllArgsConstructor
public class FuncionariosService {

    private final FuncionariosPublisher funcionariosPublisher;

    public void notifyFuncionarios() {
        if (funcionariosPublisher.subscribers.size() == 0) {
            funcionariosPublisher.addSubscriberTest();
        }
        funcionariosPublisher.notifySubscriber();
    }
}
