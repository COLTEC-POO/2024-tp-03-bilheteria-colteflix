import java.util.ArrayList;
import java.time.LocalTime;
import java.util.Date;

public abstract class Evento implements IReceita{
    protected String nome;
    private Date data;
    private LocalTime horario;
    private String local;
    private int qtdIngressos;
    private float precoIngresso;
    private int ingressosVendidos;
    protected String tipo;
    protected ArrayList<Ingresso> ingressos = new ArrayList<Ingresso>();
    protected float TotalReceita = 0;

    public Evento(String nome,Date data ,LocalTime horas,String local,int qtdIngressos, float precoIngresso){
        this.nome = nome;
        this.data = data;
        this.horario = horas;
        this.local = local;
        this.qtdIngressos = qtdIngressos;
        this.precoIngresso = precoIngresso;
    }

    public abstract void imprimir();

    public String getNome(){
        return nome;
    }

    public int getData(){
        return data.getDate();
    }

    public LocalTime getHorario(){
        return horario;
    }

    public String getLocal(){
        return local;
    }

    public int getQtdIngressos(){
        return qtdIngressos;
    }

    public int getIngressosVendidos(){
        return ingressosVendidos;
    }

    public double getPrecoIngresso(){
        return precoIngresso;
    }

    public void putIngresso(Ingresso ingresso){
        ingressos.add(ingresso);
        calculaIngressosVendidos();
    }

    public String getTipo(){
        return tipo;
    }

    public float getTotalReceita(){
        return TotalReceita;
    }

    public abstract int capIngressos(int qtdIngressos);
    public abstract int dispoIngressos(String tipo);

    public boolean dispoLugares(){
        calculaIngressosVendidos();
        if (this.getIngressosVendidos() < this.getQtdIngressos()) return true;
        return false;
    }

    public void calculaIngressosVendidos(){
        int quantidade = 0;
        for (Ingresso ingresso : ingressos){
            if (ingresso != null) quantidade++;
        }
        this.ingressosVendidos = quantidade;
    }


    public String toString(){
        String string;
        string = "Evento: " + nome + "\nDia: " + data.toString() + "\nHorário: " + horario.toString() + "\nEndereço: " + local + "\n Receitas:";
        return string;
    }
}
