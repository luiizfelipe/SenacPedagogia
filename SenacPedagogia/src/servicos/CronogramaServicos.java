package servicos;

import dao.DAOFactory;
import dao.CronogramaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.CronogramaVO;

/**
 *
 * @author cralves
 */
public class CronogramaServicos {
    
    public void cadastrarCronograma(CronogramaVO pVO) throws SQLException {
        CronogramaDAO aDAO = DAOFactory.getCronogramaDAO();
        aDAO.cadastrarCronograma(pVO);
    }//fim do método cadastrarCronograma
    
    public ArrayList<CronogramaVO> buscarCronograma() throws SQLException{
        CronogramaDAO aDAO = DAOFactory.getCronogramaDAO();
        return aDAO.buscarCronograma();
    }//fim do método buscarCronograma
    
    
     public ArrayList<CronogramaVO> filtrarCronograma(String query) throws SQLException{
        CronogramaDAO aDAO = DAOFactory.getCronogramaDAO();
        return aDAO.filtrarCronograma(query);
    }//fim do método buscarCronograma
    
    public void deletarCronograma(int idproduto) throws SQLException{
        CronogramaDAO aDAO = DAOFactory.getCronogramaDAO();
        aDAO.deletarCronograma(idproduto);
    }//fim do método deletarPropduto
     
    public void alterarCronograma(CronogramaVO pVO) throws SQLException{
        CronogramaDAO aDAO = DAOFactory.getCronogramaDAO();
        aDAO.alterarCronograma(pVO);
    }//fim do método alterarCronograma
    
}//fim da classe CronogramaServicos


