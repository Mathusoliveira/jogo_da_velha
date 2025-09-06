package jogodavelha;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();

        System.out.println("Jogador 1 = X");
        System.out.println("Jogador 2 = O");

        boolean ganhou = false;

        while (!ganhou && jogo.getJogada() <= 9) {

            char sinal = jogo.vezJogador1() ? jogo.getSinalX() : jogo.getSinalO();
            System.out.println("Vez do jogador " + (jogo.vezJogador1() ? "1" : "2"));

            int linha = valor("linha", sc);
            int coluna = valor("coluna", sc);

            // Tenta inserir o símbolo; se inválido, não incrementa a jogada
            if (jogo.inserirChar(linha, coluna, sinal)) {
                jogo.setJogada(jogo.getJogada() + 1);
            } else {
                continue; // pede outro valor
            }

            jogo.imprimirTabuleiro();

            if (jogo.validarGanhador(sinal)) {
                ganhou = true;
                System.out.println("Parabéns!! Jogador " + (sinal == jogo.getSinalX() ? "1" : "2") + " venceu.");
            } else if (jogo.getJogada() > 9) {
                System.out.println("Deu velha!!!");
            }
        }

        sc.close();
    }

    // Função para ler valores válidos
    static int valor(String tipoValor, Scanner sc) {
        int valor = 0;
        boolean valorValido = false;
        while (!valorValido) {
            System.out.print("Entre com a " + tipoValor + " (1, 2 ou 3): ");
            valor = sc.nextInt();
            if (valor >= 1 && valor <= 3) {
                valorValido = true;
            } else {
                System.out.println("Tente novamente!");
            }
        }
        return valor - 1; // ajustar índice 0-based
    }
}