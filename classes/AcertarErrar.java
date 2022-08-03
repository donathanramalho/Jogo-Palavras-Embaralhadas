package classes;
import interfaces.MecanicaDoJogo;

// Verificar a tentativa de acerto do usuário
// Retornar se ele acertou ou errou
public class AcertarErrar implements MecanicaDoJogo {
	
	// Palavra escolhida pelo sistema
	private static String palavra;
	
	// Retornar 1 se o usuário acertou.
	// Retornar 0 se ele errar
	@Override
	public int posJogada(String chute) {
		if (palavra.toLowerCase().equals(chute.toLowerCase()))
			return 1;
		else
			return 0;
	}
	
	// Definir a palavra que foi escolhida pelo sistema
	public void setPosJagada(String senha, String palavra) {
		
		// A senha é recebida de outra classe,
		// para apenas o sistema definir a palavra
		if (senha=="MinhaSenha") {
			AcertarErrar.palavra = palavra;
		}
	}

}
