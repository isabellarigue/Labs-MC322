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
      
      Tabuleiro tabuleiro = new Tabuleiro(board);
      tabuleiro.conectaPeca(tabuleiro);
      for (int l = 0; l < commands.length; l++) {
    	  posColuna = (int)(commands[l].charAt(0)) - 97; //converter para numero a= 97, b =98...
    	  posLinha = (int)(commands[l].charAt(1)) - 49; //converter para numero 0=48, subtraindo um para começar do 0 e coincidir com os indices da matriz
    	  novaColuna = (int)(commands[l].charAt(3)) - 97; //converter para numero a= 97, b =98...
    	  novaLinha = (int)(commands[l].charAt(4)) - 49; //converter para numero 0=48, subtraindo um para começar do 0 e coincidir com os indices da matriz
    	  tabuleiro.mover(posLinha, posColuna, novaLinha, novaColuna);
    	  tk.writeBoard("source: " + commands[l].charAt(0) + commands[l].charAt(1) + ";" + " target: " + commands[l].charAt(3) + commands[l].charAt(4), tabuleiro.getBoard());
      }
      
      tk.stop();
   }

}
