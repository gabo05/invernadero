package invernadero.models;

public class Orden {
    protected String fecha;
    protected String tiempo;
    protected String fardos;
    protected String carro;

    public String getFecha() {
        return fecha;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public String getFardos() {
        return fardos;
    }

    public void setFardos(String fardos) {
        this.fardos = fardos;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void readLine(String[] line){

    }
}