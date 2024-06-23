public class Lutador {

    // Nome do lutador
    private String nome;

    // Altura do lutador (em metros)
    private double altura;

    // Peso do lutador (em kg)
    private double peso;

    // Categoria de peso do lutador (calculada a partir do peso)
    private String categoria;

    public Lutador(String nome, double altura, double peso) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.categoria = calcularCategoria(); // Calcula a categoria na hora da criação do lutador
    }

    // Getters e Setters para os atributos nome, altura e peso
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
        this.categoria = calcularCategoria(); // Recalcula a categoria após alteração de peso
    }

    public String getCategoria() {
        return categoria;
    }

    // Método privado para calcular a categoria de peso do lutador a partir do IMC
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

    // Sobrescreve o método toString() para retornar uma representação textual do lutador
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
