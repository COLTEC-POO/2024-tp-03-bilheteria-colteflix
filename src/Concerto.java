import java.time.LocalTime;
import java.util.Date;

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
        TotalReceita = 0;
        for(Ingresso ingresso: this.ingressos){
            TotalReceita += ingresso.valorIngresso;
        }
        TotalReceita = TotalReceita * 100;
        TotalReceita = (int) TotalReceita;
        TotalReceita = TotalReceita / 100;
    }

    public String mostrarExtrato(){
        this.calcularReceita();
        Date data = new Date();
        String string ="**********Receita " + this.nome + "**********\n" + "Data: " + data.toString() + "\n" + "Receita: " + TotalReceita;
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
