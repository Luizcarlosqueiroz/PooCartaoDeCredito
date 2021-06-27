package vendedor;




import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marília
 */
public class InterfaceVendedor extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceVendedor
     */
    public InterfaceVendedor() {
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

        labelCnpjVendedor = new javax.swing.JLabel();
        labelNomeFantasiaVendedor = new javax.swing.JLabel();
        labelVendedor = new javax.swing.JLabel();
        labelEnderecoVendedor = new javax.swing.JLabel();
        inputNomeFantasiaVendedor = new javax.swing.JTextField();
        inputEnderecoVendedor = new javax.swing.JTextField();
        btnAddVendedor = new javax.swing.JButton();
        imputCnpjVendedor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelCnpjVendedor.setText("CNPJ");

        labelNomeFantasiaVendedor.setText("Nome Fantasia");

        labelVendedor.setText("Vendedor");

        labelEnderecoVendedor.setText("Endereço");

        btnAddVendedor.setText("Cadastrar");
        btnAddVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNomeFantasiaVendedor)
                            .addComponent(labelEnderecoVendedor))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputEnderecoVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                            .addComponent(inputNomeFantasiaVendedor, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(91, 91, 91))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCnpjVendedor)
                        .addGap(33, 33, 33)
                        .addComponent(imputCnpjVendedor)
                        .addGap(122, 122, 122))))
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddVendedor)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelVendedor)
                        .addGap(23, 23, 23)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(labelVendedor)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCnpjVendedor)
                    .addComponent(imputCnpjVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeFantasiaVendedor)
                    .addComponent(inputNomeFantasiaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEnderecoVendedor)
                    .addComponent(inputEnderecoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnAddVendedor)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVendedorActionPerformed
        
        try{
        
        Vendedor vendedor = new Vendedor();
        
        vendedor.setCnpj(imputCnpjVendedor.getText());
        vendedor.setNomeFantasia(inputNomeFantasiaVendedor.getText());
        vendedor.setEndereco(inputEnderecoVendedor.getText());
        
        VendedorNegocio dados = new VendedorNegocio();
        dados.inserirVendedor(vendedor);
        JOptionPane.showMessageDialog(this,"Vendedor cadastrado com sucesso");
            
        imputCnpjVendedor.setText("");
        inputNomeFantasiaVendedor.setText("");
        inputEnderecoVendedor.setText("");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnAddVendedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceVendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddVendedor;
    private javax.swing.JTextField imputCnpjVendedor;
    private javax.swing.JTextField inputEnderecoVendedor;
    private javax.swing.JTextField inputNomeFantasiaVendedor;
    private javax.swing.JLabel labelCnpjVendedor;
    private javax.swing.JLabel labelEnderecoVendedor;
    private javax.swing.JLabel labelNomeFantasiaVendedor;
    private javax.swing.JLabel labelVendedor;
    // End of variables declaration//GEN-END:variables
}