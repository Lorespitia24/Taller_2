package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.Habitacion;
import entity.Hotel;

public class Reserva {

   private ArrayList<Hotel> listaHoteles;
    
    public Reserva() {
        listaHoteles = new ArrayList<>();
    }
   
    
    //crear hoteles
	public void crearHotel(String nombreHotel, int cantidadMaximaHabitaciones) {
        Hotel hotelNew = new Hotel(nombreHotel, cantidadMaximaHabitaciones);
        for (int i = 1; i <= cantidadMaximaHabitaciones; i++) {
            hotelNew.getListaHabitaciones().add(new Habitacion(i, false));
        }
		listaHoteles.add(hotelNew);
	}


    //Crear una reserva
     public void generarReserva(Hotel hotel, Habitacion habitacion, boolean estadoHabitacion) {
        for (int i = 0; i < listaHoteles.size(); i++) {
			if (listaHoteles.get(i).getId() == hotel.getId()) {
                reservarHabitacion(hotel, habitacion, estadoHabitacion);
				listaHoteles.remove(i);
				listaHoteles.add(i, hotel);  
				break;
			}
		}
	}

    //
        public void reservarHabitacion(Hotel hotel, Habitacion habitacion, boolean estadoHabitacion) {
        for (int i = 0; i < hotel.getListaHabitaciones().size(); i++) {
			if (hotel.getListaHabitaciones().get(i).getNumeroHabitacion() == habitacion.getNumeroHabitacion()) {
                habitacion.setEstadoHabitacion(estadoHabitacion);
				hotel.getListaHabitaciones().remove(i);
                hotel.getListaHabitaciones().add(i, habitacion);
				break;
			}
		}
	}

    public Map<Integer, ArrayList> getHabitacionDisponible(Hotel hotel){ 
        Map<Integer, ArrayList> estadoHabitaciones=new HashMap<>();
        ArrayList<Habitacion> habitacionDisponibles = new ArrayList<>();
        ArrayList<Habitacion> habitacionOcupada = new ArrayList<>();
        for (Habitacion habitacion : hotel.getListaHabitaciones()) {
            if(!habitacion.isEstadoHabitacion()){
                habitacionDisponibles.add(habitacion);
            }else{
                habitacionOcupada.add(habitacion);
            }
        }
        estadoHabitaciones.put(1, habitacionDisponibles);
        estadoHabitaciones.put(2, habitacionOcupada);
        
        return estadoHabitaciones;
    }


        public ArrayList<Hotel> getListaHoteles() {
            return listaHoteles;
        }
    

    


    

}
