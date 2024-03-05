
package dao;

/**
 *
 * @author cralves
 */
public class DAOFactory {
    //criar um objeto e instanciar a classe
    private static AlunoDAO alunoDAO = new AlunoDAO();
    
    //Faz uma cópia dos métodos da produtoDAO e disponibilizar para a classe que solicitar
    public static AlunoDAO getAlunoDAO() {
        return alunoDAO;
    }//fim do método getProdutoDAO
    
    private static ProfessorDAO professorDAO = new ProfessorDAO();
    
    //Faz uma cópia dos métodos da produtoDAO e disponibilizar para a classe que solicitar
    public static ProfessorDAO getProfessorDAO() {
        return professorDAO;
    }//fim do método getProdutoDAO
    
    
}//fim da classe DAOFactory
