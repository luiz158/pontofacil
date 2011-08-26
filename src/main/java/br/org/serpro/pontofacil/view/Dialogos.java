package br.org.serpro.pontofacil.view;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.org.serpro.pontofacil.control.Control;
import br.org.serpro.pontofacil.entity.Configuracao;
import br.org.serpro.pontofacil.entity.Turno;
import br.org.serpro.pontofacil.exception.LoginFalhou;
import br.org.serpro.pontofacil.util.timedialog.TimeDialog;

public class Dialogos {

	public static final int ACERTAR_RELOGIO = 1;
	public static final int APONTAR_SISCOP = 0;

	private static final Log LOG = LogFactory.getLog(Dialogos.class);
	
	private Configuracao configuracao = null;

	public void dialogoErroFatal(final String mensagem, final Exception exception) {

		JOptionPane.showMessageDialog(null,
				mensagem + exception.getMessage(), "Erro Fatal",
				JOptionPane.ERROR_MESSAGE);

	}

	public void dialogoSaida1Turno1() {
		JOptionPane
				.showMessageDialog(
						null,
						"Já faz 4 horas que você esta trabalhando, quando for almoçar não esqueça de bater seu ponto.");
	}

	public void dialogoSaida1Turno2() {
		JOptionPane
				.showMessageDialog(
						null,
						"Já faz 4 horas que você esta trabalhando, quando for almoçar não esqueça de bater seu ponto.");
	}

	public void dialogoSaida2Turno() {
		JOptionPane.showMessageDialog(null,
				"Já fazem 4 horas que você entrou no 2 turno.");
	}

	public void dialogoChegada1Turno() {
		final int opcao = abreDialogoDeAlerta("Você ainda não apontou sua chegada no SISCOP, o que você deseja fazer?");

		if (opcao == ACERTAR_RELOGIO) {

			/**
			 * Abre dialogo para receber data de chegada
			 */
			final Date data = abreDialogoDeAcertaRelogio("Informe sua horade chegada do 1 turno.");

			/**
			 * Se a data não for nula setar relogio
			 */
			if (data != null) {

				Control.getInstance().getRelogioRN().getLOCAL().setHrEnt1Turno(data);
				
				Control.getInstance().getVIEW().setTrayToolTip(Control.getInstance().getRelogioFormatado());

			}

		} else if (opcao == APONTAR_SISCOP) {

			Control.getInstance().getVIEW().abrirSiscop();

			/*
			 * int apontarSiscop =abreDialogoDeApontarSiscop(
			 * "Confirma apontamento do horário de entrada no 1 turno no Siscop?"
			 * );
			 * 
			 * if (apontarSiscop == JOptionPane.OK_OPTION) {
			 * 
			 * try {
			 * 
			 * siscopRN.apontarPonto(configuracao.getLogin(), configuracao
			 * .getSenha(), Turno.HR_ENT_1_TURNO);
			 * 
			 * } catch (IOException e) { log.error("Erro ao apontar Siscop.",
			 * e); } catch (ParseException e) {
			 * log.error("Erro ao apontar Siscop.", e); } catch
			 * (CPFExcedeuMaximoTentativas e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); } catch (LoginFalhou e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 * 
			 * }
			 */
		}
	}

	public int abreDialogoDeAlerta(final String mensagem) {
		final Object[] options = { "Apontar SISCOP", "Acerta Relogio" };

		final JOptionPane jOptionPane = new JOptionPane();
		jOptionPane.setFont(jOptionPane.getFont().deriveFont(24));

		return jOptionPane.showOptionDialog(null, mensagem, "Alerta de Ação",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				options, options[0]);
	}

	public int abreDialogoDeApontarSiscop(final String mensagem) {
		return JOptionPane.showOptionDialog(null, mensagem, "Apontar Siscop",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, null, null);
	}

	public Date abreDialogoDeAcertaRelogio(final String mensagem) {
		Date date = null;

		/**
		 * Recebe uma data válida do usuário
		 */
		while (date == null) {
			date = TimeDialog.showTimeDialog(null, mensagem, "Acertar Relogio");
		}

		return date;
	}

	public void dialogoEntrada2Turno() {
		final int opcao = abreDialogoDeAlerta("Já passaram 1 hora desde quando você saiu do 1 turno. O que você deseja fazer?");

		if (opcao == ACERTAR_RELOGIO) {

			/**
			 * Abre dialogo para receber data de chegada
			 */
			final Date data = abreDialogoDeAcertaRelogio("Informe sua horade chegada no 2 turno.");

			/**
			 * Se a data não for nula setar relogio
			 */
			if (data != null) {

				Control.getInstance().getRelogioRN().getLOCAL().setHrEnt1Turno(data);
				
				
				Control.getInstance().getVIEW().setTrayToolTip(Control.getInstance().getRelogioFormatado());

			}

		} else if (opcao == APONTAR_SISCOP) {

			final int apontarSiscop = abreDialogoDeApontarSiscop("Confirma apontamento do horário de entrada no 2 turno no Siscop?");

			if (apontarSiscop == JOptionPane.OK_OPTION) {

				try {

					Control.getInstance().getSiscopRN().apontarPonto(configuracao.getLogin(), configuracao
							.getSenha(), Turno.HR_ENT_2_TURNO);

				} catch (IOException exception) {
					LOG.error("Erro ao apontar Siscop.", exception);
				} catch (ParseException exception) {
					LOG.error("Erro ao apontar Siscop.", exception);
				} catch (LoginFalhou exception) {
					LOG.error("Erro ao apontar Siscop.", exception);
				}

			}
		}
	}

	public void dialogoDesligamento1() {

		final int apontarSiscop = abreDialogoDeApontarSiscop("Você esta deligando o camputador, deseja apontar sua saida para almoço?");

		if (apontarSiscop == JOptionPane.OK_OPTION) {

			try {

				Control.getInstance().getSiscopRN().apontarPonto(configuracao.getLogin(), configuracao
						.getSenha(), Turno.HR_ENT_2_TURNO);

			} catch (IOException exception) {
				LOG.error("Erro ao apontar Siscop.", exception);
			} catch (ParseException exception) {
				LOG.error("Erro ao apontar Siscop.", exception);
			} catch (LoginFalhou exception) {
				LOG.error("Erro ao apontar Siscop.", exception);
			}

		}

	}

	public void dialogoDesligamento2() {

		final int apontarSiscop = abreDialogoDeApontarSiscop("Você esta deligando o camputador, deseja apontar sua saida da empresa?");

		if (apontarSiscop == JOptionPane.OK_OPTION) {

			try {

				Control.getInstance().getSiscopRN().apontarPonto(configuracao.getLogin(), configuracao
						.getSenha(), Turno.HR_ENT_2_TURNO);

			} catch (Exception exception) {
				LOG.error("Erro ao apontar Siscop.", exception);

				dialogoErroFatal("Erro ao apontar Siscop.", exception);
			}

		}

	}

	public void dialogoErro(final String string, final Exception exception) {
		JOptionPane.showMessageDialog(null, string + exception.getMessage(), "Erro Fatal",	JOptionPane.ERROR_MESSAGE);

	}

	public void dialogoAtrasoApontamento(Turno turno) {
		final int opcao = abreDialogoDeAlerta("Você ainda não apontou o(a) " + turno.getLiteral());

		if (opcao == ACERTAR_RELOGIO) {

			/**
			 * Abre dialogo para receber data de chegada
			 */
			final Date data = abreDialogoDeAcertaRelogio("Informe a(o) "+ turno.getLiteral());

			/**
			 * Se a data não for nula setar relogio
			 */
			if (data != null) {

				if(turno.equals(Turno.HR_ENT_1_TURNO)){
					
					Control.getInstance().getRelogioRN().getLOCAL().setHrEnt1Turno(data);	
					
				} else if(turno.equals(Turno.HR_SAI_1_TURNO)){
				
					Control.getInstance().getRelogioRN().getLOCAL().setHrSai1Turno(data);
					
				} else if(turno.equals(Turno.HR_ENT_2_TURNO)){
					
					Control.getInstance().getRelogioRN().getLOCAL().setHrEnt2Turno(data);
					
				} else if(turno.equals(Turno.HR_SAI_2_TURNO)){
					
					Control.getInstance().getRelogioRN().getLOCAL().setHrSai2Turno(data);

				}
				
				Control.getInstance().getVIEW().setTrayToolTip(Control.getInstance().getRelogioFormatado());

			}

		} else if (opcao == APONTAR_SISCOP) {

			final int apontarSiscop = abreDialogoDeApontarSiscop("Confirma apontamento do horário de entrada no 2 turno no Siscop?");

			if (apontarSiscop == JOptionPane.OK_OPTION) {

				try {

					Control.getInstance().getSiscopRN().apontarPonto(configuracao.getLogin(), configuracao
							.getSenha(), Turno.HR_ENT_2_TURNO);

				} catch (IOException exception) {
					LOG.error("Erro ao apontar Siscop.", exception);
				} catch (ParseException exception) {
					LOG.error("Erro ao apontar Siscop.", exception);
				} catch (LoginFalhou exception) {
					LOG.error("Erro ao apontar Siscop.", exception);
				}

			}
		}		
	}
}
