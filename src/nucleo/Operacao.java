/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleo;

/**
 *
 * @author RauLuar
 */
public class Operacao {

    private int n1, n2;

    public Operacao(int n1, int n2) {
        setN1(n1);
        setN2(n2);
    }

    public int soma(int n1, int n2) {
     

        return (getN1() + getN2());
    }

    public int getN1() {
        return n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int subtracao(int n1, int n2) {
     
        int auxN;
        if (n2 > n1) {//evitanto resultandos negativos
            auxN = n2;
            n2 = n1;
            n1 = auxN;
            setN1(n1);
            setN2(n2);
        }
        return (getN1() - getN2());
    }

    public int multiplicacao(int n1, int n2) {
      
        return (getN1() * getN2());
    }

    public int divisao(int n1, int n2) {
       
        if (n2 == 0) {
            return -1;
        }
        return (getN1() / getN2());
    }

    public String resultadoOperacao(char op) {
        String resultado = Constante.ESPACO;
        int v1 = getN1();
        int v2 = getN2();
        int r;
        if (op == Constante.SOMA) {//opcao soma
            r = soma(v1, v2);//faz a operacao do valor1+valor2
          
            resultado = v1 + Constante.ESPACO + Constante.SOMA + Constante.ESPACO + v2 + Constante.ESPACO + Constante.IGUAL + r;
            
        }
        if (op == Constante.SUBTRACAO) {//opcao subtracao
            r = subtracao(v1, v2);//faz a operacao do valor1-valor2
            if(v2 > v1){
                int auxV = v2;
                v2 = v1;
                v1 = auxV;
            }
            resultado = v1 + Constante.ESPACO + Constante.SUBTRACAO + Constante.ESPACO + v2 + Constante.ESPACO + Constante.IGUAL + r;
        }
        if (op == Constante.MULTIPLICACAO) {//opcao multiplicacao
            r = multiplicacao(v1, v2);//faz a operacao do valor*valor2
            resultado += v1 + Constante.ESPACO + Constante.MULTIPLICACAO + Constante.ESPACO + v2 + Constante.ESPACO + Constante.IGUAL + r;
        }
        if (op == Constante.DIVISAO) {//opcao divisao
            r = divisao(v1, v2);//faz a operacao do valor1/valor2
            
            resultado += v1 + Constante.ESPACO + Constante.DIVISAO + Constante.ESPACO + v2 + Constante.ESPACO + Constante.IGUAL + r;

        }
        return resultado;
    }
    public static void main(String[] args) {
        Operacao o = new Operacao(4, 5);
        String r = o.resultadoOperacao('+');
        System.out.println(r);
    }
}
