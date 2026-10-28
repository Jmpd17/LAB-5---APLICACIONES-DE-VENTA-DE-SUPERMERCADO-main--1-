import java.time.LocalDate;

public class Factura {
    private  String id;
    private String numeroFactura;
    private  String numComprobante;
    private Venta venta;
    private LocalDate fechaImpresion;

    public  factura (
        String id,
        String numeroFactura,
        String numComprobante,
        Venta venta,
        LocalDate fechaImpresion
    )

    {
    this.id = id;
    this.numeroFactura = numeroFactura;
    this.numComprobante = numComprobante;
    this.venta = venta;
    this.LocalDate fechaImpresion;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumComprobante(String numComprobante) {this.numComprobante = numComprobante;}

    public String getNumComprobant() {
        return numComprobante;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNumeroComprobante(){return numeroFactura;}


    public LocalDate getfechaImpresion() {
        return fechaImpresion;
    }

    public void setfechaImpresion(String fecha) {
        this.fechaImpresion = fechaImpresion;
    }
}
}
