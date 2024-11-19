package prueba;
import paneles.*;

public class Main {
    public static void main(String[] args) {
        Panel3 p1 = new Panel3();
        conexion pbc = new conexion();
        pbc.conectar();
        p1.setVisible(true);
    }
}
