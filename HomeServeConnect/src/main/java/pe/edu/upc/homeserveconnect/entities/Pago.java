package pe.edu.upc.homeserveconnect.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;

    @Column(name = "tipoPago", length = 30, nullable = false)
    private String tipoPago;

    @Column(name = "tipoComprobante", length = 30)
    private String tipoComprobante;

    @Column(name = "monto", nullable = false)
    private double monto;

    @Column(name = "fechaPago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "banco", length = 50)
    private String banco;

    @ManyToOne
    @JoinColumn(name = "idContrato", nullable = false)
    private Contrato contrato;

    public Pago() {
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
