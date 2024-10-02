package ado1;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Vetor vetor = new Vetor(10);

        while (true) {
            String menu = "Menu de Opções:\n"
                    + "1. Adicionar Filme\n"
                    + "2. Remover Filme\n"
                    + "3. Buscar Filme por Posição\n"
                    + "4. Buscar Posição de um Filme\n"
                    + "5. Exibir Vetor de Filmes\n"
                    + "6. Alterar Filme\n"
                    + "7. Sair\n"
                    + "Escolha uma opção:";
            String opcaoStr = JOptionPane.showInputDialog(menu);
            int opcao;

            try {
                opcao = Integer.parseInt(opcaoStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, insira um número.");
                continue;
            }

            try {
                switch (opcao) {
                    case 1:  // Adicionar Filme
                        String titulo = JOptionPane.showInputDialog("Digite o título do filme:");
                        Filme filme = new Filme(titulo);
                        vetor.adicionar(filme);  // Adicionando objeto Filme ao vetor
                        JOptionPane.showMessageDialog(null, "Filme adicionado com sucesso!");
                        break;

                    case 2:  // Remover Filme por posição
                        String posicaoRemoverStr = JOptionPane.showInputDialog("Digite a posição do filme a ser removido:");
                        int posicaoRemover = Integer.parseInt(posicaoRemoverStr);
                        vetor.remove(posicaoRemover);  // Usando o método remove da classe Vetor
                        JOptionPane.showMessageDialog(null, "Filme removido com sucesso!");
                        break;

                    case 3:  // Buscar Filme por posição
                        String posicaoBuscarStr = JOptionPane.showInputDialog("Digite a posição do filme a ser buscado:");
                        int posicaoBuscar = Integer.parseInt(posicaoBuscarStr);
                        Object filmeBuscado = vetor.busca(posicaoBuscar);  // Usando o método busca da classe Vetor
                        JOptionPane.showMessageDialog(null, "Filme na posição " + posicaoBuscar + ": " + filmeBuscado);
                        break;

                    case 4:  // Buscar Posição de um Filme
                        String tituloBuscar = JOptionPane.showInputDialog("Digite o título do filme a ser buscado:");
                        int posicaoEncontrada = -1;
                        // Vamos percorrer o vetor para buscar um filme com o título fornecido
                        for (int i = 0; i < vetor.tamanho(); i++) {
                            Filme f = (Filme) vetor.busca(i);
                            if (f.getTitulo().equalsIgnoreCase(tituloBuscar)) {
                                posicaoEncontrada = i;
                                break;
                            }
                        }

                        if (posicaoEncontrada != -1) {
                            JOptionPane.showMessageDialog(null, "Filme encontrado na posição: " + posicaoEncontrada);
                        } else {
                            JOptionPane.showMessageDialog(null, "Filme não encontrado.");
                        }
                        break;

                    case 5:  // Exibir vetor de filmes
                        JOptionPane.showMessageDialog(null, "Conteúdo do vetor de filmes: " + vetor.toString());
                        break;

                    case 6:  // Alterar dados de um filme
                        String posicaoAlterarStr = JOptionPane.showInputDialog("Digite a posição do filme a ser alterado:");
                        int posicaoAlterar = Integer.parseInt(posicaoAlterarStr);
                        Filme filmeParaAlterar = (Filme) vetor.busca(posicaoAlterar);  // Buscando o filme na posição

                        if (filmeParaAlterar != null) {
                            String novoTitulo = JOptionPane.showInputDialog("Digite o novo título do filme:");
                            filmeParaAlterar.setTitulo(novoTitulo);  // Alterando o título do filme
                            JOptionPane.showMessageDialog(null, "Filme alterado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Filme não encontrado.");
                        }
                        break;

                    case 7:  // Sair do programa
                        JOptionPane.showMessageDialog(null, "Saindo...");
                        return;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            } 
        }
    }
}
