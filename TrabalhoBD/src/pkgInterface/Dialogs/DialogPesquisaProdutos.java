/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgInterface.Dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import util.ConexaoBD;
import util.Produto;

/**
 *
 * @author felip
 */
public class DialogPesquisaProdutos extends JDialog{
    
    private final PesquisaProdutos painel;
    private Produto produtoSelecionado;
    private final JButton btnConfirmar;
    private JTable tabProdutos;
    
    public DialogPesquisaProdutos (javax.swing.JFrame parent){
        super(parent);
        super.setModal(true);
        painel = new PesquisaProdutos();
        this.btnConfirmar = painel.getBtnConfirma();
        this.tabProdutos = painel.getTabProdutos();
        
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabProdutos.getSelectedRowCount() == 1){
                    recupera();
                    dispose();
                }
                else if(tabProdutos.getSelectedRowCount() > 1)
                    JOptionPane.showMessageDialog(painel, "Você deve selecionar apenas 1 produto !","Info",JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(painel, "Você deve selecionar 1 produto !","Info",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        this.setContentPane(painel);
        setSize(475, 369);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }
    
    //Recupera todas as informações do produto selecionado
    private void recupera(){
        
        String codigo = tabProdutos.getValueAt(tabProdutos.getSelectedRow(),0).toString();
        ConexaoBD conexao = new ConexaoBD();
        conexao.conectar();
        String sql = "SELECT * FROM PRODUTO WHERE codigo = "+codigo;
        try {
            ResultSet rst = conexao.consultaBD(sql);
            rst.next();
            int cod = rst.getInt("codigo");
            String descricao = rst.getString("descricao");
            Double valorCusto = rst.getDouble("valorcusto");
            Double lucro = rst.getDouble("lucro")/100;
            Double icms = rst.getDouble("icms")/100;
            Double ipi = rst.getDouble("ipi")/100;
            Double outros = rst.getDouble("outrosimpostos")/100;
            Integer estoque = rst.getInt("estoque");
            Integer estoqueMin = rst.getInt("estoqueminimo");
            Integer estoqueMax = rst.getInt("estoquemaximo");
            produtoSelecionado = new Produto(cod, descricao,valorCusto,lucro,icms,ipi,outros,estoque,estoqueMin,estoqueMax);
            
        } catch (SQLException ex) {
            Logger.getLogger(DialogPesquisaProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }
    
    
}
