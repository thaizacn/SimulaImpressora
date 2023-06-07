package br.com.impressora.controller.test;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.impressora.controller.ImpressoraController;
import br.com.impressora.model.ImpressoraModel;

public class ImpressoraControllerTest {
    @Mock
    private ImpressoraModel mockImpressora;

    private ImpressoraController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        controller = new ImpressoraController(mockImpressora);
    }

    @Test
    public void testRealizarImpressao() {
        String texto = "Texto de teste";
        controller.realizarImpressao(texto);
        verify(mockImpressora).imprimir(texto);
    }

    @Test
    public void testVerificarNivelCartucho() {
        controller.verificarNivelCartucho();
        verify(mockImpressora).getNivelCartucho();
    }

    @Test
    public void testRecarregarCartucho() {
        controller.recarregarCartucho();
        verify(mockImpressora).recarregarCartucho();
    }
}
