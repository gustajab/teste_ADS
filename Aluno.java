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
}
