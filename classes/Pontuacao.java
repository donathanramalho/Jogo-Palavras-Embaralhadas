package classes;
import interfaces.MecanicaDoJogo;

// Definir a pontua��o ap�s jogada do usu�rio
public class Pontuacao implements MecanicaDoJogo {
	
	// Pontua��o inicial
	private int pontuacao = 100;
	
	private int perderPontuacao;
	
	// Definir a pontua��o de perda
	public Pontuacao(int perderPontuacao) {
		this.perderPontuacao = perderPontuacao;
	}
	
	// Retirar pontos quando o usu�rio errar a tentativa
	@Override
	public int posJogada(String chute) {
		if (chute.equals("errou")) {
			pontuacao -= perderPontuacao;
		}
		return pontuacao;
	}
	
	
	
	
}
