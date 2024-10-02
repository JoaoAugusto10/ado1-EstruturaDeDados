package ado1;

public class Filme {
    private String titulo;

    // Construtor
    public Filme(String titulo) {
        this.titulo = titulo;
    }

    // Getter e Setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // toString para representar o objeto Filme como string
    @Override
    public String toString() {
        return "Filme{" +
                "Título='" + titulo + '\'' +
                '}';
    } 
}
