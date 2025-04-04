
public class Aluno {
    // Atributos privados para garantir o encapsulamento
    private String nome;
    private String cpf;
    private String endereco;
    private int idade;

    /**
     * Construtor que inicializa um novo aluno com seus dados básicos.
     */
    public Aluno(String nome, String cpf, String endereco, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
    }

    /**
     * Retorna a idade do aluno.
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Retorna o nome do aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o CPF do aluno.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Retorna o endereço do aluno.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Sobrescreve o método toString para fornecer uma representação textual do aluno.
     */
    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Endereço: " + endereco + ", Idade: " + idade;
    }
}

// Se você quiser manter a classe ListaDeAlunos, ela deve ser definida como uma classe separada
class ListaDeAlunos {
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
    
    public ListaDeAlunos() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    
    // Adicione aqui os métodos da classe ListaDeAlunos
    
    public Aluno get(int index) {
        // Implementação do método get
        return null; // Substitua por sua implementação real
    }
}
