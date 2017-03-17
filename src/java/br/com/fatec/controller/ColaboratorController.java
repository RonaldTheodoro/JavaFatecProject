package br.com.fatec.controller;

import br.com.fatec.bean.Colaborator;
        

public class ColaboratorController {
    
    public Colaborator insertColaborator(Colaborator colaborator) {
        colaborator.setType("Test");
        return colaborator;
    }
}
