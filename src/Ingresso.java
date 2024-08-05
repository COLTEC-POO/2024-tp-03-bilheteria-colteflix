import java.util.Date;
public class Ingresso {
    Date dataVenda;
    float valorIngresso;

    String tipo;

    public Ingresso(Date dataVenda, int valorIngresso, String tipo){
        this.dataVenda = dataVenda;
        this.valorIngresso = valorIngresso;
        this.tipo = tipo;
    }

}
