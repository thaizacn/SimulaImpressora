package br.com.impressora.view.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.impressora.view.ImpressoraApp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImpressoraAppTest {

    private InputStream originalSystemIn;
    private PrintStream originalSystemOut;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        // Armazena os streams originais do sistema
        originalSystemIn = System.in;
        originalSystemOut = System.out;

        // Redefine o System.out para capturar a saída
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        // Restaura os streams originais do sistema
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    public void testImprimirTexto() {
        // Preparação
        String textoEntrada = "1\nTexto de teste\n4\n";
        InputStream inputStream = new ByteArrayInputStream(textoEntrada.getBytes());
        System.setIn(inputStream);

        // Execução
        ImpressoraApp.main(new String[]{});

        // Verificação
        String output = outputStream.toString();
        assertEquals("===== MENU DE IMPRESSORA =====\r\n"
        		+ "1 - Realizar uma impressao\r\n"
        		+ "2 - Verificar nivel do cartucho\r\n"
        		+ "3 - Recarregar cartucho\r\n"
        		+ "4 - Encerrar impressao\r\n"
        		+ "Escolha uma opcaoo: Digite o texto que sera impresso: Imprimindo: Texto de teste\r\n"
        		+ "\r\n"
        		+ "===== MENU DE IMPRESSORA =====\r\n"
        		+ "1 - Realizar uma impressao\r\n"
        		+ "2 - Verificar nivel do cartucho\r\n"
        		+ "3 - Recarregar cartucho\r\n"
        		+ "4 - Encerrar impressao\r\n"
        		+ "Escolha uma opcaoo: ", output);
    }

    @Test
    public void testVerificarNivelCartucho() {
        // Preparação
        String textoEntrada = "2\n4\n";
        InputStream inputStream = new ByteArrayInputStream(textoEntrada.getBytes());
        System.setIn(inputStream);

        // Execução
        ImpressoraApp.main(new String[]{});

        // Verificação
        String output = outputStream.toString();
        assertEquals("===== MENU DE IMPRESSORA =====\r\n"
        		+ "1 - Realizar uma impressao\r\n"
        		+ "2 - Verificar nivel do cartucho\r\n"
        		+ "3 - Recarregar cartucho\r\n"
        		+ "4 - Encerrar impressao\r\n"
        		+ "Escolha uma opcaoo: O nivel de tinta esta: 100\r\n"
        		+ "\r\n"
        		+ "===== MENU DE IMPRESSORA =====\r\n"
        		+ "1 - Realizar uma impressao\r\n"
        		+ "2 - Verificar nivel do cartucho\r\n"
        		+ "3 - Recarregar cartucho\r\n"
        		+ "4 - Encerrar impressao\r\n"
        		+ "Escolha uma opcaoo: ", output);
    }

    @Test
    public void testRecarregarCartucho() {
        // Preparação
        String textoEntrada = "3\n4\n";
        InputStream inputStream = new ByteArrayInputStream(textoEntrada.getBytes());
        System.setIn(inputStream);

        // Execução
        ImpressoraApp.main(new String[]{});

        // Verificação
        String output = outputStream.toString();
        assertEquals("===== MENU DE IMPRESSORA =====\r\n"
        		+ "1 - Realizar uma impressao\r\n"
        		+ "2 - Verificar nivel do cartucho\r\n"
        		+ "3 - Recarregar cartucho\r\n"
        		+ "4 - Encerrar impressao\r\n"
        		+ "Escolha uma opcaoo: \r\n"
        		+ "===== MENU DE IMPRESSORA =====\r\n"
        		+ "1 - Realizar uma impressao\r\n"
        		+ "2 - Verificar nivel do cartucho\r\n"
        		+ "3 - Recarregar cartucho\r\n"
        		+ "4 - Encerrar impressao\r\n"
        		+ "Escolha uma opcaoo: ", output);
    }

    @Test
    public void testOpcaoInvalida() {
        // Preparação
        String textoEntrada = "5\n4\n";
        InputStream inputStream = new ByteArrayInputStream(textoEntrada.getBytes());
        System.setIn(inputStream);

        // Execução
        ImpressoraApp.main(new String[]{});

        // Verificação
        String output = outputStream.toString();
        assertEquals("===== MENU DE IMPRESSORA =====\r\n"
        		+ "1 - Realizar uma impressao\r\n"
        		+ "2 - Verificar nivel do cartucho\r\n"
        		+ "3 - Recarregar cartucho\r\n"
        		+ "4 - Encerrar impressao\r\n"
        		+ "Escolha uma opcaoo: Opcaoo invalida. Tente novamente.\r\n"
        		+ "\r\n"
        		+ "===== MENU DE IMPRESSORA =====\r\n"
        		+ "1 - Realizar uma impressao\r\n"
        		+ "2 - Verificar nivel do cartucho\r\n"
        		+ "3 - Recarregar cartucho\r\n"
        		+ "4 - Encerrar impressao\r\n"
        		+ "Escolha uma opcaoo: ", output);
    }
}




