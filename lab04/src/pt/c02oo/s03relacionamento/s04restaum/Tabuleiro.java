package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private Peca tabuleiro[][];
	private char board[][];
	
	public Tabuleiro(char board[][]) {
		this.tabuleiro = new Peca[7][7];
		for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) 
            	if(i == 3 && j == 3)
            		this.tabuleiro[i][j] = new Peca(i, j, false); //posicao do meio que comeca sem peca 
            	else if (posicaoValida(i, j))
                    this.tabuleiro[i][j] = new Peca(i, j, true);
            	else
            		this.tabuleiro[i][j] = null; //posicao fora do tabuleiro
		}
		this.board = board;
	}
	
	public char[][] getBoard() {
		return board;
	}

	public boolean posicaoValida(int l, int c) { //retorna verdadeiro se for uma posicao do tabuleiro
        if((c == 0 || c == 1 || c == 5 || c == 6) && (l == 0 || l == 1 || l == 5 || l == 6))
            return false;
        return true;			
	}
	
	public void conectaPeca(Tabuleiro tabuleiroJogo) {
		for(int i = 0; i < 7; i++) 
			for(int j = 0; j < 7; j++) 
				if (posicaoValida(i, j) || (i == 3 && j == 3))
					tabuleiro[i][j].conecta(tabuleiroJogo);
	}
	
	public void mover(int linha, int coluna, int novaLinha, int novaColuna) {
		//fala pra peça q quer q ela se mova para tal lugar
		tabuleiro[linha][coluna].movimentarPeca(novaLinha, novaColuna);
	}

	public boolean verificarExistencia(int linha, int coluna) { //devolve se a peca ainda existe no tabuleiro 
		if(tabuleiro[linha][coluna].getExiste())
			return true;
		return false;
	}
	
	public void mudarExistencia(int linha, int coluna) {
		if(tabuleiro[linha][coluna].getExiste()) {
			tabuleiro[linha][coluna].setExiste(false);
			board[linha][coluna] = '-';
		} else {
			tabuleiro[linha][coluna].setExiste(true);
			board[linha][coluna] = 'P';
		}
	}
	
	public void tirarPeca(int linha, int coluna) {
	//se a peça avisar q comeu outra peça, ent o tabuleiro retira essa peça
		mudarExistencia(linha, coluna);
	}
}
