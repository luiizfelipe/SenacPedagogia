/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.AlunoVO;
import modelo.CronogramaVO;
import modelo.ProfessorVO;
import modelo.TurmaVO;
import persistencia.ConexaoBanco;
import servicos.AlunoServicos;
import servicos.CronogramaServicos;

/**
 *
 * @author 292100561
 */
public class CadastrarCronograma extends javax.swing.JPanel {

    /**
     * Creates new form CadastrarCronograma
     */
    public CadastrarCronograma() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdValue = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        jtfCursoValue = new javax.swing.JTextField();
        jlEndereco = new javax.swing.JLabel();
        jtfNomeProfessorValue = new javax.swing.JTextField();
        jlNome = new javax.swing.JLabel();
        jlDataNasc = new javax.swing.JLabel();
        jtfData = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbPreencher = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jtfIdValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlEmail.setText("Curso");

        jtfCursoValue.setEditable(false);
        jtfCursoValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlEndereco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlEndereco.setText("Data");

        jtfNomeProfessorValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlNome.setText("ID da Turma");

        jlDataNasc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlDataNasc.setText("Professor");

        jtfData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDataActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 255, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel1.setText("CADASTRAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jbPreencher.setBackground(new java.awt.Color(204, 204, 204));
        jbPreencher.setText("Preencher nome Curso");
        jbPreencher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPreencherActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        jLabel3.setText("CRONOGRAMA");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel2.setText("TELA PARA CADASTRAR ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlEmail)
                    .addComponent(jlDataNasc)
                    .addComponent(jlNome))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtfCursoValue, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jtfIdValue, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jtfNomeProfessorValue, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jlEndereco)
                        .addGap(62, 62, 62)
                        .addComponent(jtfData)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jbPreencher)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIdValue, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNome)
                    .addComponent(jbPreencher))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCursoValue, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEmail)
                    .addComponent(jtfData, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEndereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNomeProfessorValue, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDataNasc))
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jbPreencher.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    private void cadastrar(){
            try {
                CronogramaVO pVO = new CronogramaVO();

                pVO.setId(parseInt(jtfIdValue.getText()));
                pVO.setNome_curso(jtfCursoValue.getText());
                pVO.setNome_professor(jtfNomeProfessorValue.getText());
                pVO.setData(jtfData.getText());

            
                /*
                Enviar o objeto pVO para o banco de dados,
                mas o envio é através da Servicos,
                porém antes passa pela DAO.
                */
                CronogramaServicos ps = servicos.ServicosFactory.getCronogramaServicos();

                //Chamndo o método
                ps.cadastrarCronograma(pVO);

                //Retorno para o usuário
                JOptionPane.showMessageDialog(this, "Cronograma cadastrado com sucesso!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro! GUICadAlunos " + e.getMessage());
            }
        }//fim do método cadastrar
    
    private void limpar(){
        jtfIdValue.setText("");
        jtfCursoValue.setText("");
        jtfNomeProfessorValue.setText("");
        jtfData.setText("");
        
    }
    
    
    
    
    
    
    
    
    
    
    
    private void jtfDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDataActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        cadastrar();
        limpar();
    }//GEN-LAST:event_jPanel1MousePressed

    public static TurmaVO buscarPorId(ArrayList<TurmaVO> lista, long idBuscado) {
        TurmaVO turmaFind = new TurmaVO();
        for (TurmaVO turma : lista) {
            if (turma.getId() == idBuscado) {
                turmaFind = turma; // Encontrou o objeto com o ID desejado
            }
        }
        return turmaFind; // Não encontrou nenhum objeto com o ID especificado
    }
    
    private void jbPreencherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPreencherActionPerformed

            Connection con = new ConexaoBanco().getConexao();
        try {
            
            String sql = "Select * from turma";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            ResultSet rs = pstm.executeQuery();
            ArrayList<TurmaVO> pro = new ArrayList<>();
            
            while( rs.next() ){
                TurmaVO pVO = new TurmaVO();
                pVO.setId(rs.getLong("id_turma"));
                pVO.setId_professor(rs.getInt("id_professor"));
                pVO.setId_curso(rs.getInt("id_curso"));
                pVO.setData_inicio(rs.getString("data_inicio"));
                pVO.setData_final(rs.getString("data_final"));
                pVO.setCarga_horaria(rs.getInt("carga_horaria"));                                            
                pro.add(pVO);
            }//fim do while
            
            TurmaVO t = buscarPorId(pro, parseInt(jtfIdValue.getText()));
            pstm.close();
            
            jtfIdValue.setText(String.valueOf(t.getId_curso()));
         
        } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro! GUICadProfessors " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarCronograma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbPreencherActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbPreencher;
    private javax.swing.JLabel jlDataNasc;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlEndereco;
    private javax.swing.JLabel jlNome;
    private javax.swing.JTextField jtfCursoValue;
    private javax.swing.JTextField jtfData;
    private javax.swing.JTextField jtfIdValue;
    private javax.swing.JTextField jtfNomeProfessorValue;
    // End of variables declaration//GEN-END:variables
}
