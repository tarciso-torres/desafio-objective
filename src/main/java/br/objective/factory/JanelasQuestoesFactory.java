package br.objective.factory;

import java.awt.HeadlessException;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import br.objective.model.Prato;

public class JanelasQuestoesFactory {

	private JanelasQuestoesFactory() {
		throw new IllegalStateException("JanelasQuestoesFactory");
	}

	private static final String BOLO_CHOCOLATE = " Bolo de Chocolate";
	private static final String CONFIRM = "Confirm";
	private static final String DESISTO = "Desisto";
	private static final String PRATO_QUE_PENSOU = "O prato que você pensou é ";
	private static final String TITULO_APP = "Gourmet";
	
	private static String ultimoPratoRejeitado;
	private static int escolha;
	private static boolean devePerguntarPorBoloDeChocolate = false;
	private static NavigableSet<Prato> pratos = new TreeSet<>();
	private static String[] options = { "Sim", "Não" };
	
	private static Logger log = Logger.getLogger("br.objective.JanelasQuestoesFactory");

	public static void montaOpcoes() {
		
		log.info("inicio do processo");
		
		Optional<String> nomePrato;
		Optional<String> descricaoPrato;

		pratos.add(new Prato("lasanha", "massa"));

		try {
			isPratoPensadoEstaDentroDasOpcoesCadastradas(pratos);

			if (escolha == 1 && devePerguntarPorBoloDeChocolate) {
				escolha = JOptionPane.showOptionDialog(null, PRATO_QUE_PENSOU + BOLO_CHOCOLATE + "?", CONFIRM,
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if(escolha == 0) {
					mensagemSeTiverAcertadoAOpcao();
				}
			}

			if (escolha == 1) {
				nomePrato = Optional.ofNullable(JOptionPane.showInputDialog(null, "Qual prato você pensou?", DESISTO,
						JOptionPane.QUESTION_MESSAGE));
				if (nomePrato.isPresent()) {
					descricaoPrato = Optional.ofNullable(JOptionPane.showInputDialog(null,
							nomePrato.get() + " é ______ mas " + ultimoPratoRejeitado + " não.", "Complete",
							JOptionPane.QUESTION_MESSAGE));
					if (descricaoPrato.isPresent()) {
						pratos.add(new Prato(nomePrato.get().toLowerCase(), descricaoPrato.get().toLowerCase()));
					}
				}
			}

		} catch (HeadlessException e) {
			log.error(e.getStackTrace());
		}
	}

	private static void isPratoPensadoEstaDentroDasOpcoesCadastradas(NavigableSet<Prato> pratos) {
		
		for (Prato prato : pratos) {
			escolha = JOptionPane.showOptionDialog(null, PRATO_QUE_PENSOU + prato.getCaracteristica() + "?", CONFIRM,
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			
			if(prato.getCaracteristica().equals(pratos.last().getCaracteristica()) && escolha == 1) {
				devePerguntarPorBoloDeChocolate = true;
				ultimoPratoRejeitado = BOLO_CHOCOLATE;
			}
			
			if (escolha == 0) {
				escolha = JOptionPane.showOptionDialog(null, PRATO_QUE_PENSOU + prato.getNome() + "?", CONFIRM,
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if(prato.getNome().equals(pratos.last().getNome()) && escolha == 1) {
					devePerguntarPorBoloDeChocolate = false;
					ultimoPratoRejeitado = prato.getNome();
				}
				if (escolha == 0) {
					mensagemSeTiverAcertadoAOpcao();
					break;

				}
			}
			
		}
	}

	private static void mensagemSeTiverAcertadoAOpcao() {
		JOptionPane.showMessageDialog(null, "Acertei de novo!", TITULO_APP,
				JOptionPane.INFORMATION_MESSAGE);
	}

}
