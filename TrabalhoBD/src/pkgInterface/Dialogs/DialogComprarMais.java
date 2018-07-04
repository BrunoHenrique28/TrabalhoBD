/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgInterface.Dialogs;

import java.awt.Frame;
import javax.swing.JDialog;
import util.Fornecedor;
import util.Produto;

/**
 *
 * @author felip
 */
public class DialogComprarMais extends JDialog {
    
    private Produto produto;
    private ComprarMais painel;
    private Fornecedor fornecedor;

    public DialogComprarMais(Produto produto, ComprarMais painel, Fornecedor fornecedor, Frame owner) {
        super(owner,true);
        this.produto = produto;
        this.painel = painel;
        this.fornecedor = fornecedor;
        setContentPane(painel);
    }
    
    private void carregaInformacoes(){
    
        setContentPane(painel);
        setSize(393, 132);
        
    }
    
    
    
    
    
}
