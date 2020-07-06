/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.Fornecedor;
import java.util.List;

/**
 *
 * @author Igor Davanço
 */
public interface FornecedorDAO {
    public void create(Fornecedor f);
    public List<Fornecedor> read();
    public void update(Fornecedor f);
    public void delete(Fornecedor f);
}
