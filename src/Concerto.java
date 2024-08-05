import java.time.LocalTime;
import java.util.Date;

public class Concerto extends Evento{

    public Concerto(double precoIngresso){
        super("Orquestra Musical", new Date(), LocalTime.of(16, 00), "Casa Branca", 150, precoIngresso);
    }

    public void calcularReceita(){
        int i=0;
        for(Ingresso ingresso: this.ingressos){
            if(DataReceita.get(i) != null){
                if(DataReceita.get(i) == ingresso.dataVenda){
                    Receita.set(i, Receita.get(i) + ingresso.valorIngresso);
                }else {
                    i++;
                    DataReceita.set(i, ingresso.dataVenda);
                    Receita.set(i,ingresso.valorIngresso);
                }
            }else{
                DataReceita.set(i, ingresso.dataVenda);
            }
        }
    }

    public String mostrarExtrato(){
        String string = "";
        float total = 0;
        for(int i = 0; i < DataReceita.size(); i++){
            if(DataReceita.get(i) == null && Receita.get(i) != null){
                total += Receita.get(i);
                string = string + "Data: " + DataReceita.get(i) + "\nReceita: " + Receita.get(i) + "\n";
            }
        }
        string = string + "Total: " + total;
        return string;
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
}
