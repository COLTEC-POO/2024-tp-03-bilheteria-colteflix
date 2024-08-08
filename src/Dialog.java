import javax.swing.JOptionPane;

public class Dialog {
    public static void message(String titulo, String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, titulo, 0);
    }
}
