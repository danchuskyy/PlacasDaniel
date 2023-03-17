/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.m03poomorenodaniel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author danch
 */
public class M03POOMorenoDaniel {

    public static void main(String[] args) {
        //creamos el scanner 
        Scanner scanner = new Scanner(System.in);
        String comando;

        //creo un arraylist para meter las casas
        ArrayList<Casa> listadecasas = new ArrayList<>();

        //tengo la variable quit para hacer el programa (quit)
        Boolean quit = false;

        do {

            //muestro por pantalla paa que el usuario ponga el comando
            System.out.print("> ");
            comando = scanner.nextLine();

            // hago un split del comando
            String[] comandosplit = comando.split(" ");     //split del comando

            //empieza el programa, le digo que coja la posicion 0
            switch (comandosplit[0].toLowerCase()) {    //lo ponemos en minuscula

                //creo los casos 
                case "addcasa":

                    //creo una condicion diciendo que el parametro introducido por el usuario tiene que ser igual a 4
                    if (comandosplit.length == 4) {

                        //creo una condicion que comprueba la longitud del DNI
                        if (comandosplit[1].length() == 9) {

                            //creo una condicion el cual si la posicion 2(nombre del cliente), es in integer, muestre un error
                            if (!comandosplit[2].matches("\\d")) {

                                //creo una condicion el cual si en la posicion 3(superficie), encuentra una letra de la A-Z o $ = simbolo raro, muestre un error
                                if (!comandosplit[3].matches("[a-zA-Z]+$")) {

                                    //hago un parseint para convertir la superficio en integer, estaba en string
                                    int posi3 = Integer.parseInt(comandosplit[3]);

                                    // condicion diciendo que superficie tiene que ser mayor que 10 m2
                                    if (posi3 > 10) {

                                        Boolean inlista = dbcasa(comandosplit[1], listadecasas);

                                        if (inlista == false) {

                                            //creo un OBJETO llamado EJEMPLOCASA
                                            Casa objetocasa = new Casa(comandosplit[1], comandosplit[2], posi3, true);

                                            //añado el objeto a la lista de casas
                                            listadecasas.add(objetocasa);

                                            System.out.println("OK: Casa registrada.");

                                        } else {
                                            System.out.println("Este nif esta repetido");
                                        }
                                    } else {     //si la superficie es menor que 10, te muestra un error
                                        System.out.println("ERROR: Superfície incorrecta. Ha de ser més gran de 10.");
                                    }
                                } else {
                                    System.out.println(" ERROR: La posición 3 (superficie), contiene un string, pon un integer");
                                }
                            } else {
                                System.out.println("ERROR:  La posición 2(nombre) és in Integer, pon un nombre");
                            }
                        } else {
                            System.out.println("ERROR:  Dni incorrecto");
                        }

                    } else {   // si no contiene 4 parametros te salta un error
                        System.out.println("ERROR: Número de paràmetres incorrecte ");
                    }

                    break;

                case "addplaca":

                    // condicion que los parametros sean igual a 5 
                    if (comandosplit.length == 5) {

                        //creo una condicion que comprueba la longitud del DNI
                        if (comandosplit[1].length() == 9) {

                            //hago un parseint para convertir la superficio en integer, estaba en string
                            int intsuperficie = Integer.parseInt(comandosplit[2]);

                            // condicion diciendo que superficie tiene que ser mayor que 0 m2
                            if (intsuperficie > 0) {

                                //hago un parseint para convertir la preu en float, estaba en string
                                Float preu = Float.parseFloat(comandosplit[3]);

                                // condicion diciendo que el preu tiene que ser mayor que 0 m2
                                if (preu > 0) {

                                    //hago un parseint para convertir la potencia en integer, estaba en string
                                    int intpotencia = Integer.parseInt(comandosplit[4]);

                                    // condicion diciendo que superficie tiene que ser mayor que 10 m2
                                    if (intpotencia > 0) {
                                        //creo un OBJETO llamado objetocasa
                                        Placa objetoplaca = new Placa(intsuperficie, preu, intpotencia);

                                        //hago un bucle recorriendo la lista de casas, si coincide el Dni, se añade la placa a esa casa
                                        for (Casa casaindividual : listadecasas) {
                                            //le digo que si el dni coincide, ejecute el comando
                                            if (comandosplit[1].equals(casaindividual.getNif())) {

                                                //añado la placa a la casa
                                                casaindividual.agregarObjetoPlaca(objetoplaca);
                                                System.out.println("Placa afegida a la casa.");

                                            } else {
                                                System.out.println("ERROR:  No hay una casa con este nif ");
                                            }
                                        }

                                    } else {
                                        System.out.println("ERROR: Potència incorrecta. Ha de ser més gran de 0");
                                    }
                                } else {
                                    System.out.println("ERROR: Preu incorrecte. Ha de ser més gran de 0.");
                                }
                            } else {
                                System.out.println("ERROR: Superfície incorrecta. Ha de ser més gran que 0.");
                            }
                        } else {
                            System.out.println("ERROR: Dni incorrecto");
                        }
                    } else {
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                    }

                    break;
                case "addaparell":

                    // condicion que los parametros sean igual a 4
                    if (comandosplit.length == 4) {

                        //creo una condicion que comprueba la longitud del DNI
                        if (comandosplit[1].length() == 9) {

                            //hago un parseint para convertir la superficio en integer, estaba en string
                            int intpotencia = Integer.parseInt(comandosplit[3]);

                            // condicion diciendo que LA POTENCIA tiene que ser mayor que 0w
                            if (intpotencia > 0) {
                                Boolean inlista = dbcasa(comandosplit[1], listadecasas);
                                if (inlista == true) {
                                    //creo un OBJETO llamado OBJETOAPARELL
                                    Aparell objetoAparell = new Aparell(comandosplit[2], intpotencia);

                                    //recorro la lista de casas y añado la placa
                                    for (Casa casaindividual : listadecasas) {
                                        if (comandosplit[1].equals(casaindividual.getNif())) {
                                            //añado el objeto placa
                                            casaindividual.agregarObjetoAparell(objetoAparell);
                                            System.out.println("Aparell afegit a la casa.");

                                        } else {
                                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif. ");
                                        }
                                    }
                                } else {
                                    System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif. ");
                                }
                            } else {
                                System.out.println("ERROR: Potència incorrecte. Ha de ser més gran de 0. ");
                            }
                        } else {
                            System.out.println("ERROR: Dni incorrecto");
                        }
                    } else {
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                    }

                    break;
                case "oncasa":

                    //creo una condicion diciendo que el parametro introducido por el usuario tiene que ser igual a 2
                    if (comandosplit.length == 2) {

                        //creo una condicion que comprueba la longitud del DNI
                        if (comandosplit[1].length() == 9) {
                            Boolean inlista = dbcasa(comandosplit[1], listadecasas);
                            //si el dni esta en la lista, ejecuta el comando/orden
                            if (inlista == true) {
                                for (Casa casaindividual : listadecasas) {
                                    if (comandosplit[1].equals(casaindividual.getNif())) {
                                        //llamo al metodo onPlomos para que encienda el plomo de la casa especificada
                                        onPlomos(casaindividual);

                                    } else {
                                        System.out.println("");
                                    }
                                }
                            } else {
                                System.out.println("ERROR: Este nif no está registrado. ");
                            }
                        } else {
                            System.out.println("ERROR: Dni incorrecto. ");
                        }
                    } else {
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                    }

                    break;
                case "onaparell":

                    //creo una condicion diciendo que el parametro introducido por el usuario tiene que ser igual a 3
                    if (comandosplit.length == 3) {

                        //creo una condicion que comprueba la longitud del DNI
                        if (comandosplit[1].length() == 9) {
                            Boolean incasaAparell = dbcasa(comandosplit[1], listadecasas);
                            //llamo al metodo el cual si la descripcion no esta en la lista, que no pueda encender el aparato.
                            if (incasaAparell == true) {
                                for (Casa casaindividual : listadecasas) {
                                    if (comandosplit[1].equals(casaindividual.getNif())) {
                                        ArrayList<Aparell> listaaparells = casaindividual.getAparells();
                                        for (int x = 0; x < listaaparells.size(); x++) {
                                            onPlomosAparells(listaaparells.get(x));
                                        }

                                    }
                                }
                            } else {
                                System.out.println("ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada. ");
                            }
                        } else {
                            System.out.println("ERROR: Dni incorrecto. ");
                        }
                    } else {
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                    }

                    break;
                case "offaparell":

                    //creo una condicion diciendo que el parametro introducido por el usuario tiene que ser igual a 3
                    if (comandosplit.length == 3) {

                        //creo una condicion que comprueba la longitud del DNI
                        if (comandosplit[1].length() == 9) {
                            Boolean incasaAparell = dbcasa(comandosplit[1], listadecasas);

                            if (incasaAparell == true) {
                                for (Casa casaindividual : listadecasas) {
                                    if (comandosplit[1].equals(casaindividual.getNif())) {
                                        ArrayList<Aparell> listaaparells = casaindividual.getAparells();
                                        //hago un bucle recorriendo a lista de casas, y una vez ha encontrado la casa por el NIF, hago otro bucle recorriendo la lista de aparells
                                        for (int x = 0; x < listaaparells.size(); x++) {
                                            offPlomosAparells(listaaparells.get(x));
                                        }

                                    }
                                }
                            } else {
                                System.out.println("ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada. ");
                            }
                        } else {
                            System.out.println("ERROR: Dni incorrecto. ");
                        }
                    } else {
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                    }

                    break;
                case "list":
                    if (comandosplit.length == 1) {
                        System.out.println("--- Endolls Solars, S.L. ---");
                        System.out.println("Cases enregistrades: " + listadecasas.size());
                        System.out.println("");

                        if (listadecasas.size() >= 1) {
                            //creo un bucle llamando a la clase Casa, le doy el nombre de la variable i, y que recorra la listadecasas.

                            for (Casa i : listadecasas) {
                                System.out.print("Casa: ");
                                System.out.println("Client: " + i.getNif() + " - " + i.getNom());
                                System.out.println("Superficie de la teulada: " + i.getSuperficie());

                                //creo un arraylist metiendo el contenido de una casa (i)
                                ArrayList<Placa> listaplacas = i.getPlacas();

                                ArrayList<Aparell> listaaparells = i.getAparells();

                                //recorro la lista de placas de una casa y lo muestro por pantalla
                                for (int x = 0; x < listaplacas.size(); x++) {
                                    System.out.println("La placa " + (x + 1) + " tiene " + listaplacas.get(x).getSuperficie() + " metros cuadrados.");
                                }
                                System.out.println("Plaques solars instal·lades: " + listaplacas.size());
                                System.out.println("Aparells registrats:: " + listaaparells.size());
                            }

                        } else {
                            System.out.println("ERROR: No hay casas añadidas");
                        }
                    } else {
                        System.out.println("ERROR: Número de paràmetres incorrecte. ");
                    }
                    break;

                case "info":

                    //creo una condicion diciendo que el parametro introducido por el usuario tiene que ser igual a 4
                    if (comandosplit.length == 2) {

                        //creo una condicion que comprueba la longitud del DNI
                        if (comandosplit[1].length() == 9) {
                            Boolean inlista = dbcasa(comandosplit[1], listadecasas);

                            if (inlista == true) {
                                double suma = 0;
                                for (Casa i : listadecasas) {

                                    System.out.println("Client: " + i.getNif() + " - " + i.getNom());

                                    //creo un arraylist metiendo el contenido de una casa
                                    ArrayList<Placa> listaplacas = i.getPlacas();

                                    System.out.println("Plaques solars instal·lades: " + listaplacas.size());
                                    for (int x = 0; x < listaplacas.size(); x++) {

                                        System.out.print("Inversió total: ");
                                        //hago la suma del arraylist del precio de las placas
                                        System.out.print(suma += listaplacas.get(x).getPreu());
                                        System.out.println(" €");
                                        
                                    }
                                    System.out.println("Potencia total X W");

                                    //me falta por hacer la suma del precio del arraylist
                                }

                            } else {
                                System.out.println("ERROR:  Este nif no está registrado. ");
                            }
                        } else {
                            System.out.println("ERROR:  Dni incorrecto. ");
                        }
                    } else {
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                    }

                    break;

                case "quit":
                    if (comandosplit.length == 1) {
                        quit = true;
                        // Finalizar el bucle si se introduce el comando "salir"
                        //System.out.println("Saliendo del programa...");
                    } else {
                        System.out.println("ERROR:  Número de paràmetres incorrecte. ");
                    }
                    break;

                default:
                    // Mensaje de error si se introduce un comando desconocido
                    System.out.println("ERROR:  Comando desconocido. Introduce un comando válido.");
                    break;
            }

        } while (quit != true);
    }

    //creo un metodo el cual es un boolean y se llama db casa y entre parentesis le dare los datos de entrada
    //en este caso los datos de entrada es el NIF que escribe 
    private static boolean dbcasa(String nif, ArrayList<Casa> listadecasas) {

        //hago un bucle recorriendo la lista de casas
        for (int i = 0; i < listadecasas.size(); i++) {
            if (nif.equals(listadecasas.get(i).getNif())) {
                return true;
            }

        }
        return false;

    }

    //tengo que hacer que la clave primaria sea descripcion y no NIF de aparell
    private static boolean incasaAparell(String descripcio, ArrayList<Aparell> dbaparells) {

        //hago un bucle recorriendo la lista de casas
        for (int i = 0; i < dbaparells.size(); i++) {
            if (descripcio.equals(dbaparells)) {
                return true;
            }

        }
        return false;

    }

    public static void onPlomos(Casa x) {

        if (x.getPlomos() == true) {
            System.out.println("La casa ja té l'interruptor encès. ");

        } else {
            x.setPlomos();
            System.out.println("Ok, encès. ");
        }

    }

    public static void onPlomosAparells(Aparell i) {

        if (i.getPlomoAparell() == true) {
            System.out.println("La casa ja té l'interruptor encès. ");

        } else {
            i.setPlomosAparell();
            System.out.println("Ok, encès. ");
        }

    }

    public static void offPlomosAparells(Aparell i) {

        if (i.getPlomoAparell() == true) {
            i.offAparell();

        } else {
            System.out.println("L'aparell ja està apagat. ");
        }

    }
    //
}
