package DDA.postObligatorio.common.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompraMessage {
    private BigInteger idVuelo;
    private String documentoPasajero;
    private float precioTotal;
}
