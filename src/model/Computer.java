package model;

import java.util.ArrayList;

public class Computer {

    private String serial;
    private int floor;
    private int column;
    private ArrayList<Incident> incidents;

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para satisfacer los
     * requerimientos.
     * Se agregó un ArrayList de Incident llamado "incidents" para almacenar
     * todos los incidentes relacionados con este computador, ya que un computador
     * puede tener varios incidentes. Esto cumple la relación de uno a varios.
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
     * Se agregó el parámetro Incident para recibir el incidente y se añadió la
     * lógica para guardarlo en la lista de incidentes del computador.
     * No retorna nada porque solo agrega el incidente.
     */
    public void addIncident(Incident i) {
        incidents.add(i);

    }

    /*
     * Método adicional para saber cuántos incidentes tiene el computador.
     * Este método ayuda a consultar cuál tiene más incidentes.
     */
    public int getIncidentCount(){
        return incidents.size();
    }

}
