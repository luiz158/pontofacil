/*
 * horaPanel.java
 *
 * Created on 17 de Abril de 2009, 16:20
 */

package br.org.serpro.pontofacil.util.timedialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author  72767863587
 */
public class TimePanel extends javax.swing.JPanel {
    private MaskFormatter formatter = null;

    /** Creates new form horaPanel */
    public TimePanel() {
        try {
            formatter = new MaskFormatter("##:##");
            formatter.setPlaceholderCharacter('_');

            initComponents();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgora = new javax.swing.JButton();
        txtHora = new javax.swing.JFormattedTextField(formatter);
        lblHora = new javax.swing.JLabel();

        btnAgora.setText("Agora");
        btnAgora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgoraActionPerformed(evt);
            }
        });

        lblHora.setFont(new java.awt.Font("Verdana", 1, 12));
        lblHora.setText("Hora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgora)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgora)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAgora, lblHora, txtHora});

    }// </editor-fold>//GEN-END:initComponents

    private void btnAgoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgoraActionPerformed
        	SimpleDateFormat spf = new SimpleDateFormat("HH:mm", new Locale("pt", "BR"));
                txtHora.setText(spf.format(new Date()));
    }//GEN-LAST:event_btnAgoraActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgora;
    private javax.swing.JLabel lblHora;
    private javax.swing.JFormattedTextField txtHora;
    // End of variables declaration//GEN-END:variables

	public javax.swing.JFormattedTextField getTxtHora() {
		return txtHora;
	}

	public void setTxtHora(javax.swing.JFormattedTextField txtHora) {
		this.txtHora = txtHora;
	}
    

    
    
    
}
