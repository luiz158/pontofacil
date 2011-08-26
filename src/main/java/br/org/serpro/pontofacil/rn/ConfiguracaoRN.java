/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.org.serpro.pontofacil.rn;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.org.serpro.pontofacil.entity.Configuracao;

/**
 * 
 * @author 72767863587
 */
public final class ConfiguracaoRN {

	/**
	 * Log da classe
	 */
	private static final Log LOG = LogFactory.getLog(ConfiguracaoRN.class);

	private static final Preferences PREFERENCIAS = Preferences.userNodeForPackage(Configuracao.class);

	public Configuracao recuperarConfiguracao() throws Exception {
		final Configuracao configuracao = new Configuracao();

		configuracao.setLogin("72767863587");
		configuracao.setSenha("anjo2000");

		if (configuracao.getLogin().equals("")) {
			throw new Exception(
					"Colocar seu login e senha abaixo antes de executar.");
		}

		/*
		 * Configuracao configuracao = null;
		 * 
		 * byte[] data = preferencias.getByteArray("configuracao", null);
		 * 
		 * if (data == null) { return new Configuracao(); }
		 * 
		 * ByteArrayInputStream is = new ByteArrayInputStream(data);
		 * ObjectInputStream oin;
		 * 
		 * try { oin = new ObjectInputStream(is);
		 * 
		 * configuracao = (Configuracao) oin.readObject(); } catch (Exception e)
		 * { log.error("Erro ao salvar configuração.", e); }
		 */

		return configuracao;
	}

	public void apagarConfiguracoes() throws BackingStoreException {

		PREFERENCIAS.clear();

	}

	public void salvarConfiguracao(final Configuracao aConfiguracao) {
		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ObjectOutputStream out;
		byte[] data = null;
		try {
			out = new ObjectOutputStream(outputStream);
			out.writeObject(aConfiguracao);
			data = outputStream.toByteArray();
			out.close();

			PREFERENCIAS.putByteArray("configuracao", data);
		} catch (IOException e) {
			LOG.error("Erro ao salvar configuração.", e);
		}
	}
}
