import java.util.ArrayList; // Import ArrayList or your preferred List implementation
import java.util.List;

public class GerenciadorLutadores {

    private List<Lutador> lutadores; // Lista para armazenar os lutadores

    public GerenciadorLutadores() {
        this.lutadores = new ArrayList<>(); // Inicializa a lista de lutadores com um ArrayList vazio
    }

    public void adicionarLutador(Lutador lutador) {
        lutadores.add(lutador); // Adiciona um novo lutador à lista
    }

    public void removerLutador(Lutador lutador) {
        lutadores.remove(lutador); // Remove um lutador da lista
    }

    public void alterarLutador(Lutador lutadorAntigo, Lutador lutadorNovo) {
        int index = lutadores.indexOf(lutadorAntigo); // Obtém o índice do lutador antigo na lista
        if (index != -1) { // Verifica se o lutador antigo foi encontrado
            lutadores.set(index, lutadorNovo); // Substitui o lutador antigo pelo novo na lista
        }
    }

    public List<Lutador> getLutadores() {
        return lutadores; // Retorna a lista de lutadores
    }

    public void fecharCategorias() {
        System.out.println("**CATEGORIAS FECHADAS**"); // Exibe uma mensagem indicando que as categorias foram fechadas
        for (Lutador lutador : lutadores) { // Itera sobre cada lutador na lista
            System.out.println(lutador); // Exibe as informações do lutador
        }
    }
}
