package DDA.postObligatorio.compras.controllers;

import DDA.postObligatorio.common.messages.CompraMessage;
import DDA.postObligatorio.common.models.DtoCompra;
import DDA.postObligatorio.compras.mappers.ComprasMapper;
import DDA.postObligatorio.compras.services.ComprasSender;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.UUID;

@RestController
@RequestMapping("/compras")
@AllArgsConstructor
public class ComprasController {
    private final ComprasSender comprasSender;

    @PostMapping("/")
    public void agregarCompra(
            @RequestBody final DtoCompra item) {

        final CompraMessage message = CompraMessage.builder()
                .idVuelo(item.idVuelo)
                .documentoPasajero(item.documentoPasajero)
                .precioTotal(item.precioTotal)
                .build();

        comprasSender.send(message);
    }
}
