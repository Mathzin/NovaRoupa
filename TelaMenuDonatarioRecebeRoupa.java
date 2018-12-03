/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DonatarioControl;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import model.Pessoa;

/**
 *
 * @author karol
 */
public class TelaMenuDonatarioRecebeRoupa extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaMenuDonatarioRecebeRoupa
     */
    public TelaMenuDonatarioRecebeRoupa() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbRoupasReceber = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtLimitePecas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRecebidas = new javax.swing.JTextField();
        txtQtdeRoupas = new javax.swing.JTextField();
        btRetornar = new javax.swing.JButton();
        btReceber = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Donatário - Banco de Roupas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-blazer.png"))); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbRoupasReceber.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Blusa",  new Double(0.0)},
                {"Camisa",  new Double(0.0)},
                {"Casaco",  new Double(0.0)},
                {"Short",  new Double(0.0)},
                {"Bermuda",  new Double(0.0)},
                {"Calça",  new Double(0.0)},
                {"Sapato", null}
            },
            new String [] {
                "Roupas", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRoupasReceber.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tbRoupasReceber);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 114, 523, 139));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Selecione a peça que deseja:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 88, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Informe a quantidade que deseja receber:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 271, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Limite de Peças:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 6, -1, -1));

        txtLimitePecas.setEditable(false);
        getContentPane().add(txtLimitePecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 29, 94, 40));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Peças Recebidas até o momento:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, -1, -1));

        txtRecebidas.setEditable(false);
        getContentPane().add(txtRecebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 28, 84, 42));
        getContentPane().add(txtQtdeRoupas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 299, 236, -1));

        btRetornar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-retornar-filled.png"))); // NOI18N
        btRetornar.setText("RETORNAR");
        btRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetornarActionPerformed(evt);
            }
        });
        getContentPane().add(btRetornar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 362, -1, -1));

        btReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-abaixo-dentro-de-um-círculo.png"))); // NOI18N
        btReceber.setText("Receber");
        btReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceberActionPerformed(evt);
            }
        });
        getContentPane().add(btReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundoInterno.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 420));

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
        if(tbRoupasReceber.getSelectedRowCount()==0){
           JOptionPane.showMessageDialog(null, "Selecione alguma peça!");
       }
        else{
        if(Integer.valueOf(txtQtdeRoupas.getText())>0){
            DonatarioControl.salvarBancoRoupas();
           
          DonatarioControl.receberRoupas(TelaLoginDonatario.txtLogDonaLogin.getText(),TelaLoginDonatario.txtLogDonaSenha.getText(),tbRoupasReceber.getSelectedRow(),Integer.valueOf(txtQtdeRoupas.getText()));  
            tbRoupasReceber.setValueAt(Pessoa.bancoRoupas2.get(tbRoupasReceber.getSelectedRow()), tbRoupasReceber.getSelectedRow(), 1);
       
        String recebidas = Integer.toString(DonatarioControl.verRoupasRecebidas(TelaLoginDonatario.txtLogDonaLogin.getText(),TelaLoginDonatario.txtLogDonaSenha.getText()));
        txtRecebidas.setText(recebidas);
        
       
        }
        else {
            
            JOptionPane.showMessageDialog(null, "Quantidade inserida inválida");
        }
        }
        }catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Digite apenas números inteiros");

        }
      
    }//GEN-LAST:event_btReceberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReceber;
    private javax.swing.JButton btRetornar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbRoupasReceber;
    public static javax.swing.JTextField txtLimitePecas;
    private javax.swing.JTextField txtQtdeRoupas;
    public static javax.swing.JTextField txtRecebidas;
    // End of variables declaration//GEN-END:variables
}
