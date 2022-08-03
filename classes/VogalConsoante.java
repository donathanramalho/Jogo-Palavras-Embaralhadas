package classes;
import interfaces.Embaralhador;

// Classe para embaralhar a palavra selecionada pelo programa
// Trocar as vogais com as consoantes
public class VogalConsoante implements Embaralhador{
	
	@Override
	public String palavraEmbaralhada(String palavra) {
		String vogal = "aeiou";
		
		// Criando uma StringBuilder para editar a String da
		// maneira desejada
		StringBuilder novaPalavra = new StringBuilder(palavra);
		
		// Verificar cada letra
		for (int i = 0; i<palavra.length()-1; i++) {
			if (vogal.indexOf(palavra.toLowerCase().charAt(i)) != -1) {
				char letra = novaPalavra.charAt(i);
				novaPalavra.setCharAt(i, novaPalavra.charAt(i+1));
				novaPalavra.setCharAt(i+1, letra);
			}	
		}
		
		return novaPalavra.toString();
	}
	
}
