import java.util.ArrayList; // Import ArrayList or your preferred List implementation
import java.util.List;
public class GerenciadorLutadores {

    private List<Lutador> lutadores;

    public GerenciadorLutadores() {
        this.lutadores = new ArrayList<>();
    }

    public void adicionarLutador(Lutador lutador) {
        lutadores.add(lutador);
    }

    public void removerLutador(Lutador lutador) {
        lutadores.remove(lutador);
    }

    public void alterarLutador(Lutador lutadorAntigo, Lutador lutadorNovo) {
        int index = lutadores.indexOf(lutadorAntigo);
        if (index != -1) {
            lutadores.set(index, lutadorNovo);
        }
    }

    public List<Lutador> getLutadores() {
        return lutadores;
    }

    public void fecharCategorias() {
        System.out.println("**CATEGORIAS FECHADAS**");
        for (Lutador lutador : lutadores) {
            System.out.println(lutador);
        }
    }
}
