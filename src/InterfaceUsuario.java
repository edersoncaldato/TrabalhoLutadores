import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class InterfaceUsuario {

    private GerenciadorLutadores gerenciadorLutadores;
    private Scanner scanner;

    public InterfaceUsuario(GerenciadorLutadores gerenciadorLutadores) {
        this.gerenciadorLutadores = gerenciadorLutadores;
        this.scanner = new Scanner(System.in);
    }

    public void executarMenu() {
        while (true) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    adicionarLutador();
                    break;
                case 2:
                    removerLutador();
                    break;
                case 3:
                    alterarLutador();
                    break;
                case 4:
                    mostrarLutadores();
                    break;
                case 5:
                    gerenciadorLutadores.fecharCategorias();
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("\n**MENU**");
        System.out.println("1. Adicionar Lutador");
        System.out.println("2. Remover Lutador");
        System.out.println("3. Alterar Lutador");
        System.out.println("4. Mostrar Lutadores");
        System.out.println("5. Fechar Categorias");
        System.out.println("6. Sair");
        System.out.print("Digite sua opção: ");
    }

    private int lerOpcao() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            scanner.next(); // Consumir entrada inválida
            return 0;
        }
    }

    private void adicionarLutador() {
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
        gerenciadorLutadores.adicionarLutador(lutador);
        System.out.println("Lutador " + nome + " adicionado com sucesso!");
        scanner.nextLine(); // Consumir quebra de linha após entrada de peso
    }


    private void removerLutador() {
        System.out.print("Nome do Lutador a Remover: ");
        String nome = scanner.nextLine();

        Lutador lutador = gerenciadorLutadores.getLutadores().stream()
                .filter(l -> l.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);

        if (lutador != null) {
            gerenciadorLutadores.removerLutador(lutador);
            System.out.println("Lutador " + nome + " removido com sucesso!");
        } else {
            System.out.println("Lutador não encontrado.");
        }
    }

    private void alterarLutador() {
        List<Lutador> lutadores = gerenciadorLutadores.getLutadores();

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
        gerenciadorLutadores.alterarLutador(lutadorAntigo, lutadorNovo);
        System.out.println("Lutador " + lutadorAntigo.getNome() + " alterado para " + nomeNovo + " com sucesso!");
        scanner.nextLine(); // Consume newline
    }





    private void mostrarLutadores() {
        List<Lutador> lutadores = gerenciadorLutadores.getLutadores();

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
