/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class Menu extends javax.swing.JFrame {

    public Menu(String[] arquivo) {
        initComponents();
        this.arquivo = arquivo;
    }
    private String[] arquivo;
    
                         
    private void initComponents() {

        Opcoes = new javax.swing.JComboBox<>();
        btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Opcoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Inser��o", "Busca", "Remo��o" }));

        btn.setText("OK");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecione o gr�fico:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Opcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Opcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        setSize(new java.awt.Dimension(450, 200));
        setLocationRelativeTo(null);
        
        pack();
    }// </editor-fold>                        

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {                                    
    	if (!Opcoes.getSelectedItem().equals("Selecione")) {
    		if(Opcoes.getSelectedItem().equals("Inser��o"))
    			new Graficos(arquivo,1);
    		//como parametro Graficos recebe o arquivo a ser manipulado
    		//juntamente com uma identifica��o de qual gr�fico gerar
    		if(Opcoes.getSelectedItem().equals("Busca"))
    			new Graficos(arquivo,2);
    		if(Opcoes.getSelectedItem().equals("Remo��o"))
    			new Graficos(arquivo,3);
        } else {
            JOptionPane.showMessageDialog(null, "Gr�fico n�o selecionado!", "Error", 0);
        }
    }                                   

                     
    private javax.swing.JComboBox<String> Opcoes;
    private javax.swing.JButton btn;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}
