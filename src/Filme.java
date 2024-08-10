import java.time.LocalTime;

public class Filme extends Evento{

    public Filme(String nome, Date data, LocalTime horario, String local,float precoIngresso){
        super(nome, data, horario, local, 200, precoIngresso);
        this.tipo = "Filme";
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
        System.out.println("horario: " + getHorario());

    }

    public void calcularReceita(){
        int i=0;
        for(Ingresso ingresso: this.ingressos){
            if(DataReceita.get(i) != null){
                if(DataReceita.get(i).getDate() == ingresso.dataVenda.getDate()){
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

    public int dispoIngressos(String tipo){
        if (tipo.equals("Vip")) return 0;
        return getQtdIngressos()-getIngressosVendidos();
    }

}
