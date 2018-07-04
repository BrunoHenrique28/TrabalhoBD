package pkgInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pkgInterface.Dialogs.DialogPesquisaProdutos;
import util.ConexaoBD;
import util.Fornecedor;
import util.Produto;

public class CompraProduto extends javax.swing.JFrame {

    private Produto produtoSelecionado;
    private Fornecedor fornecedor;
    
    public CompraProduto() {
        initComponents();
        mostraProdutos();
    }

    private void mostraProdutos(){
        ConexaoBD conexao = new ConexaoBD();
        conexao.conectar();
        
        String sql = "Select codigo, descricao, estoque from produto";
        try
        {
            ResultSet resultado = conexao.consultaBD(sql);
            DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
            limpaTabela();
            while(resultado.next()){
                Object[] produto = {resultado.getInt("codigo"),resultado.getString("descricao"),resultado.getInt("estoque")};
                model.addRow(produto);
            }
            conexao.desconectar();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgFiltros = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        edtICMS = new javax.swing.JTextField();
        edtDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edtNomeFornecedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edtCodigoFornecedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        edtCodigoProduto = new javax.swing.JTextField();
        edtIpi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        edtOutrosImpostos = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        edtLucro = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rbCodigo = new javax.swing.JRadioButton();
        rbDescricao = new javax.swing.JRadioButton();
        edtFiltro = new javax.swing.JTextField();
        rbExibirEstoqueCritico = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        btnCompraMais = new javax.swing.JButton();
        edtEstoqueAtual = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        edtEstoqueMaximo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        edtEstoqueMinimo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos Cadastrados"));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));

        jScrollPane1.setMinimumSize(new java.awt.Dimension(0, 0));

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProdutos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(70);
        tblProdutos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(70);
        tblProdutos.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(70);
        tblProdutos.getTableHeader().getColumnModel().getColumn(2).setMinWidth(70);
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do Produto"));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));

        jLabel2.setText("Descrição");

        jLabel11.setText("ICMS %");

        edtICMS.setEditable(false);

        edtDescricao.setEditable(false);

        jLabel3.setText("Nome do Fornecedor");

        edtNomeFornecedor.setEditable(false);

        jLabel4.setText("Cód. do Fornecedor");

        edtCodigoFornecedor.setEditable(false);

        jLabel8.setText("Cód. Produto");

        edtCodigoProduto.setEditable(false);

        edtIpi.setEditable(false);

        jLabel12.setText("IPI %");

        edtOutrosImpostos.setEditable(false);

        jLabel14.setText("Outros Impostos %");

        edtLucro.setEditable(false);

        jLabel17.setText("Lucro %");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(edtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                            .addComponent(edtNomeFornecedor))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(edtICMS, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtIpi, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(edtOutrosImpostos, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17)
                    .addComponent(edtLucro)
                    .addComponent(edtCodigoFornecedor)
                    .addComponent(edtCodigoProduto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtCodigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(edtICMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(edtLucro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(edtIpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edtOutrosImpostos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(26, 26, 26)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        bgFiltros.add(rbCodigo);
        rbCodigo.setSelected(true);
        rbCodigo.setText("Código");
        rbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCodigoActionPerformed(evt);
            }
        });

        bgFiltros.add(rbDescricao);
        rbDescricao.setText("Descrição");
        rbDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDescricaoActionPerformed(evt);
            }
        });

        edtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtFiltroKeyReleased(evt);
            }
        });

        bgFiltros.add(rbExibirEstoqueCritico);
        rbExibirEstoqueCritico.setText("Itens com estoque crítico");
        rbExibirEstoqueCritico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbExibirEstoqueCriticoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtFiltro)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rbCodigo)
                        .addGap(18, 18, 18)
                        .addComponent(rbDescricao)
                        .addGap(18, 18, 18)
                        .addComponent(rbExibirEstoqueCritico)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCodigo)
                    .addComponent(rbDescricao)
                    .addComponent(rbExibirEstoqueCritico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Controle do estoque"));

        btnCompraMais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCompraMais.setText("COMPRAR MAIS");

        edtEstoqueAtual.setEditable(false);

        jLabel13.setText("Estoque Atual");

        edtEstoqueMaximo.setEditable(false);

        jLabel15.setText("Estoque Máximo");

        jLabel16.setText("Estoque Minimo");

        edtEstoqueMinimo.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(edtEstoqueMinimo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(edtEstoqueMaximo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(edtEstoqueAtual)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCompraMais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtEstoqueMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtEstoqueAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCompraMais, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VENDA");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("GERENCIAMENTO DE PRODUTOS");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(246, 246, 246)
                    .addComponent(jLabel1)
                    .addContainerGap(247, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtFiltroKeyReleased
        consultaFiltro();
    }//GEN-LAST:event_edtFiltroKeyReleased

    private void rbExibirEstoqueCriticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbExibirEstoqueCriticoActionPerformed
        String sql;
        if(rbExibirEstoqueCritico.isSelected()){
            sql = "Select codigo, descricao, estoque from PRODUTO P WHERE P.estoque < P.estoqueMinimo";
            edtFiltro.setEnabled(false);
            edtFiltro.setText("");
        }
        else{
            sql = "Select codigo, descricao, estoque from PRODUTO P";
            edtFiltro.setEnabled(true);
        }
        ConexaoBD conexao = new ConexaoBD();
        conexao.conectar();
        try
        {
            ResultSet resultado = conexao.consultaBD(sql);
            limpaTabela();
            DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
             while(resultado.next()){
                Object[] produto = {resultado.getInt("codigo"),resultado.getString("descricao"),resultado.getInt("estoque")};
                model.addRow(produto);
            }
            conexao.desconectar();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
            
    }//GEN-LAST:event_rbExibirEstoqueCriticoActionPerformed

    private void rbDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDescricaoActionPerformed
        String sql;
        if(rbExibirEstoqueCritico.isSelected()){
            sql = "Select codigo, descricao, estoque from PRODUTO P WHERE P.estoque < P.estoqueMinimo";
            edtFiltro.setEnabled(false);
        }
        else{
            sql = "Select codigo, descricao, estoque from PRODUTO P";
            edtFiltro.setEnabled(true);
            edtFiltro.setText("");
        }
        ConexaoBD conexao = new ConexaoBD();
        conexao.conectar();
        try
        {
            ResultSet resultado = conexao.consultaBD(sql);
            limpaTabela();
            DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
             while(resultado.next()){
                Object[] produto = {resultado.getInt("codigo"),resultado.getString("descricao"),resultado.getInt("estoque")};
                model.addRow(produto);
            }
            conexao.desconectar();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_rbDescricaoActionPerformed

    private void rbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCodigoActionPerformed
        String sql;
        if(rbExibirEstoqueCritico.isSelected()){
            sql = "Select codigo, descricao, estoque from PRODUTO P WHERE P.estoque < P.estoqueMinimo";
            edtFiltro.setEnabled(false);
        }
        else{
            sql = "Select codigo, descricao, estoque from PRODUTO P";
            edtFiltro.setEnabled(true);
            edtFiltro.setText("");
        }
        ConexaoBD conexao = new ConexaoBD();
        conexao.conectar();
        try
        {
            ResultSet resultado = conexao.consultaBD(sql);
            limpaTabela();
            DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
             while(resultado.next()){
                Object[] produto = {resultado.getInt("codigo"),resultado.getString("descricao"),resultado.getInt("estoque")};
                model.addRow(produto);
            }
            conexao.desconectar();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_rbCodigoActionPerformed

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked
        recupera();
        
    }//GEN-LAST:event_tblProdutosMouseClicked

    private void consultaFiltro(){
        ConexaoBD conexao = new ConexaoBD();
        conexao.conectar();
        String sql;
        if(rbCodigo.isSelected()){
            sql = "Select codigo, descricao, estoque from PRODUTO P WHERE CAST(P.codigo as varchar(10)) like '%"+edtFiltro.getText()+"%' ORDER BY codigo";
        }
        else
            sql = "Select codigo, descricao, estoque from PRODUTO P WHERE P.descricao like '%"+edtFiltro.getText()+"%' ORDER BY descricao";
        
        try
        {
            ResultSet resultado = conexao.consultaBD(sql);
            DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
            limpaTabela();
             while(resultado.next()){
                Object[] produto = {resultado.getInt("codigo"),resultado.getString("descricao"),resultado.getInt("estoque")};
                model.addRow(produto);
            }
            conexao.desconectar();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void limpaTabela(){
        DefaultTableModel model =(DefaultTableModel) tblProdutos.getModel();
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
    }
    
    //Recupera todas as informações do produto selecionado
    private void recupera(){
        
        String codigo = tblProdutos.getValueAt(tblProdutos.getSelectedRow(),0).toString();
        ConexaoBD conexao = new ConexaoBD();
        conexao.conectar();
        String sql = "SELECT * FROM PRODUTO WHERE codigo = "+codigo;
        try {
            ResultSet rst = conexao.consultaBD(sql);
            rst.next();
            int cod = rst.getInt("codigo");
            edtCodigoProduto.setText(""+cod);
            String descricao = rst.getString("descricao");
            edtDescricao.setText(descricao);
            Double valorCusto = rst.getDouble("valorcusto");
            Double lucro = rst.getDouble("lucro")/100;
            edtLucro.setText(NumberFormat.getPercentInstance().format(lucro));
            Double icms = rst.getDouble("icms")/100;
            edtICMS.setText(NumberFormat.getPercentInstance().format(icms));
            Double ipi = rst.getDouble("ipi")/100;
            edtIpi.setText(NumberFormat.getPercentInstance().format(ipi));
            Double outros = rst.getDouble("outrosimpostos")/100;
            edtOutrosImpostos.setText(NumberFormat.getPercentInstance().format(outros));
            Integer estoque = rst.getInt("estoque");
            edtEstoqueAtual.setText(estoque.toString());
            Integer estoqueMin = rst.getInt("estoqueminimo");
            edtEstoqueMinimo.setText(estoqueMin.toString());
            Integer estoqueMax = rst.getInt("estoquemaximo");
            edtEstoqueMaximo.setText(estoqueMax.toString());
            int codFornecedor = rst.getInt("codFornecedor");
            edtCodigoFornecedor.setText(""+codFornecedor);
            sql = "SELECT nome FROM FORNECEDOR WHERE codigofornecedor = "+codFornecedor;
            rst = conexao.consultaBD(sql);
            rst.next();
            String nomeFornecedor = rst.getString("nome");
            fornecedor = new Fornecedor(codFornecedor, nomeFornecedor);
            edtNomeFornecedor.setText(nomeFornecedor);
            produtoSelecionado = new Produto(cod, descricao,valorCusto,lucro,icms,ipi,outros,estoque,estoqueMin,estoqueMax);
            conexao.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DialogPesquisaProdutos.class.getName()).log(Level.SEVERE, null, ex);
            conexao.desconectar();
        }
      
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompraProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgFiltros;
    private javax.swing.JButton btnCompraMais;
    private javax.swing.JTextField edtCodigoFornecedor;
    private javax.swing.JTextField edtCodigoProduto;
    private javax.swing.JTextField edtDescricao;
    private javax.swing.JTextField edtEstoqueAtual;
    private javax.swing.JTextField edtEstoqueMaximo;
    private javax.swing.JTextField edtEstoqueMinimo;
    private javax.swing.JTextField edtFiltro;
    private javax.swing.JTextField edtICMS;
    private javax.swing.JTextField edtIpi;
    private javax.swing.JTextField edtLucro;
    private javax.swing.JTextField edtNomeFornecedor;
    private javax.swing.JTextField edtOutrosImpostos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbDescricao;
    private javax.swing.JRadioButton rbExibirEstoqueCritico;
    private javax.swing.JTable tblProdutos;
    // End of variables declaration//GEN-END:variables
}
