import java.time.LocalTime;
import java.util.Date;

public class Filme extends Evento{

    public Filme(int precoIngresso){
        super("Até o último Homem", new Date(), LocalTime.of(19, 30), "Cinemark", 200, precoIngresso);
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
        System.out.println("horario: " + getHorario());

    }


}
