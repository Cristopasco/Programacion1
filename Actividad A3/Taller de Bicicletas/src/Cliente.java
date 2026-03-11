import java.util.ArrayList;

public class Cliente {

    public String nombre;
    public String telefono;
    public ArrayList<Bicicleta> bicicletas = new ArrayList<>();

    public Cliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void agregarBicicleta(Bicicleta b) {
        bicicletas.add(b);
    }
}