package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.Cliente;
import entity.Habitacion;
import entity.Hotel;

public class Reserva {

   private ArrayList<Hotel> listaHoteles;
   private ArrayList<Cliente> listaClientes;
    
    public Reserva() {
        listaHoteles = new ArrayList<>();
        listaClientes = new ArrayList<>();
        crearHotel("Hilton", 10);
        listaClientes.add(crearCliente("Luis", 123, "SM"));
    }
   //crear cliente
   public Cliente crearCliente(String nombre,int cedula, String empresa) {
        Cliente cliente = new Cliente(nombre, cedula, empresa);
        listaClientes.add(cliente);
        return cliente;
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
     public void generarReserva(Hotel hotel, Habitacion habitacion, Cliente cliente, boolean estadoHabitacion) {
        for (int i = 0; i < listaHoteles.size(); i++) {
			if (listaHoteles.get(i).getId() == hotel.getId()) {
                reservarHabitacion(hotel, habitacion, cliente, estadoHabitacion);
				listaHoteles.remove(i);
				listaHoteles.add(i, hotel);  
				break;
			}
		}
	}

    //
        public void reservarHabitacion(Hotel hotel, Habitacion habitacion,Cliente cliente, boolean estadoHabitacion) {
        for (int i = 0; i < hotel.getListaHabitaciones().size(); i++) {
			if (hotel.getListaHabitaciones().get(i).getNumeroHabitacion() == habitacion.getNumeroHabitacion()) {
                habitacion.setEstadoHabitacion(estadoHabitacion);
                if (estadoHabitacion == false) {
                    habitacion.setCliente(null);
                } else {
                     habitacion.setCliente(cliente);
                }
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

    public String verInformacionHotel(Hotel hotel){
        String informacionHotel = "Hotel :"+ hotel.getNombreHotel();
        for (Habitacion habitacion : hotel.getListaHabitaciones()) {
            if (habitacion.isEstadoHabitacion()) {
                informacionHotel += " Empresa :"+ habitacion.getCliente().getEmpresa()+ " Nombre Cliente "+ habitacion.getCliente().getNombre() +" Cedula Cliente "+ habitacion.getCliente().getCedula()
                                    +" Habitacion #"+ habitacion.getNumeroHabitacion() + "\n";
            }
            
        }
        return informacionHotel ;

    }

        public ArrayList<Hotel> getListaHoteles() {
            return listaHoteles;
        }
        public ArrayList<Cliente> getListaClientes() {
            return listaClientes;
        }
    
}
