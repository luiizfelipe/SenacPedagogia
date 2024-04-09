
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.CronogramaVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author cralves
 */
public class CronogramaDAO {
    
    public void cadastrarCronograma(CronogramaVO pVO) throws SQLException {
        
       
        Connection con = new ConexaoBanco().getConexao();
        
        try {
            //INSERT INTO alunos VALUES (null, 'Nome',12/2/2005,'51989638990','Rua Vladimir Heronzeg 25', '12312312331');
            String sql = "INSERT INTO cronograma VALUES (NULL,?,?,?,?)";
            //String sql = "INSERT INTO alunos VALUES (null, 'Nome',DATE('2005-2-15'),'51989638990','Rua Vladimir Heronzeg 25', '12312312331')";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setLong(1, pVO.getId() );
            pstm.setString(2, pVO.getNome_curso());
            pstm.setString(3, pVO.getNome_professor());
            pstm.setString(4, pVO.getData());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException se) {
            throw new SQLException("Erro no cadastro!" + se);
        }finally{
            con.close();
        }//fim do Try Catch Finally
        
    }//fim do método cadastrarProduto    
    
    public ArrayList<CronogramaVO> buscarCronograma() throws SQLException {
        
        Connection con = new ConexaoBanco().getConexao();
        
        try {
            String sql = "Select * from cronograma";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            ResultSet rs = pstm.executeQuery();
            ArrayList<CronogramaVO> pro = new ArrayList<>();
            
            while( rs.next() ){
                CronogramaVO pVO = new CronogramaVO();
                pVO.setId(rs.getLong("id_turma"));
                pVO.setNome_curso(rs.getString("nome_curso"));
                pVO.setNome_professor(rs.getString("nome_professor"));
                pVO.setData(rs.getString("data"));
                
                
               
                
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
    
    public ArrayList<CronogramaVO> filtrarCronograma(String query) throws SQLException{

        Connection con = new ConexaoBanco().getConexao();
        
        try {
            String sql = "select * from cronograma " + query;
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            ArrayList<CronogramaVO> pro = new ArrayList<>();
            while(rs.next() ){
                CronogramaVO pVO = new CronogramaVO();
                pVO.setId(rs.getLong("id_turma"));
                pVO.setNome_curso(rs.getString("nome_curso"));
                pVO.setNome_professor(rs.getString("nome_professor"));
                pVO.setData(rs.getString("data"));
                
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
    
    public void deletarCronograma( long idproduto) throws SQLException{
//        Connection con = new ConexaoBanco().getConexao();
//        
//        try{
//            String sql = "delete from produto where id_professor = ?";
//            PreparedStatement pstm = con.prepareStatement(sql);
//            
//            pstm.setLong(1, idproduto);
//            pstm.execute();
//            pstm.close();
//        }catch (SQLException se){
//            throw new SQLException("Erro ao deletar professores! ProdutoDAO " + se.getMessage());
//        }finally{
//            con.close();
//        }//fim da finally
    }//fim do método deletarProduto
    
    
    public void alterarCronograma(CronogramaVO pVO) throws SQLException{
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
