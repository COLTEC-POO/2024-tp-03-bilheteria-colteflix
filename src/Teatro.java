import java.util.Date;
import java.time.LocalTime;
public class Teatro extends Evento{

    public Teatro(double precoIngresso){
        super("Jeová Nissih", new Date(), LocalTime.of(20, 15), "Praça da liberdade", 250, precoIngresso);
    }
    @Override
    public int capIngressos(int qtdIngressos){
        return getQtdIngressos();
    }


}
