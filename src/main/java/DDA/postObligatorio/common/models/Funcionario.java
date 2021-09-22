package DDA.postObligatorio.common.models;

import DDA.postObligatorio.compras.components.ISubscribers;

public class Funcionario implements ISubscribers {
    public String nombreUsuario;

    public void verificarCompras() {
        System.out.println("Soy " + nombreUsuario + " y me acabo de enterar de la compra");
    }
}
