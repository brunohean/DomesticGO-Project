package pe.edu.upc.domesticgo.dtos;
import pe.edu.upc.domesticgo.entities.DetalleUsuario;

import java.time.LocalDate;

public class ChatDTO {
    private int idChat;
    private LocalDate fechaMensaje;
    private String detalleMensaje;
    // Falta Foreign Key Usuario
    private DetalleUsuario contratante;
    private DetalleUsuario contratado;

    // Getters and Setters
    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public LocalDate getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(LocalDate fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public String getDetalleMensaje() {
        return detalleMensaje;
    }

    public void setDetalleMensaje(String detalleMensaje) {
        this.detalleMensaje = detalleMensaje;
    }

    public DetalleUsuario getContratante() {
        return contratante;
    }

    public void setContratante(DetalleUsuario contratante) {
        this.contratante = contratante;
    }

    public DetalleUsuario getContratado() {
        return contratado;
    }

    public void setContratado(DetalleUsuario contratado) {
        this.contratado = contratado;
    }
}
