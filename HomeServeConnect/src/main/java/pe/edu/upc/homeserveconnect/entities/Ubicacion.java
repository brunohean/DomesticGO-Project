package pe.edu.upc.homeserveconnect.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Ubicacion")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUbicacion;

    @Column(name = "direccion", length = 150, nullable = false)
    private String direccion;

    @Column(name = "latitud", nullable = false)
    private double latitud;

    @Column(name = "longitud", nullable = false)
    private double longitud;

    @Column(name = "cadenaUbicacio", length = 200)
    private String cadenaUbicacio;

    public Ubicacion() {
    }

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
