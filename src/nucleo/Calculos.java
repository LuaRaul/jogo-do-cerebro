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
public class Calculos {

    private Calculo calculo[];
    private int quantidade;

    public Calculos(int quantidade) {
        calculo = new Calculo[quantidade];
        iniVetCalculo();
        this.quantidade = 0;
    }

    private void iniVetCalculo() {
        for (int i = 0; i < this.calculo.length; i++) {
            this.calculo[i] = new Calculo();
        }
    }

    public boolean add(String calculo) {
        boolean v = existCalculo(calculo);
        if (!v) {
            this.calculo[this.quantidade].calculo = calculo;
            this.quantidade++;
            return true;
        }
        return false;
    }

    public String get(int posicao) {
        if (posicao >= 0 && posicao < this.quantidade) {
            return this.calculo[posicao].calculo;
        }
        return null;
    }

    public void remove() {
        this.quantidade--;
    }

    public Calculo[] getAll() {
        return this.calculo;
    }

    public boolean existCalculo(String r) {
        String auxC;
        for (int i = 0; i < this.calculo.length; i++) {
            auxC = get(i);
            if (r.equalsIgnoreCase(auxC)) {
                return true;
            }

        }
        return false;
    }
}
