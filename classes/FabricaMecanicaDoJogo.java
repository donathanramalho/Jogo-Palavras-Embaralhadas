package classes;

// Cuida de toda mecânica do jogo
public class FabricaMecanicaDoJogo {
	
	private int vitoria;
	private int pontuacao;
	private Pontuacao p;
	private AcertarErrar ae;
	
	// Método construtor
	public FabricaMecanicaDoJogo(int perderPontuacao) {
		p = new Pontuacao(perderPontuacao);
		ae = new AcertarErrar();
	}
	
	// Enviar tentativa do usuário para verificação
	public int getResultado(String chute) {
		vitoria = ae.posJogada(chute);
		return vitoria;
	}
	
	
	// Enviar resultado para cálculos de pontos
	public int getPontuacao(){
		if (vitoria == 1)
			pontuacao = p.posJogada("acertou");
		else
			pontuacao = p.posJogada("errou");

		return pontuacao;
	}
	
}
