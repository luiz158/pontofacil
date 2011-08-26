/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.serpro.pontofacil.control;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.prefs.BackingStoreException;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.org.serpro.pontofacil.entity.Configuracao;
import br.org.serpro.pontofacil.entity.Turno;
import br.org.serpro.pontofacil.exception.LoginFalhou;
import br.org.serpro.pontofacil.rn.ConfiguracaoRN;
import br.org.serpro.pontofacil.rn.RelogioRN;
import br.org.serpro.pontofacil.rn.SiscopRN;
import br.org.serpro.pontofacil.view.View;

/**
 * 
 * @author 72767863587
 */
public final class Control {

    private static Control control;
    private static final View VIEW = new View();
    private static final ConfiguracaoRN configuracaoRN = new ConfiguracaoRN();
    private static final SiscopRN siscopRN = new SiscopRN();
    private static final RelogioRN relogioRN = new RelogioRN();
    private static boolean full = false;
    private static final Log LOG = LogFactory.getLog(Control.class);
    private Configuracao configuracao = null;

    private Control() {
        try {
            this.configuracao = configuracaoRN.recuperarConfiguracao();
        } catch (Exception exception) {
            VIEW.dialogoErro("Erro ao abrir configuração", exception);
        }
    }

    public static Control getInstance() {
        if (control == null) {
            control = new Control();

        }
        return control;
    }

    public static void main(final String[] args) {
        final Control control = Control.getInstance();

        if (args.length > 0) {

            if (args[0].equals("desligar")) {

                control.verificacoesDeDesligamento();

            }

            if (args[0].equals("full")) {

                control.setFull(true);

            }

            if (args[0].equals("apagar")) {

                control.apagarConfiguracoes();

            }

        }

        control.sincronizar();
    }

    public void sincronizar() {
        try {

            // this.acertarRelogioRemoto();

            /**
             * Codigo para testes sem conexão
             */
            final Date agora = Calendar.getInstance().getTime();
            Control.getInstance().getRelogioRN().getREMOTO().setHrEnt1Turno(
                    new Date(agora.getTime() - 6 * 60 * 60 * 1000));
            /*Control.getInstance().getRelogioRN().getREMOTO().setHrSai1Turno(
            new Date(agora.getTime() - 4 * 60 * 60 * 1000));
             */
            this.testaApontamentos();

        } catch (Exception exception) {

            LOG.error("Falha ao sincronizar", exception);

            VIEW.dialogoErro("Sistema falhou ao tentar sincronizar", exception);

            System.exit(1);
        }

        VIEW.setTrayToolTip(getRelogioFormatado());
    }

    private void apagarConfiguracoes() {
        try {

            this.getConfiguracaoRN().apagarConfiguracoes();

        } catch (BackingStoreException e) {

            this.getVIEW().dialogoErro(
                    "Aconteceu um erro ao apagar as configurações", e);

        }

    }

    public void testaApontamentos() {

        Turno turno = this.getRelogioRN().testarApontamentos();

        if (turno != null) {
         
        }

        LOG.info("Apontamento testado com falta em - " + turno);

    }

    public void verificacoesDeDesligamento() {
        if (!relogioRN.testaDesligamento1()) {

            VIEW.dialogoDesligamento1();

        } else if (!relogioRN.testaDesligamento2()) {

            VIEW.dialogoDesligamento2();

        }

        // TODO: Verificar saida turno extra
    }

    public void acertarRelogioRemoto() throws IOException, ParseException, LoginFalhou {
        //siscopRN.obterPonto();
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(final Configuracao configuracao) {
        this.configuracao = configuracao;
    }

    public SiscopRN getSiscopRN() {
        return siscopRN;
    }

    public RelogioRN getRelogioRN() {
        return relogioRN;
    }

    public ConfiguracaoRN getConfiguracaoRN() {
        return configuracaoRN;
    }

    public void finalizar() {

        System.exit(0);

    }

    public String getRelogioFormatado() {

        return this.getRelogioRN().getRelogioFormatado();

    }

    public boolean isFull() {
        return full;
    }

    public void setFull(final boolean full) {
        this.full = full;
    }

    public View getVIEW() {
        return VIEW;
    }

    /*
    public void showTriggers() {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", new Locale("pt",
    "BR"));
    
    String texto = "";
    
    Scheduler scheduler;
    try {
    scheduler = StdSchedulerFactory.getDefaultScheduler();
    
    List<String> jobGroups = scheduler.getTriggerGroupNames();
    
    for (int x = 0; x < jobGroups.length; x++) {
    
    String[] triggerNames = scheduler.getTriggerNames(jobGroups[x]);
    
    for (int y = 0; y < triggerNames.length; y++) {
    
    Trigger trigger = scheduler.getTrigger(triggerNames[y],
    jobGroups[x]);
    
    texto += trigger.getName() + " - " + trigger.getGroup()
    + " - " + trigger.getStartTime() + "\n";
    
    }
    
    }
    
    } catch (SchedulerException e1) {
    e1.printStackTrace();
    
    System.exit(1);
    }
    
    JOptionPane.showMessageDialog(null, texto);
    
    }
     * 
     */
}
