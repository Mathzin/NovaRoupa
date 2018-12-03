/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DonatarioControl;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import model.Donatario;
import model.Pessoa;
import view.TelaPrincipal;

/**
 *
 * @author karol
 */
public class TelaMenuDonatarioRecebeDinheiro extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaMenuDonatarioRecebeDinheiro
     */
    public TelaMenuDonatarioRecebeDinheiro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtLimite = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btReceber = new javax.swing.JButton();
        btRetornar = new javax.swing.JButton();
        txtValorDisp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Donatário - Banco de Dinheiro");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Escolha um valor para receber:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 189, -1, -1));

        txtLimite.setEditable(false);
        getContentPane().add(txtLimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 50, 78, 41));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Valor Limite:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 22, -1, -1));
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 185, 110, -1));

        btReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-abaixo-dentro-de-um-círculo.png"))); // NOI18N
        btReceber.setText("Receber");
        btReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceberActionPerformed(evt);
            }
        });
        getContentPane().add(btReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 355, 110, -1));

        btRetornar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-retornar-filled.png"))); // NOI18N
        btRetornar.setText("RETORNAR");
        btRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetornarActionPerformed(evt);
            }
        });
        getContentPane().add(btRetornar, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 355, -1, -1));

        txtValorDisp.setEditable(false);
        getContentPane().add(txtValorDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 50, 78, 41));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Valor Disponivel:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 22, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundoInterno.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetornarActionPerformed
        this.dispose();
             TelaMenuDonatario telaMenuDona = new TelaMenuDonatario();
             TelaPrincipal.painel.add(telaMenuDona);
             telaMenuDona.setVisible(true);
    }//GEN-LAST:event_btRetornarActionPerformed

    private void btReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceberActionPerformed
      
try {
        if(txtValor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor escolha um valor para ser Recebido!");
        } 
        String valor = txtValor.getText();
        valor = valor.replace(",", ".");
        Double valorDouble = Double.parseDouble(valor);
         
        DonatarioControl.receberDinheiro(TelaLoginDonatario.txtLogDonaLogin.getText(),TelaLoginDonatario.txtLogDonaSenha.getText(),valorDouble);
       
        TelaMenuDonatarioRecebeDinheiro.txtValorDisp.setText(Double.toString(Pessoa.dinheiroDoado)); 
       }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números inteiros");

}
 if(Donatario.msg==0){
            JOptionPane.showMessageDialog(null, "Dinheiro Recebido com sucesso: R$"+Integer.valueOf(txtValor.getText()), "Recebimento efetivado", WIDTH);
        }
        if(Donatario.msg==1){
            JOptionPane.showMessageDialog(null, "Limite Atingido", "Recebimento não efetivado", WIDTH);
        }
        else if(Donatario.msg==2){
            JOptionPane.showMessageDialog(null, "Não há dinheiro suficiente no Banco", "Recebimento não efetivado", WIDTH);
        }
        else if(Donatario.msg==3){
            JOptionPane.showMessageDialog(null, "Não há dinheiro no banco", "Recebimento não efetivado", WIDTH);
        }
        else if(Donatario.msg==4){
             JOptionPane.showMessageDialog(null, "Valor inserido inválido", "Recebimento não efetivado", WIDTH);
        }
        
        
    }//GEN-LAST:event_btReceberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReceber;
    private javax.swing.JButton btRetornar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JTextField txtLimite;
    private javax.swing.JTextField txtValor;
    public static javax.swing.JTextField txtValorDisp;
    // End of variables declaration//GEN-END:variables
}
