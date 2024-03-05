/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import dao.AlunoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.AlunoVO;

/**
 *
 * @author cralves
 */
public class AlunoServicos {
    
    public void cadastrarAluno(AlunoVO pVO) throws SQLException {
        AlunoDAO aDAO = DAOFactory.getAlunoDAO();
        aDAO.cadastrarAluno(pVO);
    }//fim do método cadastrarProduto
    
    public ArrayList<AlunoVO> buscarAluno() throws SQLException{
        AlunoDAO aDAO = DAOFactory.getAlunoDAO();
        return aDAO.buscarAluno();
    }//fim do método buscarProduto
    
    
     public ArrayList<AlunoVO> filtrarProduto(String query) throws SQLException{
        AlunoDAO aDAO = DAOFactory.getAlunoDAO();
        return aDAO.filtrarAluno(query);
    }//fim do método buscarProduto
    
    public void deletarAluno(int idproduto) throws SQLException{
        AlunoDAO aDAO = DAOFactory.getAlunoDAO();
        aDAO.deletarAluno(idproduto);
    }//fim do método deletarPropduto
     
    public void alterarAluno(AlunoVO pVO) throws SQLException{
        AlunoDAO aDAO = DAOFactory.getAlunoDAO();
        aDAO.alterarAluno(pVO);
    }//fim do método alterarProduto
    
}//fim da classe ProdutoServicos
