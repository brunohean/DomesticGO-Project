package pe.edu.upc.domesticgo.dtos;



import java.time.LocalDate;

public class ReseniasDtos {
    private  int idResenia;
    private LocalDate fecharesenia;
    private String Detalles;

    public String getDetalles() {
        return Detalles;
    }

    public void setDetalles(String detalles) {
        Detalles = detalles;
    }

    public LocalDate getFecharesenia() {
        return fecharesenia;
    }

    public void setFecharesenia(LocalDate fecharesenia) {
        this.fecharesenia = fecharesenia;
    }

    public int getIdResenia() {
        return idResenia;
    }

    public void setIdResenia(int idResenia) {
        this.idResenia = idResenia;
    }
}
