/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;

import br.com.controle.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ManterCliente extends DAO{
    public void inserir(Cliente cl) throws Exception {
    try {
    abrirBanco();
    String query = "INSERT INTO cliente(nome,cpf,email,endereco) "
            + "values(?,?,?,?)";
    pst=(PreparedStatement) con.prepareStatement(query);
    pst.setString(1, cl.getNome());
    pst.setInt(2,cl.getCpf());
    pst.setString(3,cl.getEmail());
    pst.setString(4,cl.getEndereco());
    pst.execute();
    fecharBanco();
    } catch (Exception e) {
        System.out.println("Erro " + e.getMessage());
    }
    }
    public void deletar(Cliente cl) throws Exception{
         abrirBanco();
         String query = "delete FROM cliente where cpf=?";
         pst=(PreparedStatement) con.prepareStatement(query);
         pst.setInt(1, cl.getCpf());
         pst.execute();
         JOptionPane.showMessageDialog(null, "Código deletado com sucesso");
        fecharBanco();   
     }
    
  public void editarCliente(Cliente c) throws Exception {
        abrirBanco();
        //JOptionPpublicane.showMessageDialog(null, a.getNome()+ a.getEmail() + a.getIdade());
        String query = "UPDATE cliente set nome = ?,email = ?, endereco=? where cpf=?";
        pst = (PreparedStatement) con.prepareStatement(query);
        pst.setString(1, c.getNome());
        pst.setString(2, c.getEmail());
        pst.setString(3, c.getEndereco());
        pst.setInt(4, c.getCpf());
        pst.executeUpdate();
        fecharBanco();
    }
        public ArrayList<Cliente> PesquisarTudo () throws Exception {
       ArrayList<Cliente> Cliente = new ArrayList<Cliente>();
         try{
         abrirBanco();  
         String query = "select * FROM cliente";
         pst = (PreparedStatement) con.prepareStatement(query);
         ResultSet tr = pst.executeQuery();
         Cliente ca ;
         while (tr.next()){               
           ca = new Cliente();
           ca.setNome(tr.getString("nome"));
           ca.setCpf(tr.getInt("cpf"));
           ca.setEmail(tr.getString("email"));
           ca.setEndereco(tr.getString("endereço"));
           Cliente.add(ca);
         } 
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
       return Cliente;
     }
public void PesquisarRegistro(Cliente ca) throws Exception {
    try {
        abrirBanco();
        String query = "SELECT * FROM cliente WHERE cpf=?";
        pst = (PreparedStatement) con.prepareStatement(query);
        pst.setInt(1, ca.getCpf());
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            // Preencher o objeto Cliente ca com os dados encontrados
            ca.setNome(rs.getString("nome"));
            ca.setCpf(rs.getInt("cpf"));
            ca.setEmail(rs.getString("email"));
            ca.setEndereco(rs.getString("endereco"));
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado");
        }

        fecharBanco();
    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
    }
}}