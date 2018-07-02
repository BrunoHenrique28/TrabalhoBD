
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
import util.Cliente;
import util.ConexaoBD;

/**
 *
 * @author felip
 */
public class DialogPesquisaCliente extends JDialog{
    private final PesquisaClientes painel;
    private Cliente clienteSelecionado;
    private final JButton btnConfirmar;
    private JTable tabClientes;
    
    public DialogPesquisaCliente (javax.swing.JFrame parent){
        super(parent);
        super.setModal(true);
        painel = new PesquisaClientes();
        this.btnConfirmar = painel.getBtnConfirma();
        this.tabClientes = painel.getTabClientes();
        
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabClientes.getSelectedRowCount() == 1){
                    recupera();
                    dispose();
                }
                else if(tabClientes.getSelectedRowCount() > 1)
                    JOptionPane.showMessageDialog(painel, "Você deve selecionar apenas 1 clientes !","Info",JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(painel, "Você deve selecionar 1 cliente !","Info",JOptionPane.INFORMATION_MESSAGE);
            }

        });
        
        this.setContentPane(painel);
        setSize(475, 369);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }
    
    //Recupera todas as informações do produto selecionado
    private void recupera(){
        
        String codigo = tabClientes.getValueAt(tabClientes.getSelectedRow(),0).toString();
        ConexaoBD conexao = new ConexaoBD();
        conexao.conectar();
        String sql = "SELECT * FROM CLIENTE WHERE codigo = "+codigo;
        System.out.println("Codigo do cliente : "+codigo);
        try {
            ResultSet rst = conexao.consultaBD(sql);
            
            while(rst.next()){
                int cod = rst.getInt("codigo");
                String nome = rst.getString("nome");
                String cpf = rst.getString("cpf");
                String rg = rst.getString("rg");
                String tel = rst.getString("telefone");
                String end = rst.getString("endereco");
                clienteSelecionado = new Cliente(cod, nome, cpf, rg, tel, end);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogPesquisaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }
}
