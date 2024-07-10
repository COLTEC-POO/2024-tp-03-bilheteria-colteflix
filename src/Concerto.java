import java.time.LocalTime;
import java.util.Date;

public class Concerto extends Evento{

    public Concerto(double precoIngresso){
        super("Orquestra Musical", new Date(), LocalTime.of(16, 00), "Casa Branca", 150, precoIngresso);
    }
    @Override
    public int capIngressos(int qtdIngressos){
        return getQtdIngressos();
    }

    @Override
    public void imprimir(){
        System.out.println("Quantidade de ingressos possiveis: " + getQtdIngressos());
        System.out.println("Nome: " + getNome());
        System.out.println("Local: " + getLocal());
        System.out.println("Horario: " + getHorario());

    }
}
