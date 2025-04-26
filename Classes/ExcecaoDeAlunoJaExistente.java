/**
 * Exceção personalizada que é lançada quando se tenta adicionar um aluno
 * que já existe na lista de alunos.
 */
public class ExcecaoDeAlunoJaExistente extends Exception {
    
    /**
     * Construtor que inicializa a exceção com uma mensagem padrão.
     */
    public ExcecaoDeAlunoJaExistente() {
        super("Aluno já existe na lista!");
    }
    
    /**
     * Construtor que inicializa a exceção com uma mensagem personalizada.
     * 
     * @param mensagem Mensagem de erro personalizada
     */
    public ExcecaoDeAlunoJaExistente(String mensagem) {
        super(mensagem);
    }
    
    /**
     * Construtor que inicializa a exceção com uma mensagem personalizada e a causa.
     * 
     * @param mensagem Mensagem de erro personalizada
     * @param causa Causa da exceção
     */
    public ExcecaoDeAlunoJaExistente(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
