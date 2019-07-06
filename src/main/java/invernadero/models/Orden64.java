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
        String val = "";

        String[] sc = line[3].split(" ");
        if(sc.length > 1){
            String[] vals = sc[1].split(".");
            val = sc[1].replaceAll("[\\D]", "");
            this.setCarro(val);
        }
        sc = line[4].split(" ");
        if(sc.length > 1){
            String[] vals = sc[1].split(".");
            val = sc[1].replaceAll("[\\D]", "");
            this.setFardos(val);
        }
        sc = line[5].split("\\s|\\[");
        if(sc.length > 1){
            String[] vals = sc[1].split(".");
            val = sc[1].replaceAll("[\\D]", "");
            this.setSeccion(val);
        }
    }
    public String toString() {
        return this.tiempo+"|"+this.carro+"|"+this.fardos+"|"+this.seccion;
    }
}