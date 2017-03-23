package br.com.fatec.controller;

import br.com.fatec.bean.Colaborator;
        

public class ColaboratorController {
    private Colaborator colaborator;
    
    public ColaboratorController(Colaborator colaborator) {
        this.colaborator = colaborator;
                
    }
    
    public Colaborator insertColaborator() {
        colaborator.setType("Test");
        return colaborator;
    }
}
