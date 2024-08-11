import java.time.LocalTime;
import java.util.Date;

public class Filme extends Evento{

    public Filme(String nome, Date data,LocalTime horario, String local,float precoIngresso){
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

    public int dispoIngressos(String tipo){
        if (tipo.equals("Vip")) return 0;
        return getQtdIngressos()-getIngressosVendidos();
    }

}
