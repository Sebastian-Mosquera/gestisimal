package service;

import models.Articulo;

import java.util.HashMap;
import java.util.Scanner;

public class ArticuloService {
    private Scanner sc;
    private Articulo articulo;
    private HashMap<String, Articulo> listaArticulos;

    public ArticuloService() {
        sc = new Scanner(System.in);
        listaArticulos = new HashMap<>();
    }
    public void menu(){
        char opcion;
        do {
            System.out.println("-----MENU-------");
            System.out.println("1. Listado");
            System.out.println("2. Alta(Ingresar un articulo)");
            System.out.println("3. Baja(Eliminar un articulo)");
            System.out.println("4. Modificar articulo");
            System.out.println("5. Entrada de mercancia(Agregar stock de mercancia) ");
            System.out.println("6. Salida de mercancia(Restar stock a un articulo) ");
            System.out.println("7. Salir");
            System.out.println("Ingrese una opcion");
            opcion = sc.next().charAt(0);
            switch (opcion){
                case '1' -> listaArticulos();
                case '2' -> ingreseArticulo();
                case '3' -> eliminarArticulo();
                case '4' -> modificarArticulo();
                case '5' -> agregarStock();
                case '6' -> restarStock();
                default -> System.out.println("Opcion no valida");
            }


        }while (opcion != 7);
    }
    private void listaArticulos() {
        for (Articulo articulo : listaArticulos.values()) {
            System.out.println(articulo);
        }
    }
    private void ingreseArticulo(){
        System.out.println("Ingrese codigo del articulo");
        String codigo = sc.nextLine();
        System.out.println("Ingrese descripcion del articulo");
        String descripcion = sc.nextLine();
        System.out.println("Ingrese precio del articulo");
        double precioCompra = sc.nextDouble();
        System.out.println("Ingrese precio de compra");
        double precioVenta = sc.nextDouble();
        System.out.println("ingrese el stock total");
        int stock = sc.nextInt();
        articulo = new Articulo(codigo, descripcion, precioCompra, precioVenta, stock);
        listaArticulos.put(codigo, articulo);
    }
    private void eliminarArticulo(){
        System.out.println("Ingrese codigo del articulo a eliminar ");
        String codigo =sc.nextLine();
        listaArticulos.remove(codigo);
    }
    private void modificarArticulo(){
        System.out.println("Ingrese codigo del articulo a modificar ");
        String codigo = sc.nextLine();
        if (codigo != null){
            System.out.println("Ingrese la nueva descripcion del articulo");
            articulo.setDescripcion(sc.nextLine());
            System.out.println("Ingrese el nuevo precio del compra");
            articulo.setPrecioCompra(sc.nextDouble());
            System.out.println("Ingrese el nuevo precio de venta");
            articulo.setPrecioVenta(sc.nextDouble());
            System.out.println("Ingrese el nuevo stock ");
            articulo.setPrecioCompra(sc.nextInt());
            listaArticulos.put(codigo, articulo);
        }else{
            System.out.println("No existe el producto");
        }
    }
    private void agregarStock(){
        System.out.println("Ingrese codigo del articulo a sumar stock ");
        String codigo = sc.nextLine();
        if (codigo != null){
            for (Articulo articulo : listaArticulos.values()) {
                if (articulo.getCodigo().equals(codigo)) {
                    System.out.println("Ingrese la cantidad de stock a sumar");
                    articulo.setStock(sc.nextInt()+articulo.getStock());
                }
            }
        }else {
            System.out.println("No existe el producto");
        }
    }
    private void restarStock() {
        System.out.println("Ingrese codigo del articulo a estar stock ");
        String codigo = sc.nextLine();
        if (codigo != null) {
            for (Articulo articulo : listaArticulos.values()) {
                    System.out.println("Ingrese la cantidad de stock a eliminar");
                    int stockE = sc.nextInt();
                    if(stockE < articulo.getStock()){
                        articulo.setStock(articulo.getStock()-stockE);
                    }else{
                        System.out.println("No se puede eliminar esta cantidad ");
                    }
                }
            }else {
            System.out.println("No existe el producto");
        }
    }
}

