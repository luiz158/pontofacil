/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.org.serpro.pontofacil.rn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import br.org.serpro.pontofacil.entity.Relogio;
import br.org.serpro.pontofacil.entity.Turno;

/**
 * 
 * @author 72767863587
 */
public class RelogioRN {

	private static final Relogio LOCAL = new Relogio();
	private static final Relogio REMOTO = new Relogio();

	public static Relogio getLOCAL() {
		return LOCAL;
	}

	public static Relogio getREMOTO() {
		return REMOTO;
	}

	public boolean testaHorarioChegada1Turno() {
		final Relogio relogio = this.obterRelogioConcretizado();
		boolean teste = true;

		if (relogio.getHrEnt1Turno() == null
				&& relogio.getHrSai1Turno() == null
				&& relogio.getHrEnt2Turno() == null
				&& relogio.getHrSai2Turno() == null
				&& relogio.getHrEnt1TurnoExt() == null
				&& relogio.getHrSai1TurnoExt() == null
				&& relogio.getHrEnt2TurnoExt() == null
				&& relogio.getHrSai2TurnoExt() == null) {

			teste = false;

		}

		return teste;

	}

	public boolean testaHorarioSaida1Turno() {
		final Relogio relogio = this.obterRelogioConcretizado();
		boolean teste = true;

		if (relogio.getHrEnt1Turno() != null
				&& relogio.getHrSai1Turno() == null
				&& relogio.getHrEnt2Turno() == null
				&& relogio.getHrSai2Turno() == null
				&& relogio.getHrEnt1TurnoExt() == null
				&& relogio.getHrSai1TurnoExt() == null
				&& relogio.getHrEnt2TurnoExt() == null
				&& relogio.getHrSai2TurnoExt() == null) {

			teste = false;

		}

		return teste;

	}

	public boolean testaHorarioEntrada2Turno() {
		final Relogio relogio = this.obterRelogioConcretizado();
		boolean teste = true;

		if (relogio.getHrEnt1Turno() != null
				&& relogio.getHrSai1Turno() != null
				&& relogio.getHrEnt2Turno() == null
				&& relogio.getHrSai2Turno() == null
				&& relogio.getHrEnt1TurnoExt() == null
				&& relogio.getHrSai1TurnoExt() == null
				&& relogio.getHrEnt2TurnoExt() == null
				&& relogio.getHrSai2TurnoExt() == null) {

			teste = false;

		}

		return teste;

	}

	public boolean testaHorarioSaida2Turno() {
		final Relogio relogio = this.obterRelogioConcretizado();
		boolean teste = true;

		if (relogio.getHrEnt1Turno() != null
				&& relogio.getHrSai1Turno() != null
				&& relogio.getHrEnt2Turno() != null
				&& relogio.getHrSai2Turno() == null
				&& relogio.getHrEnt1TurnoExt() == null
				&& relogio.getHrSai1TurnoExt() == null
				&& relogio.getHrEnt2TurnoExt() == null
				&& relogio.getHrSai2TurnoExt() == null) {

			teste = false;

		}

		return teste;

	}

	public boolean testaDesligamento1() {
		boolean teste = true;
		Date hrEnt1Turno = null;

		if (this.obterRelogioConcretizado().getHrSai1Turno() == null) {

			hrEnt1Turno = RelogioRN.getREMOTO().getHrEnt1Turno();

			if (hrEnt1Turno == null) {

				hrEnt1Turno = RelogioRN.getLOCAL().getHrEnt1Turno();

			}

			if (hrEnt1Turno != null) {

				final long minAlmoco = hrEnt1Turno.getTime() + 3 * 60 * 60
						* 1000;
				final long maxAlmoco = hrEnt1Turno.getTime() + 5 * 60 * 60
						* 1000;

				if (hrEnt1Turno.getTime() > minAlmoco
						&& hrEnt1Turno.getTime() < maxAlmoco) {

					teste = false;

				}

			}

		}

		return teste;

	}

	public boolean testaDesligamento2() {
		Date hrEnt2Turno = null;
		boolean teste = true;

		if (this.obterRelogioConcretizado().getHrSai2Turno() == null) {

			hrEnt2Turno = RelogioRN.getREMOTO().getHrEnt2Turno();

			if (hrEnt2Turno == null) {

				hrEnt2Turno = RelogioRN.getLOCAL().getHrEnt2Turno();

			}

			if (hrEnt2Turno != null) {

				final long minSaida = hrEnt2Turno.getTime() + 3 * 60 * 60
						* 1000;

				if (hrEnt2Turno.getTime() > minSaida) {

					teste = false;

				}

			}

		}

		return teste;

	}

	/**
	 * Obtem conjunto de horas apontadas no Siscop ou no sistema
	 * 
	 * @return
	 */
	public Relogio obterRelogioConcretizado() {
		final Relogio relogio = new Relogio();

		relogio.copia(getREMOTO());

		if (getREMOTO().getHrEnt1Turno() == null) {

			relogio.setHrEnt1Turno(getLOCAL().getHrEnt1Turno());

		}

		if (getREMOTO().getHrSai1Turno() == null) {

			relogio.setHrSai1Turno(getLOCAL().getHrSai1Turno());

		}

		if (getREMOTO().getHrEnt2Turno() == null) {

			relogio.setHrEnt2Turno(getLOCAL().getHrEnt2Turno());

		}

		if (getREMOTO().getHrSai2Turno() == null) {

			relogio.setHrSai2Turno(getLOCAL().getHrSai2Turno());

		}

		return relogio;
	}

	/**
	 * Formata um texto com os horarios assumidos pelo computador 1T E-08:00
	 * E-08:00 S-12:00 / 2T E-13:00 S-17:00 / 1TE E-08:00 S-12:00 / 2TE E-13:00
	 * S-17:00
	 * 
	 * @return Texto com apontamentos concretizados
	 */
	public String getRelogioFormatado() {

		final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", new Locale(
				"pt", "BR"));

		final Relogio relogio = this.obterRelogioConcretizado();

		if (this.testaHorarioChegada1Turno()) {

			if (this.testaHorarioSaida1Turno()) {

				if (this.testaHorarioEntrada2Turno()) {

					if (this.testaHorarioSaida2Turno()) {
						return "1T E-" + sdf.format(relogio.getHrEnt1Turno())
								+ " S-" + sdf.format(relogio.getHrSai1Turno())
								+ " / 2T E-"
								+ sdf.format(relogio.getHrEnt2Turno()) + " S-"
								+ sdf.format(relogio.getHrSai2Turno());

					} else {
						return "1T E-" + sdf.format(relogio.getHrEnt1Turno())
								+ " S-" + sdf.format(relogio.getHrSai1Turno())
								+ " / 2T E-"
								+ sdf.format(relogio.getHrEnt2Turno());

					}
				} else {
					return "1T E-" + sdf.format(relogio.getHrEnt1Turno())
							+ " S-" + sdf.format(relogio.getHrSai1Turno());

				}
			} else {
				return "1T E-" + sdf.format(relogio.getHrEnt1Turno());

			}
		}

		return "Relogio sem apontamentos";

	}

	public Turno testarApontamentos() {
		Turno turno = null;
		final Relogio relogio = this.obterRelogioConcretizado();

		/**
		 * Testa apontamento para um dia de semana normal com 2 turnos
		 */
		if (relogio.getHrEnt1Turno() != null) {

			if (relogio.getHrSai1Turno() != null) {

				if (relogio.getHrEnt2Turno() != null) {

					if (relogio.getHrSai2Turno() == null) {

						turno = Turno.HR_SAI_2_TURNO;

					}

				} else {

					turno = Turno.HR_ENT_2_TURNO;

				}

			} else {

				turno = Turno.HR_SAI_1_TURNO;

			}

		} else {

			turno = Turno.HR_ENT_1_TURNO;

		}

		return turno;
	}
}
