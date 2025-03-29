package Classes;

/**
 * Classe que representa um aluno no sistema escolar.
 * Armazena informações pessoais como nome, CPF, endereço e idade.
 */
public class Aluno {
    // Atributos privados para garantir o encapsulamento
    private String nome;
    private String cpf;
    private String endereco;
    private int idade;
    
    /**
     * Construtor que inicializa um novo aluno com seus dados básicos.
     * 
     * @param nome Nome completo do aluno
     * @param cpf CPF do aluno (documento de identificação)
     * @param endereco Endereço residencial do aluno
     * @param idade Idade do aluno em anos
     */
    public Aluno(String nome, String cpf, String endereco, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
    }
    
    /**
     * Retorna a idade do aluno.
     * 
     * @return Idade do aluno em anos
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Retorna o nome do aluno.
     * 
     * @return Nome completo do aluno
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna o CPF do aluno.
     * 
     * @return CPF do aluno
     */
    public String getCpf() {
        return cpf;
    }
    
    /**
     * Retorna o endereço do aluno.
     * 
     * @return Endereço residencial do aluno
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Sobrescreve o método toString para fornecer uma representação textual do aluno.
     * 
     * @return String com os dados formatados do aluno
     */
    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Endereço: " + endereco + ", Idade: " + idade;
    }



    public class ListaDeAlunos {
        private class No {
            Aluno aluno;
            No proximo;

        No(Aluno aluno) {
            this.aluno = aluno;
            this.proximo = null;
        }
    }

        private No primeiro;
        private No ultimo;
        private int tamanho;

    public ListaDeAlunos() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    // Adiciona um aluno no início da lista
    public void incluirNoInicio(Aluno aluno) {
        No novoNo = new No(aluno);
        if (tamanho == 0) {
            primeiro = ultimo = novoNo;
        } else {
            novoNo.proximo = primeiro;
            primeiro = novoNo;
        }
        tamanho++;
    }

    // Adiciona um aluno no final da lista
    public void incluirNoFim(Aluno aluno) {
        No novoNo = new No(aluno);
        if (tamanho == 0) {
            primeiro = ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            ultimo = novoNo;
        }
        tamanho++;
    }

    // Ordena a lista em ordem alfabética pelo nome
    public void ordenar() {
        if (tamanho <= 1) return;
        for (No i = primeiro; i != null; i = i.proximo) {
            for (No j = i.proximo; j != null; j = j.proximo) {
                if (i.aluno.getNome().compareTo(j.aluno.getNome()) > 0) {
                    Aluno temp = i.aluno;
                    i.aluno = j.aluno;
                    j.aluno = temp;
                }
            }
        }
    }

    // Remove e retorna o aluno do final da lista
    public Aluno removerDoFim() {
        if (tamanho == 0) return null;
        Aluno alunoRemovido = ultimo.aluno;
        if (tamanho == 1) {
            primeiro = ultimo = null;
        } else {
            No penultimo = primeiro;
            while (penultimo.proximo != ultimo) {
                penultimo = penultimo.proximo;
            }
            penultimo.proximo = null;
            ultimo = penultimo;
        }
        tamanho--;
        return alunoRemovido;
    }

    // Retorna o número de alunos na lista
    public int tamanho() {
        return tamanho;
    }

    public Aluno get(int index) {
        if (index < 0 || index >= tamanho) return null;
        No atual = primeiro;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual.aluno;
    }
}

}
