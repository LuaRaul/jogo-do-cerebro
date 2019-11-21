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
public class Funcoes {

    public String buscaOperacao(String calculo) {
        for (int i = 0; i < calculo.length(); i++) {
            char c = calculo.charAt(i);
            if (c == Constante.SOMA) {
                return Constante.ESPACO + c;
            }
            if (c == Constante.SUBTRACAO) {
                return Constante.ESPACO + c;
            }
            if (c == Constante.MULTIPLICACAO) {
                return Constante.ESPACO + c;
            }
            if (c == Constante.DIVISAO) {
                return Constante.ESPACO + c;
            }

        }
        return Constante.ESPACO;
    }

    public String[] separarCalculo1(String calculo) {
        String v[] = new String[2];
        int pos = buscaPosOperacao(calculo);
        v[0] = calculo.substring(0, pos);
        v[1] = calculo.substring(pos + 1, calculo.length());
        return v;
    }

    public String[] separarCalculo(String calculo, String separador) {
        if (calculo.length() > 0 ) {
            String v[] = calculo.split(separador);
            String r;
            int posicao, numero = 0;
            if (v.length > 0) {
                posicao = v.length - 1;
                r = v[posicao];
                numero = Integer.parseInt(r);
            }
            return v;
        }

        return  null;
    }

    public int buscaPosOperacao(String calculo) {
        for (int i = 0; i < calculo.length(); i++) {
            char c = calculo.charAt(i);
            if (c == Constante.SOMA) {
                return i;
            }
            if (c == Constante.SUBTRACAO) {
                return i;
            }
            if (c == Constante.MULTIPLICACAO) {
                return i;
            }
            if (c == Constante.DIVISAO) {
                return i;
            }

        }
        return -1;
    }

    public int convertString(String dado) {
        if (dado.length() > 0) {
            int codAsc;
            boolean tipoInt = false, tipoString = false;
            for (int i = 0; i < dado.length(); i++) {
                codAsc = (int) dado.charAt(i);
                if (codAsc >= 48 && codAsc <= 57) {
                    tipoInt = true;
                }
                if (codAsc >= 97 && codAsc <= 122) {
                    tipoString = true;
                }
            }

            if (tipoInt != tipoString) {
                return Integer.parseInt(dado);
            }

        }
        return -1;
    }

}
