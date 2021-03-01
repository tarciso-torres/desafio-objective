package br.objective.utils;

import org.junit.Assert;
import org.junit.Test;


public class ValidacoesUtilsTest {
	
	@Test
	public void deveRetornarFalseSeNomePratoForVazio() {
		Assert.assertFalse(ValidacoesUtils.validaPratoEscolhidoPeloJogador("", "doce"));
	}
	
	@Test
	public void deveRetornarFalseSeDescricaoPratoForVazio() {
		Assert.assertFalse(ValidacoesUtils.validaPratoEscolhidoPeloJogador("sorvete", ""));
	}
	
	@Test
	public void deveRetornarTrueSeNomePratoEDescricaoPratoNaoForVazio() {
		Assert.assertTrue(ValidacoesUtils.validaPratoEscolhidoPeloJogador("sorvete", "doce"));
	}

}
