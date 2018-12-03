
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class TelaPrincipal extends javax.swing.JFrame {
    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }
     public static void notifi(String message, String header) {
JFrame frame = new JFrame();
frame.setAlwaysOnTop(true);
frame.setSize(300,125);
frame.setUndecorated(true);
frame.setLayout(new GridBagLayout());

GridBagConstraints constraints = new GridBagConstraints();
constraints.gridx = 0;
constraints.gridy = 0;
constraints.weightx = 1.0f;
constraints.weighty = 1.0f;
constraints.insets = new Insets(5, 5, 5, 5);
constraints.fill = GridBagConstraints.BOTH;
JLabel headingLabel = new JLabel(header);
//frame.getContentPane().setBackground(new java.awt.Color(100,0,0));
//headingLabel .setIcon(headingIcon); // --- use image icon you want to be as heading image.
headingLabel.setOpaque(false);
frame.add(headingLabel, constraints);
constraints.gridx++;
constraints.weightx = 0f;
constraints.weighty = 0f;
constraints.fill = GridBagConstraints.NONE;
constraints.anchor = GridBagConstraints.NORTH;
JButton cloesButton = new JButton(new AbstractAction("x") {
        @Override
        public void actionPerformed(final ActionEvent e) {
               frame.dispose();
        }
        });
cloesButton.setFocusable(false);
frame.add(cloesButton, constraints);
constraints.gridx = 0;
constraints.gridy++;
constraints.weightx = 1.0f;
constraints.weighty = 1.0f;
constraints.insets = new Insets(5, 5, 5, 5);
constraints.fill = GridBagConstraints.BOTH;
JLabel messageLabel = new JLabel("<HtMl>"+message);
frame.add(messageLabel, constraints);
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen

Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of the task bar
frame.setLocation(scrSize.width - frame.getWidth(), scrSize.height - toolHeight.bottom - frame.getHeight());

frame.setVisible(true);
new Thread(){
      @Override
      public void run() {
           try {
                  Thread.sleep(5000); // time after which pop up will be disappeared.
                  frame.dispose();
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
      };
}.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        painel = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCadDoa = new javax.swing.JMenuItem();
        menuLogDoa = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuCadDona = new javax.swing.JMenuItem();
        menuLogDona = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuCadTroca = new javax.swing.JMenuItem();
        menuLogTroca = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuCadDoaT = new javax.swing.JMenuItem();
        menuLogDoaT = new javax.swing.JMenuItem();
        menuDuvidas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NovaRoupa+=Doações");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painel.setBackground(new java.awt.Color(255, 255, 255));
        painel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        painel.setForeground(new java.awt.Color(255, 255, 255));
        painel.setOpaque(false);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 908, Short.MAX_VALUE)
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        getContentPane().add(painel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 520));
        painel.getAccessibleContext().setAccessibleName("");
        painel.getAccessibleContext().setAccessibleDescription("");

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(0, 0, 0), null, null));
        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundo2_1.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, painel, org.jdesktop.beansbinding.ELProperty.create("${background}"), jLabel1, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 910, 520));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setName(""); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-bem-estar.png"))); // NOI18N
        jMenu1.setText("Doador");

        menuCadDoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-formato.png"))); // NOI18N
        menuCadDoa.setText("Cadastro");
        menuCadDoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadDoaActionPerformed(evt);
            }
        });
        jMenu1.add(menuCadDoa);

        menuLogDoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-entrar.png"))); // NOI18N
        menuLogDoa.setText("Login");
        menuLogDoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogDoaActionPerformed(evt);
            }
        });
        jMenu1.add(menuLogDoa);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-voluntariado-2.png"))); // NOI18N
        jMenu2.setText("Donatário");

        menuCadDona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-formato.png"))); // NOI18N
        menuCadDona.setText("Cadastro");
        menuCadDona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadDonaActionPerformed(evt);
            }
        });
        jMenu2.add(menuCadDona);

        menuLogDona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-entrar.png"))); // NOI18N
        menuLogDona.setText("Login");
        menuLogDona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogDonaActionPerformed(evt);
            }
        });
        jMenu2.add(menuLogDona);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-guarda-roupas.png"))); // NOI18N
        jMenu3.setText("Troca-Roupas");

        menuCadTroca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-formato.png"))); // NOI18N
        menuCadTroca.setText("Cadastro");
        menuCadTroca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadTrocaActionPerformed(evt);
            }
        });
        jMenu3.add(menuCadTroca);

        menuLogTroca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-entrar.png"))); // NOI18N
        menuLogTroca.setText("Login");
        menuLogTroca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogTrocaActionPerformed(evt);
            }
        });
        jMenu3.add(menuLogTroca);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-voluntariado.png"))); // NOI18N
        jMenu4.setText("Doar-Tempo");

        menuCadDoaT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-formato.png"))); // NOI18N
        menuCadDoaT.setText("Cadastro");
        menuCadDoaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadDoaTActionPerformed(evt);
            }
        });
        jMenu4.add(menuCadDoaT);

        menuLogDoaT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-entrar.png"))); // NOI18N
        menuLogDoaT.setText("Login");
        menuLogDoaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogDoaTActionPerformed(evt);
            }
        });
        jMenu4.add(menuLogDoaT);

        jMenuBar1.add(jMenu4);

        menuDuvidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8-sobre.png"))); // NOI18N
        menuDuvidas.setText("Sobre Nós");
        menuDuvidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDuvidasMouseClicked(evt);
            }
        });
        menuDuvidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDuvidasActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuDuvidas);

        setJMenuBar(jMenuBar1);

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadDoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadDoaActionPerformed
      
        TelaCadastroDoador telaCadDoa = new TelaCadastroDoador();
        painel.add(telaCadDoa);
        telaCadDoa.setVisible(true);
    }//GEN-LAST:event_menuCadDoaActionPerformed

    private void menuLogDoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogDoaActionPerformed
 
        TelaLoginDoador telaLogDoa = new TelaLoginDoador();
        painel.add(telaLogDoa);
        telaLogDoa.setVisible(true);
    }//GEN-LAST:event_menuLogDoaActionPerformed

    private void menuCadDonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadDonaActionPerformed
    
        TelaCadastroDonatario telaCadDona = new TelaCadastroDonatario();
        painel.add(telaCadDona);
        telaCadDona.setVisible(true);

    }//GEN-LAST:event_menuCadDonaActionPerformed

    private void menuLogDonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogDonaActionPerformed
        
        TelaLoginDonatario telaLogDona = new TelaLoginDonatario();
        painel.add(telaLogDona);
        telaLogDona.setVisible(true);
    }//GEN-LAST:event_menuLogDonaActionPerformed

    private void menuCadTrocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadTrocaActionPerformed
       
        TelaCadastroTrocaRoupa telaCadTroca = new TelaCadastroTrocaRoupa();
        painel.add(telaCadTroca);
        telaCadTroca.setVisible(true);
    }//GEN-LAST:event_menuCadTrocaActionPerformed

    private void menuLogTrocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogTrocaActionPerformed

       
        TelaLoginTrocaRoupa telaLogTroca = new TelaLoginTrocaRoupa();
        painel.add(telaLogTroca);
        telaLogTroca.setVisible(true);
    }//GEN-LAST:event_menuLogTrocaActionPerformed

    private void menuCadDoaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadDoaTActionPerformed
         
    }//GEN-LAST:event_menuCadDoaTActionPerformed

    private void menuLogDoaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogDoaTActionPerformed
        
    }//GEN-LAST:event_menuLogDoaTActionPerformed

    private void menuDuvidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDuvidasActionPerformed

    }//GEN-LAST:event_menuDuvidasActionPerformed

    private void menuDuvidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDuvidasMouseClicked
         TelaSobreNos telaSobre = new TelaSobreNos();
        painel.add(telaSobre);
        telaSobre.setVisible(true);
    }//GEN-LAST:event_menuDuvidasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuCadDoa;
    private javax.swing.JMenuItem menuCadDoaT;
    private javax.swing.JMenuItem menuCadDona;
    private javax.swing.JMenuItem menuCadTroca;
    private javax.swing.JMenu menuDuvidas;
    private javax.swing.JMenuItem menuLogDoa;
    private javax.swing.JMenuItem menuLogDoaT;
    private javax.swing.JMenuItem menuLogDona;
    private javax.swing.JMenuItem menuLogTroca;
    public static javax.swing.JPanel painel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
