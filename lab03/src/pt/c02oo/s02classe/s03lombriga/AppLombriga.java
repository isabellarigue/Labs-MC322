package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < lombrigas.length; l++) {
	      String passosStr = ""; //para gravar a parte da string que representa os passos da lombriga
		    
	      int tamAquario = Character.getNumericValue(lombrigas[l].charAt(0)) * 10 + Character.getNumericValue(lombrigas[l].charAt(1)); 
	      int tamLombriga = Character.getNumericValue(lombrigas[l].charAt(2)) * 10 + Character.getNumericValue(lombrigas[l].charAt(3)); 
	      int pCabeca = Character.getNumericValue(lombrigas[l].charAt(4)) * 10 + Character.getNumericValue(lombrigas[l].charAt(5)); 
	      
	      AquarioLombriga aquarioLombriga = new AquarioLombriga(tamAquario, tamLombriga, pCabeca);
	      
	      for(int k = 6; k < lombrigas[l].length(); k++) {
	    	  passosStr += lombrigas[l].charAt(k); //separando a parte da string que representa os passos
	      }
	      
	      Animacao passos = new Animacao(passosStr);
		  
	      tk.gravaPasso("=====");
	      tk.gravaPasso(passos.apresenta(aquarioLombriga));
		  
	      for(int i = 0; i < lombrigas[l].length() - 6; i++) {
	    	  passos.passo(aquarioLombriga);
	    	  tk.gravaPasso(passos.apresenta(aquarioLombriga));
	      }
      }
      tk.stop();
   }
   
}
