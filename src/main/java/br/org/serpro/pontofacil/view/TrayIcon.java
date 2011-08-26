/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.serpro.pontofacil.view;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.org.serpro.pontofacil.control.Control;

public class TrayIcon {

    public static java.awt.TrayIcon trayIcon = null;

    public TrayIcon() {

        final PopupMenu popup = new PopupMenu();

        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("media/clock.png"));

        ActionListener exitListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Control.getInstance().getVIEW().finalizar();
            }
        };

        MenuItem itemMostrarAlarmes = new MenuItem("Mostrar Alarmes");

        ActionListener actionMostrarAlarmes = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            }
        };

        itemMostrarAlarmes.addActionListener(actionMostrarAlarmes);

        MenuItem itemSincronizar = new MenuItem("Sincronizar");

        ActionListener actionSincronizar = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Control.getInstance().sincronizar();
            }
        };

        itemSincronizar.addActionListener(actionSincronizar);

        MenuItem itemAjuda = new MenuItem("Ajuda");

        ActionListener actionAjuda = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Control.getInstance().getVIEW().abrirAjuda();
            }
        };

        itemAjuda.addActionListener(actionAjuda);

        MenuItem itemSobre = new MenuItem("Sobre");

        ActionListener actionSobre = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Control.getInstance().getVIEW().abrirSobre();
            }
        };

        itemSobre.addActionListener(actionSobre);

        MenuItem itemExit = new MenuItem("Exit");

        itemExit.addActionListener(exitListener);

        ActionListener actionConfiguracao = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Control.getInstance().getVIEW().abrirConfiguracao();
            }
        };

        MenuItem itemConfiguracao = new MenuItem("Configurações");

        itemConfiguracao.addActionListener(actionConfiguracao);

        ActionListener actionSiscop = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Control.getInstance().getVIEW().abrirSiscop();
            }
        };

        MenuItem itemSiscop = new MenuItem("Apontar SISCOP");
        itemSiscop.addActionListener(actionSiscop);

        trayIcon = new java.awt.TrayIcon(image, null, popup);

        popup.add(itemMostrarAlarmes);
        popup.add(itemConfiguracao);
        popup.add(itemSincronizar);
        popup.addSeparator();
        popup.add(itemSiscop);
        popup.addSeparator();
        popup.add(itemAjuda);
        popup.add(itemSobre);
        popup.add(itemExit);

        trayIcon.setImageAutoSize(true);
    }

    public static void setToolTip(String tooltip) {
        TrayIcon.trayIcon.setToolTip(tooltip);
    }

    public static void setImage(String image) {
        //TODO
    }
}
