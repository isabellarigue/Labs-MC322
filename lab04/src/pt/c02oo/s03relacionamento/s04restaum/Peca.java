package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	private int posLinha, posColuna;
	private boolean existe;
	private Tabuleiro tabuleiroConecta;
	
	public Peca(int posLinha, int posColuna, boolean existe) {
		this.posLinha = posLinha;
		this.posColuna = posColuna;
		this.existe = existe;
		this.tabuleiroConecta = null;
	}
	
	public boolean getExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}
	
	public void conecta(Tabuleiro saida) {
		this.tabuleiroConecta = saida;
	}

	public boolean verificarCaminho(int novaLinha, int novaColuna) { 
		/* verifica se o caminho para a peca ir na posicao pretendida (novaLinha e novaColuna) eh valido */
		//primeiramente, verifica-se se o lugar pretendido esta vazio e se eh uma posicao do tabuleiro:
		if((! tabuleiroConecta.verificarExistencia(novaLinha, novaColuna)) && (tabuleiroConecta.posicaoValida(novaLinha, novaColuna))) { 
			if((novaLinha == posLinha + 2) && (novaColuna == posColuna)) {//movimenta para baixo
				if(tabuleiroConecta.verificarExistencia(novaLinha - 1, novaColuna)) { //vendo se tem uma peca a ser comida
					tabuleiroConecta.tirarPeca(novaLinha - 1, novaColuna); //avisando o tabuleiro para ele tirar a peca, ja que esta foi comida
					return true;
				}
			} else if((novaLinha == posLinha - 2) && (novaColuna == posColuna)){ //movimenta para cima
				if(tabuleiroConecta.verificarExistencia(novaLinha + 1, novaColuna)) { //vendo se tem uma peca a ser comida
					tabuleiroConecta.tirarPeca(novaLinha + 1, novaColuna); //avisando o tabuleiro para ele tirar a peca, ja que esta foi comida
					return true;
				}
			} else if((novaColuna == posColuna + 2) && (novaLinha == posLinha)) { //movimenta para direita
				if(tabuleiroConecta.verificarExistencia(novaLinha, novaColuna - 1)) { //vendo se tem uma peca a ser comida
					tabuleiroConecta.tirarPeca(novaLinha, novaColuna - 1); //avisando o tabuleiro para ele tirar a peca, ja que esta foi comida
					return true;
				}
			} else if((novaColuna == posColuna - 2) && (novaLinha == posLinha)) { //movimenta para esquerda 
				if(tabuleiroConecta.verificarExistencia(novaLinha, novaColuna + 1)) { //vendo se tem uma peca a ser comida
					tabuleiroConecta.tirarPeca(novaLinha, novaColuna + 1); //avisando o tabuleiro para ele tirar a peca, ja que esta foi comida
					return true;
				}
			}
		}
		return false;
	}
	
	public void movimentarPeca(int novaLinha, int novaColuna) {
		/* verifica se eh possivel ir para a nova posicao pretendida, caso sim altera as condicoes de existencia na posicao antiga e na nova */
		if(verificarCaminho(novaLinha, novaColuna)) { 
			tabuleiroConecta.mudarExistencia(posLinha, posColuna); //a peca vai mudar de lugar, entao na posicao antiga ela deixa de existir 
			tabuleiroConecta.mudarExistencia(novaLinha, novaColuna); //e na nova posicao ela passa a existir
		}
	}

}
