import org.example.vista.ventanaIA;
import org.example.controlador.controladorIA;

public class main {
    public static void main(String[] args) {
         ventanaIA view =new ventanaIA("INTELIGENCIA ARTIFICIAL");
         controladorIA controller = new controladorIA(view);
    }
}
