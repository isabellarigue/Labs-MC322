package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	int tamAquario, tamLombriga, pCabeca, orientacao;
	
	public AquarioLombriga(int tamAquario, int tamLombriga, int pCabeca) {
		this.tamAquario = tamAquario;
		
		//Se for informado um tamanho de lombriga maior que a do aquario, a lombriga passa a ter o tamanho do aquario
		if(tamLombriga > tamAquario)
			this.tamLombriga = tamAquario;
		else
			this.tamLombriga = tamLombriga;
		
		//Se for informada uma posicao invalida (fora do aquario ou de um modo que a lombriga fique com um pedaco fora), a posicao passa a ser 1
		if(pCabeca < 1 || pCabeca > tamAquario || (pCabeca + tamLombriga - 1) > tamAquario)
			this.pCabeca = 1;
		else
			this.pCabeca = pCabeca; //posicao inicial da cabeca
		
		orientacao = 1; //para representar que a cabeca esta virada para a esquerda
	}
	
	public void crescer() {
		if(tamAquario > tamLombriga) 
			if(orientacao == 1) { //virada para esquerda
				if((pCabeca + tamLombriga) <= tamAquario ) //verificando se nao vai crescer para fora do aquario
					tamLombriga += 1;
			} else { //virada para direita
				if((pCabeca - tamLombriga) > 0) //verificando se nao vai crescer para fora do aquario
					tamLombriga += 1;
			}
	}
	
	public void mover() {
		if(orientacao == 1) { //virada para esquerda
			if(pCabeca > 1) //ha espaco no aquario para andar
				pCabeca -= 1; 
			else 
				virar();
		} else { //virada para direita
			if(pCabeca < tamAquario) //ha espaco no aquario para andar
				pCabeca += 1; 
			else
				virar();
		}
	}
	
	public void virar() {
		if(orientacao == 1) { //virada para esquerda
			pCabeca = pCabeca + tamLombriga - 1; //invertendo o lado
			orientacao = 2;		
		} else { //virada para direita
			pCabeca = pCabeca - tamLombriga + 1; //invertendo o lado
			orientacao = 1;			
		}
	}
	
	public String apresenta() {
		String apresentaStr = "";
		int i, j, k;
		
		if(orientacao == 1) {
			for(i = 1; i <= tamAquario; i++) {
				if(i == pCabeca) {
					apresentaStr += "O";
					for(j = 1; j < tamLombriga; j++) {
						apresentaStr += "@";
						i++;
					}
				} else
					apresentaStr += "#";
			}
			
		} else {
			String apresentaStr1 = "";
			for(i = tamAquario; i > 0; i--) {
				if(i == pCabeca) {
					apresentaStr1 += "O";
					for(j = 1; j < tamLombriga; j++) {
						apresentaStr1 += "@";
						i--;
					}
				} else
					apresentaStr1 += "#";
			}
			k = apresentaStr1.length() - 1;
			while(k >= 0) { //invertendo o lado da string
			    apresentaStr += apresentaStr1.charAt(k);
			    k--;
			}
		}
		
		return apresentaStr;
	}
		
		
}
