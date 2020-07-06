/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Produto;
import Connection.MysqlFactory;
import Interfaces.ProdutoDAO;
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
public class MysqlProdutoDAO implements ProdutoDAO{
    public void create(Produto p){
        Connection con = MysqlFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Product (ProductName, CategoryId, SupplierId, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued) VALUES (?, ?, ?, NULL, 0, 0, 0, 0, 0)");
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getCategoria_id());
            stmt.setInt(3, p.getFornecedor_id());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
        }finally{
            MysqlFactory.closeConnection();
        }
    }
    
    public List<Produto> read(){
        Connection con = MysqlFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Product");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("Id"));
                produto.setNome(rs.getString("ProductName"));
                produto.setCategoria_id(rs.getInt("CategoryId"));
                produto.setFornecedor_id(rs.getInt("SupplierId"));
                
                produtos.add(produto);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SqliteProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            MysqlFactory.closeConnection();
        }
        
        return produtos;
    }
    
    public void update(Produto p){
        Connection con = MysqlFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE Product SET ProductName = ?, CategoryId = ?, SupplierId = ? WHERE Id = ?");
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getCategoria_id());
            stmt.setInt(3, p.getFornecedor_id());
            stmt.setInt(4, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex);
        }finally{
            MysqlFactory.closeConnection();
        }
    }
    
    public void delete(Produto p){
        Connection con = MysqlFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Product WHERE Id = ?");
            stmt.setInt(1, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!" + ex);
        }finally{
            MysqlFactory.closeConnection();
        }
    }
}
