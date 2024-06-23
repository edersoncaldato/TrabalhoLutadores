import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class InterfaceUsuario {
    // GerenciadorLutadores gerenciadorLutadores; // Objeto que gerencia a lista de lutadores (already declared)
    private GerenciadorLutadores gerenciadorLutadores; // Objeto que gerencia a lista de lutadores (with visibility modifier)

    // Menu menu; // Objeto que representa o menu da interface (already declared)
    private Menu menu; // Objeto que representa o menu da interface (with visibility modifier)

    // Scanner scanner; // Scanner para leitura de entradas do usuário (already declared)
    private Scanner scanner; // Scanner para leitura de entradas do usuário (with visibility modifier)

    public InterfaceUsuario(Scanner scanner, GerenciadorLutadores gerenciadorLutadores) {
        this.scanner = scanner;
        this.gerenciadorLutadores = gerenciadorLutadores;
    }

    public void executarMenu() {
        // Cria um novo objeto Menu passando o scanner para leitura de entrada
        Menu menu = new Menu(scanner);
        int opcao;

        // Loop principal do menu
        do {
            // Exibe o menu principal
            menu.exibirMenu();

            // Lê a opção escolhida pelo usuário
            opcao = menu.lerOpcao();

            // Chama a função correspondente à opção escolhida
            rotearParaFuncao(opcao);

            // Opcional: Tratar mensagem ou lógica de entrada inválida aqui (se lerOpcao não retornar um indicador de erro)
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
        // Solicita o nome do lutador ao usuário
        System.out.print("Nome do Lutador: ");
        String nome = scanner.nextLine(); // Captura o nome do lutador

        // Tenta capturar o nome do lutador
        try {
            nome = scanner.nextLine(); // Armazena o nome do lutador em uma variável
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para Nome. Digite um nome válido.");
            scanner.next(); // Consome a entrada inválida
            return; // Sai da função se a entrada for inválida
        }

        // Solicita a altura do lutador ao usuário
        System.out.print("Altura (em metros): ");
        double altura;

        // Tenta capturar a altura do lutador
        try {
            altura = scanner.nextDouble(); // Armazena a altura do lutador em uma variável
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para altura. Digite um número decimal.");
            scanner.next(); // Consome a entrada inválida
            return; // Sai da função se a entrada for inválida
        }

        // Solicita o peso do lutador ao usuário
        System.out.print("Peso (em kg): ");
        double peso;

        // Tenta capturar o peso do lutador
        try {
            peso = scanner.nextDouble(); // Armazena o peso do lutador em uma variável
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para peso. Digite um número decimal.");
            scanner.next(); // Consome a entrada inválida
            return; // Sai da função se a entrada for inválida
        }

        // Cria um novo objeto Lutador com os dados coletados
        Lutador lutador = new Lutador(nome, altura, peso);

        // Adiciona o lutador à lista de lutadores do gerenciador
        this.gerenciadorLutadores.adicionarLutador(lutador);

        // Exibe mensagem de sucesso
        System.out.println("Lutador " + nome + " adicionado com sucesso!");

        // Consome a quebra de linha após a entrada de peso
        scanner.nextLine();
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
            return; // Sai do método se não houver lutadores
        }

        // Exibe a lista de lutadores disponíveis
        System.out.println("Lista de Lutadores:");
        for (int i = 0; i < lutadores.size(); i++) {
            Lutador lutador = lutadores.get(i);
            System.out.println((i + 1) + ". " + lutador.getNome());
        }

        // Solicita a escolha do usuário
        System.out.print("Número do Lutador a Alterar (ou 0 para cancelar): ");
        int escolha;
        try {
            escolha = scanner.nextInt(); // Captura a escolha do usuário
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número.");
            scanner.next(); // Consome a entrada inválida
            return;
        }

        if (escolha == 0) {
            System.out.println("Alteração cancelada.");
            return; // Sai do método se o usuário cancelar a alteração
        }

        if (escolha < 1 || escolha > lutadores.size()) {
            System.out.println("Número inválido. Digite um número entre 1 e " + lutadores.size() + ".");
            return; // Sai do método se a escolha não estiver dentro do intervalo válido
        }

        Lutador lutadorAntigo = lutadores.get(escolha - 1); // Obtém o lutador selecionado

        // Exibe informações do lutador selecionado
        System.out.println("Lutador Atual:");
        System.out.println("Nome: " + lutadorAntigo.getNome());
        System.out.println("Altura: " + lutadorAntigo.getAltura() + " m");
        System.out.println("Peso: " + lutadorAntigo.getPeso() + " kg");

        // Coleta novas informações para o lutador
        System.out.print("Novo Nome: ");
        String nomeNovo = scanner.nextLine(); // Captura o novo nome do lutador
        try {
            nomeNovo = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para Nome. Digite um nome válido.");
            scanner.next(); // Consome a entrada inválida
            return;
        }
        System.out.print("Nova Altura (em metros): ");
        double novaAltura;
        try {
            novaAltura = scanner.nextDouble(); // Captura a nova altura do lutador
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para altura. Digite um número decimal.");
            scanner.next(); // Consome a entrada inválida
            return;
        }

        System.out.print("Novo Peso (em kg): ");
        double novoPeso;
        try {
            novoPeso = scanner.nextDouble(); // Captura o novo peso do lutador
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para peso. Digite um número decimal.");
            scanner.next(); // Consome a entrada inválida
            return;
        }

        // Cria um novo objeto lutador com as informações atualizadas
        Lutador lutadorNovo = new Lutador(nomeNovo, novaAltura, novoPeso);
        // Chama o método do gerenciador para alterar o lutador na lista
        this.gerenciadorLutadores.alterarLutador(lutadorAntigo, lutadorNovo);
        System.out.println("Lutador " + lutadorAntigo.getNome() + " alterado para " + nomeNovo + " com sucesso!");
        scanner.nextLine(); // Consome a quebra de linha após a entrada do peso
    }






    public void mostrarLutadores(GerenciadorLutadores gerenciadorLutadores) {
        // Recupera a lista de lutadores do gerenciador
        List<Lutador> lutadores = this.gerenciadorLutadores.getLutadores();

        // Verifica se a lista de lutadores está vazia
        if (lutadores.isEmpty()) {
            System.out.println("Não há lutadores cadastrados."); // Mensagem se a lista estiver vazia
        } else {
            // Exibe o título da lista de lutadores
            System.out.println("\n**LISTA DE LUTADORES**");

            // Itera sobre cada lutador na lista
            for (Lutador lutador : lutadores) {
                // Exibe as informações do lutador (toString do Lutador)
                System.out.println(lutador);
            }
        }
    }
}
