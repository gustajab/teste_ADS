package Classes;
//import java.util.List;
//import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String cpf;
    private String endereco;
    private int idade;
    
    public Aluno(String nome, String cpf, String endereco, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
    }
    
    public int getIdade() {
        return idade;
    }

    public String getNome(){
        return nome;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + ", CPF: " + cpf + ", Endereço: " + endereco + ", Idade: " + idade;
    }

}
