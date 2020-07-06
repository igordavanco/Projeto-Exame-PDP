/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Fornecedor;
import Connection.SqliteFactory;
import Interfaces.FornecedorDAO;
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
public class SqliteFornecedorDAO implements FornecedorDAO{
    
    public void create(Fornecedor f){
        Connection con = SqliteFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Supplier (CompanyName, Address, City, Phone) VALUES (?, ?, ?, ?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEndereco());
            stmt.setString(3, f.getCidade());
            stmt.setString(4, f.getTelefone());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
        }finally{
            SqliteFactory.closeConnection();
        }
    }
    
    public List<Fornecedor> read(){
        Connection con = SqliteFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Fornecedor> fornecedores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Supplier");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setId(rs.getInt("Id"));
                fornecedor.setNome(rs.getString("CompanyName"));
                fornecedor.setEndereco(rs.getString("Address"));
                fornecedor.setCidade(rs.getString("City"));
                fornecedor.setTelefone(rs.getString("Phone"));
                
                fornecedores.add(fornecedor);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SqliteFornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            SqliteFactory.closeConnection();
        }
        
        return fornecedores;
    }
    
    public void update(Fornecedor f){
        Connection con = SqliteFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE Supplier SET CompanyName = ?, Address = ?, City = ?, Phone = ? WHERE Id = ?");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEndereco());
            stmt.setString(3, f.getCidade());
            stmt.setString(4, f.getTelefone());
            stmt.setInt(5, f.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex);
        }finally{
            SqliteFactory.closeConnection();
        }
    }
    
    public void delete(Fornecedor f){
        Connection con = SqliteFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Supplier WHERE Id = ?");
            stmt.setInt(1, f.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!" + ex);
        }finally{
            SqliteFactory.closeConnection();
        }
    }
}
