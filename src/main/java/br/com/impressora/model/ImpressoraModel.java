package br.com.impressora.model;

public class ImpressoraModel {
	
    private int nivelCartucho;

    public ImpressoraModel() {
        nivelCartucho = 100;
    }

    public void imprimir(String texto) {
        if (nivelCartucho <= 0) {
            System.out.println("A tinta do cartucho acabou!");
        } else {
            System.out.println("Imprimindo: " + texto);
            nivelCartucho -= 20;
        }
    }

    public int getNivelCartucho() {
    	System.out.println("O nivel de tinta esta: " + nivelCartucho);
        return nivelCartucho;
    }

    public void setNivelCartucho(int nivelCartucho) {
        this.nivelCartucho = nivelCartucho;
    }

    public void recarregarCartucho() {
        nivelCartucho = 100;
    }
}

