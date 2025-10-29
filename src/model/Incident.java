package model;

public class Incident {
    private String description;

    /*
     * Constructor de la clase.
     * Recibe la descripción del incidente y la asigna al atributo.
     */

    public Incident(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return description;
    }

    public String toString(){
        return "Incidente:" + description;
    }

}
