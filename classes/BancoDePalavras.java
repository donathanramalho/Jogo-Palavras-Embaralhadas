package classes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class BancoDePalavras {
	
	// Atributos
	private int nivelFacil = 0;
	private int nivelMedio = 8;
	private int nivelDificil = 16;
	private String palavra;
	private AcertarErrar ae = new AcertarErrar();
	
	// Escolhendo a palavra para o jogo
	public String palavraNivel(int nivel) throws Exception {
		Random r = new Random();
		
		// Grupo de palavras de acordo com o nível
		int local;
		
		// Palavra final
		String a = getPalavra();
		
		// Recebendo grupo de palavra com a dificuldade
		switch (nivel) {
			case 1:
				local = nivelFacil;
				break;
			case 2:
				local = nivelMedio;
				break;
			default:
				local = nivelDificil;
				break;
		}
		
		// Seprarando palavra do grupo selecionado
		palavra = a.split(",")[r.nextInt(local, local+7)];
		ae.setPosJagada("MinhaSenha", palavra);
		return palavra;
	}
	
	// Pegar o conteúdo do TXT
	private String getPalavra() throws Exception {
		String conteudo = "";
		try {
			FileReader txt = new FileReader("arquivo.txt");
			BufferedReader lerTxt = new BufferedReader(txt);
			String linha = "";
			try {
				linha = lerTxt.readLine();
				
				// Recebendo todo conteúdo, linha por linha
				while (linha!=null) {
					conteudo += linha;
					linha = lerTxt.readLine();
				}
				txt.close();
			} catch (IOException e) {
				throw new Exception(e);
			}
		} catch(FileNotFoundException e) {
			throw new Exception("Arquivo não encontrado!");
		}
		return conteudo;
	}
	
}
