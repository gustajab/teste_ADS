/**
 * Classe que implementa uma lista encadeada de alunos.
 * Permite armazenar e manipular uma coleção de objetos Aluno.
 */
public class ListaDeAlunos {
    private class No {
        Aluno aluno;
        No proximo;
        
        public No(Aluno aluno) {
            this.aluno = aluno;
            this.proximo = null;
        }
    }
    
    private No primeiro;
    private No ultimo;
    private int tamanho;
    
    /**
     * Construtor que inicializa uma lista vazia.
     */
    public ListaDeAlunos() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    
    /**
     * Adiciona um aluno ao final da lista.
     * 
     * @param aluno Aluno a ser adicionado
     */
    public void adicionar(Aluno aluno) {
        No novoNo = new No(aluno);
        
        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            ultimo = novoNo;
        }
        
        tamanho++;
    }
    
    /**
     * Retorna o aluno na posição especificada.
     * 
     * @param index Índice do aluno a ser retornado
     * @return Aluno na posição especificada ou null se o índice for inválido
     */
    public Aluno get(int index) {
        if (index < 0 || index >= tamanho) {
            return null;
        }
        
        No atual = primeiro;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        
        return atual.aluno;
    }
    
    /**
     * Verifica se a lista contém o aluno especificado.
     * Utiliza o método equals da classe Aluno para comparação.
     * 
     * @param aluno Aluno a ser verificado
     * @return true se o aluno estiver na lista, false caso contrário
     */
    public boolean contem(Aluno aluno) {
        No atual = primeiro;
        
        while (atual != null) {
            if (atual.aluno.equals(aluno)) {
                return true;
            }
            atual = atual.proximo;
        }
        
        return false;
    }
    
    /**
     * Retorna o tamanho da lista.
     * 
     * @return Número de alunos na lista
     */
    public int getTamanho() {
        return tamanho;
    }
    
    /**
     * Verifica se a lista está vazia.
     * 
     * @return true se a lista estiver vazia, false caso contrário
     */
    public boolean estaVazia() {
        return tamanho == 0;
    }
}
