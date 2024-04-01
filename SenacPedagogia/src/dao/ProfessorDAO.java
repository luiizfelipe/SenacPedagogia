
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ProfessorVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author cralves
 */
public class ProfessorDAO {
    
    public void cadastrarProfessor(ProfessorVO pVO) throws SQLException {
        
       
        Connection con = new ConexaoBanco().getConexao();
        
        try {
            // INSERT INTO Professores VALUES (NULL, " NOME PROFESSOR", "EMAIL@GMAIL", '2023-01-01', 'Rua', 'telefone', '123123', now(), now());
            
            /*
            
            CREATE TABLE professores (
            idProfessor INTEGER PRIMARY KEY AUTO_INCREMENT,
            nome VARCHAR(255),
            email VARCHAR(255),
            cpf VARCHAR(14),
            data_nascimento DATE,
            endereco VARCHAR(255),
            telefone VARCHAR(20),
            createAccount DATE,
            lastLogin DATE
        );

            */
            String sql = "INSERT INTO professores(nome,email) VALUES (null, ?, ?, ?, ?, ?, ?, now(), now())";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, pVO.getNome() );
            pstm.setString(2, pVO.getEmail());
            pstm.setString(3, pVO.getData_nascimento());
            pstm.setString(5, pVO.getEndereco());
            pstm.setString(4, pVO.getTelefone());
            pstm.setString(5, pVO.getCpf());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException se) {
            throw new SQLException("Erro no cadastro!" + se);
        }finally{
            con.close();
        }//fim do Try Catch Finally
        
    }//fim do método cadastrarProduto    
    
    public ArrayList<ProfessorVO> buscarProfessor() throws SQLException {
        
        Connection con = new ConexaoBanco().getConexao();
        
        try {
            String sql = "Select * from professores";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            ResultSet rs = pstm.executeQuery();
            ArrayList<ProfessorVO> pro = new ArrayList<>();
            
            while( rs.next() ){
                ProfessorVO pVO = new ProfessorVO();
                pVO.setIdProfessor(rs.getLong("id_professor"));
                pVO.setNome(rs.getString("nome"));
                pVO.setEmail(rs.getString("email"));
                pVO.setData_nascimento(rs.getString("data_nasc"));
                pVO.setEndereco(rs.getString("endereco"));
                pVO.setTelefone(rs.getString("fone"));
                pVO.setCpf(rs.getString("cpf"));
                pVO.setCreateAccount(rs.getString("create_dat"));
                pVO.setLastLogin(rs.getString("loaded_at"));
                
               
                
                pro.add(pVO);
            }//fim do while
            
            pstm.close();
            
            return pro;
            
        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar professor! " + se.getMessage());
        }finally {
            con.close();
        }//fim da finally
    }//fecha o método buscarProduto
    
    public ArrayList<ProfessorVO> filtrarProfessor(String query) throws SQLException{
        Connection con = new ConexaoBanco().getConexao();
        
        try {
            String sql = "select * from professores " + query;
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            ArrayList<ProfessorVO> pro = new ArrayList<>();
            while(rs.next() ){
                ProfessorVO pVO = new ProfessorVO();
                //pVO.setIdProduto(rs.getLong("idproduto"));
                pVO.setNome(rs.getString("nome"));
                //pVO.setValorCusto(rs.getDouble("valorcusto"));
                //pVO.setQuantidade(rs.getInt("quantidade"));
                
                pro.add(pVO);
            }//fim do while
            pstm.close();
            return pro;
        } catch (SQLException se) {
            throw new SQLException("Erro ao filtrar professores! " + se.getMessage());
        }finally{
            con.close();
        }//fim da finally
    }//fim do método filtrarProduto
    
    public void deletarProfessor( long idproduto) throws SQLException{
        Connection con = new ConexaoBanco().getConexao();
        
        try{
            String sql = "delete from produto where id_professor = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setLong(1, idproduto);
            pstm.execute();
            pstm.close();
        }catch (SQLException se){
            throw new SQLException("Erro ao deletar professores! ProdutoDAO " + se.getMessage());
        }finally{
            con.close();
        }//fim da finally
    }//fim do método deletarProduto
    
    
    public void alterarProfessor(ProfessorVO pVO) throws SQLException{
        Connection con = new ConexaoBanco().getConexao();
        /*try {
            String sql;
            sql = "Update produto set "
                    + "nome = ' " +pVO.getNome() + " ' ,  "
                    + "valorcusto = " + pVO.getValorCusto() + ", "
                    + "quantidade = " + pVO.getQuantidade() + " "
                    + " where idproduto = " + pVO.getIdProduto() + " ";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            pstm.close();
            
        } catch (SQLException se) {
            throw new SQLException("Erro ao Alterar Produto!" + se.getMessage());
        }finally{
            con.close();;
        }
       */
        }
}//fecha a classe ProdutoDAO
