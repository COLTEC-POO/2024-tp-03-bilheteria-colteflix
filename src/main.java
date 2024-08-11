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
                case 3:
                    exibirDetalhes();
                    break;
                case 4:
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
        Date data = new Date(10,8,2024);
        LocalTime horario;
        String local;
        int qtdIngressos;
        int ingressosVendidos = 0;
        int hora,minuto;

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
                Dialog.entrada("Criar Evento", "Preço do " + tipo + ": ");
                if (Dialog.entrada == null) return;
                preco = Float.parseFloat(Dialog.entrada);
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
                data = new Date(entradas[0],entradas[1],entradas[2]);
                break;
            } catch (Exception e) {
                Dialog.mensagem("Criar Evento", "Preço tem que ser maior ou igual a 0.");
                continue;
            }
        }
        // Hora
        while (true) {
            try {
                Dialog.entrada("Criar Evento", "Horário do " + tipo + ": \nDigite separados por espaço ' ', a hora e os minutos");
                if (Dialog.entrada == null) return;
                hora = Integer.parseInt(Dialog.entrada.split(" ")[0]);
                minuto = Integer.parseInt(Dialog.entrada.split(" ")[1]);
                System.out.println(""+hora+" "+minuto);
                if (hora < 0 || minuto < 0) {
                    Dialog.mensagem("Criar Evento", "Hora ou minuto têm de ser maior ou igual a 0.");
                    continue;
                }
                if (hora >= 24) {
                    Dialog.mensagem("Criar Evento", "Hora tem de ser menor que 24.");
                    continue;
                }
                if (minuto >= 60) {
                    Dialog.mensagem("Criar Evento", "Minuto tem de ser menor que 60.");
                    continue;
                }
                String addH = "",addM = "";
                if (hora < 10) addH = "0";
                if (minuto < 10) addM = "0";
                horario = LocalTime.parse(addH+hora+":"+addM+minuto);
                break;
            } catch (Exception e) {
                Dialog.mensagem("Criar Evento", "Horas e minutos têm de ser inteiros.");
                continue;
            }
        }
        // Local
        while (true) {
            try {
                Dialog.entrada("Criar Evento", "Local do "+tipo+": ");
                if (Dialog.entrada == null) return;
                if (Dialog.entrada == ""){
                    Dialog.mensagem("Criar Evento", "O local não pode ser nulo.");
                    continue;
                }
                local = Dialog.entrada;
                break;
            } catch (Exception e) {
                Dialog.mensagem("Criar Evento", "Horas e minutos têm de ser inteiros.");
                continue;
            }
        }
        // Confirmação
        String resultado = "", linha = "----------------------------------------\n";
        resultado += linha;
        resultado += data.getDate() + "\n" + horario + "\n";
        resultado += local + "\n";
        resultado += linha;
        Dialog.confirmacao("Criar Evento", "Criar " + tipo + "\n" + nome + " ?\n"+resultado+"R$"+preco);

        if (Dialog.opcao == 1) return;
        switch (tipo) {
            case "Filme":
                Eventos.add(new Filme(nome, data, horario, local,preco));
                break;
            case "Teatro":
                Eventos.add(new Teatro(nome, data, horario, local,preco));
                break;
            case "Concerto":
                Eventos.add(new Concerto(nome, data, horario, local,preco));
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
                Dialog.entrada("Vender Ingresso", "Qual Evento ?:" + eventos);
                if (Dialog.entrada == null) return;
                posicao = Integer.parseInt(Dialog.entrada);
                if (posicao >= 1 && posicao <= total)
                    break;
                else
                    Dialog.mensagem("Vender Ingresso", "Digite o número do Evento.");
            } catch (Exception e) {
                Dialog.mensagem("Vender Ingresso", "Digite o número do Evento.");
            }
        }
        posicao--;
        Evento evento = Eventos.get(posicao);
        if (!(evento.dispoLugares())){
            Dialog.mensagem("Vender Ingresso","O Evento está cheio.");
            return;
        }
        int opcaoTipo = 0;
        String tipoIngresso = "";
        // Tipo Ingresso
        while (true) {
            try {
                Dialog.opcoes("Vender Ingresso", "Tipo do Ingresso do "+evento.getTipo()+" "+evento.getNome()+": ","Normal","Meia","Vip","Cancelar");
                opcaoTipo = Dialog.opcao;
                if (Dialog.opcao == 3) return;
                int qtdDispoIngressos = 0;
                switch (Dialog.opcao){
                    case 0:
                        tipoIngresso = "Normal";
                        qtdDispoIngressos = evento.dispoIngressos("Normal");
                        break;
                    case 1:
                        tipoIngresso = "Meia";
                        qtdDispoIngressos = evento.dispoIngressos("Meia");
                        break;
                    case 2:
                        tipoIngresso = "Vip";
                        qtdDispoIngressos = evento.dispoIngressos("Vip");
                        break;
                }
                if (qtdDispoIngressos <= 0){
                    Dialog.mensagem("Vender Ingresso","Quantidade de Ingressos desse tipo atingiu o seu limite." );
                    return;
                }
                break;
            } catch (Exception e) {
                Dialog.mensagem("Vender Ingresso", "Digite o número do Evento.");
            }
        }
        int qtd = 0;
        // Quantidade
        while (true){
            try{
                int qtdMax = evento.dispoIngressos(tipoIngresso);
                // Aprresentação
                Dialog.entrada("Vender Ingresso","Digite a quantidade de Ingressos: \nMáximo: "+qtdMax);
                if (Dialog.entrada == null) return;
                qtd = Integer.parseInt(Dialog.entrada);
                if (qtd > qtdMax){
                    Dialog.mensagem("Vender Ingresso","A quantidade de ingressos "+tipoIngresso+" para este evento, no momento, deve ser menor que "+qtdMax+".");
                    continue;
                }
                break;
            }catch (Exception e){
                Dialog.mensagem("Vender Ingresso","A quantidade deve ser inteira q maior ou igual a 1.");
            }
        }
        Dialog.confirmacao("Vender Ingresso", "Confirmar a venda de "+qtd+" ingressos do tipo "+tipoIngresso+" do "+evento.getTipo()+" "+evento.getNome());
        if (Dialog.opcao == 1) return;
        for (int i=0;i<qtd;i++){
            switch (tipoIngresso){
                case "Normal":
                    evento.putIngresso(new IngressoNormal(new Date(), evento.getPrecoIngresso()));
                    break;
                case "Meia":
                    evento.putIngresso(new IngressoMeia(new Date(), evento.getPrecoIngresso()));
                    break;
                case "Vip":
                    evento.putIngresso(new IngressoVip(new Date(), evento.getPrecoIngresso()));
                    break;
            }
        }
        System.out.println(evento.mostrarExtrato());
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
            resultado += "Ingressos vendidos: " + evento.getIngressosVendidos()+linha;
        }
        Dialog.mensagem("Exibir detalhes", resultado);
    }
}
