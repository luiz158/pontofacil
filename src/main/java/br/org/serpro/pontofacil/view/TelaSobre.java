/*
 * jSobre.java
 *
 * Created on 16 de Abril de 2009, 13:28
 */
package br.org.serpro.pontofacil.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;


/**
 *
 * @author  72767863587
 */
public class TelaSobre extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6372149958391756426L;
	
	/** Creates new form jSobre */
    public TelaSobre(final Frame parent,final  boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobre");
        setModal(true);

        jTextPane1.setContentType("text/html");
        jTextPane1.setText("<html>\n  <head>\n\n  </head>\n  <body>\n<center>\n      <h3>Ponto Fácil</h3>\n     <img src='http://www.gnu.org/graphics/heckert_gnu.small.png'>\n      <h4>Autor: Alexandre Haguiar - Versão 0.1</h4>\n      <h4><a href='http://www.gnu.org/copyleft/gpl.html'>Licença: GPL</a></h4>\n</center>\n  </body>\n</html>\n");
        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        final java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-398)/2, (screenSize.height-374)/2, 398, 374);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(final ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
