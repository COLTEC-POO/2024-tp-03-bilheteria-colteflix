import java.util.Date;
public class IngressoMeia extends Ingresso {
    public IngressoMeia(Date dataVenda, int valorIngresso, String tipo){
        super(dataVenda, valorIngresso*2, tipo);
    }
}
