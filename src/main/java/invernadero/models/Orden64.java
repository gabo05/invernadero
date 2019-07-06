package invernadero.models;

public class Orden64 extends Orden{
   
    private String seccion;

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    
    public void readLine(String[] line){
        this.setTiempo(line[1]);
        String[] sc = line[3].split(" ");
        this.setCarro(sc.length > 1 ? sc[1] : "");
        sc = line[4].split(" ");
        this.setFardos(sc.length > 1 ? sc[1] : "");
        sc = line[5].split("\\s|\\[");
        this.setSeccion(sc.length > 1 ? sc[1] : "");
    }
    public String toString() {
        return this.tiempo+"|"+this.carro+"|"+this.fardos+"|"+this.seccion;
    }
}