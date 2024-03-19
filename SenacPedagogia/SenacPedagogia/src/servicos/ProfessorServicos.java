/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import dao.ProfessorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ProfessorVO;

/**
 *
 * @author cralves
 */
public class ProfessorServicos {
    
    public void cadastrarProfessor(ProfessorVO pVO) throws SQLException {
        ProfessorDAO aDAO = DAOFactory.getProfessorDAO();
        aDAO.cadastrarProfessor(pVO);
    }//fim do método cadastrarProduto
    
    public ArrayList<ProfessorVO> buscarProfessor() throws SQLException{
        ProfessorDAO aDAO = DAOFactory.getProfessorDAO();
        return aDAO.buscarProfessor();
    }//fim do método buscarProduto
    
    
     public ArrayList<ProfessorVO> filtrarProduto(String query) throws SQLException{
        ProfessorDAO aDAO = DAOFactory.getProfessorDAO();
        return aDAO.filtrarProfessor(query);
    }//fim do método buscarProduto
    
    public void deletarProfessor(int idproduto) throws SQLException{
        ProfessorDAO aDAO = DAOFactory.getProfessorDAO();
        aDAO.deletarProfessor(idproduto);
    }//fim do método deletarPropduto
     
    public void alterarProfessor(ProfessorVO pVO) throws SQLException{
        ProfessorDAO aDAO = DAOFactory.getProfessorDAO();
        aDAO.alterarProfessor(pVO);
    }//fim do método alterarProduto
    
}//fim da classe ProdutoServicos
