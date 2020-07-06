/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Interfaces.CategoriaDAO;
import Interfaces.FornecedorDAO;
import Interfaces.ProdutoDAO;

/**
 *
 * @author Igor Davanço
 */
public abstract class DAOFactory {
    public static final int SQLITE = 1;
    public static final int MYSQL = 2;
    public static final int MONGODB = 3;
    
    public abstract ProdutoDAO getProdutoDAO();
    public abstract CategoriaDAO getCategoriaDAO();
    public abstract FornecedorDAO getFornecedorDAO();
    
    public static DAOFactory getDAOFactory(int whichFactory){
        switch(whichFactory){
            case SQLITE:
                return new SqliteFactory();
            case MYSQL:
                return new MysqlFactory();
            /*case MONGODB:
                return new mongodbFactory();*/
            default:
                return null;           
        }
    }
}
