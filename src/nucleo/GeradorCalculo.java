/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleo;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author RauLuar
 */
public class GeradorCalculo {

    int n1, n2;
    int resultado;
    Operacao operacao;
    Calculos calculos;
    int qtd;
    Random r;
    char op;

    //0 - 50
    public GeradorCalculo(int n1, int n2, char op, int qtd) {
        this.n1 = n1;
        this.n2 = n2;
        this.op = op;

        calculos = new Calculos(qtd);
        this.qtd = qtd;
        r = new Random();
    }

    public int gerarCalculo() {

        int v1, v2;
        int v3 = 1;
        int contadorCalculo = 0;
        String calculo, textOp = "";
        boolean verifResult;
        do {
            v1 = faixa(this.n1, this.n2, this.op);//gera o primeiro valor
            v2 = faixa(this.n1, this.n2, this.op);//gera o segundo valor
            this.operacao = new Operacao(v1, v2);
            calculo = this.operacao.resultadoOperacao(this.op);
            resultado = extrairResultado(calculo);
            //verica o contador de calculo se ja chegou a quantidade de calculo pedido
            //e verifica se um dos calculos deu um resultado igual faixa estabelecida, ex: faixa 1-50, 
            //nao pode haver um calculo que o seu resultado passa 50
            if (contadorCalculo <= this.qtd && resultado < this.n2) {
                //calculo = "" + v1 + "" + textOp + "" + v2 + "=" + resultado;//
                if (this.op == Constante.DIVISAO) {
                    if (v1 == v2 && resultado == 1 && v2 == 1) {
                        if (calculos.add(calculo)) {
                            System.out.println(calculos.get(contadorCalculo));
                            contadorCalculo++;
                        }

                    }
                    if (v1 != v2 && resultado != 0 && v1 != v2 && resultado != 1 && resultado * v2 == v1) {

                        if (calculos.add(calculo)) {
                            System.out.println(calculos.get(contadorCalculo));
                            contadorCalculo++;
                        }

                    }
                } else {
                    if (calculos.add(calculo)) {
                        System.out.println(calculos.get(contadorCalculo));
                        contadorCalculo++;
                    }

                }

            }
            if (contadorCalculo == this.qtd) {
                v3 = 0;
            }
        } while (v3 != 0);

        return resultado;

    }

    //gera numeros dentro do do intervalo de dois numeros, ex:1-50, 
    //a variavel tipoNumero, da a possibilidade de gerar apenas numeros pares, impares ou ambos, dentro de um intervalo 
    //
    public int faixa(int f1, int f2, char op) {
        Random r = new Random();

        do {
            int n2 = r.nextInt(f2);

            if (op == Constante.DIVISAO) {
                if (n2 > f1 && n2 < f2 && n2 % 2 == 0) {
                    //System.out.println(n2);
                    return n2;
                }
            } else {
                if (n2 > f1 && n2 < f2) {
                    //System.out.println(n2);
                    return n2;
                }
            }

        } while (true);
    }
//recebe uma String contendo o calculo e o resultado,ex:2+3=9, e tira apenas o resultado

    public int extrairResultado(String calculo) {

        String v[] = calculo.split(Constante.IGUAL);
        String r;
        int posicao, numero = 0;
        if (v.length > 0) {
            posicao = v.length - 1;
            r = v[posicao];
            numero = Integer.parseInt(r);
        }
        return numero;
    }

    public boolean verifResultado(String r, Calculos calculos) {
        Calculo c[] = calculos.getAll();
        String auxC;
        for (int i = 0; i < c.length; i++) {
            auxC = c[i].getCalculo();
            if (r.equalsIgnoreCase(auxC)) {
                return true;
            }

        }
        return false;
    }

    public Calculo[] ordena(Calculo c[]) {
        Funcoes f = new Funcoes();

        int v[] = new int[c.length], numer;
        String calculo[], calculo1[], valorPosicao[];
        valorPosicao = new String[c.length];
        for (int i = 0; i < c.length; i++) {
            String n = c[i].getCalculo();
            if (n != null) {
                calculo = f.separarCalculo(n, Constante.IGUAL);
                calculo1 = f.separarCalculo1(calculo[0]);
                numer = f.convertString(calculo1[0]);
                v[i] = numer;
            }

        }
        //Arrays.sort(v);
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length; j++) {
                if (v[i] < v[j]) {
                    int auxV = v[i];
                    v[i] = v[j];
                    v[j] = auxV;
                    String aux = c[i].getCalculo();
                    c[i].setCalculo(c[j].getCalculo());
                    c[j].setCalculo(aux);

                }
            }
        }
        return c;

    }

    public Calculo[] agrupaTodos(Calculo c1[], Calculo c2[], Calculo c3[], Calculo c4[]) {
        Calculo calc[], todos[];
        int contTodos = 0, cont = 0;
        todos = new Calculo[c1.length + c2.length + c3.length + c4.length];
        for (int i = 0; i < todos.length; i++) {
            todos[i] = new Calculo();;

        }
        calc = ordena(c1);
        do {

            todos[contTodos].setCalculo(calc[cont].getCalculo());
            cont++;
            contTodos++;
        } while (cont != calc.length );
        cont = 0;

        calc = ordena(c2);
        do {

            todos[contTodos].setCalculo(calc[cont].getCalculo());
            cont++;
            contTodos++;
        } while (cont != calc.length);
        cont = 0;
        calc = ordena(c3);
        do {

            todos[contTodos].setCalculo(calc[cont].getCalculo());
            cont++;
            contTodos++;
        } while (cont != calc.length );
        cont = 0;
        calc = ordena(c4);
        do {

            todos[contTodos].setCalculo(calc[cont].getCalculo());
            cont++;
            contTodos++;
        } while (cont != calc.length );
        cont = 0;
        return todos;
    }

    public static void main(String[] args) {
        GeradorCalculo c;
        Calculo todos[], calc1[], calc2[], calc3[], calc4[];
        Funcoes f = new Funcoes();
        int lim1 = 0;
        int lim2 = 100;
        int qtd = 10, contTodos = 0, cont = 0;
        todos = new Calculo[qtd * 4];
        for (int i = 0; i < todos.length; i++) {
            todos[i] = new Calculo();;

        }
        c = new GeradorCalculo(lim1, lim2, Constante.SOMA, qtd);
        c.gerarCalculo();
        calc1 = c.ordena(c.calculos.getAll());

        c = new GeradorCalculo(lim1, lim2, Constante.SUBTRACAO, qtd);
        c.gerarCalculo();
        calc2 = c.calculos.getAll();

        System.out.println("");
        c = new GeradorCalculo(lim1, lim2, Constante.MULTIPLICACAO, qtd);
        c.gerarCalculo();
        calc3 = c.ordena(c.calculos.getAll());

        System.out.println("");
        c = new GeradorCalculo(lim1, lim2, Constante.DIVISAO, qtd);
        c.gerarCalculo();
        calc4 = c.ordena(c.calculos.getAll());
        todos = c.ordena(c.agrupaTodos(calc1, calc2, calc3, calc4));
        for (int i = 0; i < todos.length; i++) {
            Calculo todo = todos[i];
            System.out.println("Aqui->" + todo.getCalculo());
        }
        /*String[] s = f.separarCalculo(todos[0].getCalculo(), Constante.IGUAL);
        System.out.println(s[0]);
        System.out.println(s[1]);
        System.out.println("");*/
    }
}
