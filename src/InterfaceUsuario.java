import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class InterfaceUsuario {
    public GerenciadorLutadores gerenciadorLutadores;
    public Menu menu;
    public Scanner scanner;

    public InterfaceUsuario(Scanner scanner, GerenciadorLutadores gerenciadorLutadores) {
        this.scanner = scanner;
        this.gerenciadorLutadores = gerenciadorLutadores;
    }

    public void executarMenu() {
        Menu menu = new Menu(scanner);
        int opcao;
        do {
            menu.exibirMenu();
            opcao = menu.lerOpcao();
            rotearParaFuncao(opcao); // Call rotearParaFuncao directly

            // Optional: Handle invalid input message or logic here (if lerOpcao doesn't return an error indicator)
        } while (opcao != -1);
    }

    private void rotearParaFuncao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarLutador(gerenciadorLutadores);
                break;
            case 2:
                removerLutador(gerenciadorLutadores);
                break;
            case 3:
                alterarLutador(gerenciadorLutadores);
                break;
            case 4:
                mostrarLutadores(gerenciadorLutadores);
                break;
            case 5:
                gerenciadorLutadores.fecharCategorias();
                break;
            case 6:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }


    public void adicionarLutador(GerenciadorLutadores gerenciadorLutadores) {
        System.out.print("Nome do Lutador: ");
        String nome = scanner.nextLine(); // Capture name
        try {
            nome = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para Nome. Digite um nome válido.");
            scanner.next(); // Consumir entrada inválida
            return;
        }
        System.out.print("Altura (em metros): ");
        double altura;
        try {
            altura = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para altura. Digite um número decimal.");
            scanner.next(); // Consumir entrada inválida
            return;
        }

        System.out.print("Peso (em kg): ");
        double peso;
        try {
            peso = scanner.nextDouble(); // Capture weight separately
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para peso. Digite um número decimal.");
            scanner.next(); // Consumir entrada inválida
            return;
        }

        Lutador lutador = new Lutador(nome, altura, peso);
        this.gerenciadorLutadores.adicionarLutador(lutador);
        System.out.println("Lutador " + nome + " adicionado com sucesso!");
        scanner.nextLine(); // Consumir quebra de linha após entrada de peso
    }


    public void removerLutador(GerenciadorLutadores gerenciadorLutadores) {
        List<Lutador> lutadores = this.gerenciadorLutadores.getLutadores();

        if (lutadores.isEmpty()) {
            System.out.println("Não há lutadores na lista.");
            return; // Exit if no fighters exist
        }

        // Display Fighter List
        System.out.println("Lista de Lutadores:");
        for (int i = 0; i < lutadores.size(); i++) {
            Lutador lutador = lutadores.get(i);
            System.out.println((i + 1) + ". " + lutador.getNome());
        }

        // Prompt for Selection
        System.out.print("Número do Lutador a Remover (ou 0 para cancelar): ");
        int escolha;
        try {
            escolha = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número.");
            scanner.next(); // Consume invalid input
            return;
        }

        if (escolha == 0) {
            System.out.println("Remoção cancelada.");
            return; // Exit if user chooses to cancel
        }

        if (escolha < 1 || escolha > lutadores.size()) {
            System.out.println("Número inválido. Digite um número entre 1 e " + lutadores.size() + ".");
            return; // Exit if invalid choice
        }

        Lutador lutador = lutadores.get(escolha - 1); // Get selected fighter

        this.gerenciadorLutadores.removerLutador(lutador);
        System.out.println("Lutador " + lutador.getNome() + " removido com sucesso!");
        scanner.nextLine(); // Consume newline
    }


    public void alterarLutador(GerenciadorLutadores gerenciadorLutadores) {
        List<Lutador> lutadores = this.gerenciadorLutadores.getLutadores();

        if (lutadores.isEmpty()) {
            System.out.println("Não há lutadores na lista.");
            return; // Exit if no fighters exist
        }

        // Display Fighter List
        System.out.println("Lista de Lutadores:");
        for (int i = 0; i < lutadores.size(); i++) {
            Lutador lutador = lutadores.get(i);
            System.out.println((i + 1) + ". " + lutador.getNome());
        }

        // Prompt for Selection
        System.out.print("Número do Lutador a Alterar (ou 0 para cancelar): ");
        int escolha;
        try {
            escolha = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número.");
            scanner.next(); // Consume invalid input
            return;
        }

        if (escolha == 0) {
            System.out.println("Alteração cancelada.");
            return; // Exit if user chooses to cancel
        }

        if (escolha < 1 || escolha > lutadores.size()) {
            System.out.println("Número inválido. Digite um número entre 1 e " + lutadores.size() + ".");
            return; // Exit if invalid choice
        }

        Lutador lutadorAntigo = lutadores.get(escolha - 1); // Get selected fighter

        // Proceed with alteration process (rest of the code remains the same)
        System.out.println("Lutador Atual:");
        System.out.println("Nome: " + lutadorAntigo.getNome());
        System.out.println("Altura: " + lutadorAntigo.getAltura() + " m");
        System.out.println("Peso: " + lutadorAntigo.getPeso() + " kg");


        // Gather New Information
        System.out.print("Novo Nome: ");
        String nomeNovo = scanner.nextLine();
        try {
            nomeNovo = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para Nome. Digite um nome válido.");
            scanner.next(); // Consumir entrada inválida
            return;
        }
        System.out.print("Nova Altura (em metros): ");
        double novaAltura;
        try {
            novaAltura = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para altura. Digite um número decimal.");
            scanner.next(); // Consume invalid input
            return;
        }

        System.out.print("Novo Peso (em kg): ");
        double novoPeso;
        try {
            novoPeso = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para peso. Digite um número decimal.");
            scanner.next(); // Consume invalid input
            return;
        }

        Lutador lutadorNovo = new Lutador(nomeNovo, novaAltura, novoPeso);
        this.gerenciadorLutadores.alterarLutador(lutadorAntigo, lutadorNovo);
        System.out.println("Lutador " + lutadorAntigo.getNome() + " alterado para " + nomeNovo + " com sucesso!");
        scanner.nextLine(); // Consume newline
    }





    public void mostrarLutadores(GerenciadorLutadores gerenciadorLutadores) {
        List<Lutador> lutadores = this.gerenciadorLutadores.getLutadores();

        if (lutadores.isEmpty()) {
            System.out.println("Não há lutadores cadastrados.");
        } else {
            System.out.println("\n**LISTA DE LUTADORES**");
            for (Lutador lutador : lutadores) {
                System.out.println(lutador);
            }
        }
    }
}
