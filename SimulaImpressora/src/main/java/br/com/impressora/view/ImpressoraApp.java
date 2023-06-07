package br.com.impressora.view;

import java.util.Scanner;

import br.com.impressora.model.ImpressoraModel;

public class ImpressoraApp {

    public static void main(String[] args) {
        ImpressoraModel minhaImpressora = new ImpressoraModel();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== MENU DE IMPRESSORA =====");
            System.out.println("1 - Realizar uma impressao");
            System.out.println("2 - Verificar nivel do cartucho");
            System.out.println("3 - Recarregar cartucho");
            System.out.println("4 - Encerrar impressao");
            System.out.print("Escolha uma opcaoo: ");
            String decisao = scanner.nextLine();

            if (decisao.equals("1")) {
                System.out.print("Digite o texto que sera impresso: ");
                String texto = scanner.nextLine();
                minhaImpressora.imprimir(texto);
                System.out.println();
            } else if (decisao.equals("2")) {
                minhaImpressora.getNivelCartucho();
                System.out.println();
            } else if (decisao.equals("3")) {
                minhaImpressora.recarregarCartucho();
                System.out.println();
            } else if (decisao.equals("4")) {
                break;
            } else {
                System.out.println("Opcaoo invalida. Tente novamente.");
                System.out.println();
            }
        }

        scanner.close();
    }
}

