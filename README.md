# Sistema Escolar - Gerenciamento de Alunos e Turmas

Este projeto implementa um sistema simples de gerenciamento escolar, permitindo o cadastro de alunos em diferentes turmas de acordo com suas idades, além de funcionalidades de consulta e listagem.

## Funcionalidades

- Cadastro de alunos com validação de idade para cada tipo de turma
- Listagem de alunos por turma
- Visualização de informações das turmas
- Busca de alunos por CPF
- Verificação de duplicidade de alunos (pelo CPF)

## Estrutura do Projeto

O projeto está organizado nas seguintes classes:

- **Aluno**: Representa um aluno com seus dados pessoais
- **Turma**: Representa uma turma escolar e gerencia a lista de alunos matriculados
- **ListaDeAlunos**: Implementa uma lista encadeada de alunos (estrutura de dados alternativa)
- **Main**: Classe principal com interface de usuário via console

## Como Compilar e Executar

### Compilação
Para compilar os arquivos, navegue até o diretório que contém a pasta "Classes" e execute:

```
cd Classes
javac *.java
```

### Execução
Após compilar, execute a classe Main:

```
java Main
```

## Requisitos do Sistema

- Java JDK 8 ou superior

## Implementação de Conceitos OO

Este projeto demonstra vários conceitos de Orientação a Objetos:

1. **Encapsulamento**: Atributos privados com métodos getters
2. **Sobrescrita de métodos**: Implementação personalizada dos métodos `toString()` e `equals()` da classe Object
3. **Composição**: Turmas contêm listas de alunos
4. **Validação de dados**: Verificação de idade adequada para cada turma
5. **Estrutura de dados**: Implementação de uma lista encadeada personalizada

## Etapas de Desenvolvimento

### Primeira Etapa
- Implementação das classes básicas
- Funcionalidades de cadastro e listagem

### Segunda Etapa
- Sobrescrita dos métodos `toString()` e `equals()`
- Implementação da busca por CPF
- Verificação de duplicidade de alunos
- Organização do código em arquivos separados
