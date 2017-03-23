package br.com.fatec.bean;


public class Colaborator extends Person {
    protected String name;
    protected String type;
    
    public Colaborator(String name, String type) {
        this.name = name;
        this.type = type;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
