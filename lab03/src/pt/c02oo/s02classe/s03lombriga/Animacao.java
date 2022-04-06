package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	String animacao;
	int numPasso;
	
	public Animacao(String animacao) {
		this.animacao = animacao;
		numPasso = 0; //para representar em qual passo esta
	}
	
	public String apresenta(AquarioLombriga objeto) {
		return objeto.apresenta();
	}
	
	public void passo(AquarioLombriga objeto) {
		switch (animacao.charAt(numPasso)) {
			case 'C' : objeto.crescer(); break;
			case 'M' : objeto.mover(); break;
			case 'V' : objeto.virar(); break;
			default: System.out.println("invalido");
		    } 
		numPasso += 1;
	}
	
}
