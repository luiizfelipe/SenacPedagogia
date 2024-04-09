
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.ProfessorVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author cralves
 */
public class ProfessorDAO {
    
    public void cadastrarProfessor(ProfessorVO pVO) throws SQLException, ParseException {
        
       
        Connection con = new ConexaoBanco().getConexao();
        
        try {
            // INSERT INTO Professores VALUES (NULL, " NOME PROFESSOR", "EMAIL@GMAIL", '2023-01-01', 'Rua', 'telefone', '123123', now(), now());
            if (pVO.getNome() == null || pVO.getNome().trim().isEmpty()) {
                throw new IllegalArgumentException("Nome do aluno não pode estar vazio.");
            }
            // Convertendo a data inserida pelo usuário para o formato aceito pelo banco de dados
            SimpleDateFormat formatarEntrada = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatarSaida = new SimpleDateFormat("yyyy-MM-dd");
            Date data = formatarEntrada.parse(pVO.getData_nascimento());
            String dataFormatada = formatarSaida.format(data);

            if (pVO.getCpf().length() != 11) {
                throw new IllegalArgumentException("CPF deve conter 11 dígitos.");
            }

            if (!pVO.getTelefone().matches("[0-9]+")) {
                throw new IllegalArgumentException("O número de telefone deve conter apenas dígitos.");
            }
            /*
            
            CREATE TABLE professores (
            id_professor | int(11)      | NO   | PRI | NULL    | auto_increment |
| nome         | varchar(255) | YES  |     | NULL    |                |
| email        | varchar(255) | YES  |     | NULL    |                |
| cpf          | varchar(14)  | YES  |     | NULL    |                |
| data_nasc    | date         | YES  |     | NULL    |                |
| endereco     | varchar(255) | YES  |     | NULL    |                |
| fone         | varchar(20)  | YES  |     | NULL    |                |
| create_dat   | date         | YES  |     | NULL    |                |
| loaded_at    | date         | YES  |     | NULL    |                |
+------------
        );

            */
            String sql = "INSERT INTO professores VALUES (null, ?, ?, ?, ?, ?, ?, now(), now());";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, pVO.getNome() );
            pstm.setString(2, pVO.getEmail());
            pstm.setString(3, pVO.getCpf());
            pstm.setString(4, dataFormatada);
            pstm.setString(5, pVO.getEndereco());
            pstm.setString(6, pVO.getTelefone());
            
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
