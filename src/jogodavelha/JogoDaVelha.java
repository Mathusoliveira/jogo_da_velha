package jogodavelha;

public class JogoDaVelha {

    private char[][] jogoDaVelha;
    private int jogada;
    private final char sinalX;
    private final char sinalO;

    public JogoDaVelha() {
        jogoDaVelha = new char[3][3];
        jogada = 1;
        sinalX = 'X';
        sinalO = 'O';

        // Inicializar o tabuleiro com espaços
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jogoDaVelha[i][j] = ' ';
            }
        }
    }

    public int getJogada() {
        return jogada;
    }

    public void setJogada(int jogada) {
        this.jogada = jogada;
    }

    public char getSinalX() {
        return sinalX;
    }

    public char getSinalO() {
        return sinalO;
    }

    // Inserir símbolo no tabuleiro
    public boolean inserirChar(int linha, int coluna, char sinal) {
        if (jogoDaVelha[linha][coluna] == ' ') {
            jogoDaVelha[linha][coluna] = sinal;
            return true; // jogada válida
        } else {
            System.out.println("Posição já ocupada! Tente outra.");
            return false; // jogada inválida
        }
    }

    // Verifica se é a vez do jogador 1
    public boolean vezJogador1() {
        return jogada % 2 == 1;
    }

    // Verifica se o jogador com o símbolo 'sinal' ganhou
    public boolean validarGanhador(char sinal) {
        return (jogoDaVelha[0][0] == sinal && jogoDaVelha[0][1] == sinal && jogoDaVelha[0][2] == sinal) ||
               (jogoDaVelha[1][0] == sinal && jogoDaVelha[1][1] == sinal && jogoDaVelha[1][2] == sinal) ||
               (jogoDaVelha[2][0] == sinal && jogoDaVelha[2][1] == sinal && jogoDaVelha[2][2] == sinal) ||
               (jogoDaVelha[0][0] == sinal && jogoDaVelha[1][0] == sinal && jogoDaVelha[2][0] == sinal) ||
               (jogoDaVelha[0][1] == sinal && jogoDaVelha[1][1] == sinal && jogoDaVelha[2][1] == sinal) ||
               (jogoDaVelha[0][2] == sinal && jogoDaVelha[1][2] == sinal && jogoDaVelha[2][2] == sinal) ||
               (jogoDaVelha[0][0] == sinal && jogoDaVelha[1][1] == sinal && jogoDaVelha[2][2] == sinal) ||
               (jogoDaVelha[0][2] == sinal && jogoDaVelha[1][1] == sinal && jogoDaVelha[2][0] == sinal);
    }

    // Imprimir o tabuleiro
    public void imprimirTabuleiro() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(jogoDaVelha[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }
}