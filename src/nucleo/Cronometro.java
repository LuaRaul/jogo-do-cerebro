// Classe PrintTask dorme por um tempo aleatório de 0 a 5 segundos
package nucleo;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Cronometro implements Runnable {
//0jhtp.indb 752 07/07/2016 15:21:09
//Capítulo 23 Concorrência 753

    private static final SecureRandom generator = new SecureRandom();

    private int c, tempo;
    private JLabel jLabel;
    private JComponent component;
    private JComponent component1;
    private JComponent component2;
    private int contHora, contMinuto, contSegundo;
    private String format;
    //private Actividade actividade;
    String audioFilePath;
    //AudioPlayerExample2 player;
 int hrs , ms , ss;
    // construtor
    public Cronometro(JComponent component, JComponent component1, JComponent component2, int h,int m,int s) {

        this.component = component;
        this.component1 = component1;
        this.component2 = component2;
       
        this.hrs = h; this.ms = m; this.ss=ss;
        contHora = contMinuto = contSegundo = 0;
        //player = new AudioPlayerExample2();
        audioFilePath = "src/estudando/com/tempo/janelas/welcome.wav";

    }

    public void cicloHora() {
        contHora = contMinuto = contSegundo = c = 0;
        while (contHora < this.hrs) {
            while (contMinuto < 59) {
                while (c < 59) {
                    try // coloca a thread para dormir pela quantidade de tempo sleepTime
                    {

                        //Thread.sleep(sleepTime); // coloca a thread para dormir ÿ
                        while (contSegundo < 59) {
                            Thread.sleep(15);
                            contSegundo++;

                        }
                        contSegundo = 0;
                        c++;
                        format = (contHora <= 9) ? "0" + contHora + ":" : "" + contHora + ":";
                        format += (contMinuto <= 9) ? "0" + contMinuto + ":" : "" + contMinuto + ":";
                        format += (c <= 9) ? "0" + c : "" + c;
                        ((JLabel) component2).setText("Contagem-->"+format);

                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                        Thread.currentThread().interrupt(); // reinterrompe a thread
                    }

                    // imprime o nome da tarefa
                    //System.out.printf("%s done sleeping%n", taskName);
                }
                contMinuto++;
                format = (contHora <= 9) ? "0" + contHora + ":" : "" + contHora + ":";
                format += (contMinuto <= 9) ? "0" + contMinuto + ":" : "" + contMinuto + ":";
                format += (c <= 9) ? "0" + c : "" + c;
                ((JLabel) component2).setText("Contagem-->"+format);
                c = 0;
            }

        }
        contHora++;
        format = (contHora <= 9) ? "0" + contHora + ":" : "" + contHora + ":";
        format += (contMinuto <= 9) ? "0" + contMinuto + ":" : "" + contMinuto + ":";
        format += (c <= 9) ? "0" + c : "" + c;
        ((JLabel) component2).setText("Contagem-->"+format);
        contMinuto = 0;
    }

    public void cicloMinuto() {
        contHora = contMinuto = contSegundo = c = 0;
        while (contMinuto < this.contMinuto) {
            while (c < 59) {
                try // coloca a thread para dormir pela quantidade de tempo sleepTime
                {

                   
                    while (contSegundo < 59) {
                        Thread.sleep(15);
                        contSegundo++;

                    }
                    contSegundo = 0;
                    format = (0 <= 9) ? "0" + 0 + ":" : "" + 0 + ":";
                    format += (contMinuto <= 9) ? "0" + contMinuto + ":" : "" + contMinuto + ":";
                    format += (c <= 9) ? "0" + c : "" + c;
                    ((JLabel) component2).setText("Contagem-->"+format);
                    c++;

                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                    Thread.currentThread().interrupt(); // reinterrompe a thread
                }

                // imprime o nome da tarefa
                //System.out.printf("%s done sleeping%n", taskName);
            }
            contMinuto++;

            c = 0;
            format = (0 <= 9) ? "0" + 0 + ":" : "" + 0 + ":";
            format += (contMinuto <= 9) ? "0" + contMinuto + ":" : "" + contMinuto + ":";
            format += (c <= 9) ? "0" + c : "" + c;
            ((JLabel) component2).setText("Contagem-->"+format);
        }
    }

    public void cicloSegundo() {
        contHora = contMinuto = contSegundo = c = 0;
        //nesta funçao , o c=segundo e o segundo = milissegundo
        while (c < this.ss) {
            try // coloca a thread para dormir pela quantidade de tempo sleepTime
            {
                format = (0 <= 9) ? "0" + 0 + ":" : "" + 0 + ":";
                        format += (0 <= 9) ? "0" + 0 + ":" : "" + 0 + ":";
                        format += (c <= 9) ? "0" + c : "" + c;
                        ((JLabel) component2).setText("Contagem-->"+format);

                //Thread.sleep(sleepTime); // coloca a thread para dormir ÿ
                while (contSegundo < 59) {
                    Thread.sleep(15);
                    contSegundo++;
                    
                }
                contSegundo = 0;
                c++;

            } catch (InterruptedException exception) {
                exception.printStackTrace();
                Thread.currentThread().interrupt(); // reinterrompe a thread
            }

            // imprime o nome da tarefa
            //System.out.printf("%s done sleeping%n", taskName);
        }
    }

    public void intervaloTempo() {
        contHora = contMinuto = contSegundo = c = 0;
        while (contMinuto < this.ss) {
            while (c < 59) {
                try // coloca a thread para dormir pela quantidade de tempo sleepTime
                {

                    format = (c <= 9) ? "0" + c : "" + c;
                    ((JLabel) component2).setText(format);
                    //Thread.sleep(sleepTime); // coloca a thread para dormir ÿ
                    while (contSegundo < 59) {
                        Thread.sleep(15);
                        contSegundo++;

                    }
                    contSegundo = 0;
                    c++;
                    oqueFazer();

                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                    Thread.currentThread().interrupt(); // reinterrompe a thread
                }

                // imprime o nome da tarefa
                //System.out.printf("%s done sleeping%n", taskName);
            }
            contMinuto++;
            format = (contMinuto <= 9) ? "0" + contMinuto : "" + contMinuto;
            ((JLabel) component1).setText(format);
            c = 0;
        }
    }

    public void oqueFazer() {
        /*try {
            System.out.println(actividade.getAcao());

            if (actividade.getAcao().equalsIgnoreCase("Bloquear")) {
                Runtime.getRuntime().exec("Rundll32.exe User32.dll,LockWorkStation");
            }

        } catch (IOException ex) {
            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    // método run contém o código que uma thread executará
    public void run() {

        String op = "minuto";
        switch (op) {
            case "Hora":
                cicloHora();
                break;
            case "Minuto":
                cicloMinuto();
                break;
            case "Segundo":
                cicloSegundo();
                break;

        }
        intervaloTempo();
    }
}
