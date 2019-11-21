package nucleo;

// Classe PrintTask dorme por um tempo aleatório de 0 a 5 segundos
//PrintTaskPainel deferencia do PrintTask, no construtor , recebe um jPanel,
//onde é extraido os JLabel hora inicio e final, para que a execuçao da actividade, aconteça dentro
//da classe Agendado.
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import nucleo.Conta;

public class PrintTaskPainel implements Runnable {
//0jhtp.indb 752 07/07/2016 15:21:09
//Capítulo 23 Concorrência 753

    private static final SecureRandom generator = new SecureRandom();

    private int c, tempo;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
     private JTextField jTextField1;
     private boolean respondeu;
    ExecutorService executorService;

    // construtor
    Conta conta;

    public PrintTaskPainel(JLabel jl1, JLabel jl2, JLabel jl3,JLabel jl4,JTextField jTextField1, boolean respondeu) {
        this.jLabel1 = jl1;
        this.jLabel2 = jl2;
        this.jLabel3 = jl3;
        this.jLabel4 = jl4;
        this.jTextField1 = jTextField1;
        this.respondeu = respondeu;
        this.conta = new Conta(1,20, 10);

    }
    //retorna elementos dento de um panel

    // método run contém o código que uma thread executará
    public void run() {
        this.conta.proximaContaTest(jLabel1, jLabel2, jLabel3,jLabel4,jTextField1, respondeu);

    }
}
