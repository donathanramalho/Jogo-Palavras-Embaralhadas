package classes;

import java.util.Random;
import interfaces.Embaralhador;

// Cuida dos tipos de embaralhamento da palavra selecionada
public class FabricaEmbaralhadores {
	
	private Embaralhador embaralhador;
	private BancoDePalavras banco;
	private String palavra;
	private int nivel;
	
	// M�todo construtor
	public FabricaEmbaralhadores(int nivel) {
		this.nivel = nivel;
		banco = new BancoDePalavras();
	}
	
	// Escolher uma classe embaralhadora aleat�riamente
	public String getEmbaralhador() {
		
		// N�mero aleat�rio
		Random r = new Random();
		int metodo = r.nextInt(2);
		
		// Escolhendo o embaralhador
		if (metodo == 0)
			embaralhador = new VogalConsoante();
		else
			embaralhador = new Aleatorio();
		
		// Receber uma palavra de acordo com o n�vel escolhido
		try {
			palavra = banco.palavraNivel(nivel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Retornar palavra aleat�ria e embaralhada
		return embaralhador.palavraEmbaralhada(palavra);
		
	}
	
}
