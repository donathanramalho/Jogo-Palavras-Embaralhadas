package usuario;

import java.util.Scanner;
import classes.FabricaEmbaralhadores;
import classes.FabricaMecanicaDoJogo;

public class Main {

	public static void main(String[] args) throws Exception {
		
		int dificuldade;
		int pontuacaoPerder;
		int pontuacao;
		String respostaUsuario;
		int verificacao;
		String palavra;
		

		Scanner in = new Scanner(System.in);
		
		
		//-------------------------------------------//
		// -- -- Explica��o do jogo ao usu�rio -- -- //
		System.out.println("Palavras Emabralhadas");
		System.out.println("\nRegras:");
		System.out.println("Surgir� uma palavra, e voc� deve acertar qual �");
		System.out.println("Voc� come�ar� o jogo com 100 pontos");
		System.out.println("Cada vez que perder, ira diminuir sua pontu��o com o valor desejado");
		System.out.println("Quando esse valor chegar a zero, voc� perde\n");
		
		
		//-----------------------------------------------//
		// -- -- Configura��es feitas pelo usu�rio -- -- //
		
		// Foi criado um loop para todas as perguntas direcionadas ao usu�rio
		// At� que esteja respondido corretamente

		// Configura��o de ganhos e perdas de pontos
		while(true) {
			try {
				System.out.print("Quantos pontos deseja perder se voc� errar(1 a 100)? ");
				pontuacaoPerder = in.nextInt();
				if (pontuacaoPerder < 1 || pontuacaoPerder > 100)
					throw new Exception();
				break;
			} catch (Exception e){
				in.nextLine(); // N�o ficar repetindo o loop por causa da pergunta
				System.out.println("\nDigite um valor de 1 a 100!");
			}	
		}
		
		// Configura��o de dificuldade
		while(true) {
			try {
				System.out.print("Qual a dificuldade de palavra que voc� deseja(1, 2 ou 3)? ");
				dificuldade = in.nextInt();
				if (dificuldade < 1 || dificuldade > 3)
					throw new Exception();
				break;
			} catch (Exception e){
				in.nextLine(); // N�o ficar repetindo o loop por causa da pergunta
				System.out.println("\nDigite um 1, 2 ou 3!");
			}	
		}
		
		
		//----------------------------------------------------------------//
		// -- -- Configurando game com as especifica��es do usu�rio -- -- //
		
		// Inst�nciando a mec�nica do jogo e as palavras a serem utilizadas
		FabricaEmbaralhadores fe = new FabricaEmbaralhadores(dificuldade);
		FabricaMecanicaDoJogo fm = new FabricaMecanicaDoJogo(pontuacaoPerder);
		
		// Recebendo palavra aleat�ria, embaralhada com algum m�todo aleat�rio
		palavra = fe.getEmbaralhador();
		
		
		//-------------------------------------------------//
		// -- -- Retorno ao usu�rio (In�cio do Game) -- -- //
		
		// Loop para serem feitas v�rias tentativas do usu�rio
		while (true) {
			System.out.println("\nPalavra escolhida:");
			System.out.println(palavra);
			
			System.out.print("\nR: ");
			respostaUsuario = in.next();
			
			// Verificar se o usu�rio acertou
			verificacao = fm.getResultado(respostaUsuario);
			
			// C�lculo de pontos de acordo com a valida��o da resposta
			pontuacao = fm.getPontuacao();
			
			// Se acertou
			if (verificacao == 1) {
				System.out.println("\nParab�ns!! Voc� acertou a palavra.");
				break;
			// Se zerrou todos os pontos
			} else if (pontuacao <= 0) {
				System.out.println("Sinto muito, voc� zerou sua pontua��o.");
				System.out.println("GAME OVER!");
				break;
			// Se errou, mas possui algum ponto ainda
			} else {
				System.out.println("\nSinto muito, voc� acaba de perder " + pontuacaoPerder + " pontos");
			}
			
			// Mostrar os pontos que o usu�rio ainda possui
			System.out.println("Pontos restantes: " + pontuacao);
		}
		
		in.close();
	
	}

}
