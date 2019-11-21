/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleo;

import java.awt.Color;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import jogo.pkgdo.cerebro.FormPrincipal;

/**
 *
 * @author RauLuar
 */
public class Conta {

    private int n1;
    private int n2;
    private int resultado;
    GeradorCalculo c[];
    int contConta;//quantidade de contas das operacoes
    int contCalculo=0;//quantidade de calculos que ha em cada operacao
    private Funcoes f;
    private Calculo todos[];

    public Conta(int limitInit, int limitFinal, int qtd) {
        /*c = new GeradorCalculo[4];
         c[0] = new GeradorCalculo(limitInit, limitFinal, Constante.SOMA, qtd);
         c[0].gerarCalculo();

         c[1] = new GeradorCalculo(limitInit, limitFinal, Constante.SUBTRACAO, qtd);
         c[1].gerarCalculo();

         c[2] = new GeradorCalculo(limitInit, limitFinal, Constante.MULTIPLICACAO, qtd);
         c[2].gerarCalculo();

         c[3] = new GeradorCalculo(limitInit, limitFinal, Constante.DIVISAO, qtd);
         c[3].gerarCalculo();*/

        GeradorCalculo c;
        Calculo calc1[], calc2[], calc3[], calc4[];
       f = new Funcoes();
        int contTodos = 0, cont = 0;
        todos = new Calculo[qtd * 4];
        for (int i = 0; i < todos.length; i++) {
            todos[i] = new Calculo();;

        }
        c = new GeradorCalculo(limitInit, limitFinal, Constante.SOMA, qtd);
        c.gerarCalculo();
        calc1 = c.ordena(c.calculos.getAll());

        c = new GeradorCalculo(limitInit, limitFinal, Constante.SUBTRACAO, qtd);
        c.gerarCalculo();
        calc2 = c.calculos.getAll();

        System.out.println("");
        c = new GeradorCalculo(limitInit, limitFinal, Constante.MULTIPLICACAO, qtd);
        c.gerarCalculo();
        calc3 = c.ordena(c.calculos.getAll());

        System.out.println("");
        c = new GeradorCalculo(limitInit, limitFinal, Constante.DIVISAO, qtd);
        c.gerarCalculo();
        calc4 = c.ordena(c.calculos.getAll());
        todos = c.ordena(c.agrupaTodos(calc1, calc2, calc3, calc4));
        
        
    }

    public void proximaConta(JLabel jl1, JLabel jl2, JLabel jl3) {
        String perguntaCalculo[], r, calcular[];
        java.util.Scanner t = new java.util.Scanner(System.in);
        String op;
        GeradorCalculo c1 = null;
        Calculo auxC[];
        if (contConta < c.length) {
            c1 = c[contConta];
        } else {
            auxC = c1.calculos.getAll();
            if (contCalculo < auxC.length) {
                String calc = auxC[contCalculo].getCalculo();
                perguntaCalculo = this.f.separarCalculo(calc, Constante.IGUAL);
                //op = buscaOperacao(perguntaCalculo[0]);
                calcular = this.f.separarCalculo1(perguntaCalculo[0]);
                jl1.setText(calcular[0]);
                jl2.setText(calcular[1]);
                op = nomeOperacao(perguntaCalculo[0]) + ".png";
                jl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + op))); // NOI18N
            } else {
                contConta++;
                contCalculo = 0;
            }
        }

    }

    public void proximaContaTest(JLabel jl1, JLabel jl2, JLabel jl3, JLabel jl4, JTextField jTextField1, boolean respondeu) {
        /*String perguntaCalculo[], r, calcular[];
         java.util.Scanner t = new java.util.Scanner(System.in);
         String op;
         int contEmpo = 0;
         int numero;
         boolean v = false;
         Color color = jTextField1.getBackground();
         for (int i = 0; i < c.length; i++) {
         GeradorCalculo c1 = c[i];

         Calculo auxC[] = c1.calculos.getAll();
         for (int j = 0; j < auxC.length; j++) {
         try {
         String calc = auxC[j].getCalculo();
         perguntaCalculo = this.f.separarCalculo(calc, Constante.IGUAL);
         //op = buscaOperacao(perguntaCalculo[0]);
         calcular = this.f.separarCalculo1(perguntaCalculo[0]);
         jl1.setText(calcular[0]);
         jl2.setText(calcular[1]);
         jTextField1.setText(Constante.ESPACO);
         jTextField1.setBackground(color);

         op = nomeOperacao(perguntaCalculo[0]) + ".png";
         jl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + op))); // NOI18N
         while (contEmpo <= 10) {
         jl4.setText("00:" + (contEmpo <= 9 ? "0" + contEmpo : "" + contEmpo));
         Thread.sleep(1000);
         String result1 = jTextField1.getText();
         System.out.println(result1);
         String result2[] = this.f.separarCalculo(calc, Constante.IGUAL);
         System.out.println(result1 + "==" + result2[1]);
         if (FormPrincipal.respondeu) {
         int veriResposta = 1;
         while (veriResposta <= 5) {
         piscarResposta(jTextField1, veriResposta, color);
         Thread.sleep(500);
         veriResposta++;
         }
         if (result1.equalsIgnoreCase(result2[1])) {
         jTextField1.setBackground(Color.GREEN);
         PontuacaoRespostaCertaErrada(0,true);
         PontuacaoRespostaCertaErrada(1,false);
         FormPrincipal.respondeu = false;
         v = true;
         contEmpo = 9;
         } else {
         jTextField1.setBackground(Color.red);
         PontuacaoRespostaCertaErrada(0,false);
         PontuacaoRespostaCertaErrada(2,false);
         FormPrincipal.respondeu = false;
         contEmpo = 9;
         v = true;
         }
         Thread.sleep(500);

         }

         contEmpo++;
         }
         if (contEmpo == 11) {
         if (v) {
         contEmpo = 0;
         jl4.setText("00:0" + contEmpo);
         } else {

         return;
         }
         }

         } catch (InterruptedException ex) {
         Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
         }*/

        String perguntaCalculo[], r, calcular[];
        String op;
        int contEmpo = 0;
        int numero;
        boolean v = false;
        Color color = jTextField1.getBackground();
        while (contCalculo < todos.length) {
            
            try {
                String calc = todos[contCalculo].getCalculo();
                perguntaCalculo = this.f.separarCalculo(calc, Constante.IGUAL);
                //op = buscaOperacao(perguntaCalculo[0]);
                calcular = this.f.separarCalculo1(perguntaCalculo[0]);
                jl1.setText(calcular[0]);
                jl2.setText(calcular[1]);
                jTextField1.setText(Constante.ESPACO);
                jTextField1.setBackground(color);

                op = nomeOperacao(perguntaCalculo[0]) + ".png";
                jl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + op))); // NOI18N
                while (contEmpo <= 10) {
                    jl4.setText("00:" + (contEmpo <= 9 ? "0" + contEmpo : "" + contEmpo));
                    Thread.sleep(1000);
                    String result1 = jTextField1.getText();
                    System.out.println(result1);
                    String result2[] = this.f.separarCalculo(calc, Constante.IGUAL);
                    System.out.println(result1 + "==" + result2[1]);
                    if (FormPrincipal.respondeu) {
                        int veriResposta = 1;
                        while (veriResposta <= 5) {
                            piscarResposta(jTextField1, veriResposta, color);
                            Thread.sleep(500);
                            veriResposta++;
                        }
                        if (result1.equalsIgnoreCase(result2[1])) {
                            jTextField1.setBackground(Color.GREEN);
                            PontuacaoRespostaCertaErrada(0, true);
                            PontuacaoRespostaCertaErrada(1, false);
                            FormPrincipal.respondeu = false;
                            v = true;
                            contEmpo = 9;
                        } else {
                            jTextField1.setBackground(Color.red);
                            PontuacaoRespostaCertaErrada(0, false);
                            PontuacaoRespostaCertaErrada(2, false);
                            FormPrincipal.respondeu = false;
                            contEmpo = 9;
                            v = true;
                        }
                        Thread.sleep(500);

                    }

                    contEmpo++;
                }
                if (contEmpo == 11) {
                    if (v) {
                        contEmpo = 0;
                        jl4.setText("00:0" + contEmpo);
                    } else {

                        return;
                    }
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
            }

            contCalculo++;
        }

    }

    public void PontuacaoRespostaCertaErrada(int posLabel, boolean acertou) {
        String result1 = FormPrincipal.jLabel[posLabel].getText();
        int numero;
        if (result1.equalsIgnoreCase("00")) {
            result1 = "0";
        }
        if (posLabel == 0) {
            numero = this.f.convertString(result1);
            if (acertou) {
                numero += 10;
            } else {
                if (numero > 0) {
                    numero -= 10;
                }
            }
        } else {
            numero = this.f.convertString(result1);
            numero += 1;
        }

        FormPrincipal.jLabel[posLabel].setText("" + numero);

    }

    public void piscarResposta(JTextField jTextField1, int pintar, Color color) {
        if (pintar == 1) {
            jTextField1.setBackground(Color.red);
        }

        if (pintar == 2) {
            jTextField1.setBackground(Color.GREEN);
        }
        if (pintar == 3) {
            jTextField1.setBackground(Color.red);
        }

        if (pintar == 4) {
            jTextField1.setBackground(Color.GREEN);
        }
        if (pintar == 5) {
            jTextField1.setBackground(color);
        }

    }

    public String nomeOperacao(String calculo) {
        for (int i = 0; i < calculo.length(); i++) {
            char c = calculo.charAt(i);
            if (c == Constante.SOMA) {
                return Constante.NOME_SOMA;
            }
            if (c == Constante.SUBTRACAO) {
                return Constante.NOME_SUBTRACAO;
            }
            if (c == Constante.MULTIPLICACAO) {
                return Constante.NOME_MULTIPLICACAO;
            }
            if (c == Constante.DIVISAO) {
                return Constante.NOME_DIVISAO;
            }

        }
        return "";
    }

    public void ordenaCalculos() {
        Arrays.sort(c);
    }

    /*public Conta(int n1, int n2, int resultado) {
     this.n1 = n1;
     this.n2 = n2;
     this.resultado = resultado;
     }*/
    /**
     * @return the n1
     */
    public int getN1() {
        return n1;
    }

    /**
     * @param n1 the n1 to set
     */
    public void setN1(int n1) {
        this.n1 = n1;
    }

    /**
     * @return the n2
     */
    public int getN2() {
        return n2;
    }

    /**
     * @param n2 the n2 to set
     */
    public void setN2(int n2) {
        this.n2 = n2;
    }

    /**
     * @return the resultado
     */
    public int getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public static void main(String[] args) {
        Conta c = new Conta(1, 50, 10);
        Funcoes f = new Funcoes();
        //c.proximaConta();
        String recebe[];
        recebe = f.separarCalculo("20+3=5", Constante.IGUAL);
        for (int i = 0; i < recebe.length; i++) {
            String recebe1 = recebe[i];
            System.out.println(recebe1);
        }
        System.out.println();

        recebe = f.separarCalculo1(recebe[0]);
        for (int i = 0; i < recebe.length; i++) {
            String recebe1 = recebe[i];
            System.out.println(recebe1);
        }
        System.out.println();
        String op = c.nomeOperacao("2-3=5");

        System.out.println(op);
    }
}
