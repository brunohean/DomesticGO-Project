package pe.edu.upc.homeserveconnect.dto;

public class UbicacionDTO {

    private int idUbicacion;
    private String direccion;
    private double latitud;
    private double longitud;
    private String cadenaUbicacio;

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getCadenaUbicacio() {
        return cadenaUbicacio;
    }

    public void setCadenaUbicacio(String cadenaUbicacio) {
        this.cadenaUbicacio = cadenaUbicacio;
    }
}
