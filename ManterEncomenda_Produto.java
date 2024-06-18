/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;

import br.com.controle.Encomenda_Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ManterEncomenda_Produto extends DAO{
        public void inserir(Encomenda_Produto cl) throws Exception {
    try {
    abrirBanco();
    String query = "INSERT INTO encomenda_produto(codigo,produto_id)"
            + "values(?,?)";
    pst=(PreparedStatement) con.prepareStatement(query);
    pst.setString(1, cl.getCodigo());
    pst.setString(2,cl.getProduto_id());
    pst.execute();
    fecharBanco();
    } catch (Exception e) {
        System.out.println("Erro " + e.getMessage());
    }
    }
    public void deletar(Encomenda_Produto cl) throws Exception{
         abrirBanco();
         String query = "delete FROM encomenda_produto where codigo=?";
         pst=(PreparedStatement) con.prepareStatement(query);
         pst.setString(1, cl.getCodigo());
         pst.execute();
         JOptionPane.showMessageDialog(null, "Código deletado com sucesso");
        fecharBanco();   
     }
public void editarEncomenda_Produto(Encomenda_Produto e) throws Exception {
        abrirBanco();
        //JOptionPpublicane.showMessageDialog(null, a.getNome()+ a.getEmail() + a.getIdade());
        String query = "UPDATE encomenda_produto set produto_id = ? WHERE codigo = ?";
        pst = (PreparedStatement) con.prepareStatement(query);
        pst.setString(1, e.getProduto_id());
        pst.setString(2, e.getCodigo());
        pst.executeUpdate();
        fecharBanco();
    }
        public ArrayList<Encomenda_Produto> PesquisarTudo () throws Exception {
       ArrayList<Encomenda_Produto> Categoria = new ArrayList<Encomenda_Produto>();
         try{
         abrirBanco();  
         String query = "select * FROM encomenda_produto";
         pst = (PreparedStatement) con.prepareStatement(query);
         ResultSet tr = pst.executeQuery();
         Encomenda_Produto ca ;
         while (tr.next()){               
           ca = new Encomenda_Produto();
           ca.setCodigo(tr.getString("codigo"));
           ca.setProduto_id(tr.getString("produto_id"));
           Categoria.add(ca);
         } 
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
       return Categoria;
     }
    public void PesquisarRegistro (Encomenda_Produto ca) throws Exception {
         try{
         abrirBanco();  
         String query = "select * FROM encomenda_produto where codigo=?";
         pst = (PreparedStatement) con.prepareStatement(query);
         pst.setString(1, ca.getCodigo());
         ResultSet tr = pst.executeQuery();
         if(tr.next()){               
           ca = new Encomenda_Produto();
           ca.setCodigo(tr.getString("codigo"));
           ca.setProduto_id(tr.getString("produto_id"));
         } else{
             JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado");
         }
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
    }       
}
