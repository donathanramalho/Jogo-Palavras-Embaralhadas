package classes;

// Cuida de toda mec�nica do jogo
public class FabricaMecanicaDoJogo {
	
	private int vitoria;
	private int pontuacao;
	private Pontuacao p;
	private AcertarErrar ae;
	
	// M�todo construtor
	public FabricaMecanicaDoJogo(int perderPontuacao) {
		p = new Pontuacao(perderPontuacao);
		ae = new AcertarErrar();
	}
	
	// Enviar tentativa do usu�rio para verifica��o
	public int getResultado(String chute) {
		vitoria = ae.posJogada(chute);
		return vitoria;
	}
	
	
	// Enviar resultado para c�lculos de pontos
	public int getPontuacao(){
		if (vitoria == 1)
			pontuacao = p.posJogada("acertou");
		else
			pontuacao = p.posJogada("errou");

		return pontuacao;
	}
	
}
