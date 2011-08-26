/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.serpro.pontofacil.entity;

import java.util.Date;

/**
 * 
 * @author 72767863587
 */
public class Relogio {
	
	private Date hrEnt1Turno = null;
	private Date hrSai1Turno = null;
	private Date hrEnt2Turno = null;
	private Date hrSai2Turno = null;
	private Date hrEnt1TurnoExt = null;
	private Date hrSai1TurnoExt = null;
	private Date hrEnt2TurnoExt = null;
	private Date hrSai2TurnoExt = null;
	public Date getHrEnt1Turno() {
		return hrEnt1Turno;
	}
	public void setHrEnt1Turno(final Date hrEnt1Turno) {
		this.hrEnt1Turno = hrEnt1Turno;
	}
	public Date getHrSai1Turno() {
		return hrSai1Turno;
	}
	public void setHrSai1Turno(final Date hrSai1Turno) {
		this.hrSai1Turno = hrSai1Turno;
	}
	public Date getHrEnt2Turno() {
		return hrEnt2Turno;
	}
	public void setHrEnt2Turno(final Date hrEnt2Turno) {
		this.hrEnt2Turno = hrEnt2Turno;
	}
	public Date getHrSai2Turno() {
		return hrSai2Turno;
	}
	public void setHrSai2Turno(final Date hrSai2Turno) {
		this.hrSai2Turno = hrSai2Turno;
	}
	public Date getHrEnt1TurnoExt() {
		return hrEnt1TurnoExt;
	}
	public void setHrEnt1TurnoExt(final Date hrEnt1TurnoExt) {
		this.hrEnt1TurnoExt = hrEnt1TurnoExt;
	}
	public Date getHrSai1TurnoExt() {
		return hrSai1TurnoExt;
	}
	public void setHrSai1TurnoExt(final Date hrSai1TurnoExt) {
		this.hrSai1TurnoExt = hrSai1TurnoExt;
	}
	public Date getHrEnt2TurnoExt() {
		return hrEnt2TurnoExt;
	}
	public void setHrEnt2TurnoExt(final Date hrEnt2TurnoExt) {
		this.hrEnt2TurnoExt = hrEnt2TurnoExt;
	}
	public Date getHrSai2TurnoExt() {
		return hrSai2TurnoExt;
	}
	public void setHrSai2TurnoExt(final Date hrSai2TurnoExt) {
		this.hrSai2TurnoExt = hrSai2TurnoExt;
	}
	public void copia(final Relogio aRelogio) {

		this.setHrEnt1Turno(aRelogio.getHrEnt1Turno());
		this.setHrSai1Turno(aRelogio.getHrSai1Turno());
		this.setHrEnt2Turno(aRelogio.getHrEnt2Turno());
		this.setHrSai2Turno(aRelogio.getHrSai2Turno());
		this.setHrEnt1TurnoExt(aRelogio.getHrEnt1TurnoExt());
		this.setHrSai1TurnoExt(aRelogio.getHrSai1TurnoExt());
		this.setHrEnt2TurnoExt(aRelogio.getHrEnt2TurnoExt());
		this.setHrSai2TurnoExt(aRelogio.getHrSai2TurnoExt());
		
	}

}
