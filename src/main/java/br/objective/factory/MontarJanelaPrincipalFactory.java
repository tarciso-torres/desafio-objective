package br.objective.factory;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.objective.utils.AlinharPanel;

public class MontarJanelaPrincipalFactory {
	
	private MontarJanelaPrincipalFactory() {
		throw new IllegalStateException("Factory class");
	}
	
	public static void montarTela() {

		JLabel textoInicial = new JLabel(
				"                              Pense em um prato que gosta                              ");

		JButton botaoOk = new JButton("OK");
		botaoOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JanelasQuestoesFactory.montaOpcoes();
			}
		});

		final JPanel panel = AlinharPanel.alinharPanelVerticalCentro(20, textoInicial, botaoOk);

		JFrame janela = new JFrame("Jogo Gourmet");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(500, 180);
		janela.setLocationRelativeTo(null);
		janela.add(panel);
		janela.setVisible(true);
		janela.pack();

	}

}
