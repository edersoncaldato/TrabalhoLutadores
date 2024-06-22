public class Lutador {

    private String nome;
    private double altura;
    private double peso;
    private String categoria;

    public Lutador(String nome, double altura, double peso) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.categoria = calcularCategoria();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
        this.categoria = calcularCategoria(); // Atualiza a categoria após a alteração do peso
    }

    public String getCategoria() {
        return categoria;
    }

    private String calcularCategoria() {
        double imc = peso / (altura * altura);
        if (imc > 30) {
            return "Pesado";
        } else if (imc < 24.9) {
            return "Pena";
        } else {
            return "Médio";
        }
    }

    @Override
    public String toString() {
        return "Lutador{" +
                "nome='" + nome + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
