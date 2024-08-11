public class IngressoVip extends Ingresso {
    public IngressoVip(Date dataVenda, double valorIngresso){
        super(dataVenda, valorIngresso*2, "Vip");
    }
}
