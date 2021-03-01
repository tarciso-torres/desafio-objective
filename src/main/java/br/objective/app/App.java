package br.objective.app;
import br.objective.factory.MontarJanelaPrincipalFactory;

public class App {
	
	private App() {
		throw new IllegalStateException("Utils class");
	}
	
	public static void tela() {
		MontarJanelaPrincipalFactory.montarTela();
	}

	

}
