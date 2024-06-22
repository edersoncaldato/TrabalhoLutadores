import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Cria um gerenciador de lutadores
        GerenciadorLutadores gerenciadorLutadores = new GerenciadorLutadores();

        // Cria uma interface de usuário
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(gerenciadorLutadores);

        // Executa o menu principal
        interfaceUsuario.executarMenu();
    }
}