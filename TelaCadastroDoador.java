/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DoadorControl;
import javax.swing.JOptionPane;

public class TelaCadastroDoador extends javax.swing.JInternalFrame {
     
    public TelaCadastroDoador() {
        initComponents();
     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCadDoaLogin = new javax.swing.JTextField();
        txtCadDoaNome = new javax.swing.JTextField();
        botaoCadDoa = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        rbFisica = new javax.swing.JRadioButton();
        rbJuridica = new javax.swing.JRadioButton();
        txtCadDoaSenha2 = new javax.swing.JTextField();
        txtCadDoaSenha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setTitle("Cadastro Doador");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-adicionar-usuário-masculino.png"))); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Login:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 114, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Senha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 148, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Confirmar Senha:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 194, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nome Completo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 68, -1, -1));
        jPanel1.add(txtCadDoaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 106, 303, -1));
        jPanel1.add(txtCadDoaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 64, 303, -1));

        botaoCadDoa.setText("Cadastrar");
        botaoCadDoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadDoaActionPerformed(evt);
            }
        });
        jPanel1.add(botaoCadDoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 330, 120, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Pessoa:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 232, -1, -1));

        buttonGroup1.add(rbFisica);
        rbFisica.setText("Física");
        rbFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFisicaActionPerformed(evt);
            }
        });
        jPanel1.add(rbFisica, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 232, -1, -1));

        buttonGroup1.add(rbJuridica);
        rbJuridica.setText("Jurídica");
        jPanel1.add(rbJuridica, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 232, -1, -1));
        jPanel1.add(txtCadDoaSenha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 190, 303, -1));
        jPanel1.add(txtCadDoaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 148, 303, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundoInterno.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFisicaActionPerformed

    private void botaoCadDoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadDoaActionPerformed

        if(txtCadDoaNome.getText().equals("") ||txtCadDoaLogin.getText().equals("")|| txtCadDoaSenha.getText().equals("") || txtCadDoaSenha2.getText().equals("") || !rbFisica.isSelected() && !rbJuridica.isSelected() ){
            JOptionPane.showMessageDialog(null, "Preencha os campos em branco!", "Cadastro não efetivado", WIDTH);  
        }
        else if(txtCadDoaSenha.getText().equals(txtCadDoaSenha2.getText())){
            
            if(rbFisica.isSelected()){
               DoadorControl.cadastroDoador(txtCadDoaLogin.getText(), txtCadDoaSenha.getText(),1); 
            }
            else if(rbJuridica.isSelected()){
               DoadorControl.cadastroDoador(txtCadDoaLogin.getText(), txtCadDoaSenha.getText(),2);
            }
            if(DoadorControl.aux==1){
                this.dispose();
            }
        }
        else if(!txtCadDoaSenha.getText().equals(txtCadDoaSenha2.getText())){
        JOptionPane.showMessageDialog(null, "Confirmação de Senha incorreta", "Cadastro não efetivado", WIDTH);
        }
    }//GEN-LAST:event_botaoCadDoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadDoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbFisica;
    private javax.swing.JRadioButton rbJuridica;
    private javax.swing.JTextField txtCadDoaLogin;
    private javax.swing.JTextField txtCadDoaNome;
    private javax.swing.JTextField txtCadDoaSenha;
    private javax.swing.JTextField txtCadDoaSenha2;
    // End of variables declaration//GEN-END:variables
}
