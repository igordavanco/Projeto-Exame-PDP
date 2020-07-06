/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.Produto;
import java.util.List;

/**
 *
 * @author Igor Davanço
 */
public interface ProdutoDAO {
    public void create(Produto p);
    public List<Produto> read();
    public void update(Produto p);
    public void delete(Produto p);
}
