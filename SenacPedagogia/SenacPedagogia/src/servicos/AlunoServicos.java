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
    }//fim do método cadastrarAluno
    
    public ArrayList<AlunoVO> buscarAluno() throws SQLException{
        AlunoDAO aDAO = DAOFactory.getAlunoDAO();
        return aDAO.buscarAluno();
    }//fim do método buscarAluno
    
    
     public ArrayList<AlunoVO> filtrarAluno(String query) throws SQLException{
        AlunoDAO aDAO = DAOFactory.getAlunoDAO();
        return aDAO.filtrarAluno(query);
    }//fim do método buscarAluno
    
    public void deletarAluno(int idproduto) throws SQLException{
        AlunoDAO aDAO = DAOFactory.getAlunoDAO();
        aDAO.deletarAluno(idproduto);
    }//fim do método deletarPropduto
     
    public void alterarAluno(AlunoVO pVO) throws SQLException{
        AlunoDAO aDAO = DAOFactory.getAlunoDAO();
        aDAO.alterarAluno(pVO);
    }//fim do método alterarAluno
    
}//fim da classe AlunoServicos
