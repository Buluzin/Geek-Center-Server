/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;

import br.com.controle.Produtos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ManterProdutos extends DAO {
    public void inserir(Produtos cl) throws Exception {
        try {
            abrirBanco();
            String query = "INSERT INTO produtos(id_produto,categoria_id,produto,preco_R$,quantidade,tamanho) values(?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, cl.getId_produto());
            pst.setInt(2, cl.getCategoria_id());
            pst.setString(3, cl.getProduto());
            pst.setDouble(4, cl.getPreco_R$());
            pst.setInt(5, cl.getQuantidade());
            pst.setString(6, cl.getTamanho());
            pst.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    public void deletar(Produtos cl) throws Exception {
        abrirBanco();
        String query = "DELETE FROM produtos WHERE id_produto=?";
        pst = (PreparedStatement) con.prepareStatement(query);
        pst.setString(1, cl.getId_produto());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Código deletado com sucesso");
        fecharBanco();
    }

    public void editarProdutos(Produtos c) throws Exception {
        abrirBanco();
        String query = "UPDATE Produtos SET preco_R$ = ?, categoria_id = ?, produto = ?, quantidade = ?, tamanho = ? WHERE id_produto = ?";
        pst = (PreparedStatement) con.prepareStatement(query);
        pst.setFloat(1, c.getPreco_R$());
        pst.setInt(2, c.getCategoria_id());
        pst.setString(3, c.getProduto());
        pst.setInt(4, c.getQuantidade());
        pst.setString(5, c.getTamanho());
        pst.setString(6, c.getId_produto());
        pst.executeUpdate();
        fecharBanco();
    }

    public ArrayList<Produtos> PesquisarTudo() throws Exception {
        ArrayList<Produtos> produtos = new ArrayList<>();
        try {
            abrirBanco();
            String query = "SELECT * FROM produtos";
            pst = (PreparedStatement) con.prepareStatement(query);
            ResultSet tr = pst.executeQuery();
            Produtos prod;
            while (tr.next()) {
                prod = new Produtos();
                prod.setId_produto(tr.getString("id_produto"));
                prod.setCategoria_id(tr.getInt("categoria_id"));
                prod.setProduto(tr.getString("produto"));
                prod.setPreco_R$(tr.getFloat("preco_R$"));
                prod.setQuantidade(tr.getInt("quantidade"));
                prod.setTamanho(tr.getString("tamanho"));
                produtos.add(prod);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return produtos;
    }

    public void PesquisarRegistro(Produtos prod) throws Exception {
        try {
            abrirBanco();
            String query = "SELECT * FROM produtos WHERE id_produto=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, prod.getId_produto());
            ResultSet tr = pst.executeQuery();
            if (tr.next()) {
                prod.setCategoria_id(tr.getInt("categoria_id"));
                prod.setProduto(tr.getString("produto"));
                prod.setPreco_R$(tr.getFloat("preco_R$"));
                prod.setQuantidade(tr.getInt("quantidade"));
                prod.setTamanho(tr.getString("tamanho"));
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado");
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }
}
