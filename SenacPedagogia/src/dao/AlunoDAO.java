
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.AlunoVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author cralves
 */
public class AlunoDAO {
    
    public void cadastrarAluno(AlunoVO aVO) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {

            if (aVO.getNome() == null || aVO.getNome().trim().isEmpty()) {
                throw new IllegalArgumentException("Nome do aluno não pode estar vazio.");
            }
            // Convertendo a data inserida pelo usuário para o formato aceito pelo banco de dados
            SimpleDateFormat formatarEntrada = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatarSaida = new SimpleDateFormat("yyyy-MM-dd");
            Date data = formatarEntrada.parse(aVO.getData_nascimento());
            String dataFormatada = formatarSaida.format(data);

            if (aVO.getCpf().length() != 11) {
                throw new IllegalArgumentException("CPF deve conter 11 dígitos.");
            }

            if (!aVO.getTelefone().matches("[0-9]+")) {
                throw new IllegalArgumentException("O número de telefone deve conter apenas dígitos.");
            }

            String sql = "INSERT INTO alunos (nome, data_nascimento, cpf, telefone, endereco) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, aVO.getNome());
            pstm.setString(2, dataFormatada); // Inserindo a data formatada
            pstm.setString(3, aVO.getCpf());
            pstm.setString(4, aVO.getTelefone());
            pstm.setString(5, aVO.getEndereco());

            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException | ParseException | IllegalArgumentException ex) {
            throw new SQLException("Erro no cadastro: " + ex.getMessage());
        } finally {
            con.close();
        }
    }//fim do método cadastrarProduto    
    
    public ArrayList<AlunoVO> buscarAluno() throws SQLException {
        
        Connection con = new ConexaoBanco().getConexao();
        
        try {
            String sql = "Select * from produto";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            ResultSet rs = pstm.executeQuery();
            ArrayList<AlunoVO> pro = new ArrayList<>();
            
            while( rs.next() ){
                AlunoVO aVO = new AlunoVO();
                
                //aVO.setIdProduto(rs.getLong("idproduto"));
                aVO.setNome(rs.getString("nome"));
                //aVO.setValorCusto(rs.getDouble("valorCusto"));
                //aVO.setQuantidade(rs.getInt("quantidade"));
                
                pro.add(aVO);
            }//fim do while
            
            pstm.close();
            
            return pro;
            
        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar produto! " + se.getMessage());
        }finally {
            con.close();
        }//fim da finally
    }//fecha o método buscarProduto
    
    public ArrayList<AlunoVO> filtrarAluno(String query) throws SQLException{
        Connection con = new ConexaoBanco().getConexao();
        
        try {
            String sql = "select * from produto " + query;
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            ArrayList<AlunoVO> pro = new ArrayList<>();
            while(rs.next() ){
                AlunoVO aVO = new AlunoVO();
                //aVO.setIdProduto(rs.getLong("idproduto"));
                aVO.setNome(rs.getString("nome"));
                //aVO.setValorCusto(rs.getDouble("valorcusto"));
                //aVO.setQuantidade(rs.getInt("quantidade"));
                
                pro.add(aVO);
            }//fim do while
            pstm.close();
            return pro;
        } catch (SQLException se) {
            throw new SQLException("Erro ao filtrar produto! " + se.getMessage());
        }finally{
            con.close();
        }//fim da finally
    }//fim do método filtrarProduto
    
    public void deletarAluno( long idproduto) throws SQLException{
        Connection con = new ConexaoBanco().getConexao();
        
        try{
            String sql = "delete from produto where idproduto = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setLong(1, idproduto);
            pstm.execute();
            pstm.close();
        }catch (SQLException se){
            throw new SQLException("Erro ao deletar produto! ProdutoDAO " + se.getMessage());
        }finally{
            con.close();
        }//fim da finally
    }//fim do método deletarProduto
    
    
    public void alterarAluno(AlunoVO aVO) throws SQLException{
        Connection con = new ConexaoBanco().getConexao();
        /*try {
            String sql;
            sql = "Update produto set "
                    + "nome = ' " +aVO.getNome() + " ' ,  "
                    + "valorcusto = " + aVO.getValorCusto() + ", "
                    + "quantidade = " + aVO.getQuantidade() + " "
                    + " where idproduto = " + aVO.getIdProduto() + " ";
            
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
