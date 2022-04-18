package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private Peca tabuleiro[][];
	private char board[][];
	
	public Tabuleiro(char board[][]) {
		this.tabuleiro = new Peca[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
            	if(i == 3 && j == 3) {
            		this.tabuleiro[i][j] = new Peca(i, j, false); //posicao do meio que comeca sem peca 
            	} else if (posicaoValida(i, j)) {
            		this.tabuleiro[i][j] = new Peca(i, j, true); //posicao onde tem peca
            	} else {
            		this.tabuleiro[i][j] = null; //posicao fora do tabuleiro
            	}
			}
		}
		this.board = board;
	}
	
	public char[][] getBoard() {
		return board;
	}

	public boolean posicaoValida(int linha, int coluna) { 
		/* retorna verdadeiro se for uma posicao do tabuleiro */
		if(((coluna >= 2 && coluna <= 4) && (linha >= 0 && linha <= 6)) || ((coluna >= 0 && coluna <= 6) && (linha >= 2 && linha <= 4)))
			return true;
		return false;
	}
	
	public void conectaPeca(Tabuleiro tabuleiroJogo) { 
		/* conecta cada peca ao tabuleiro */
		for(int i = 0; i < 7; i++) 
			for(int j = 0; j < 7; j++) 
				if (posicaoValida(i, j) || (i == 3 && j == 3))
					tabuleiro[i][j].conecta(tabuleiroJogo);
	}
	
	public void mover(int linha, int coluna, int novaLinha, int novaColuna) { 
		/* pede para a peca se mover */
		tabuleiro[linha][coluna].movimentarPeca(novaLinha, novaColuna);
	}

	public boolean verificarExistencia(int linha, int coluna) { 
		/* retorna verdadeiro se existe uma peca em tal linha e coluna */
		if(tabuleiro[linha][coluna].getExiste())
			return true;
		return false;
	}
	
	public void mudarExistencia(int linha, int coluna) {
		/* muda a existencia de uma peca em determinada posicao (linha e coluna) do tabuleiro
		   tambem altera o simbolo na matriz board */
		if(tabuleiro[linha][coluna].getExiste()) {
			tabuleiro[linha][coluna].setExiste(false);
			board[linha][coluna] = '-';
		} else {
			tabuleiro[linha][coluna].setExiste(true);
			board[linha][coluna] = 'P';
		}
	}
	
	public void tirarPeca(int linha, int coluna) {
		/* se a peca avisar que comeu outra peca, entao o tabuleiro retira essa peca comida (tabuleiro[linha][coluna]) */
		mudarExistencia(linha, coluna);
	}
}
