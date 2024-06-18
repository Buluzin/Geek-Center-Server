/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;

import java.sql.SQLException;


public class TesteCod extends DAO{
     public static void main(String[] args) throws SQLException {
        DAO cx1 = new DAO();
        cx1.abrirBanco();
    }
}
