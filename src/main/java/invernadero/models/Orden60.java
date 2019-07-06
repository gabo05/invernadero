package invernadero.models;

public class Orden60 extends Orden{
   
    private String bloque;

    public String getBloque() {
        return bloque;
    }

    public void sedtBloque(String seccion) {
        this.bloque = seccion;
    }
    
    public void readLine(String[] line){
        this.setTiempo(line[1]);
        String[] sc = line[3].split(" ");
        this.setCarro(sc.length > 1 ? sc[1] : "");
        sc = line[4].split(" ");
        this.setFardos(sc.length > 1 ? sc[1] : "");
        sc = line[5].split("\\s|\\[");
        this.sedtBloque(sc.length > 1 ? sc[1] : "");
    }
    public String toString() {
        return this.tiempo+"|"+this.carro+"|"+this.fardos+"|"+this.bloque;
    }
}