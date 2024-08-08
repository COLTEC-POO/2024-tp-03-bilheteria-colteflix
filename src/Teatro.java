import java.time.LocalTime;
import java.util.Date;
public class Teatro extends Evento{

    public Teatro(String nome,float precoIngresso){
        super(nome, new Date(), LocalTime.of(20, 15), "Praça da liberdade", 250, precoIngresso);
        this.tipo = "Teatro";
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
        this.calcularReceita();
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

    public void dispoIngressos(){

    }

}
