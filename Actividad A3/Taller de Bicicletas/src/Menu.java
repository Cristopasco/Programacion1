import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Mecanico> mecanicos = new ArrayList<>();
    ArrayList<OrdenServicio> ordenes = new ArrayList<>();


    public void iniciar() {

        int opcion;

        do {

            System.out.println("\n--- TALLER DE BICICLETAS ---");
            System.out.println("1 Registrar un cliente");
            System.out.println("2 Registrar una bicicleta a un cliente");
            System.out.println("3 Registrar un mecanico");
            System.out.println("4 Crear una orden de servicio");
            System.out.println("5 Asignar o cambiar un mecanico");
            System.out.println("6 Agregar una tarea");
            System.out.println("7 Agregar un repuesto");
            System.out.println("8 Cambiar estado de una orden");
            System.out.println("9 Calcular un costo total de orden");
            System.out.println("0 Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    registrarCliente();
                    break;

                case 2:
                    registrarBicicleta();
                    break;

                case 3:
                    registrarMecanico();
                    break;

                case 4:
                    crearOrden();
                    break;

                case 5:
                    asignarMecanico();
                    break;

                case 6:
                    agregarTarea();
                    break;

                case 7:
                    agregarRepuesto();
                    break;

                case 8:
                    cambiarEstado();
                    break;

                case 9:
                    calcularCosto();
                    break;
            }

        } while (opcion != 0);
    }


    private void registrarCliente() {

        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();

        System.out.print("Telefono: ");
        String tel = sc.nextLine();

        clientes.add(new Cliente(nombre, tel));
    }


    private void registrarBicicleta() {

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes.");
            return;
        }

        for (int i = 0; i < clientes.size(); i++)
            System.out.println(i + " - " + clientes.get(i).nombre);

        System.out.print("Indice de cliente: ");
        int ic = sc.nextInt();
        sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Color: ");
        String color = sc.nextLine();

        clientes.get(ic).agregarBicicleta(new Bicicleta(marca, color));
    }


    private void registrarMecanico() {

        System.out.print("Nombre de mecanico: ");
        String nom = sc.nextLine();

        mecanicos.add(new Mecanico(nom));
    }


    private void crearOrden() {

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes.");
            return;
        }

        for (int i = 0; i < clientes.size(); i++)
            System.out.println(i + " - " + clientes.get(i).nombre);

        System.out.print("Indice de cliente: ");
        int cli = sc.nextInt();

        if (clientes.get(cli).bicicletas.isEmpty()) {
            System.out.println("Ese cliente no tiene bicicletas.");
            return;
        }

        for (int i = 0; i < clientes.get(cli).bicicletas.size(); i++) {

            Bicicleta b = clientes.get(cli).bicicletas.get(i);
            System.out.println(i + " - " + b.marca + " " + b.color);
        }

        System.out.print("Indice de bicicleta: ");
        int ib = sc.nextInt();
        sc.nextLine();

        System.out.print("Descripcion de problema: ");
        String desc = sc.nextLine();

        System.out.print("Fecha de ingreso: ");
        String fecha = sc.nextLine();

        Bicicleta bici = clientes.get(cli).bicicletas.get(ib);

        ordenes.add(new OrdenServicio(bici, desc, fecha));
    }


    private void asignarMecanico() {

        if (ordenes.isEmpty() || mecanicos.isEmpty()) {
            System.out.println("Debe haber ordenes y mecanicos.");
            return;
        }

        for (int i = 0; i < ordenes.size(); i++) {

            OrdenServicio o = ordenes.get(i);

            System.out.println(i + " - " +
                    o.bicicleta.marca + " " +
                    o.bicicleta.color +
                    " | " + o.estado);
        }

        System.out.print("Indice de orden: ");
        int io = sc.nextInt();

        for (int i = 0; i < mecanicos.size(); i++)
            System.out.println(i + " - " + mecanicos.get(i).nombre);

        System.out.print("Indice de mecanico: ");
        int im = sc.nextInt();

        ordenes.get(io).asignarMecanico(mecanicos.get(im));
    }


    private void agregarTarea() {

        if (ordenes.isEmpty()) {
            System.out.println("No hay ordenes.");
            return;
        }

        for (int i = 0; i < ordenes.size(); i++) {

            OrdenServicio o = ordenes.get(i);

            System.out.println(i + " - " +
                    o.bicicleta.marca + " " +
                    o.bicicleta.color +
                    " | " + o.estado);
        }

        System.out.print("Indice de orden: ");
        int it = sc.nextInt();
        sc.nextLine();

        System.out.print("Descripcion de tarea: ");
        String desc = sc.nextLine();

        System.out.print("Costo: ");
        double costo = sc.nextDouble();

        ordenes.get(it).agregarTarea(new Tarea(desc, costo));
    }


    private void agregarRepuesto() {

        if (ordenes.isEmpty()) {
            System.out.println("No hay ordenes.");
            return;
        }

        for (int i = 0; i < ordenes.size(); i++) {

            OrdenServicio o = ordenes.get(i);

            System.out.println(i + " - " +
                    o.bicicleta.marca + " " +
                    o.bicicleta.color +
                    " | " + o.estado);
        }

        System.out.print("Indice de orden: ");
        int ir = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre del repuesto: ");
        String nr = sc.nextLine();

        System.out.print("Cantidad: ");
        int cant = sc.nextInt();

        System.out.print("Costo unitario: ");
        double cu = sc.nextDouble();

        ordenes.get(ir).agregarRepuesto(new Repuesto(nr, cant, cu));
    }


    private void cambiarEstado() {

        if (ordenes.isEmpty()) {
            System.out.println("No hay ordenes.");
            return;
        }

        for (int i = 0; i < ordenes.size(); i++) {

            OrdenServicio o = ordenes.get(i);

            System.out.println(i + " - " +
                    o.bicicleta.marca + " " +
                    o.bicicleta.color +
                    " | " + o.estado);
        }

        System.out.print("Indice de orden: ");
        int ie = sc.nextInt();

        System.out.println("1 RECIBIDA");
        System.out.println("2 EN PROCESO");
        System.out.println("3 FINALIZADA");
        System.out.println("4 ENTREGADA");

        int est = sc.nextInt();

        ordenes.get(ie).cambiarEstado(EstadoOrden.values()[est - 1]);
    }


    private void calcularCosto() {

        if (ordenes.isEmpty()) {
            System.out.println("No hay ordenes.");
            return;
        }

        for (int i = 0; i < ordenes.size(); i++) {

            OrdenServicio o = ordenes.get(i);

            System.out.println(i + " - " +
                    o.bicicleta.marca + " " +
                    o.bicicleta.color +
                    " | " + o.estado);
        }

        System.out.print("Indice de orden: ");
        int ic = sc.nextInt();

        System.out.println("Costo total: " +
                ordenes.get(ic).calcularCostoTotal());
    }
}