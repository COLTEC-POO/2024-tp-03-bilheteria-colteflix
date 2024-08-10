import java.util.ArrayList;
import java.util.Date;
import java.time.LocalTime;

public abstract class Evento implements IReceita{
    private String nome;
    private Date data;
    private LocalTime horario;
    private String local;
    private int qtdIngressos;
    private int ingressosVendidos = 0;
    private float precoIngresso;
    protected String tipo;
    protected ArrayList<Ingresso> ingressos = new ArrayList<>();
    protected ArrayList<Double> Receita = new ArrayList<>();
    protected ArrayList<Date> DataReceita = new ArrayList<>();
    protected float TotalReceita = 0;

    public Evento(String nome, Date data, LocalTime horas,String local,int qtdIngressos, float precoIngresso, int ingressosVendidos){
        this.nome = nome;
        this.data = data;
        this.horario = horas;
        this.local = local;
        this.qtdIngressos = qtdIngressos;
        this.precoIngresso = precoIngresso;
        this.ingressosVendidos = 0;
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

    public int getIngressosVendidos(){
        return ingressosVendidos;
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

    public int calculaIngressosvendidos(int quantidade){
        Dialog.mensagem("Exibir detalhes", "digite o numero do evento que deseja comprar o ingresso");
        Dialog.entrada("Exibir detalhes", "numero do evento");
        if(quantidade < this.qtdIngressos){
            ingressosVendidos = ingressosVendidos + quantidade;
            qtdIngressos = qtdIngressos - quantidade;

        }
        return ingressosVendidos;
    }


    public String toString(){
        String string;
        string = "Evento: " + nome + "\nDia: " + data.toString() + "\nHorário: " + horario.toString() + "\nEndereço: " + local + "\n Receitas:";
        return string;
    }
}
