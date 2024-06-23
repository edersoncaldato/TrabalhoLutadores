import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Cria um objeto Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Cria um objeto GerenciadorLutadores para gerenciar lutadores
        GerenciadorLutadores gerenciadorLutadores = new GerenciadorLutadores();

        // Cria um objeto Menu passando o scanner para leitura de entrada
        Menu menu = new Menu(scanner);

        // Cria um objeto InterfaceUsuario passando o scanner e o gerenciador de lutadores
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(scanner, gerenciadorLutadores);

        // Executa o menu principal
        interfaceUsuario.executarMenu();

        // Fecha o objeto Scanner para liberar recursos
        scanner.close();
    }
}
