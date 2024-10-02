import models.Articulo;
import service.ArticuloService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArticuloService articuloService = new ArticuloService();
        articuloService.menu();

    }
}