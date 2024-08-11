public class IngressoMeia extends Ingresso {
    public IngressoMeia(Date dataVenda, double valorIngresso){
        super(dataVenda, valorIngresso/2, "Meia");
    }
}
