package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author cralves
 */
public class ConexaoBanco {

    String url = "jdbc:mysql://localhost:3306"; // URL de conexão com o MySQL
    String user = "root"; // Nome de usuário do MySQL
    String password = ""; // Senha do MySQL
    String dbName = "pedagogia";
    String scriptPath = "CreateDatabase.sql";
    int portaMySQL = 3306; // Porta padrão do MySQL

    public int getPortaMySQL() {
        return portaMySQL;
    }

    public void setPortaMySQL(int portaMySQL) {
        this.portaMySQL = portaMySQL;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    boolean status = false;

    //Método que efetua a conexão com o Mysql
    public Connection getConexao() {
        Connection c = null;
        try {
            String url = "jdbc:mysql://localhost:3306/pedagogia?user=" + user + "&password=" + password;
            c = DriverManager.getConnection(url);
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar! " + se.getMessage());
        }//fecha o catch
        return c;
    }//fecha o método getConexao

    public boolean HasPegagogia() {
        boolean existe = false;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            // Consulta todos os bancos de dados
            ResultSet resultSet = connection.getMetaData().getCatalogs();
            while (resultSet.next()) {
                String dbName = resultSet.getString(1);

                // Verifica se o banco de dados "pedagogia" existe
                if (dbName.equals("pedagogia")) {
                    existe = true;
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return existe;
    }

    public boolean isServiceOn() {
        try {
            Socket socket = new Socket("127.0.0.1", portaMySQL);
            // Também é possível usar "localhost" em vez de "127.0.0.1".
            // Se a conexão for bem-sucedida, o serviço está em execução.
            socket.close();
            return true;
        } catch (IOException e) {

            // Se ocorrer uma exceção, o serviço não está em execução.
            return false;
        }
    }

    public void createDatabase() {
        
        
        try (Connection con = DriverManager.getConnection(url, user, password)){
              try (Statement statement = con.createStatement()) {
                        statement.execute("CREATE DATABASE pedagogia;");
              }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try (Connection connection = DriverManager.getConnection(url + "/" + dbName, user, password)){
                try (Statement statement = connection.createStatement()) {
                        statement.execute("CREATE TABLE curso (id INTEGER PRIMARY KEY, nomeCurso VARCHAR(255) );");
                        statement.execute("CREATE TABLE alunos (id_aluno INTEGER PRIMARY KEY AUTO_INCREMENT,nome VARCHAR(255),fone VARCHAR(20),cpf VARCHAR(14),email VARCHAR(255),data_nasc DATE,endereco VARCHAR(255),create_dat DATE,loaded_at DATE);");
                        statement.execute("CREATE TABLE professores (id_professor INTEGER PRIMARY KEY AUTO_INCREMENT,nome VARCHAR(255), email VARCHAR(255),cpf VARCHAR(14),data_nasc DATE,endereco VARCHAR(255),fone VARCHAR(20),create_dat DATE,loaded_at DATE);");
                        statement.execute("CREATE TABLE turma (id INTEGER PRIMARY KEY,id_professor INTEGER,id_curso INTEGER,data_inicio DATE,data_final DATE,carga_horaria INTEGER,FOREIGN KEY (id_professor) REFERENCES professores(id_professor),FOREIGN KEY (id_curso) REFERENCES curso(id));");
                        statement.execute("CREATE TABLE cronograma (id INTEGER PRIMARY KEY AUTO_INCREMENT,id_turma INTEGER,nome_curso VARCHAR(255),nome_professor VARCHAR(255),data DATE,FOREIGN KEY (id_turma) REFERENCES turma(id));");
                        statement.execute("CREATE TABLE AccountLogin (idLogin SERIAL PRIMARY KEY,idProfessor INTEGER,login VARCHAR(255),senha VARCHAR(255));");
                        
                        JOptionPane.showMessageDialog(null, "Banco pedagogia criado");
               }
         }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}//fecha a classe ConexaoBanco
