import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    // Referência ao gerenciador de lutadores (para interagir com a lista de lutadores)
    private GerenciadorLutadores gerenciadorLutadores;

    // Referência à interface de usuário (para delegar tarefas de exibição e leitura de dados)
    private InterfaceUsuario interfaceUsuario;

    // Scanner para leitura de entradas do usuário
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void exibirMenu() {
        System.out.println("\n**MENU**");
        System.out.println("1. Adicionar Lutador");
        System.out.println("2. Remover Lutador");
        System.out.println("3. Alterar Lutador");
        System.out.println("4. Mostrar Lutadores");
        System.out.println("5. Fechar Categorias"); // (A função dessa opção depende da implementação do GerenciadorLutadores)
        System.out.println("6. Sair");
        System.out.print("Digite sua opção: ");
    }

    public int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            return opcao;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            scanner.next(); // Consome a entrada inválida
            return 0; // Retorna 0 para indicar entrada inválida (opcional, ajuste de acordo com sua lógica)
        }
    }
}
