package br.objective.utils;

public class ValidacoesUtils {
	
	private ValidacoesUtils() {
		throw new IllegalStateException("Utils class");
	}
	
	/**
	* Retorna um valor boleano verdadeiro caso o nome e descrição do prato não seja vazio ou null 

	* @param  nomePrato  Nome do prato que o jogador pensou
	* @param  descricaoPrato Caracteristica do prato
	* @return      retorna a validação do prato.
	*/
	public static boolean validaPratoEscolhidoPeloJogador(String nomePrato, String descricaoPrato) {
		if(nomePrato != null && !nomePrato.isEmpty() && descricaoPrato != null && !descricaoPrato.isEmpty()) {
			return true;
		}
		return false;
	}

}
