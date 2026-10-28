import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta implements IFacturable, IOperaciones {

    private String id;
    private LocalDate fechaVenta;
    private Cliente cliente;
    private List<Producto> productos;
    private double subTotal;
    private double total;
    private final double ITBIS = 0.18;

    public Venta(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.subTotal = 0.0;
        this.total = 0.0;
    }
}