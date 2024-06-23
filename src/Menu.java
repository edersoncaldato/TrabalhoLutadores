import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    public GerenciadorLutadores gerenciadorLutadores;
    private InterfaceUsuario interfaceUsuario;
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
        System.out.println("5. Fechar Categorias");
        System.out.println("6. Sair");
        System.out.print("Digite sua opção: ");
    }

    public int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            return opcao; // Return the read option directly
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            scanner.next(); // Consume invalid input
            return 0; // Indicate invalid input (optional, adjust based on your logic)
        }
    }
}
