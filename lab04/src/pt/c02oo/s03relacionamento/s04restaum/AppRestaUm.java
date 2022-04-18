package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
	  int posLinha, posColuna, novaLinha, novaColuna;
	  
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
      
      char board[][] = {
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
      };
            
      tk.writeBoard("Tabuleiro inicial", board);
      
      //criando o tabuleiro e conectando cada peca a ele
      Tabuleiro tabuleiro = new Tabuleiro(board);
      tabuleiro.conectaPeca(tabuleiro);
      
      for (int l = 0; l < commands.length; l++) {
    	  
    	  //utilizacao da tabela ASCII para converter char para o valor númerico, 
    	  //lembrando de subtrair 1 para que a posicao da linha/coluna coincida com o indice da matriz:
    	  posColuna = (int)(commands[l].charAt(0)) - 97; 
    	  posLinha = (int)(commands[l].charAt(1)) - 49; 
    	  novaColuna = (int)(commands[l].charAt(3)) - 97; 
    	  novaLinha = (int)(commands[l].charAt(4)) - 49; 
    	  
    	  //pede-se o movimento da peca ao tabuleiro:
    	  tabuleiro.mover(posLinha, posColuna, novaLinha, novaColuna);
    	  tk.writeBoard("source: " + commands[l].charAt(0) + commands[l].charAt(1) + ";" + " target: " + commands[l].charAt(3) + commands[l].charAt(4), tabuleiro.getBoard());
      }
      
      tk.stop();
   }

}
