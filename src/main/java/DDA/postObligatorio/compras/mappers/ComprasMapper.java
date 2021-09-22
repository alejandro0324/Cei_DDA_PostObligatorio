package DDA.postObligatorio.compras.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;

@Mapper
public interface ComprasMapper {
    @Insert("INSERT INTO compra(precio_total, idVuelo, documento_pasajero) VALUES(#{precioTotal}, #{idVuelo}, #{documento});")
    public void crearCompra(@Param("idVuelo") final BigInteger idVuelo, @Param("documento") final String documento, @Param("precioTotal") final float precioTotal);
}

