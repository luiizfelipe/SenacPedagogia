/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author 292100561
 */
public class DbStatus {

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

}
