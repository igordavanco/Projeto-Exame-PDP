/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;


import DAO.MysqlCategoriaDAO;
import DAO.MysqlFornecedorDAO;
import DAO.MysqlProdutoDAO;
import Interfaces.CategoriaDAO;
import Interfaces.FornecedorDAO;
import Interfaces.ProdutoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Igor Davanço
 */
public class MysqlFactory extends DAOFactory{
    private static Connection instance;
    private static final String URL = "jdbc:mysql://localhost:3306/northwind";
    private static final String USER = "root";
    private static final String PASS = "root";
    
    public static Connection getConnection(){
        try{
            if(instance == null){
                instance = DriverManager.getConnection(URL, USER, PASS);
            }
        }catch(SQLException e){
            throw new RuntimeException("Ops!! Erro ao conectar com o banco de dados!", e);
        }
        return instance;
    }
    
    public static void closeConnection(){
        try{
            if(instance.isClosed() == false){
                instance.close();
                instance = null;
            }
        }catch(SQLException e){
            throw new RuntimeException("Ops!! Erro ao fechar o banco de dados!", e);
        }
    }

    @Override
    public ProdutoDAO getProdutoDAO() {
        return new MysqlProdutoDAO();
    }

    @Override
    public CategoriaDAO getCategoriaDAO() {
        return new MysqlCategoriaDAO();
    }

    @Override
    public FornecedorDAO getFornecedorDAO() {
        return new MysqlFornecedorDAO();
    }
}
