
package pkgInterface.Dialogs;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
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
    private ArrayList<Produto> produtos;
    
    
    public DialogFinalizarVenda(Frame owner) {
        super(owner,true);
        this.setSize(473, 305);
        painel = new FinalizarVenda();
        setContentPane(painel);
        btnConfirmar = painel.getBtnConfirma();
        vendaFinalizada = false;
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendaFinalizada = true;
                ConexaoBD conexao = new ConexaoBD();
                conexao.conectar();
                if(painel.getCliente() == null){ // cadastra uma venda a prazo no banco de dados
                    
                    String sql = "INSERT INTO VENDA_AVISTA VALUES()";
                    System.out.println("ACTION QUE CADASTRA VENDA A PRAZO NO BANCO DE DADOS!");
                
                } else{ // Cadastra uma venda a vista no banco de dados
                    String modoDePagamento = painel.getCmbFormaDePagamento().getSelectedItem().toString();
                    
                    System.out.println("ACTION QUE CADASTRA VENDA A VISTA NO BANCO DE DADOS!");
                }
                
                conexao.desconectar();
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
    
    
}
