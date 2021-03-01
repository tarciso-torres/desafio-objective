package br.objective.utils;

public class ValidacoesUtils {
	
	private ValidacoesUtils() {
		throw new IllegalStateException("Utils class");
	}
	
	/**
	* Retorna um valor boleano verdadeiro caso o nome e descri��o do prato n�o seja vazio ou null 

	* @param  nomePrato  Nome do prato que o jogador pensou
	* @param  descricaoPrato Caracteristica do prato
	* @return      retorna a valida��o do prato.
	*/
	public static boolean validaPratoEscolhidoPeloJogador(String nomePrato, String descricaoPrato) {
		if(nomePrato != null && !nomePrato.isEmpty() && descricaoPrato != null && !descricaoPrato.isEmpty()) {
			return true;
		}
		return false;
	}

}
