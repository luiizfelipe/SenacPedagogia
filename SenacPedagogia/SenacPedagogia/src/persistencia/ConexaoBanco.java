package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cralves
 */
public class ConexaoBanco {

    //Método que efetua a conexão com o Mysql
    public Connection getConexao() {
        Connection c = null;
        try {
            String url = "jdbc:mysql://localhost:3306/pedagogia?user=root&password=";
            c = DriverManager.getConnection(url);
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar! " + se.getMessage());
        }//fecha o catch
        return c;
    }//fecha o método getConexao
}//fecha a classe ConexaoBanco
