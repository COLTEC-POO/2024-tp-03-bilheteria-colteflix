import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
public class main {
    public static ArrayList<Evento> Eventos = new ArrayList<Evento>();

    public static void main(String[] args) {
        Dialog.mensagem("Colteflix", "Bem vindo(a) ao Colteflix");
        boolean running = true;
        while (running) {
            Dialog.opcoes("Índice", "Escolha o que fazer: ", "Criar Evento", "Vender Ingresso", "Exibir Informações",
                    "Exibir Detalhes", "Sair");
            switch (Dialog.opcao) {
                case 0:
                    criarEvento();
                    break;
                case 1:
                    venderIngresso();
                    break;
                case 2:
                    exibirInformacoes();
                    break;
                case 4:
                    exibirDetalhes();
                    break;
                case 5:
                    Dialog.confirmacao("Sair", "Deseja sair ?");
                    if (Dialog.opcao == 0)
                        running = false;
                    break;
            }
        }
    }

    public static void criarEvento() {
        String[] tipos = { "Filme", "Teatro", "Concerto" };
        String nome = "", tipo = "";
        float preco = 0f;
        Date data = new Date();
        LocalTime horario;
        String local;
        int qtdIngressos;
        int ingressosVendidos = 0;

        // Tipo
        Dialog.opcoes("Criar Evento", "Tipo do evento: ", "Filme", "Teatro", "Concerto", "Cancelar");
        if (Dialog.opcao == 3)
            return;
        tipo = tipos[Dialog.opcao];
        // Nome
        while (true) {
            nome = Dialog.entrada("Criar Evento", "Nome do " + tipo + ": ");
            if (nome == null)
                return;
            if (nome.equals("")) {
                Dialog.mensagem("Criar Evento", "Nome não permitido");
                continue;
            }
            break;
        }
        // Preço
        while (true) {
            try {
                preco = Float.parseFloat(Dialog.entrada("Criar Evento", "Preço do " + tipo + ": "));
                // if (preco == null) return;
                if (preco < 0f) {
                    Dialog.mensagem("Criar Evento", "Preço tem que ser maior ou igual a 0.");
                    continue;
                }
                break;
            } catch (Exception e) {
                Dialog.mensagem("Criar Evento", "Preço tem que ser maior ou igual a 0.");
                continue;
            }
        }
        // Data
        while (true) {
            try {
                Dialog.entrada("Criar Evento", "Data do " + tipo + ": \nDigite separados por espaço ' ', o ano, o mês e o dia.");
                if (Dialog.entrada == null) {
                    break;
                }
                String[] entrada = Dialog.entrada.split(" ");
                System.out.println(entrada[0]);
                int[] entradas = { Integer.parseInt(entrada[0]), Integer.parseInt(entrada[1]),
                        Integer.parseInt(entrada[2]) };
                boolean toContinue = false;
                for (int ent : entradas) {
                    if (ent <= 0) {
                        toContinue = true;
                        Dialog.mensagem("Criar Evento", "Digite valores maiores que 0.");
                        break;
                    }
                }
                if (entradas[0] < 2024) {
                    toContinue = true;
                    Dialog.mensagem("Criar Evento", "Ano não pode ser anterior de 2024.");
                }
                if (entradas[1] > 12) {
                    toContinue = true;
                    Dialog.mensagem("Criar Evento", "Mês não pode ser maior que 12.");
                }
                if (entradas[2] > 31) {
                    toContinue = true;
                    Dialog.mensagem("Criar Evento", "Dia não pode ser maior que 31.");
                }
                if (toContinue)
                    continue;
                if (preco < 0f) {
                    Dialog.mensagem("Criar Evento", "Preço tem que ser maior ou igual a 0.");
                    continue;
                }
                break;
            } catch (Exception e) {
                Dialog.mensagem("Criar Evento", "Preço tem que ser maior ou igual a 0.");
                continue;
            }
        }
        // Preço
        while (true) {
            try {
                preco = Float.parseFloat(Dialog.entrada("Criar Evento", "Preço do " + tipo + ": "));
                // if (preco == null) return;
                if (preco < 0f) {
                    Dialog.mensagem("Criar Evento", "Preço tem que ser maior ou igual a 0.");
                    continue;
                }
                break;
            } catch (Exception e) {
                Dialog.mensagem("Criar Evento", "Preço tem que ser maior ou igual a 0.");
                continue;
            }
        }
        // Confirmação
        Dialog.confirmacao("Criar Evento", "Criar " + tipo + "\n" + nome + " ?");
        if (Dialog.opcao == 1)
            return;
        switch (tipo) {
            case "Filme":
                Eventos.add(new Filme(nome, preco, ingressosVendidos));
                break;
            case "Teatro":
                Eventos.add(new Teatro(nome, preco, ingressosVendidos));
                break;
            case "Concerto":
                local = Dialog.entrada("Criar Evento", "Digite o local");
                horario = LocalTime.parse(Dialog.entrada("Criar Evento", "Digite o horario"));
                Dialog.entrada("Criar Evento", "quantidade de ingressos");
                Eventos.add(new Concerto(nome, data, horario, local, 600, preco, ingressosVendidos));
                break;
        }
    }
    public static void venderIngresso() {
        String eventos = "";
        int total = 0, posicao = 0;
        for (Evento evento : Eventos) {
            eventos += "\n " + (total + 1) + " - " + evento.tipo + " '" + evento.getNome() + "'";
            total++;
        }
        while (true) {
            try {
                posicao = Integer.parseInt(Dialog.entrada("Vender Ingresso", "Qual Evento ?:" + eventos));
                if (posicao >= 1 && posicao <= total)
                    break;
                else
                    Dialog.mensagem("Vender Ingresso", "Digite o número do Evento");
            } catch (Exception e) {
                Dialog.mensagem("Vender Ingresso", "Digite o número do Evento");
            }
        }

    }



    public static void exibirInformacoes() {
        String resultado = "", linha = "----------------------------------------\n";
        resultado += linha;
        for (Evento evento : Eventos) {
            resultado += evento.getTipo() + " " + evento.getNome() + "\n";
            resultado += evento.getData() + " " + evento.getHorario() + "\n";
            resultado += evento.getLocal() + "\n";
            resultado += evento.TotalReceita + "\n";
            resultado += linha;
        }
        Dialog.mensagem("Exibir Informações", resultado);
    }

    public static void exibirDetalhes(){
        String resultado = "", linha = "----------------------------------------\n";
        resultado += linha;
        for(Evento evento: Eventos){
            resultado += evento.getTipo() + " " + evento.getNome() + "\n";
            resultado += "Ingressos vendidos: " + evento.getIngressosVendidos();
        }
        Dialog.mensagem("Exibir detalhes", resultado);
    }
}
