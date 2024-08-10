import java.time.LocalTime;

public class Concerto extends Evento{

    public Concerto(String nome, Date data, LocalTime horario, String local,float precoIngresso){
        super(nome, data, horario, local, 150, precoIngresso);
        this.tipo = "Concerto";
    }
    @Override
    public int capIngressos(int qtdIngressos){
        return getQtdIngressos();
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



    @Override
    public void imprimir(){
        System.out.println("Quantidade de ingressos possiveis: " + getQtdIngressos());
        System.out.println("Nome: " + getNome());
        System.out.println("Local: " + getLocal());
        System.out.println("horario: " + getHorario());
    };

    public int dispoIngressos(String tipo){
        if (tipo.equals("Vip")){
            int qtdVip = 0;
            for (Ingresso ingresso : ingressos){
                if (ingresso.tipo.equals("Vip")) qtdVip++;
            }
            return getQtdIngressos()/10-qtdVip;
        }
        return getQtdIngressos()-getIngressosVendidos();
    }
}
