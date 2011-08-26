/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.serpro.pontofacil;

import br.org.serpro.pontofacil.view.TrayIcon;

/**
 *
 * @author 72767863587
 */
public class PontoFacil {

    /**
     * Intervalor em minutos entre cada teste
     */
    private static int intervalo = 30;

    public static void main(String args[]) throws InterruptedException {

        TrayIcon trayIcon = new TrayIcon();

        SwingWorker worker = new SwingWorker() {

            public Object construct() {
                while (1 != 0) {
                    System.out.println("Ola Mundo!");
                    Thread.sleep(10000);
                }
            }
        };
        worker.start();
    }
}
