import java.util.Date;
public abstract class Ingresso implements IReceita{
    Date dataVenda;
    double valorIngresso;
    String tipo;

    public Ingresso(Date dataVenda, double valorIngresso, String tipo){
        this.dataVenda = dataVenda;
        this.valorIngresso = valorIngresso;
        this.tipo = tipo;
    }
    public void calcularReceita(){
        valorIngresso = valorIngresso + 0;
    }
    public String mostrarExtrato(){
        String string = "";
        if(this.tipo == "Meia"){
            string = "***********Meia Entrada***********\n";
        }else if(this.tipo == "Normal"){
            string = "***********Entrada Normal***********\n";
        }else if(this.tipo == "Vip"){
            string = "***********Entrada VIP***********\n";
        }else{
            string = "***********Entrada Não Identificada***********\n";
        }

        string = string + "Data de compra: " + dataVenda.getTime() + "\nValor da compra: " + valorIngresso;
        return string;
    }

}
