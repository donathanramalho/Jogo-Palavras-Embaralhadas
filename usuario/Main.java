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
		// -- -- Explicação do jogo ao usuário -- -- //
		System.out.println("Palavras Emabralhadas");
		System.out.println("\nRegras:");
		System.out.println("Surgirá uma palavra, e você deve acertar qual é");
		System.out.println("Você começará o jogo com 100 pontos");
		System.out.println("Cada vez que perder, ira diminuir sua pontução com o valor desejado");
		System.out.println("Quando esse valor chegar a zero, você perde\n");
		
		
		//-----------------------------------------------//
		// -- -- Configurações feitas pelo usuário -- -- //
		
		// Foi criado um loop para todas as perguntas direcionadas ao usuário
		// Até que esteja respondido corretamente

		// Configuração de ganhos e perdas de pontos
		while(true) {
			try {
				System.out.print("Quantos pontos deseja perder se você errar(1 a 100)? ");
				pontuacaoPerder = in.nextInt();
				if (pontuacaoPerder < 1 || pontuacaoPerder > 100)
					throw new Exception();
				break;
			} catch (Exception e){
				in.nextLine(); // Não ficar repetindo o loop por causa da pergunta
				System.out.println("\nDigite um valor de 1 a 100!");
			}	
		}
		
		// Configuração de dificuldade
		while(true) {
			try {
				System.out.print("Qual a dificuldade de palavra que você deseja(1, 2 ou 3)? ");
				dificuldade = in.nextInt();
				if (dificuldade < 1 || dificuldade > 3)
					throw new Exception();
				break;
			} catch (Exception e){
				in.nextLine(); // Não ficar repetindo o loop por causa da pergunta
				System.out.println("\nDigite um 1, 2 ou 3!");
			}	
		}
		
		
		//----------------------------------------------------------------//
		// -- -- Configurando game com as especificações do usuário -- -- //
		
		// Instânciando a mecânica do jogo e as palavras a serem utilizadas
		FabricaEmbaralhadores fe = new FabricaEmbaralhadores(dificuldade);
		FabricaMecanicaDoJogo fm = new FabricaMecanicaDoJogo(pontuacaoPerder);
		
		// Recebendo palavra aleatória, embaralhada com algum método aleatório
		palavra = fe.getEmbaralhador();
		
		
		//-------------------------------------------------//
		// -- -- Retorno ao usuário (Início do Game) -- -- //
		
		// Loop para serem feitas várias tentativas do usuário
		while (true) {
			System.out.println("\nPalavra escolhida:");
			System.out.println(palavra);
			
			System.out.print("\nR: ");
			respostaUsuario = in.next();
			
			// Verificar se o usuário acertou
			verificacao = fm.getResultado(respostaUsuario);
			
			// Cálculo de pontos de acordo com a validação da resposta
			pontuacao = fm.getPontuacao();
			
			// Se acertou
			if (verificacao == 1) {
				System.out.println("\nParabéns!! Você acertou a palavra.");
				break;
			// Se zerrou todos os pontos
			} else if (pontuacao <= 0) {
				System.out.println("Sinto muito, você zerou sua pontuação.");
				System.out.println("GAME OVER!");
				break;
			// Se errou, mas possui algum ponto ainda
			} else {
				System.out.println("\nSinto muito, você acaba de perder " + pontuacaoPerder + " pontos");
			}
			
			// Mostrar os pontos que o usuário ainda possui
			System.out.println("Pontos restantes: " + pontuacao);
		}
		
		in.close();
	
	}

}
