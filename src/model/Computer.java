package model;

public class Computer {

    private String serial;
    private int floor;
    private int column;
    private ArrayList<Incident> incidents;

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para satisfacer los
     * requerimientos.
     */

    public Computer(String serial, int floor, int column) {
        this.serial = serial;
        this.floor = floor;
        this.column = column;
        this.incidents = new ArrayList<>();

    }

    public String getSerial(){
        return serial;
    }

    public int getFloor(){
        return floor;
    }

    public ArrayList<Incident> getIncidents(){
        return incidents;
    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * El siguiente metodo esta incompleto.
     * Agregue los parametros y retorno que sean pertinentes.
     * Agregue la logica necesaria.
     */
    public void addIncident(Incident i) {
        incidents.add(i);

    }
    public int getIncidentCount(){
        return incidents.size();
    }

}
