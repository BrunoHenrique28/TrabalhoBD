package util;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author felip
 */
public class ConexaoBD {
    
    private String usuario;
    private String senha;
    private Connection con = null;
    
    public ConexaoBD(){
        this.senha = "conectabanco";
        this.usuario = "postgres";
        
    }
    
    public void conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/MercaFacil",usuario,senha);
            System.out.println("Conectado com sucesso ! ");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Falha ao conectar ao BD !","ERRO DE CONEXÃO",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public int manipulaBD(String sql) throws SQLException{
        System.out.println(sql);
        PreparedStatement pst = con.prepareStatement(sql);
        return pst.executeUpdate();
    }
    
    public ResultSet consultaBD(String sql) throws SQLException{
        ResultSet res;
        Statement stm;
        
        stm = con.createStatement();
        res = stm.executeQuery(sql);
        
        return res;
    }
    
    public static String valuesInsertion(String [] valores){
         String v = "VALUES(";
        for(int i = 0; i < valores.length; i++){
            v = v.concat("'"+valores[i]+"'");
            if(i < valores.length -1)
                v = v.concat(",");
            else
                v = v.concat(")");
        }
        return v;
    }
    
    public void desconectar(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
