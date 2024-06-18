/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;

import br.com.controle.Encomenda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ManterEncomenda extends DAO {

    public void inserir(Encomenda enc) throws Exception {
        try {
            abrirBanco();
            String query = "INSERT INTO encomenda(codigo,cpf,data_encomenda) VALUES (?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, enc.getCodigo());
            pst.setInt(2, enc.getCpf());
            pst.setString(3, enc.getData_encomenda());
            pst.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro ao inserir encomenda: " + e.getMessage());
        }
    }

    public void deletar(Encomenda enc) throws Exception {
        try {
            abrirBanco();
            String query = "DELETE FROM encomenda WHERE codigo=?";
            pst = con.prepareStatement(query);
            pst.setString(1, enc.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Encomenda deletada com sucesso");
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro ao deletar encomenda: " + e.getMessage());
        }
    }

    public void editarEncomenda(Encomenda enc) throws Exception {
        try {
            abrirBanco();
            String query = "UPDATE encomenda SET cpf=?, data_encomenda=? WHERE codigo=?";
            pst = con.prepareStatement(query);
            pst.setInt(1, enc.getCpf());
            pst.setString(2, enc.getData_encomenda());
            pst.setString(3, enc.getCodigo());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Encomenda atualizada com sucesso");
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar encomenda: " + e.getMessage());
        }
    }

    public ArrayList<Encomenda> PesquisarTudo() throws Exception {
        ArrayList<Encomenda> encomendas = new ArrayList<>();
        try {
            abrirBanco();
            String query = "SELECT * FROM encomenda";
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Encomenda enc = new Encomenda();
                enc.setCodigo(rs.getString("codigo"));
                enc.setCpf(rs.getInt("cpf"));
                enc.setData_encomenda(rs.getString("data_encomenda"));
                encomendas.add(enc);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro ao buscar todas as encomendas: " + e.getMessage());
        }
        return encomendas;
    }

    public void PesquisarRegistro(Encomenda enc) throws Exception {
        try {
            abrirBanco();
            String query = "SELECT * FROM encomenda WHERE codigo=?";
            pst = con.prepareStatement(query);
            pst.setString(1, enc.getCodigo());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                enc.setCodigo(rs.getString("codigo"));
                enc.setCpf(rs.getInt("cpf"));
                enc.setData_encomenda(rs.getString("data_encomenda"));
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma encomenda encontrada para o código: " + enc.getCodigo());
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro ao buscar encomenda por código: " + e.getMessage());
        }
    }
}