package controller;

import javax.swing.JOptionPane;

import dao.Calculadora;
import dao.ConversorMonedas;
import dao.Reserva;
import dao.SistemaAlumnos;
import entity.Alumno;
import entity.Cliente;
import entity.Habitacion;
import entity.Hotel;

public class Controller {

    private SistemaAlumnos sistemaAlumnos;
    private ConversorMonedas conversorMonedas;
    private Calculadora calculadora;
    private Reserva reserva;

    public Controller() {
       this.sistemaAlumnos = new SistemaAlumnos();
       this.conversorMonedas = new ConversorMonedas();
       this.calculadora = new Calculadora();
       this.reserva = new Reserva();
       menuInicial();
    }

    public void menuInicial(){
        Object[] selection = { "Sistema Alumnos", "Conversor Monedas", "Calculadora", "Sistema Hotel"};
            
        
        Object seleccionAccion = JOptionPane.showInputDialog(null, "Seleccione una acción",
            "Acción", JOptionPane.QUESTION_MESSAGE, null, selection, selection[0].toString());
            
        switch (seleccionAccion.toString()) {
            case "Sistema Alumnos": 
                agregarAlumno();
            break;
            case "Conversor Monedas":
                conversorMoneda();
            break;
            case "Calculadora":
                calculadora();
            break;
            case "Sistema Hotel":
                sistemaHotel();
            break;
        }
    }

    public void agregarAlumno(){
        Object[] selectionAccionAlumno = { "Agregar Alumno", "Agregar Calificación", "Calcular Promedio", "Lista Alumnos", "Volver" };
            
        
        Object seleccionAccion = JOptionPane.showInputDialog(null, "Seleccione el alumno",
            "Alumnos", JOptionPane.QUESTION_MESSAGE, null, selectionAccionAlumno, selectionAccionAlumno[0].toString());
            
        switch (seleccionAccion.toString()) {
            case "Agregar Alumno":
            System.out.println(seleccionAccion);  
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del Alumno:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del Alumno:"));
            sistemaAlumnos.agregarAlumno( nombre, edad);
            agregarAlumno();
                break;
             
            case "Agregar Calificación":
            
                Alumno selection = (Alumno) (JOptionPane.showInputDialog(null, "Seleccione el alumno",
                                 "Alumnos", JOptionPane.QUESTION_MESSAGE, null, sistemaAlumnos.getListaAlumnos().toArray(), sistemaAlumnos.getListaAlumnos().toArray()[0].toString()));
                
                String nombreMateria = JOptionPane.showInputDialog("Ingrese el nombre de la materia:");
                double calificacion = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la calificación de 0.0 a 5.0 de "+ nombreMateria));
                
                sistemaAlumnos.agregarMaterias(selection, nombreMateria, calificacion);
                agregarAlumno();
                break;
                case "Calcular Promedio":
                Alumno selectionAlumnoPromedio = (Alumno) (JOptionPane.showInputDialog(null, "Seleccione el alumno",
                "Alumnos", JOptionPane.QUESTION_MESSAGE, null, sistemaAlumnos.getListaAlumnos().toArray(), sistemaAlumnos.getListaAlumnos().toArray()[0].toString()));
                
                JOptionPane.showMessageDialog(null, ("El promedio del alumno " + selectionAlumnoPromedio.getNombre() + " es: " + sistemaAlumnos.calcularPromedio(selectionAlumnoPromedio) ));
                agregarAlumno();
            break;
            case  "Lista Alumnos":
             Alumno selectionAlumno = (Alumno) (JOptionPane.showInputDialog(null, "Seleccione el alumno",
                "Alumnos", JOptionPane.QUESTION_MESSAGE, null, sistemaAlumnos.getListaAlumnos().toArray(), sistemaAlumnos.getListaAlumnos().toArray()[0].toString()));
                JOptionPane.showMessageDialog(null, ("Alumno: " + selectionAlumno.getNombre() + "\nEdad: " + selectionAlumno.getNombre() 
                                                       + "\nCalificaciones: "+ selectionAlumno.getListaNotas().toString()));
                agregarAlumno();
            break;
            case "Volver":
               menuInicial();
            break;
            default:
                break;
        
        }    
    }
    
    public void conversorMoneda(){

        Object[] selection = { "Dolar a Pesos Colombiano", "Pesos Colombiano a Euro", "Euro a Dolar", "Dolar a Won", "Volver"};
            
        
        Object seleccionAccion = JOptionPane.showInputDialog(null, "Seleccione una acción",
            "Acción", JOptionPane.QUESTION_MESSAGE, null, selection, selection[0].toString());
            
        switch (seleccionAccion.toString()) {
            case "Dolar a Pesos Colombiano":    
                JOptionPane.showMessageDialog(null,            
                conversorMonedas.conversorDolarPeso(Double.parseDouble(JOptionPane.showInputDialog("Ingrese un valor: "))));
                conversorMoneda();
            break;
            case "Pesos Colombiano a Euro":
                JOptionPane.showMessageDialog(null,
                conversorMonedas.conversorPesoEuro(Double.parseDouble(JOptionPane.showInputDialog("Ingrese un valor: "))));
                conversorMoneda();
            break; 
            case "Euro a Dolar":
                JOptionPane.showMessageDialog(null,
                conversorMonedas.conversorEuroDolar(Double.parseDouble(JOptionPane.showInputDialog("Ingrese un valor: "))));
                conversorMoneda();
            break;
            case "Dolar a Won":
                JOptionPane.showMessageDialog(null,
                conversorMonedas.conversorDolarWon(Double.parseDouble(JOptionPane.showInputDialog("Ingrese un valor: "))));
                conversorMoneda();
            break;
            case "Volver":
               menuInicial();
            break;
        }
    }


    public void calculadora(){
         Object[] selection = { "Suma", "Resta", "Multiplicación", "División", "Volver"};
            
        
        Object seleccionAccion = JOptionPane.showInputDialog(null, "Seleccione una operación",
            "Calculadora", JOptionPane.QUESTION_MESSAGE, null, selection, selection[0].toString());
            
        switch (seleccionAccion.toString()) {
            case "Suma":
                double valor_suma_1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer valor: "));
                double valor_suma_2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo valor: "));
                JOptionPane.showMessageDialog(null,"La suma total es: " +  calculadora.suma(valor_suma_1, valor_suma_2));
                calculadora();
            break;
            case "Resta":
                double valor_resta_1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer valor: "));
                double valor_resta_2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo valor: "));
                JOptionPane.showMessageDialog(null,"La resta total es: " +  calculadora.resta(valor_resta_1, valor_resta_2));
                calculadora();
            break; 
            case "Multiplicación":
                double valor_multiplicacion_1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer valor: "));
                double valor_multiplicacion_2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo valor: "));
                JOptionPane.showMessageDialog(null,"La multiplicación total es: " +  calculadora.multiplicacion(valor_multiplicacion_1, valor_multiplicacion_2));
                calculadora();
            break;
            case "División": 
                double valor_division_1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer valor: "));
                double valor_division_2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo valor: "));
                JOptionPane.showMessageDialog(null,"La división total es: " +  calculadora.division(valor_division_1, valor_division_2));
                calculadora();
            break; 
            case "Volver":
                menuInicial();
            break;
        }
    }
    

    public void sistemaHotel(){
        Object[] selection = { "Crear Hotel", "Reservar Habitación", "Habitaciones disponibles", "Cancelar Reserva","Ver Información", "Volver"};
            
        
        Object seleccionAccion = JOptionPane.showInputDialog(null, "Seleccione una operación",
            "Calculadora", JOptionPane.QUESTION_MESSAGE, null, selection, selection[0].toString());
            
        switch (seleccionAccion.toString()) {

            case "Crear Hotel":
                String nombreHotel = JOptionPane.showInputDialog("Ingrese el nombre del Hotel:");
                int cantidadMaximaHabitaciones = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de habitaciones:"));
                reserva.crearHotel(nombreHotel, cantidadMaximaHabitaciones);
                sistemaHotel();
            break;
            case "Reservar Habitación":
                getSeleccion_habitacion();
            break;
            case "Habitaciones disponibles":
                Hotel seleccion_hotel_disponible =(Hotel) (JOptionPane.showInputDialog(null, "Seleccione el hotel",
                  "Sistema Hotel", JOptionPane.QUESTION_MESSAGE, null, reserva.getListaHoteles().toArray(), reserva.getListaHoteles().toArray()[0].toString()));
                
                JOptionPane.showMessageDialog(null,  reserva.getHabitacionDisponible(seleccion_hotel_disponible).get(1));
                sistemaHotel();
            break;
            case "Cancelar Reserva":
                Hotel seleccion_hotel_cancelar =(Hotel) (JOptionPane.showInputDialog(null, "Seleccione el hotel",
                    "Sistema Hotel", JOptionPane.QUESTION_MESSAGE, null, reserva.getListaHoteles().toArray(), reserva.getListaHoteles().toArray()[0].toString()));
                
                Habitacion seleccion_habitacion_cancelar = (Habitacion) (JOptionPane.showInputDialog(null, "Seleccione la habitación",
                    "Sistema Hotel", JOptionPane.QUESTION_MESSAGE, null, reserva.getHabitacionDisponible(seleccion_hotel_cancelar).get(2).toArray(), seleccion_hotel_cancelar.getListaHabitaciones().toArray()[0].toString())); 

                reserva.generarReserva(seleccion_hotel_cancelar, seleccion_habitacion_cancelar, null, false);
        
                sistemaHotel();
            break;
            case "Ver Información":
                Hotel seleccion_hotel_informacion =(Hotel) (JOptionPane.showInputDialog(null, "Seleccione el hotel",
                    "Sistema Hotel", JOptionPane.QUESTION_MESSAGE, null, reserva.getListaHoteles().toArray(), reserva.getListaHoteles().toArray()[0].toString()));
                JOptionPane.showMessageDialog(null, reserva.verInformacionHotel(seleccion_hotel_informacion));
                sistemaHotel();   
            break;
            case "Volver":
                menuInicial();
            break;

        }

    }

        public Cliente clientes(){
         Object[] selection = { "Cliente Nuevo", "Cliente Antiguo"};
            
        
        Object seleccionAccion = JOptionPane.showInputDialog(null, "Seleccione una operación",
            "Cliente", JOptionPane.QUESTION_MESSAGE, null, selection, selection[0].toString());

        Cliente cliente = null;
            
        switch (seleccionAccion.toString()) {
            case "Cliente Nuevo":
                String nombre_empresa = JOptionPane.showInputDialog("Ingrese el nombre de la empresa:");
                String nombre_cliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cedula:"));
                cliente = reserva.crearCliente(nombre_cliente, cedula, nombre_empresa);
            break;
            case "Cliente Antiguo":
                cliente =(Cliente) (JOptionPane.showInputDialog(null, "Seleccione el cliente",
                    "Sistema Hotel", JOptionPane.QUESTION_MESSAGE, null, reserva.getListaClientes().toArray(), reserva.getListaHoteles().toArray()[0].toString()));
            break;
        }
        return cliente;
    } 

    private void getSeleccion_habitacion() {
        Hotel seleccion_hotel =(Hotel) (JOptionPane.showInputDialog(null, "Seleccione el hotel",
          "Sistema Hotel", JOptionPane.QUESTION_MESSAGE, null, reserva.getListaHoteles().toArray(), reserva.getListaHoteles().toArray()[0].toString()));
           
        Habitacion seleccion_habitacion = (Habitacion) (JOptionPane.showInputDialog(null, "Seleccione la habitación",
          "Sistema Hotel", JOptionPane.QUESTION_MESSAGE, null, reserva.getHabitacionDisponible(seleccion_hotel).get(1).toArray(), seleccion_hotel.getListaHabitaciones().toArray()[0].toString())); 

       reserva.generarReserva(seleccion_hotel, seleccion_habitacion, clientes(), true);
        System.out.println(seleccion_hotel.toString() + seleccion_habitacion.toString());
        sistemaHotel();
    }
    
}
