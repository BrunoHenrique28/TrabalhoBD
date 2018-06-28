
package util;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author felip
 */
public class ConexaoBD {
    
    public static Connection conectaBD() throws ClassNotFoundException{
        
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/MercaFacil","postgres","conectabanco");
            System.out.println("Conectado com sucesso ! ");
            return con;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Falha ao conectar ao BD !","ERRO DE CONEXÃO",JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
            return null;
        }
        
    }
}
