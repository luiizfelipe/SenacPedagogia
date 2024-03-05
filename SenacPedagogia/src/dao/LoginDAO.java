
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.LoginVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author cralves
 */
public class LoginDAO {
    Connection con;
    
    public ResultSet autenticarLogin(LoginVO lVO) throws SQLException{
        //Buscando uma conexão com o banco de dados
        con = new ConexaoBanco().getConexao();
        
        //Criar um objeto que seja capaz de Executar instruções SQL no Banco de Dados
        try {
            //String que receberá a intrução SQL
            String sql;
            //Montando a instrução SELECT para inserir um objeto lVO no Banco de Dados
            sql = "Select * from login where login = ? and senha = ? ";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, lVO.getLogin() );
            pstm.setString(2, lVO.getSenha() );
            
            //Executando o sql
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(
                null,
                    "LoginDAO! " + se);
        }
         return null;
    }//fim do método autenticarLogin
}//fecha a classe LoginDAO
