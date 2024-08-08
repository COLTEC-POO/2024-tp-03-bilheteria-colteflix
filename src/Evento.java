import java.util.ArrayList;
import java.util.Date;
import java.time.LocalTime;

public abstract class Evento implements IReceita{
    private String nome;
    private Date data;
    private LocalTime horario;
    private String local;
    private int qtdIngressos;
    private float precoIngresso;
    protected String tipo;
    protected ArrayList<Ingresso> ingressos = new ArrayList<>();
    protected ArrayList<Float> Receita = new ArrayList<>();
    protected ArrayList<Date> DataReceita = new ArrayList<>();
    protected float TotalReceita = 0;

    public Evento(String nome, Date data, LocalTime horas,String local,int qtdIngressos, float precoIngresso){
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

    public String getTipo(){
        return tipo;
    }

    public float getTotalReceita(){
        return TotalReceita;
    }

    public abstract int capIngressos(int qtdIngressos);

    public String toString(){
        String string;
        string = "Evento: " + nome + "\nDia: " + data.toString() + "\nHorário: " + horario.toString() + "\nEndereço: " + local + "\n Receitas:";
        return string;
    }
}
