
package pkgInterface.Dialogs;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import util.Cliente;
import util.ConexaoBD;
import util.Produto;

/**
 *
 * @author felip
 */
public class DialogFinalizarVenda extends JDialog{
    
    private final FinalizarVenda painel;
    private final JButton btnConfirmar;
    private boolean vendaFinalizada;
    private final ArrayList<Produto> produtos;
    private final String dataDaVenda;
    
    
    
    public DialogFinalizarVenda(Frame owner,ArrayList<Produto>produtos,String dataDaVenda,String valorTotal) {
        super(owner,true);
        this.dataDaVenda = dataDaVenda;
        this.produtos = produtos;
        this.setSize(473, 305);
        painel = new FinalizarVenda();
        setContentPane(painel);
        btnConfirmar = painel.getBtnConfirma();
        vendaFinalizada = false;
        painel.getLblValorTotal().setText(valorTotal);
        //Configura o botão confirmar venda
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendaFinalizada = true;
                ConexaoBD conexao = new ConexaoBD();
                Cliente c = painel.getCliente();
                
                if(c == null)
                    finalizaVendaAvista(conexao);
                else 
                    finalizaVendaPrazo(conexao, c);
                dispose();
            }
        });
    }

    public boolean isVendaFinalizada() {
        return vendaFinalizada;
    }

    public void setVendaFinalizada(boolean vendaFinalizada) {
        this.vendaFinalizada = vendaFinalizada;
    }
    
    // Cadastra uma venda a prazo no Banco de Dados
    private void finalizaVendaPrazo(ConexaoBD conexao,Cliente c){
        
        conexao.conectar();
        String sql = "INSERT INTO VENDA_APRAZO(codigocliente,datadavenda) VALUES("+ c.getCodigo()
                                 +",CAST('"+dataDaVenda+"' as DATE))";
                    try {
                        conexao.manipulaBD(sql);
                        
                        //Captura o código da venda gerada
                        int codigoDaVenda;
                        sql = "SELECT MAX (codigo) FROM VENDA_APRAZO";
                        ResultSet res = conexao.consultaBD(sql);
                        res.next();
                        codigoDaVenda = res.getInt("max");
                        
                        //Insere os produtos associados à venda no Banco de dados e atualiza o estoque de cada produto
                        for(Produto p : produtos){
                            //Descobre a quantidade comprada do produto
                            sql = "SELECT P.estoque FROM PRODUTO P WHERE P.codigo = "+p.getCodigo();
                            res = conexao.consultaBD(sql);
                            res.next();
                            int quantidade = res.getInt("estoque") - p.getEstoque();
                            
                            //Insere a ligação de cada produto com a venda
                            sql = "INSERT INTO PRODUTOS_VENDA_PRAZO(codigovenda,codigoproduto,quantidade) "
                                    + "VALUES("+codigoDaVenda+" ,"+p.getCodigo()+" ,"+quantidade+")";
                            conexao.manipulaBD(sql);
                            
                            //Atualiza o estoque
                            sql = "UPDATE PRODUTO SET estoque = "+p.getEstoque()+" WHERE codigo = "+p.getCodigo();
                            conexao.manipulaBD(sql);
                        }
                        conexao.desconectar();
                        
                    } catch (SQLException ex) {
                        conexao.desconectar();
                        Logger.getLogger(DialogFinalizarVenda.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("ACTION QUE CADASTRA VENDA A PRAZO NO BANCO DE DADOS!");
    }
    
    // Cadastra uma venda a vista no Banco de Dados
    private void finalizaVendaAvista(ConexaoBD conexao){
        String modoDePagamento = painel.getCmbFormaDePagamento().getSelectedItem().toString();
        String sql = "INSERT INTO VENDA_AVISTA(tipopagamento,datadavenda) VALUES('"+modoDePagamento
                                 +"' CAST('"+dataDaVenda+"' as DATE))";
        try {
                conexao.manipulaBD(sql);
                        
                //Captura o código da venda gerada
                int codigoDaVenda;
                sql = "SELECT MAX (codigo) FROM VENDA_AVISTA";
                ResultSet res = conexao.consultaBD(sql);
                res.next();
                codigoDaVenda = res.getInt("max");
                        
                //Insere os produtos associados à venda no Banco de dados e atualiza o estoque de cada produto
                for(Produto p : produtos){
                    //Descobre a quantidade comprada do produto
                    sql = "SELECT P.estoque FROM PRODUTO P WHERE P.codigo = "+p.getCodigo();
                    res = conexao.consultaBD(sql);
                    res.next();
                    int quantidade = res.getInt("estoque") - p.getEstoque();
                            
                    //Insere a ligação de cada produto com a venda
                    sql = "INSERT INTO PRODUTOS_VENDA_VISTA(codigovenda,codigoproduto,quantidade) "
                          + "VALUES("+codigoDaVenda+" ,"+p.getCodigo()+" ,"+quantidade+")";
                    conexao.manipulaBD(sql);
                            
                    //Atualiza o estoque
                    sql = "UPDATE PRODUTO SET estoque = "+p.getEstoque()+" WHERE codigo = "+p.getCodigo();
                    conexao.manipulaBD(sql);
                }
            conexao.desconectar();
                        
            } catch (SQLException ex) {
                conexao.desconectar();
                Logger.getLogger(DialogFinalizarVenda.class.getName()).log(Level.SEVERE, null, ex);
              }
            
            System.out.println("ACTION QUE CADASTRA VENDA A VISTA NO BANCO DE DADOS!");
    
    }
}
