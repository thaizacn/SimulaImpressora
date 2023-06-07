package br.com.impressora.controller;

import br.com.impressora.model.ImpressoraModel;

public class ImpressoraController {
    private ImpressoraModel impressora;
    
    public ImpressoraController(ImpressoraModel impressora) {
        this.impressora = impressora;
    }

    public ImpressoraController() {
        impressora = new ImpressoraModel();
    }

    public void realizarImpressao(String texto) {
        impressora.imprimir(texto);
    }

    public void verificarNivelCartucho() {
        impressora.getNivelCartucho();
    }

    public void recarregarCartucho() {
        impressora.recarregarCartucho();
    }
}
