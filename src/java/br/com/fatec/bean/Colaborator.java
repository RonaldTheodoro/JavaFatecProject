package br.com.fatec.bean;


public class Colaborator extends Person {
    protected String type;
    
    public Colaborator(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
