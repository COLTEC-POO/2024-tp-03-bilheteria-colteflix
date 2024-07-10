import java.util.Date;
import java.time.LocalTime;
public abstract class Evento {
    private String nome;
    private Date data;
    private LocalTime horario;
    private String local;
    private int qtdIngressos;
    private double precoIngresso;

    public Evento(String nome, Date data, LocalTime horas,String local,int qtdIngressos, double precoIngresso){
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

    public Date getData(){
        return data;
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

    public double getPrecoIngresso(){
        return precoIngresso;
    }
    public abstract int capIngressos(int qtdIngressos);
}
