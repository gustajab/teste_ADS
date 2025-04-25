import java.util.List;
import java.util.Scanner;

/**
 * Classe principal que contém o método main e implementa a interface com o usuário.
 * Gerencia o menu de opções e a interação com as classes do sistema.
 */
public class Main {
    /**
     * Método principal que inicia o programa.
     * 
     * @param args Argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando instâncias das turmas disponíveis no sistema
        Turma turmaInfantil = new Turma("INF01", "infantil", 2023, 20);
        Turma turmaFundamental = new Turma("FUN01", "fundamental anos iniciais", 2023, 30);
        Turma turmaFundamenta2 = new Turma("FUN02", "fundamental anos finais", 2023, 32);
        Turma turmaMedia = new Turma("MED01", "médio", 2023, 35);

        int opcao = 0;

        // Loop principal do menu
        while (opcao != 5) {
            System.out.println("\n===== SISTEMA ESCOLAR =====");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos por Turma");
            System.out.println("3. Informações das Turmas");
            System.out.println("4. Buscar Aluno por CPF");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha após o número

            // Processamento da opção escolhida
            switch (opcao) {
                case 1:
                    cadastrarAluno(scanner, turmaInfantil, turmaFundamental, turmaFundamenta2, turmaMedia);
                    break;
                case 2:
                    listarAlunosPorTurma(scanner, turmaInfantil, turmaFundamental, turmaFundamenta2, turmaMedia);
                    break;
                case 3:
                    mostrarInfoTurmas(turmaInfantil, turmaFundamental, turmaFundamenta2, turmaMedia);
                    break;
                case 4:
                    buscarAlunoPorCPF(scanner, turmaInfantil, turmaFundamental, turmaFundamenta2, turmaMedia);
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close(); // Fecha o scanner para evitar vazamento de recursos
    }

    /**
     * Método para cadastrar um novo aluno em uma turma.
     * Solicita os dados do aluno e verifica se ele pode ser adicionado à turma escolhida.
     */
    private static void cadastrarAluno(Scanner scanner, Turma turmaInfantil, Turma turmaFundamental, Turma turmaFundamenta2, Turma turmaMedia) {
        System.out.println("\n=== Cadastro de Aluno ===");

        // Coleta os dados do aluno
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        // Cria o objeto Aluno com os dados informados
        Aluno aluno = new Aluno(nome, cpf, endereco, idade);

        // Menu para seleção da turma
        System.out.println("\nSelecione a turma:");
        System.out.println("1. Infantil");
        System.out.println("2. Fundamental Anos Iniciais");
        System.out.println("3. Fundamental Anos Finais");
        System.out.println("4. Médio");
        System.out.print("Opção: ");

        int opcaoTurma = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        boolean adicionado = false;

        // Tenta adicionar o aluno na turma selecionada
        switch (opcaoTurma) {
            case 1:
                adicionado = turmaInfantil.adicionarAluno(aluno);
                break;
            case 2:
                adicionado = turmaFundamental.adicionarAluno(aluno);
                break;
            case 3:
                adicionado = turmaFundamenta2.adicionarAluno(aluno);
                break;
            case 4:
                adicionado = turmaMedia.adicionarAluno(aluno);
                break;
            default:
                System.out.println("Opção de turma inválida!");
                return;
        }

        // Informa o resultado da operação
        if (adicionado) {
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Não foi possível cadastrar o aluno. Verifique a idade, limite de vagas ou se já está cadastrado.");
        }
    }

    /**
     * Método para listar todos os alunos de uma turma específica.
     */
    private static void listarAlunosPorTurma(Scanner scanner, Turma turmaInfantil, Turma turmaFundamental, Turma turmaFundamenta2, Turma turmaMedia) {
        System.out.println("\n=== Listar Alunos por Turma ===");
        System.out.println("1. Infantil");
        System.out.println("2. Fundamental Anos Iniciais");
        System.out.println("3. Fundamental Anos Finais");
        System.out.println("4. Médio");
        System.out.print("Escolha a turma: ");

        int opcaoTurma = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        List<Aluno> alunos = null;
        String nomeTurma = "";

        // Seleciona a turma escolhida
        switch (opcaoTurma) {
            case 1:
                alunos = turmaInfantil.getAlunos();
                nomeTurma = "Infantil";
                break;
            case 2:
                alunos = turmaFundamental.getAlunos();
                nomeTurma = "Fundamental Anos Iniciais";
                break;
            case 3:
                alunos = turmaFundamenta2.getAlunos();
                nomeTurma = "Fundamental Anos Finais";
                break;
            case 4:
                alunos = turmaMedia.getAlunos();
                nomeTurma = "Médio";
                break;
            default:
                System.out.println("Opção de turma inválida!");
                return;
        }

         System.out.println("\nAlunos da Turma " + nomeTurma + ":");

        // Verifica se há alunos na turma e os lista
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados nesta turma.");
        } else {
            for (int i = 0; i < alunos.size(); i++) {
                System.out.println((i + 1) + ". " + alunos.get(i));
            }
        }
    }

    /**
     * Método para mostrar informações resumidas de todas as turmas.
     */
    private static void mostrarInfoTurmas(Turma turmaInfantil, Turma turmaFundamental, Turma turmaFundamenta2, Turma turmaMedia) {
        System.out.println("\n=== Informações das Turmas ===");
        System.out.println("Turma Infantil: " + turmaInfantil);
        System.out.println("Turma Fundamental: " + turmaFundamental);
        System.out.println("Turma Fundamental Anos Finais: " + turmaFundamenta2);
        System.out.println("Turma Médio: " + turmaMedia);
    }
    
    /**
     * Método para buscar um aluno pelo CPF em todas as turmas.
     * Utiliza o método equals sobrescrito para comparar alunos.
     */
    private static void buscarAlunoPorCPF(Scanner scanner, Turma turmaInfantil, Turma turmaFundamental, 
                                         Turma turmaFundamenta2, Turma turmaMedia) {
        System.out.println("\n=== Buscar Aluno por CPF ===");
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();
        
        // Cria um aluno temporário apenas com o CPF para usar na comparação
        Aluno alunoBusca = new Aluno("", cpf, "", 0);
        
        // Busca o aluno em cada turma
        Aluno alunoEncontrado = null;
        String nomeTurma = "";
        
        // Verifica na turma infantil
        for (Aluno aluno : turmaInfantil.getAlunos()) {
            if (aluno.equals(alunoBusca)) {
                alunoEncontrado = aluno;
                nomeTurma = "Infantil";
                break;
            }
        }
        
        // Verifica na turma fundamental anos iniciais
        if (alunoEncontrado == null) {
            for (Aluno aluno : turmaFundamental.getAlunos()) {
                if (aluno.equals(alunoBusca)) {
                    alunoEncontrado = aluno;
                    nomeTurma = "Fundamental Anos Iniciais";
                    break;
                }
            }
        }
        
        // Verifica na turma fundamental anos finais
        if (alunoEncontrado == null) {
            for (Aluno aluno : turmaFundamenta2.getAlunos()) {
                if (aluno.equals(alunoBusca)) {
                    alunoEncontrado = aluno;
                    nomeTurma = "Fundamental Anos Finais";
                    break;
                }
            }
        }
        
        // Verifica na turma média
        if (alunoEncontrado == null) {
            for (Aluno aluno : turmaMedia.getAlunos()) {
                if (aluno.equals(alunoBusca)) {
                    alunoEncontrado = aluno;
                    nomeTurma = "Médio";
                    break;
                }
            }
        }
        
        // Exibe o resultado da busca
        if (alunoEncontrado != null) {
            System.out.println("\nAluno encontrado na turma " + nomeTurma + ":");
            System.out.println(alunoEncontrado);
        } else {
            System.out.println("\nAluno com CPF " + cpf + " não encontrado em nenhuma turma.");
        }
    }
}
