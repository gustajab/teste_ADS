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
    
    /**
     * Sobrescreve o método equals para comparar alunos pelo CPF.
     * Dois alunos são considerados iguais se possuem o mesmo CPF.
     */
    @Override
    public boolean equals(Object obj) {
        // Verifica se é o mesmo objeto
        if (this == obj) {
            return true;
        }
        
        // Verifica se o objeto é nulo ou de classe diferente
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        // Converte o objeto para Aluno
        Aluno outroAluno = (Aluno) obj;
        
        // Compara pelo CPF (identificador único)
        return this.cpf != null && this.cpf.equals(outroAluno.cpf);
    }
}
