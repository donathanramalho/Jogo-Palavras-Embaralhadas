package testes;
import classes.Aleatorio;
import classes.VogalConsoante;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

class embaralhamento {

	// Testes de unidade para as classes de embaralhamento
	// Verificando duas palavras para cada teste
	// Verificando se estão embaralhados
	
	// Método 1 de embaralhar palavras
	@Test
	public void classeAleatorio() {
		Aleatorio a = new Aleatorio();
		assertNotEquals(a.palavraEmbaralhada("jogo"), "jogo");
		assertNotEquals(a.palavraEmbaralhada("computador"), "computador");
	}
	
	// Método 2 de embaralhar palavras
	@Test
	public void classeVogalConsoante() {
		VogalConsoante vc = new VogalConsoante();
		assertNotEquals(vc.palavraEmbaralhada("palavra"), "palavra");
		assertNotEquals(vc.palavraEmbaralhada("viajar"), "viajar");
	}

}
