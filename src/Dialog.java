import javax.swing.JOptionPane;

public class Dialog {
    public static String entrada = "0";
    public static int opcao = 0;

    public static void mensagem(String titulo, String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, titulo, 0);
    }

    public static int confirmacao(String titulo, String mensagem){
        opcao = JOptionPane.showConfirmDialog(null,mensagem,titulo,0);
        return opcao;
    }

    public static String entrada(String titulo, String mensagem){
        entrada = JOptionPane.showInputDialog(null,mensagem,titulo,0);
        return entrada;
    }

    public static int opcoes(String titulo, String mensagem,String... opcoes){
        opcao = JOptionPane.showOptionDialog(null, mensagem, titulo, 0, 0, null, opcoes, mensagem);
        return opcao;
    }
}
