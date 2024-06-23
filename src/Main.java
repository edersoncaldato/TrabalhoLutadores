import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create a GerenciadorLutadores object to manage fighters
        GerenciadorLutadores gerenciadorLutadores = new GerenciadorLutadores();
        Menu menu = new Menu(scanner); // Pass Scanner object
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(scanner, gerenciadorLutadores);

        // Execute the main menu
        interfaceUsuario.executarMenu();

        // Close the scanner object
        scanner.close();
    }
}
