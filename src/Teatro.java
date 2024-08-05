import java.time.LocalTime;
import java.util.Date;
public class Teatro extends Evento{

    public Teatro(double precoIngresso){
        super("Jeová Nissih", new Date(), LocalTime.of(20, 15), "Praça da liberdade", 250, precoIngresso);
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

    public void dispoIngressos(){

    }

}
