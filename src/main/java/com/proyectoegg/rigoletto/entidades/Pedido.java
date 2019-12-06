
import java.util.Date;
import java.util.List;
//holis
// holis 
//asd


public class Pedido {

    private Integer idPedido;

    private Usuario usuario;

    private Date fecha_hora;

    private MedioDePago medioPago;

    private Estado estado;

    private String domicilio;

    private Long telefono;

    private TipoEntrega tipoEntrega;

    private List<DetallePedido> productos;

    public void crearPedido() {
    }

    public void modificarPedido() {
    }

    public void borrarPedido() {
    }

    public void listarPedido() {
    }

    public double getmontoTotal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
