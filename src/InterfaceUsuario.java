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
        System.out.print("Nome do Lutador a Alterar: ");
        String nomeAntigo = scanner.nextLine();

        Lutador lutadorAntigo = gerenciadorLutadores.getLutadores().stream()
                .filter(l -> l.getNome().equalsIgnoreCase(nomeAntigo))
                .findFirst()
                .orElse(null);

        if (lutadorAntigo != null) {
            System.out.print("Novo Nome: ");
            String nomeNovo = scanner.nextLine();

            System.out.print("Nova Altura (em metros): ");
            double novaAltura;
            try {
                novaAltura = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida para altura. Digite um número decimal.");
                scanner.next(); // Consumir entrada inválida
                return;
            }

            System.out.print("Novo Peso (em kg): ");
            double novoPeso;
            try {
                novoPeso = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida para peso. Digite um número decimal.");
                scanner.next(); // Consumir entrada inválida
                return;
            }

            Lutador lutadorNovo = new Lutador(nomeNovo, novaAltura, novoPeso);
            gerenciadorLutadores.alterarLutador(lutadorAntigo, lutadorNovo);
            System.out.println("Lutador " + nomeAntigo + " alterado para " + nomeNovo + " com sucesso!");
            scanner.nextLine(); // Consumir quebra de linha
        } else {
            System.out.println("Lutador não encontrado.");
        }
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
