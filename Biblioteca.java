package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    private int contadorEmprestimo = 1;

    public void iniciar() {
        carregarDados();

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Listar livros disponíveis");
            System.out.println("2 - Realizar empréstimo");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    listarLivros();
                    break;

                case 2:
                    realizarEmprestimoFluxo(sc);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void realizarEmprestimoFluxo(Scanner sc) {

        listarLivros();

        System.out.print("Digite o ID do livro: ");
        int id = sc.nextInt();
        sc.nextLine();

        Livro livro = buscarLivro(id);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (!livro.isDisponivel()) {
            System.out.println("Livro já está emprestado.");
            return;
        }

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        livro.setDisponivel(false);

        Emprestimo e = new Emprestimo(contadorEmprestimo++, livro, nome);
        emprestimos.add(e);

        System.out.println("Empréstimo realizado com sucesso!");
    }

    private void carregarDados() {
        Autor a1 = new Autor(1, "Machado de Assis", LocalDate.of(1839, 6, 21));
        Autor a2 = new Autor(2, "Clarice Lispector", LocalDate.of(1920, 12, 10));

        autores.add(a1);
        autores.add(a2);

        livros.add(new Livro(1, "Dom Casmurro", a1));
        livros.add(new Livro(2, "Memórias Póstumas de Brás Cubas", a1));
        livros.add(new Livro(3, "A Hora da Estrela", a2));
    }

    private void listarLivros() {
        System.out.println("\n📚 Livros disponíveis:");

        for (Livro l : livros) {
            if (l.isDisponivel()) {
                System.out.println(
                        "ID: " + l.getId() +
                        " | " + l.getTitulo() +
                        " | Autor: " + l.getAutor().getNome()
                );
            }
        }
    }

    private Livro buscarLivro(int id) {
        for (Livro l : livros) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }
}