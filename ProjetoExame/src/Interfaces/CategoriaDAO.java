/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.Categoria;
import java.util.List;

/**
 *
 * @author Igor Davanço
 */
public interface CategoriaDAO {
    public void create(Categoria c);
    public List<Categoria> read();
    public void update(Categoria c);
    public void delete(Categoria c);
}
