package DDA.postObligatorio.funcionarios.components;

import DDA.postObligatorio.common.models.Funcionario;
import DDA.postObligatorio.compras.components.ISubscribers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class FuncionariosPublisher {
    public ArrayList<ISubscribers> subscribers = new ArrayList<>();

    public void addSubscriberTest() {
        Funcionario funcionario1 = new Funcionario();
        funcionario1.nombreUsuario = "Alejandro Echeverría";
        this.subscribers.add(funcionario1);
        Funcionario funcionario2 = new Funcionario();
        funcionario2.nombreUsuario = "Tomás Atrat";
        this.subscribers.add(funcionario2);
        Funcionario funcionario3 = new Funcionario();
        funcionario3.nombreUsuario = "Álvaro de la Rosa";
        this.subscribers.add(funcionario3);
    }

    public void addSubscriber() {

    }

    public void deleteSubscriber() {

    }

    public void notifySubscriber() {
        for (int i = 0; i < subscribers.size(); i++) {
            subscribers.get(i).verificarCompras();
        }
    }
}
