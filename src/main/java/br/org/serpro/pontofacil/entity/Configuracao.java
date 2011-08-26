/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.org.serpro.pontofacil.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 72767863587
 */
public class Configuracao implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4291360961562504202L;
	
	/**
	 * Versão da configuração
	 */
	private String versao;
	
	/**
	 * Senha do usuário
	 */
    private String senha;
    
    /**
     * Login do usuário
     */
    private String login;
    
    private Boolean lembrarSGI;
    private Boolean lembrarSiscop;

    /**
     * Data da configuração
     */
	private Date data;

	private boolean lembrarSiscopAoIniciar;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Configuracao other = (Configuracao) obj;
		if (lembrarSGI == null) {
			if (other.lembrarSGI != null)
				return false;
		} else if (!lembrarSGI.equals(other.lembrarSGI))
			return false;
		if (lembrarSiscop == null) {
			if (other.lembrarSiscop != null)
				return false;
		} else if (!lembrarSiscop.equals(other.lembrarSiscop))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public Boolean isLembrarSGI() {
        return lembrarSGI;
    }

    public void setLembrarSGI(final Boolean lembrarSGI) {
        this.lembrarSGI = lembrarSGI;
    }

    public Boolean isLembrarSiscop() {
        return lembrarSiscop;
    }

    public void setLembrarSiscop(final Boolean lembrarSiscop) {
        this.lembrarSiscop = lembrarSiscop;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

	public void setData(final Date data) {
		this.data = data;
		
	}

	public Date getData() {
		return data;
	}

	public void setLembrarSiscopAoIniciar(final boolean lembrarSiscopAoIniciar) {
		this.lembrarSiscopAoIniciar = lembrarSiscopAoIniciar;
		
	}

	public boolean isLembrarSiscopAoIniciar() {
		return lembrarSiscopAoIniciar;
	}

}
