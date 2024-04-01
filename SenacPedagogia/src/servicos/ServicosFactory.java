
package servicos;

/**
 *
 * @author cralves
 */
public class ServicosFactory {
    private static AlunoServicos alunoServicos = new AlunoServicos();
    
    public static AlunoServicos getAlunoServicos(){
        return alunoServicos;
    }//fim do método getAlunoServicos
    
    private static ProfessorServicos professorServicos = new ProfessorServicos();
    
    public static ProfessorServicos getProfessorServicos(){
        return professorServicos;
    }
    
    private static CronogramaServicos CronogramaServicos = new CronogramaServicos();
    
    public static CronogramaServicos getCronogramaServicos(){
        return CronogramaServicos;
    }
    
    
}//fecha a classe ServicosFactory
