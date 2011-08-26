package br.org.serpro.pontofacil.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.StatusLine;

public class LoginFalhou extends Exception {

        public String cpf;
        public StatusLine statusLine;
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -4577627794426313507L;
	
	/**
	 * Log da classe
	 */
	private static final Log LOG = LogFactory.getLog(LoginFalhou.class);

	public LoginFalhou(final String cpf) {
		super();
		
                this.cpf = cpf;
                
		LOG.error("Falha no login com o CPF " + cpf);

	}

	public LoginFalhou(final String cpf, final StatusLine status) {
		super();
		
                this.cpf = cpf;
                this.statusLine = status;
                
		LOG.error("Requisição de login com o CPF "+ cpf +" falhou com o código " + status.getStatusCode() + " - " + status.getReasonPhrase());
		
	}

}
