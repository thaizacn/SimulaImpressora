package br.com.impressora.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.impressora.model.ImpressoraModel;

public class ImpressoraModelTest {

    private ImpressoraModel impressora;

    @BeforeEach
    public void setup() {
        impressora = new ImpressoraModel();
    }

    @Test
    public void testImprimir() {
        ImpressoraModel impressoraModel = new ImpressoraModel();
        int nivelCartuchoInicial = impressoraModel.getNivelCartucho();
        impressoraModel.imprimir("Texto de teste");
        int nivelCartuchoFinal = impressoraModel.getNivelCartucho();
        int nivelCartuchoEsperado = nivelCartuchoInicial - 20;
        assertEquals(nivelCartuchoEsperado, nivelCartuchoFinal);
    }

    @Test
    public void testGetNivelCartucho() {
        impressora.setNivelCartucho(80);
        assertEquals(80, impressora.getNivelCartucho());
    }

    @Test
    public void testRecarregarCartucho() {
        impressora.setNivelCartucho(50);
        impressora.recarregarCartucho();
        assertEquals(100, impressora.getNivelCartucho());
    }
}