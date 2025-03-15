package Classes;

import java.util.ArrayList;
import java.util.List;

public class Turma {
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
    // @Override
    //  public String toString() {
    //     return "Nome: " + nome + ", CPF: " + cpf + ", Endereço: " + endereco + ", Idade: " + idade;
    //  }


    public boolean adicionarAluno(Aluno aluno) {
        if (alunos.size() < limiteVagas && validarIdade(aluno.getIdade())) {
            alunos.add(aluno);
            return true;
        }
        return false;
    }

    private boolean validarIdade(int idade) {
        switch (etapaEnsino.toLowerCase()) {
            case "infantil":
                return idade < 6;
            case "fundamental anos iniciais":
                return idade >= 6 && idade <= 11;
            case "fundamental anos finais":
                return idade >= 11 && idade <= 15;
            case "médio":
                return idade >= 15 && idade <= 18;
            default:
                return false;
        }
    }
    @Override
    public String toString() {
        return "Código: " + codigo + ", Etapa: " + etapaEnsino + ", Ano: " + ano + 
               ", Vagas: " + alunos.size() + "/" + limiteVagas;
    }
}

