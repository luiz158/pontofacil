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
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import br.org.serpro.pontofacil.control.Control;

/**
 * Esta classe é reponsavel pelo icone de tray na tela
 * 
 * @author Alexandre Haguiar
 */
public class IconeTray {

	private TrayIcon trayIcon = null;
	
	public IconeTray() throws Exception {

		final PopupMenu popup = new PopupMenu();
		
		if (SystemTray.isSupported()) {

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

			trayIcon = new TrayIcon(image, null, popup);

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

			tray.add(trayIcon);

		} else {
			
			throw new Exception("Icone em tray não suportado");
			
		}
	}
	
	public void setToolTip(String tooltip){
		
		trayIcon.setToolTip(tooltip);
		
	}

}
