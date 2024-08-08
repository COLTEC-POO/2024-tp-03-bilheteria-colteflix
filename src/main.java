import java.util.ArrayList;
import java.util.Date;

public class main {
    public static ArrayList<Evento> Eventos = new ArrayList<Evento>();
    public static void main(String[] args){
        Dialog.mensagem("Colteflix","Bem vindo(a) ao Colteflix");
        boolean running = true;
        while (running){
            Dialog.opcoes("Índice","Escolha o que fazer: ","Criar Evento","Vender Ingresso","Exibir Informações","Exibir Detalhes","Sair");
            switch (Dialog.opcao){
                case 0:
                    criarEvento();
                    break;
                case 1:
                    venderIngresso();
                    break;
                case 4:
                    Dialog.confirmacao("Sair", "Deseja sair ?");
                    if (Dialog.opcao == 0) running = false;
                    break;
            }
        }
    }

    public static void criarEvento(){
        String[] tipos = {"Filme","Teatro","Concerto"};
        String nome = "",tipo = "";
        float preco = 0f;

        // Tipo
        Dialog.opcoes("Criar Evento","Tipo do evento: ","Filme","Teatro","Concerto","Cancelar");
        tipo = tipos[Dialog.opcao];
        if (Dialog.opcao == 3) return;
        // Nome
        while (true){
            nome = Dialog.entrada("Criar Evento","Nome do "+tipo+": ");
            if (nome == null) return;
            if (nome.equals("")){
                Dialog.mensagem("Criar Evento","Nome não permitido");
                continue;
            }
            break;
        }
        // Preço
        // while (true){ 
        //     preco = Float.parseFloat(Dialog.entrada("Criar Evento","Preço do "+tipo+": "));
        //     // if (preco == null) return;
        //     if (){
        //         Dialog.mensagem("Criar Evento",);
        //         continue;
        //     }
        //     break;
        // }
        Dialog.confirmacao("Criar Evento", "Criar "+tipo+"\n"+nome+" ?");
        if (Dialog.opcao == 1) return;
        switch (tipo){
            case "Filme":
                Eventos.add(new Filme(nome,preco));
                break;
            case "Teatro":
                Eventos.add(new Teatro(nome,preco));
                break;
            case "Concerto":
                Eventos.add(new Concerto(nome,preco));
                break;
        }

    }

    public static void venderIngresso(){
        String eventos = "";
        int total = 0,posicao = 0;
        for (Evento evento : Eventos){
            eventos+="\n "+(total+1)+" - "+evento.tipo+" '"+evento.getNome()+"'";
            total++;
        }
        while (true){
            try{
                posicao = Integer.parseInt(Dialog.entrada("Vender Ingresso", "Qual Evento ?:"+eventos));
                if (posicao >= 1 && posicao <= total) break;
                else Dialog.mensagem("Vender Ingresso", "Digite o número do Evento");
            } catch (Exception e){
                Dialog.mensagem("Vender Ingresso","Digite o número do Evento");
            }
        }
        


    }
}
