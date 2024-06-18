/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;

import br.com.controle.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author laboratorio
 */
public class ManterCategoria extends DAO{
        public void inserir(Categoria cl) throws Exception {
    try {
    abrirBanco();
    String query = "INSERT INTO categoria(id_categoria,nome)"
            + "values(?,?)";
    pst=(PreparedStatement) con.prepareStatement(query);
    pst.setInt(1, cl.getId_categoria());
    pst.setString(2,cl.getNome());
    pst.execute();
    fecharBanco();
    } catch (Exception e) {
        System.out.println("Erro " + e.getMessage());
    }
    }
    public void deletar(Categoria cl) throws Exception{
         abrirBanco();
         String query = "delete FROM categoria where id_categoria=?";
         pst=(PreparedStatement) con.prepareStatement(query);
         pst.setInt(1, cl.getId_categoria());
         pst.execute();
         JOptionPane.showMessageDialog(null, "Código deletado com sucesso");
        fecharBanco();   
     }
public void editarCategoria(Categoria c) throws Exception {
        abrirBanco();
        //JOptionPpublicane.showMessageDialog(null, a.getNome()+ a.getEmail() + a.getIdade());
        String query = "UPDATE categoria set nome = ? WHERE id_categoria = ?";
        pst = (PreparedStatement) con.prepareStatement(query);
        pst.setString(1, c.getNome());
        pst.setInt(2, c.getId_categoria());
        pst.executeUpdate();
        fecharBanco();
    }
        public ArrayList<Categoria> PesquisarTudo () throws Exception {
       ArrayList<Categoria> Categoria = new ArrayList<Categoria>();
         try{
         abrirBanco();  
         String query = "select * FROM categoria";
         pst = (PreparedStatement) con.prepareStatement(query);
         ResultSet tr = pst.executeQuery();
         Categoria ca ;
         while (tr.next()){               
           ca = new Categoria();
           ca.setNome(tr.getString("nome"));
           ca.setId_categoria(tr.getInt("id_categoria"));
           Categoria.add(ca);
         } 
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
       return Categoria;
     }
    public void PesquisarRegistro (Categoria ca) throws Exception {
         try{
         abrirBanco();  
         String query = "select * FROM categoria where id_categoria=?";
         pst = (PreparedStatement) con.prepareStatement(query);
         pst.setInt(1, ca.getId_categoria());
         ResultSet tr = pst.executeQuery();
        if (tr.next()) {
         ca.setNome(tr.getString("nome"));
         ca.setId_categoria(tr.getInt("id_categoria"));
        } else {
           JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado");
}
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
    }       
}
