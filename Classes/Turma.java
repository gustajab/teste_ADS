import java.util.ArrayList;
import java.util.List;
/**
 * Classe que representa uma turma escolar.
 * Gerencia informações sobre a turma e a lista de alunos matriculados.
 */
public class Turma {
    // Atributos privados para garantir o encapsulamento
    private String codigo;
    private String etapaEnsino;
    private int ano;
    private int limiteVagas;
    private ListaDeAlunos alunos;

    /**
     * Construtor que inicializa uma nova turma.
     * 
     * @param codigo Código de identificação da turma
     * @param etapaEnsino Etapa de ensino (infantil, fundamental anos iniciais, etc.)
     * @param ano Ano letivo da turma
     * @param limiteVagas Número máximo de alunos permitidos na turma
     */
    public Turma(String codigo, String etapaEnsino, int ano, int limiteVagas) {
        this.codigo = codigo;
        this.etapaEnsino = etapaEnsino;
        this.ano = ano;
        this.limiteVagas = limiteVagas;
        this.alunos = new ListaDeAlunos(); // Inicializa a lista vazia de alunos
    }

    /**
     * Adiciona um aluno à turma, verificando o limite de vagas e a idade adequada.
     * 
     * @param aluno Objeto Aluno a ser adicionado à turma
     * @return true se o aluno foi adicionado com sucesso, false caso contrário
     */
    public boolean adicionarAluno(Aluno aluno) {
        // Verifica se há vagas disponíveis e se a idade é adequada para a etapa de ensino
        if (alunos.getTamanho() < limiteVagas && validarIdade(aluno.getIdade())) {
            try {
                alunos.adicionar(aluno);
                return true;
            } catch (ExcecaoDeAlunoJaExistente e) {
                System.out.println("Erro ao adicionar aluno: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /**
     * Verifica se a idade do aluno é adequada para a etapa de ensino da turma.
     * 
     * @param idade Idade do aluno a ser verificada
     * @return true se a idade for adequada, false caso contrário
     */
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

    /**
     * Retorna a lista de alunos matriculados na turma.
     * 
     * @return Lista de objetos Aluno
     */
    public List<Aluno> getAlunos() {
        List<Aluno> listaAlunos = new ArrayList<>();
        for (int i = 0; i < alunos.getTamanho(); i++) {
            listaAlunos.add(alunos.get(i));
        }
        return listaAlunos;
    }

    /**
     * Retorna o código da turma.
     * 
     * @return Código de identificação da turma
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Retorna a etapa de ensino da turma.
     * 
     * @return Etapa de ensino (infantil, fundamental anos iniciais, etc.)
     */
    public String getEtapaEnsino() {
        return etapaEnsino;
    }

    /**
     * Retorna o ano letivo da turma.
     * 
     * @return Ano letivo
     */
    public int getAno() {
        return ano;
    }

    /**
     * Retorna o limite de vagas da turma.
     * 
     * @return Número máximo de alunos permitidos
     */
    public int getLimiteVagas() {
        return limiteVagas;
    }

    /**
     * Sobrescreve o método toString para fornecer uma representação textual da turma.
     * 
     * @return String com os dados formatados da turma
     */
    @Override
    public String toString() {
        return "Código: " + codigo + ", Etapa: " + etapaEnsino + ", Ano: " + ano + 
               ", Vagas: " + alunos.getTamanho() + "/" + limiteVagas;
    }
    
    /**
     * Sobrescreve o método equals para comparar turmas pelo código.
     * Duas turmas são consideradas iguais se possuem o mesmo código.
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
        
        // Converte o objeto para Turma
        Turma outraTurma = (Turma) obj;
        
        // Compara pelo código (identificador único)
        return this.codigo != null && this.codigo.equals(outraTurma.codigo);
    }
}
