package entity;

import java.util.ArrayList;

public class Hotel {
    private int id;
    private String nombreHotel;
    private int cantidadMaximaHabitaciones;
    private static int ID_GENERIC = 1;
    private ArrayList<Habitacion> listaHabitaciones;


    public Hotel(String nombreHotel, int cantidadMaximaHabitaciones) {
        this.id = ID_GENERIC++;
        this.nombreHotel = nombreHotel;
        this.cantidadMaximaHabitaciones = cantidadMaximaHabitaciones;
        this.listaHabitaciones = new ArrayList<>();

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombreHotel() {
        return nombreHotel;
    }


    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }


    public int getCantidadMaximaHabitaciones() {
        return cantidadMaximaHabitaciones;
    }


    public void setCantidadMaximaHabitaciones(int cantidadMaximaHabitaciones) {
        this.cantidadMaximaHabitaciones = cantidadMaximaHabitaciones;
    }

    

    public ArrayList<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }


    public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }


    @Override
    public String toString() {
        return "Hotel : " + nombreHotel ;
    }

    
    
    
}
