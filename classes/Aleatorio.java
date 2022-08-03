package classes;
import java.util.Random;
import interfaces.Embaralhador;

// Classe para embaralhar a palavra selecionada pelo programa
// Embaralhar de maneira aleatória com a biblioteca "Random"
public class Aleatorio implements Embaralhador {
	
	@Override
	public String palavraEmbaralhada(String palavra) {
		
		Random r = new Random();
		
		// Criando uma StringBuilder para editar a String da
		// maneira desejada
		StringBuilder novaPalavra = new StringBuilder(palavra);
		
		// Verificar cada letra
		for (int i = 0; i<palavra.length(); i++) {
			int index = r.nextInt(novaPalavra.length());
			char letra = novaPalavra.charAt(index);
			novaPalavra.setCharAt(index, novaPalavra.charAt(i));
			novaPalavra.setCharAt(i, letra);
		}
		return novaPalavra.toString();
	}

}
