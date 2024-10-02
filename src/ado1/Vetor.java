package ado1;

import javax.swing.JOptionPane;

public class Vetor {
    public Object[] elementos;
    public int tamanho;
    
    // Construtor
    public Vetor(int capacidade) {
        this.elementos = new Object[capacidade];  // Corrigido para Object[]
        this.tamanho = 0;
    }

    // Método para adicionar elemento
    public void adicionar(Object elemento) throws Exception {
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("O vetor já está cheio, não é possível adicionar novos elementos");
        }
    }

    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(";");
        }
        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }
        s.append("]");
        return s.toString();
    }

    // Método de busca por posição
    public Object busca(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            return this.elementos[posicao];  // Corrigido para retornar Object
        } else {
            throw new Exception("Posição Inválida");
        }
    }

    // Método de busca de um elemento (busca1)
    public int busca1(Object elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;  // Retornar -1 se o elemento não for encontrado
    }  // Fechamento do método corrigido

    // Método para adicionar elemento em uma posição específica
    public boolean adicionaInicio(int posicao, Object elemento) throws Exception {
        this.aumentaCapacidade();
        if (posicao >= 0 && posicao <= tamanho) {
            for (int i = this.tamanho - 1; i >= posicao; i--) {
                this.elementos[i + 1] = this.elementos[i];
            }
            this.elementos[posicao] = elemento;  // Colocar o novo elemento na posição desejada
            this.tamanho++;  // Aumentar o tamanho após a inserção
        } else {
            throw new Exception("Posição Inválida");
        }

        return true;
    }

    // Método que aumenta a capacidade do vetor
    private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    // Método para remover elemento por posição
    public void remove(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            for (int i = posicao; i < this.tamanho - 1; i++) {
                this.elementos[i] = this.elementos[i + 1];
            }
            this.elementos[this.tamanho - 1] = null;  // Corrigido para usar tamanho - 1
            this.tamanho--;
        } else {
            throw new Exception("Posição Inválida");
        } 
    }
}
