package dao;

public class ConversorMonedas {
    private static double VALOR_PESO_COLOMBIA = 4051.74;
    private static double VALOR_DOLAR = 1.10;
    private static double VALOR_WON  = 1316.12;
    private static double VALOR_EURO = 0.00023;

    public double conversorDolarPeso(double valor){
        return valor * (VALOR_PESO_COLOMBIA);
    }
    
    public double conversorPesoEuro(double valor){
        return valor * (VALOR_EURO);
    }
    
    public double conversorEuroDolar(double valor){
        return valor * (VALOR_DOLAR);
    }
    
    public double conversorDolarWon(double valor){
        return valor * (VALOR_WON);
    }
    
}
