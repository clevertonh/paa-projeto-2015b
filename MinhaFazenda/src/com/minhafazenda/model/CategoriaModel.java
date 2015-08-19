/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.model;

import com.minhafazenda.service.CategoriaService;

/**
 *
 * @author cleverton
 */
public class CategoriaModel {
    
    public String insert(Categoria obj) {
        //Cria objeto de serviço
        CategoriaService objService = new CategoriaService();
        //Chama método INSERT do serviço passando o objeto categoria por parametro
        return objService.insert(obj);
    }
    
    public String update(Categoria obj) {
        //Cria objeto de serviço
        CategoriaService objService = new CategoriaService();
        //Chama método UPDATE do serviço passando o objeto categoria por parametro
        return objService.update(obj);
    }
    
    public String delete(Categoria obj) {
        //Cria objeto de serviço
        CategoriaService objService = new CategoriaService();
        //Chama método UPDATE do serviço passando o objeto categoria por parametro
        return objService.delete(obj);
    }

}
