package classes;
import interfaces.MecanicaDoJogo;

// Definir a pontuação após jogada do usuário
public class Pontuacao implements MecanicaDoJogo {
	
	// Pontuação inicial
	private int pontuacao = 100;
	
	private int perderPontuacao;
	
	// Definir a pontuação de perda
	public Pontuacao(int perderPontuacao) {
		this.perderPontuacao = perderPontuacao;
	}
	
	// Retirar pontos quando o usuário errar a tentativa
	@Override
	public int posJogada(String chute) {
		if (chute.equals("errou")) {
			pontuacao -= perderPontuacao;
		}
		return pontuacao;
	}
	
	
	
	
}
