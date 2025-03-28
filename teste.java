import java.util.Scanner;

class Aluno {
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

    class Turma {
    private String codigo;
    private String etapaEnsino;
    private int ano;
    private int limiteVagas;
    private List<Aluno> alunos;
    
    public Turma(String codigo, String etapaEnsino, int ano, int limiteVagas) {
        this.codigo = codigo;
        this.etapaEnsino = etapaEnsino;
        this.ano = ano;
        this.limiteVagas = limiteVagas;
        this.alunos = new ArrayList<>();
    }
     @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Endereço: " + endereco + ", Idade: " + idade;
    }
}

    public boolean adicionarAluno(Aluno aluno) {
        if (alunos.size() < limiteVagas && validarIdade(aluno.getIdade())) {
            alunos.add(aluno);
            return true;
        }
        return false;
    }

    class ListaDeAlunos {
    private Aluno[] alunos;
    private int tamanho;

    public ListaDeAlunos(int capacidade) {
        alunos = new Aluno[capacidade];
        tamanho = 0;
    }

    public void incluirNoInicio(Aluno aluno) {
        if (tamanho >= alunos.length) return;
        for (int i = tamanho; i > 0; i--) {
            alunos[i] = alunos[i - 1];
        }
        alunos[0] = aluno;
        tamanho++;
    }

     public void incluirNoFim(Aluno aluno) {
        if (tamanho >= alunos.length) return;
        alunos[tamanho] = aluno;
        tamanho++;
    }