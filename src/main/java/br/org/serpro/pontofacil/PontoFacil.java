package br.org.serpro.pontofacil;

import br.org.serpro.pontofacil.view.TrayIcon;

public class PontoFacil {

    private static int intervalo = 30;

    public static void main(String args[]) throws InterruptedException {

        SwingWorker worker = new SwingWorker() {

            public Object construct() {
                while (1 != 0) {
                    SiscopRN siscop = new SiscopRN();
                    siscop.doLogin("aaa", "bbb");
                    Relogio relogio = siscop.obterPonto();
                    testaHorario(Relogio);

                    TrayIcon trayIcon = new TrayIcon();
                    
                    Thread.sleep(1000 * PontoFacil.intervalo);                    
                }
            }
        };
        worker.start();
    }
}
