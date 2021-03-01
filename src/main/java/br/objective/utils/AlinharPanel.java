package br.objective.utils;

import java.awt.Dimension;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class AlinharPanel {
	
	private AlinharPanel() {
		throw new IllegalStateException("Utils class");
	}
	
	public static JPanel alinharPanelVerticalCentro(final int espacoEntreComponentes, final JComponent... componentes) {
		final JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setSize(500, 300);

		Arrays.stream(componentes).forEach(componente -> {
			componente.setAlignmentX(JPanel.CENTER_ALIGNMENT);
			panel.add(componente);
			panel.add(Box.createRigidArea(new Dimension(0, espacoEntreComponentes)));
		});

		return panel;
	}

}
