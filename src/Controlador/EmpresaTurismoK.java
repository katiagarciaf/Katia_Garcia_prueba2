package Controlador;

import java.util.ArrayList;
import java.util.Scanner;

import Modelo.DatosCliente;
import Modelo.MedioDeAlojamiento;
import Modelo.Cabagna;
import Modelo.Hotel;
import Modelo.Carpa;



public class EmpresaTurismoK {
    private ArrayList<MedioDeAlojamiento> mediosDeAlojamiento;
    private ArrayList<DatosCliente> clientes;



    public EmpresaTurismoK() {
        mediosDeAlojamiento = new ArrayList<>();
        clientes = new ArrayList<>();
    }


    public void ingresarMedioAlojamiento(MedioDeAlojamiento medio) {
        if (!mediosDeAlojamiento.contains(medio)) {
            mediosDeAlojamiento.add(medio);
            clientes.add(medio.getDatosCliente());
            System.out.println("Medio de alojamiento ingresado exitosamente.");
        } else {
            System.out.println("El medio de alojamiento ya existe.");
        }
    }

    public void mostrarMediosAlojamiento() {
        for (MedioDeAlojamiento medio : mediosDeAlojamiento) {
            System.out.println(medio);
        }
    }

    public void mostrarDatosCliente(String rutCliente) {
        for (MedioDeAlojamiento medio : mediosDeAlojamiento) {
            if (medio.getDatosCliente().getRutCliente().equals(rutCliente)) {
                System.out.println(medio);
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public int totalAdicional() {
        int totalAdicional = 0;
        for (MedioDeAlojamiento medio : mediosDeAlojamiento) {
            totalAdicional += medio.adicional();
        }
        return totalAdicional;
    }

    public int totalBonoDescuento() {
        int totalBonoDescuento = 0;
        for (MedioDeAlojamiento medio : mediosDeAlojamiento) {
            totalBonoDescuento += medio.bonoDescuento();
        }
        return totalBonoDescuento;
    }

    public int cantidadMediosAlojamiento(String tipoMedio) {
        int cantidad = 0;
        for (MedioDeAlojamiento medio : mediosDeAlojamiento) {
            if (medio.getClass().getSimpleName().equals(tipoMedio)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int valorCancelarCliente(String rutCliente) {
        for (MedioDeAlojamiento medio : mediosDeAlojamiento) {
            if (medio.getDatosCliente().getRutCliente().equals(rutCliente)) {
                return medio.valorACancelar();
            }
        }
        return -1; // Cliente no encontrado
    }

    public void aplicarIncremento() {
        for (MedioDeAlojamiento medio : mediosDeAlojamiento) {
            if (medio instanceof Cabagna) {
                ((Cabagna) medio).incrementaValorBase();
            }
        }
    }

    public static void main(String[] args) {
        EmpresaTurismoK empresa = new EmpresaTurismoK();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("------ Menú Principal ------");
            System.out.println("1. Ingresar Medio de Alojamiento");
            System.out.println("2. Mostrar Medios de Alojamiento");
            System.out.println("3. Mostrar Datos de un Cliente");
            System.out.println("4. Total Adicional");
            System.out.println("5. Total Bono Descuento");
            System.out.println("6. Cantidad Medios de Alojamiento X");
            System.out.println("7. Valor a Cancelar por un Cliente X");
            System.out.println("8. Aplicar Incremento del Valor Base");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Ingresar Medio de Alojamiento
                    System.out.println("Seleccione el tipo de medio:");
                    System.out.println("1. Carpa");
                    System.out.println("2. Cabagna");
                    System.out.println("3. Hotel");
                    int tipoMedio = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.println("Ingrese los datos del cliente:");
                    System.out.print("Nombre: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Rut: ");
                    String rutCliente = scanner.nextLine();
                    DatosCliente datosCliente = new DatosCliente(nombreCliente, rutCliente);

                    System.out.print("Ingrese el valor base por noche: ");
                    int valorBaseNoche = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.print("Ingrese el tipo de temporada (alta, media, baja): ");
                    String tipoTemporada = scanner.nextLine();

                    switch (tipoMedio) {
                        case 1:
                            // Ingresar Carpa
                            System.out.print("Ingrese la cantidad de noches: ");
                            int cantidadNochesCarpa = scanner.nextInt();
                            System.out.print("Ingrese la cantidad de personas: ");
                            int cantidadPersonasCarpa = scanner.nextInt();

                            Carpa carpa = new Carpa(valorBaseNoche, tipoTemporada, datosCliente,
                                    cantidadNochesCarpa, cantidadPersonasCarpa);
                            empresa.ingresarMedioAlojamiento(carpa);
                            break;
                        case 2:
                            // Ingresar Cabagna
                            System.out.print("Ingrese la capacidad: ");
                            int capacidadCabagna = scanner.nextInt();
                            System.out.print("¿Es fumador? (true/false): ");
                            boolean esFumadorCabagna = scanner.nextBoolean();
                            System.out.print("Ingrese la cantidad de noches: ");
                            int cantidadNochesCabagna = scanner.nextInt();
                            System.out.print("¿Tiene chimenea? (true/false): ");
                            boolean chimeneaCabagna = scanner.nextBoolean();

                            Cabagna cabagna = new Cabagna(valorBaseNoche, tipoTemporada, datosCliente,
                                    capacidadCabagna, esFumadorCabagna, cantidadNochesCabagna, chimeneaCabagna);
                            empresa.ingresarMedioAlojamiento(cabagna);
                            break;
                        case 3:
                            // Ingresar Hotel
                            System.out.print("¿Con desayuno? (true/false): ");
                            boolean conDesayunoHotel = scanner.nextBoolean();

                            int cantidadNochesHotel = 0; // Asumiendo que se debe ingresar la cantidad de noches
                            Hotel hotel = new Hotel(valorBaseNoche, tipoTemporada, datosCliente,
                                    conDesayunoHotel, cantidadNochesHotel);
                            empresa.ingresarMedioAlojamiento(hotel);
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;

                case 2:
                    // Mostrar Medios de Alojamiento
                    empresa.mostrarMediosAlojamiento();
                    break;

                case 3:
                    // Mostrar Datos de un Cliente
                    System.out.print("Ingrese el Rut del Cliente: ");
                    rutCliente = scanner.nextLine();
                    empresa.mostrarDatosCliente(rutCliente);
                    break;

                case 4:
                    // Total Adicional
                    System.out.println("Total Adicional: " + empresa.totalAdicional());
                    break;

                case 5:
                    // Total Bono Descuento
                    System.out.println("Total Bono Descuento: " + empresa.totalBonoDescuento());
                    break;

                case 6:
                    // Cantidad Medios de Alojamiento X
                    System.out.print("Ingrese el tipo de Medio (Carpa, Cabagna, Hotel): ");
                    String tipoMedioConsulta = scanner.nextLine();
                    System.out.println("Cantidad de Medios de Alojamiento " + tipoMedioConsulta + ": " +
                            empresa.cantidadMediosAlojamiento(tipoMedioConsulta));
                    break;

                case 7:
                    // Valor a Cancelar por un Cliente X
                    System.out.print("Ingrese el Rut del Cliente: ");
                    rutCliente = scanner.nextLine();
                    int valorCancelar = empresa.valorCancelarCliente(rutCliente);
                    if (valorCancelar != -1) {
                        System.out.println("Valor a Cancelar por el Cliente " + rutCliente + ": " + valorCancelar);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 8:
                    // Aplicar Incremento del Valor Base
                    empresa.aplicarIncremento();
                    System.out.println("Incremento aplicado a Cabañas con capacidad superior a 5.");
                    break;

                case 9:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 9);
    }
}
