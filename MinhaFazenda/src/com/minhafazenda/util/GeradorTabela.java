/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.util;

import com.minhafazenda.model.Categoria;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author rodrigo
 */
public class GeradorTabela {
    
    public static void main(String[] args){
        AnnotationConfiguration configuracao = new AnnotationConfiguration();
        configuracao.addAnnotatedClass(Categoria.class);
        
        SchemaExport export = new SchemaExport(configuracao);
        export.create(true, false);
        
    }
    
}
