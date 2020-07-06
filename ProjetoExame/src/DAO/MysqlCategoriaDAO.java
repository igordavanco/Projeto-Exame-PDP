/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Categoria;
import Connection.MysqlFactory;
import Interfaces.CategoriaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Igor Davanço
 */
public class MysqlCategoriaDAO implements CategoriaDAO{
    public void create(Categoria c){
        Connection con = MysqlFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Category (CategoryName, Description) VALUES (?, ?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getDescricao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
        }finally{
            MysqlFactory.closeConnection();
        }
    }
    
    public List<Categoria> read(){
        Connection con = MysqlFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Categoria> categorias = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Category");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Categoria categoria = new Categoria();
                
                categoria.setId(rs.getInt("Id"));
                categoria.setNome(rs.getString("CategoryName"));
                categoria.setDescricao(rs.getString("Description"));
                
                categorias.add(categoria);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MysqlCategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            MysqlFactory.closeConnection();
        }
        
        return categorias;
    }
    
    public void update(Categoria c){
        Connection con = MysqlFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE Category SET CategoryName = ?, Description = ? WHERE Id = ?");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getDescricao());
            stmt.setInt(3, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex);
        }finally{
            MysqlFactory.closeConnection();
        }
    }
    
    public void delete(Categoria c){
        Connection con = MysqlFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Category WHERE Id = ?");
            stmt.setInt(1, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!" + ex);
        }finally{
            MysqlFactory.closeConnection();
        }
    }
}
