package br.org.serpro.pontofacil.view;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.org.serpro.pontofacil.control.Control;
import br.org.serpro.pontofacil.entity.Turno;

public class View {

	/**
	 * Log da classe
	 */
	private static final Log LOG = LogFactory.getLog(View.class);

	private IconeTray iconeTray = null;
	private Dialogos dialogos = new Dialogos();
	private TelaConfiguracao telaConfiguracao = null;
	private TelaSobre telaSobre = null;
	private TelaAjuda telaAjuda = null;

	public View() {
		try {
			iconeTray = new IconeTray();
		} catch (Exception exception) {
			LOG.error("Erro ao incializar o icone em tray", exception);

			dialogos.dialogoErroFatal("Erro ao incializar o icone em tray",
					exception);

			System.exit(1);
		}

	}

	public void finalizar() {
		Control.getInstance().finalizar();
	}

	public void abrirAjuda() {
		telaAjuda = new TelaAjuda(null, false);

		telaAjuda.setVisible(true);
	}

	public void abrirSobre() {
		telaSobre = new TelaSobre(null, false);

		telaSobre.setVisible(true);
	}

	public void abrirConfiguracao() {
		telaConfiguracao = new TelaConfiguracao();

	}

	public void abrirSiscop() {
		try {
			Desktop.getDesktop().browse(
					new URI("http://siscop.portalcorporativo.serpro/"));

		} catch (Exception exception) {
			LOG.error("Falha ao abrir o Siscop", exception);

			dialogos.dialogoErro("Falha ao abrir o Siscop", exception);
		}

	}

	public void setTrayToolTip(final String toolTip) {

		this.iconeTray.setToolTip(toolTip);

	}

	public void dialogoDesligamento1() {
		dialogos.dialogoDesligamento1();

	}

	public void dialogoDesligamento2() {
		dialogos.dialogoDesligamento2();

	}

	public void dialogoChegada1Turno() {
		dialogos.dialogoChegada1Turno();

	}

	public void dialogoSaida1Turno1() {
		dialogos.dialogoSaida1Turno1();

	}

	public void dialogoSaida1Turno2() {
		dialogos.dialogoSaida1Turno2();

	}

	public void dialogoEntrada2Turno() {
		dialogos.dialogoEntrada2Turno();

	}

	public void dialogoErro(String string, Exception e) {
		dialogos.dialogoErro(string, e);

	}

	public void dialogoSaida2Turno1() {
		// TODO Auto-generated method stub
		
	}

	public void dialogoAtrasoApontamento(Turno turno) {
		dialogos.dialogoAtrasoApontamento(turno);
	}

}
