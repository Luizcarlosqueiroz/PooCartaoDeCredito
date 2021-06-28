/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compra;

import java.util.Date;
import javax.swing.JOptionPane;
import maquinaCartao.Maquineta;
import pagamento.ModalCredito;
import pagamento.ModalParcelado;
import pagamento.ModalRotativo;
import pagamento.Pagamento;

/**
 *
 * @author Marília
 */
public class InterfaceCompra extends javax.swing.JFrame {
    
    Compra compra = new Compra();
    
    String etapa = "compra";
    String metodoPagamento = "";
    int qtdParcelas = 1;
    
    String saidaInstrucao = "";
    String saidaUsuario = "";
    String entradaUsuario = "";
    Double valorCompra;
    String senhaUsuario;
    
    
    public InterfaceCompra() {
        initComponents();
        
        if (etapa.equals("compra")){
            displayCompra();
        } else if (etapa.equals("modoPagamento")){
            displayModoPagamento();
        }    
        
    }

    private void displayCompra(){
        labelTitulo.setText("Insira Valor da Compra");
            labelValor.setVisible(true);
            txtValor.setVisible(true);
            labelValueValor.setVisible(false);
            btnConfirmar.setText("Inserir Método de Pagamento");
            
            labelModoPagamento.setVisible(true);
            selectModoPagamento.setVisible(true);
            
            labelParcelas.setVisible(false);
            selectParcelas.setVisible(false);
            labelTaxaEmPercent.setVisible(false);
            labelValueTaxaEmPercent.setVisible(false);
            labelTaxaEmReal.setVisible(false);
            labelValueTaxaEmReal.setVisible(false);
            labelValorLiq.setVisible(false);
            labelValueValorLiq.setVisible(false);
    }
    
    private void displayModoPagamento(){
        labelTitulo.setText("Selecione Método de Pagamento");
        labelValor.setVisible(true);
            txtValor.setVisible(false);
            labelValueValor.setVisible(true);
            btnConfirmar.setText("Confirmar");
            
            labelModoPagamento.setVisible(true);
            selectModoPagamento.setVisible(true);
            labelParcelas.setVisible(true);
            selectParcelas.setVisible(true);
            labelTaxaEmPercent.setVisible(true);
            labelValueTaxaEmPercent.setVisible(true);
            labelTaxaEmReal.setVisible(true);
            labelValueTaxaEmReal.setVisible(true);
            labelValorLiq.setVisible(true);
            labelValueValorLiq.setVisible(true);    
    
    }
    
    public void gerarCompra(){
        try {
            //Compra compra = new Compra();
            
            if (txtValor.getText().matches("[0-9]+") == false) {
                JOptionPane.showMessageDialog(this, "Valor Inválido");
                return;
            }
            
            compra.setValorBruto(Double.parseDouble(txtValor.getText()));
            compra.setDiaCompra(new Date());
            // Comprador e Vendedor podem ser inderidos por suas interfaces
            // Nesse caso, como seria necessário listar cada um para saber o id de cada, usamos por padrão id 1

            compra.getComprador().setIdComprador(1);
            compra.getVendedor().setIdVendedor(1);
            
            CompraNegocios dadosCompra = new CompraNegocios();
            dadosCompra.inserirCompra(compra);
            JOptionPane.showMessageDialog(this, "Compra Cadastrada");
                        
            labelValueValor.setText(txtValor.getText());
            displayModoPagamento();
            etapa = "metodoPagamento";
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }         
    }
    
    public void gerarPagamento(String metodoPagamento){
        
        try{
            Pagamento pagamento = new Pagamento();
            
            double taxa;
            double liquido;
            double taxaPaga;
            
            switch (metodoPagamento) {
                case "Débito":
                    ModalRotativo pagamentoDebito = new ModalRotativo();
                    labelParcelas.setVisible(false);
                    selectParcelas.setVisible(false);
                    
                    taxa = pagamentoDebito.getTaxaOperacao();
                    liquido = pagamento.calcularValorLiquido(compra.getValorBruto(), taxa);
                    taxaPaga = pagamento.calcularTaxaPaga(compra.getValorBruto(), taxa);
                    
                    imprimirResultados(taxa, liquido, taxaPaga);
                    break;
                case "Crédito à Vista":
                    ModalCredito pagamentoCreditoAVista = new ModalCredito();
                    labelParcelas.setVisible(false);
                    selectParcelas.setVisible(false);
                    
                    taxa = pagamentoCreditoAVista.getTaxaOperacao();
                    liquido = pagamento.calcularValorLiquido(compra.getValorBruto(), taxa);
                    taxaPaga = pagamento.calcularTaxaPaga(compra.getValorBruto(), taxa);
                    
                    imprimirResultados(taxa, liquido, taxaPaga);
                    break;
                case "Crédito Parcelado":
                    ModalParcelado pagamentoCreditoParcelado = new ModalParcelado();
                    labelParcelas.setVisible(true);
                    selectParcelas.setVisible(true);
                    
                    pagamentoCreditoParcelado.setQuantidadeMaxParcelas(compra.getValorBruto());
                    qtdParcelas = pagamentoCreditoParcelado.getQuantidadeMaxParcelas();
                    
                    selectParcelas.addItem("1x");
                    if (qtdParcelas == 2){
                        selectParcelas.addItem("2x");
                    } else if (qtdParcelas == 3){
                        selectParcelas.addItem("2x");
                        selectParcelas.addItem("3x");
                    }
                    
                    pagamentoCreditoParcelado.setTaxaTotal(qtdParcelas);
                    taxa = pagamentoCreditoParcelado.getTaxaTotal();
                    liquido = pagamento.calcularValorLiquido(compra.getValorBruto(), taxa);
                    taxaPaga = pagamento.calcularTaxaPaga(compra.getValorBruto(), taxa);
                    
                    imprimirResultados(taxa, liquido, taxaPaga);
                    break;
                default:
                    return;
            }
            
            new Maquineta().setVisible(true);
            
        } catch  (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }  
    }
    
    public void imprimirResultados(double taxa, double liquido, double taxaPaga) {
            labelValueTaxaEmPercent.setText(String.valueOf(taxa));
            labelValueTaxaEmReal.setText(String.valueOf(taxaPaga));
            labelValueValorLiq.setText(String.valueOf(liquido));   
    }
    
    public void calcularTaxasEValorLiq(){
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        labelValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        labelModoPagamento = new javax.swing.JLabel();
        labelParcelas = new javax.swing.JLabel();
        labelTaxaEmReal = new javax.swing.JLabel();
        labelValueTaxaEmPercent = new javax.swing.JLabel();
        labelTaxaEmPercent = new javax.swing.JLabel();
        labelValueTaxaEmReal = new javax.swing.JLabel();
        labelValorLiq = new javax.swing.JLabel();
        labelValueValorLiq = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        selectParcelas = new javax.swing.JComboBox<>();
        selectModoPagamento = new javax.swing.JComboBox<>();
        labelValueValor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        labelValor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelValor.setText("Valor R$");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        getContentPane().add(labelValor, gridBagConstraints);

        txtValor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(txtValor, gridBagConstraints);

        labelModoPagamento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelModoPagamento.setText("Modo de Pagamento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        getContentPane().add(labelModoPagamento, gridBagConstraints);

        labelParcelas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelParcelas.setText("Parcelas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        getContentPane().add(labelParcelas, gridBagConstraints);

        labelTaxaEmReal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTaxaEmReal.setText("Taxa a pagar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        getContentPane().add(labelTaxaEmReal, gridBagConstraints);

        labelValueTaxaEmPercent.setText("%");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 60;
        getContentPane().add(labelValueTaxaEmPercent, gridBagConstraints);

        labelTaxaEmPercent.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTaxaEmPercent.setText("Taxa (%)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        getContentPane().add(labelTaxaEmPercent, gridBagConstraints);

        labelValueTaxaEmReal.setText("R$");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 60;
        getContentPane().add(labelValueTaxaEmReal, gridBagConstraints);

        labelValorLiq.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelValorLiq.setText("Valor Líquido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        getContentPane().add(labelValorLiq, gridBagConstraints);

        labelValueValorLiq.setText("R$");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 60;
        getContentPane().add(labelValueValorLiq, gridBagConstraints);

        labelTitulo.setText("Selecione a forma de pagamento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(labelTitulo, gridBagConstraints);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(btnConfirmar, gridBagConstraints);

        selectParcelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectParcelasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 60;
        getContentPane().add(selectParcelas, gridBagConstraints);

        selectModoPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Débito", "Crédito à Vista", "Crédito Parcelado" }));
        selectModoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectModoPagamentoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 60;
        getContentPane().add(selectModoPagamento, gridBagConstraints);

        labelValueValor.setText("R$");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 60;
        getContentPane().add(labelValueValor, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (etapa.equals("compra")){
            gerarCompra();
            
        } else if (etapa.equals("metodoPagamento")){
            
            metodoPagamento = selectModoPagamento.getSelectedItem().toString();
            gerarPagamento(metodoPagamento);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void selectParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectParcelasActionPerformed
        
        //!!!! ATUALIZAR QTD PARCELAS
        
        calcularTaxasEValorLiq();
    }//GEN-LAST:event_selectParcelasActionPerformed

    private void selectModoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectModoPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectModoPagamentoActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel labelModoPagamento;
    private javax.swing.JLabel labelParcelas;
    private javax.swing.JLabel labelTaxaEmPercent;
    private javax.swing.JLabel labelTaxaEmReal;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelValor;
    private javax.swing.JLabel labelValorLiq;
    private javax.swing.JLabel labelValueTaxaEmPercent;
    private javax.swing.JLabel labelValueTaxaEmReal;
    private javax.swing.JLabel labelValueValor;
    private javax.swing.JLabel labelValueValorLiq;
    private javax.swing.JComboBox<String> selectModoPagamento;
    private javax.swing.JComboBox<String> selectParcelas;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
