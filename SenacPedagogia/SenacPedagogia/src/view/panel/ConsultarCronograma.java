/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AlunoVO;
import servicos.AlunoServicos;
import servicos.ServicosFactory;

/**
 *
 * @author 292100561
 */
public class ConsultarCronograma extends javax.swing.JPanel {
    DefaultTableModel dtm = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"Código", "Nome", "Valor Custo", "quantidade"}
    );
    /**
     * Creates new form ConsultarAluno
     */
    public ConsultarCronograma() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtAluno = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jtfNome = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();

        jtAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Valor Custo", "Quantidade"
            }
        ));
        jScrollPane1.setViewportView(jtAluno);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Essa é a tela do cronograma");

        jButton1.setText("jButton1");

        jtfNome.setText("000");

        jLabel19.setText("jLabel19");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel19)
                        .addGap(33, 33, 33)
                        .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(16, 16, 16)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void preencherTabela(){
        try {
            //Busca objeto na AlunoServicos
            AlunoServicos ps = ServicosFactory.getAlunoServicos();
            
            //Criando um ArrayLista<alunoVO> vaziom, para receber o ArrayList com os dados
            ArrayList<AlunoVO> prod = new ArrayList<>();
            
            //Recebendo o ArrayList cheio no Aluno
            prod =ps.buscarAluno();
            
            for ( int i = 0; i < prod.size(); i++){
                dtm.addRow(new String[] {
//                    String.valueOf(prod.get(i).getIdAluno()),
//                    String.valueOf(prod.get(i).getNome()),
//                    String.valueOf(prod.get(i).getValorCusto()),
//                    String.valueOf(prod.get(i).getQuantidade()),
                });
            }//fecha o laço for
            
            
            //Adicionando modelo de tabela com os dados na tabela Aluno
            jtAluno.setModel(dtm);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro! GUIManutençãoAluno.preencherTabela" + e.getMessage() );
        }//fim do catch
    }//fim do método preencherTabela
     
//    private void limparTabela() {
//        
//        dtm.setNumRows(0);
//    }//fim do método limparTabela
//    
//    
//    private void filtrar(){
//        try {
//            if( jtfPesquisaPro.getText().isEmpty() ) {
//                preencherTabela();
//            }else{
//                AlunoServicos ps = ServicosFactory.getAlunoServicos();
//                String pesquisa = (String) jcbPesquisaPro.getSelectedItem();
//                String query;
//                if(pesquisa.equals("Código")) {
//                    query = "where idproduto = " + jtfPesquisaPro.getText();                    
//                }else if(pesquisa.equals("Nome")){
//                    query = "where nome like '%" + jtfPesquisaPro.getText() + "%' ";
//                }else if(pesquisa.equals("Valor Custo")){
//                    query = "where valorcusto = " + jtfPesquisaPro.getText();
//                }else {
//                    query = "where quantidade = " + jtfPesquisaPro.getText();
//                }//fim do else
//                
//                //Criando um ArrayLista<alunoVO> vaziom, para receber o ArrayList com os dados
//            ArrayList<AlunoVO> prod = new ArrayList<>();
//            
//            //Recebendo o ArrayList cheio no Aluno
//           prod =ps.filtrarAluno(query);
//           
//           for ( int i = 0; i < prod.size(); i++){
//                dtm.addRow(new String[] {
//                    String.valueOf(prod.get(i).getIdAluno()),
//                    String.valueOf(prod.get(i).getNome()),
//                    String.valueOf(prod.get(i).getValorCusto()),
//                    String.valueOf(prod.get(i).getQuantidade()),
//                });
//            }//fecha o laço for
//           
//           //Adicionando o modelo de tabela com os dados na tabela jtAluno
//           jtAluno.setModel(dtm);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(
//                    null,
//                    "Erro ao filtrar produto! GUIManutençãoAluno.filtrar " + e.getMessage());
//        }
//    }//fecha o método filtrar
//    
//    private void deletarAluno(){
//        try {
//            int linha = jtAluno.getSelectedRow();
//            
//            if(linha == -1){
//                JOptionPane.showMessageDialog(
//                        null,
//                        "Por favor selecione uma linha!");
//            }else{
//                AlunoServicos ps = ServicosFactory.getAlunoServicos();
//                String codAluno = (String) jtAluno.getValueAt(linha, 0);
//                ps.deletarAluno(Integer.parseInt(codAluno));
//                
//                //Mensagem para o usuário
//                JOptionPane.showMessageDialog(
//                        null,
//                        "Aluno excluído com sucesso!");
//            }//fim do else
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(
//                    null,
//                    "Erro ao deletar produto! GUIManutencaoAluno.deletar" + e.getMessage());
//        }
//    }//fim do método deletar
//    
//    private void alterarAluno() {
//        int linha = jtAluno.getSelectedRow();
//        if(linha != -1){
//            jtfCodigo.setText((String) jtAluno.getValueAt(linha, 0)) ;
//            jtfNome.setText((String) jtAluno.getValueAt(linha, 1)) ;
//            jtfValorCusto.setText((String) jtAluno.getValueAt(linha, 2)) ;
//            jtfQuantidade.setText((String) jtAluno.getValueAt(linha, 3)) ;
//        }else{
//            JOptionPane.showMessageDialog(
//                    null,
//                    "Você não selecionou nenhuma linha!");
//        }//fecha o if else
//    }//fecha o método alterarAluno
//    
//    
//    public void confirmarAlteracao(){
//        try {
//            AlunoVO pVO = new AlunoVO();
//            if(jtfNome.getText().isEmpty() ||
//                    jtfValorCusto.getText().isEmpty() ||
//                    jtfQuantidade.getText().isEmpty() ){
//                JOptionPane.showMessageDialog(
//                        null,
//                        "Erro! Por favor insira as informações corretamente!",
//                        "Erro",
//                        JOptionPane.ERROR_MESSAGE);
//            }else{
//                pVO.setIdAluno(Integer.parseInt(jtfCodigo.getText() ) );
//                pVO.setNome(jtfNome.getText() );
//                pVO.setValorCusto(Double.parseDouble(jtfValorCusto.getText() ) );
//                pVO.setQuantidade(Integer.parseInt(jtfQuantidade.getText() ) );
//                
//                AlunoServicos ps = ServicosFactory.getAlunoServicos();
//                ps.alterarAluno(pVO);
//                
//                JOptionPane.showMessageDialog(
//                        null,
//                        "Aluno alterado com sucesso!");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(
//                    null,
//                    "Erro!" + e.getMessage() );
//        }//fecha o try catch
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAluno;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
}
