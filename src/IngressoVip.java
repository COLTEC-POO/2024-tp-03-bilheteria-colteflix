import java.util.Date;
public class IngressoVip extends Ingresso {
    public IngressoVip(Date dataVenda, int valorIngresso, String tipo){
        super(dataVenda, valorIngresso*2, tipo);
    }
}
