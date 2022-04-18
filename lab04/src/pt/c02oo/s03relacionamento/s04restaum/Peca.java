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

	public boolean verificarCaminho(int novaLinha, int novaColuna) { //verifica se o caminho esta livre para a peca se movimentar
		if((! tabuleiroConecta.verificarExistencia(novaLinha, novaColuna)) && (tabuleiroConecta.posicaoValida(novaLinha, novaColuna))) { //vendo se ha uma peca onde ela deseja ir e se esta dentro do tabuleiro
			//devo falar que movimentos na diagonal sao invalidos? tera esse tipo de entrada?
			if(novaLinha == posLinha + 2) {//movimenta para baixo
				if(tabuleiroConecta.verificarExistencia(novaLinha - 1, novaColuna)) { //vendo se tem uma peca a ser comida
					tabuleiroConecta.tirarPeca(novaLinha - 1, novaColuna); //puxar essas coisas pra fora
					return true;
				}
			} else if(novaLinha == posLinha - 2) { //movimenta para cima
				if(tabuleiroConecta.verificarExistencia(novaLinha + 1, novaColuna)) {
					tabuleiroConecta.tirarPeca(novaLinha + 1, novaColuna);
					return true;
				}
			} else if(novaColuna == posColuna + 2) { //movimenta para direita
				if(tabuleiroConecta.verificarExistencia(novaLinha, novaColuna - 1)) { //vendo se tem uma peca a ser comida
					tabuleiroConecta.tirarPeca(novaLinha, novaColuna - 1);
					return true;
				}
			} else if(novaColuna == posColuna - 2) { //movimenta para esquerda DEIXAR SO ELSE?
				if(tabuleiroConecta.verificarExistencia(novaLinha, novaColuna + 1)) { //vendo se tem uma peca a ser comida
					tabuleiroConecta.tirarPeca(novaLinha, novaColuna + 1);
					return true;
				}
			}
		}
		return false;
	}
	
	public void movimentarPeca(int novaLinha, int novaColuna) {
		if(verificarCaminho(novaLinha, novaColuna)) { //a peca vai mudar de lugar, ent na posicao antiga ela deixa de existir e na nova existe == true
			tabuleiroConecta.mudarExistencia(posLinha, posColuna);
			tabuleiroConecta.mudarExistencia(novaLinha, novaColuna);
		}
	}

	

}
