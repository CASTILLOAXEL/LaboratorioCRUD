package org.example;


import org.example.Conexion.CRUD.PersonaCRUD;


                import java.util.Scanner;

                public class Main {

                    public static void main(String[] args) {
                        Scanner scanner = new Scanner(System.in);
                        PersonaCRUD personaCRUD = new PersonaCRUD();

                        boolean continuar = true;
                        while (continuar) {
                            System.out.println("Selecciona una opción:");
                            System.out.println("1. Insertar persona");
                            System.out.println("2. Mostrar personas");
                            System.out.println("3. Actualizar persona");
                            System.out.println("4. Eliminar persona");
                            System.out.println("5. Salir");

                            int opcion = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea después del nextInt()

                            switch (opcion) {
                                case 1:
                                    System.out.println("Ingrese el nombre:");
                                    String nombre = scanner.nextLine();
                                    System.out.println("Ingrese el Apellido:");
                                    String Apellido = scanner.nextLine();
                                    System.out.println("Ingrese la edad:");
                                    int edad = scanner.nextInt();
                                    scanner.nextLine(); // Consumir la nueva línea después del nextInt()
                                    System.out.println("Ingrese la ciudad:");
                                    String ciudad = scanner.nextLine();
                                    personaCRUD.insertarPersona(nombre,Apellido, edad, ciudad);
                                    break;
                                case 2:
                                    personaCRUD.mostrarPersonas();
                                    break;

                                case 3:
                                    System.out.println("Ingrese el nombre actual:");
                                    String nombreActual = scanner.nextLine();
                                    System.out.println("Ingrese el nuevo nombre:");
                                    String nuevoNombre = scanner.nextLine();
                                    personaCRUD.actualizarPersona(nombreActual, nuevoNombre);
                                    break;
                                case 4:
                                    System.out.println("Ingrese el nombre de la persona a eliminar:");
                                    String nombreEliminar = scanner.nextLine();
                                    personaCRUD.eliminarPersona(nombreEliminar);
                                    break;
                                case 5:
                                    continuar = false;
                                    break;
                                default:
                                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                            }
                        }

                        scanner.close();
                    }
                }


