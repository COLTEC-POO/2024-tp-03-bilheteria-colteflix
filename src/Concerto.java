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
}
