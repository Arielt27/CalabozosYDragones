package com.company;
import java.util.Random;
import java.util.Scanner;

//Como jugador entra a un calabozo y se puede encontrar con 5 diferentes tipos de enemigos
//al azar. Los enemigos pueden ser un dragón, un esqueleto, un zombie, un guerrero
//o un asesino. El héroe entra al calabozo con 3 pociones de salud y puede potencialmente
//conseguir más cuando derrote a un enemigo. Los enemigos realizan ataques al azar
//y le pueden bajar puntos de salud al héroe de forma aleatoria hasta un máximo de 10 puntos
//por ataque. El héroe inicia con 100 puntos de salud y los enemigos pueden tener hasta
//un máximo de 20 puntos de salud establecidos de forma aleatoria.
//Los ataques del héroe realizan daño de forma aleatoria al enemigo hasta un máximo
//de 15 puntos por ataque. Cuando un enemigo llega a tener 0 puntos de salud, entonces
//es derrotado y puede dejar caer una poción de salud, esto es aleatorio
//no siempre va dejar caer una poción de salud al ser derrotado.
//Las pociones de salud pueden restaurar 20 puntos de salud al héroe.
//El juego debe ser un calabozo infinito y termina cuando el héroe es derrotado
//por un enemigo. Por cada enemigo derrotado el héroe consigue puntos de experiencia,
//al morir el juego debe mostrar el nombre del héroe y cuantos puntos de experiencia
//logro conseguir.


public class Main
{
    // OBJETOS
    public static Calabozo dungeon = new Calabozo();
    public static Random rnd = new Random();
    public static Jugador Player = new Jugador();
    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args)
    {
        // VARIABLES
        int opc = 0;
        String action = " ";
        String help = "ayuda";
        String look = "mirar";
        String forward = "avanzar";
        String back = "retroceder";
        String right = "derecha";
        String left = "izquierda";
        String pick = "recoger";
        String heal = "curarse";
        String attack = "atacar";
        String defend = "defender";
        String exit = "salir";
        String ask;


        // MAIN
        System.out.println("****CALABOZOS Y DRAGONES****");
        System.out.println("*1- Iniciar Juego          *");
        System.out.println("*2- Instrucciones          *");
        System.out.println("*3- Salir                  *");
        System.out.println("****************************");
        System.out.print("Opc: ");
        opc = lector.nextInt();

        // Ciclo While para que el juego se ejecute infinitamente
        // hasta que el usuario ingrese el numero 3.
        while(opc!=3)
        {

            // Uso de Switch para entrar a las opciones del juego.
            switch(opc)
            {
                case 1: // INICIAR JUEGO

                    System.out.println(" ");
                    System.out.println("\t***CALABOZOS Y DRAGONES***");

                    boolean running = true;

                    while(running)
                    {
                        System.out.println(" ");

                        System.out.println("\t ¡Bienvenido al Calabozo!");
                        System.out.println(" ");

                        System.out.println("Tu salud es: " + Player.getHealth() + "%");
                        System.out.println("Tienes: " + Player.getPotion() + " pociones");
                        System.out.print("¿Que haces? ");
                        action = lector.next();

                        System.out.println(" ");

                        // ACCIONES QUE EL JUGADOR EJECUTA

                        // MIRAR
                        if(action.equals(look))
                        {
                            dungeon.verHabitacion();
                            System.out.println(" ");
                        }

                        // RECOGER POCION
                        if(action.equals(pick))
                        {
                            if(dungeon.getPotion() == 0)
                            {
                                System.out.println("No hay pociones disponibles");
                            }
                            else{
                                int playerPotion = Player.getPotion();
                                int dungeonPotion = dungeon.getPotion();

                                int totalPotion = playerPotion + dungeonPotion;

                                Player.setPotion(totalPotion);
                                System.out.println("Tienes: " + Player.getPotion() + " pociones");

                                System.out.println(" ");
                            }
                        }

                        // CURARSE
                        if(action.equals(heal))
                        {
                            if(Player.potion == 0)
                            {
                                System.out.println("No tienes pociones");
                            }
                            else{
                                Player.Heal();
                            }
                            System.out.println(" ");
                        }

                        // ATACAR
                        if(action.equals(attack))
                        {
                            System.out.println(" ");
                        }

                        // DEFENDER
                        if(action.equals(defend))
                        {
                            Player.Defend();
                            System.out.println(" ");
                        }

                        // CODIGO SI EL JUGADOR NO INGRESA UN COMANDO VALIDO
                        /*if(action != look && action != forward && action != back && action != left && action != right && action != pick && action != attack && action != defend && action != heal)
                        {
                            System.out.println(" ");
                            System.out.println("\t\t\t\t\t*Comando no encontrado*");
                            System.out.println("\t*Escribe 'ayuda' para consultar los comandos del juego*");
                            System.out.println(" ");
                        }*/

                        // CODIGO SI EL JUGADOR ESCRIBE AYUDA
                        if(action.equals(help))
                        {
                            System.out.println(" ");
                            System.out.println("Comandos: ");
                            System.out.println("mirar");
                            System.out.println("avanzar");
                            System.out.println("retroceder");
                            System.out.println("derecha");
                            System.out.println("izquierda");
                            System.out.println("recoger");
                            System.out.println("curarse");
                            System.out.println("atacar");
                            System.out.println("defender");
                            System.out.println("salir");
                            System.out.println(" ");
                        }

                        // SALIR
                        if(action.equals(exit))
                        {
                            running = false;
                        }
                    }

                    System.out.println(" ");
                    System.out.println("****CALABOZOS Y DRAGONES****");
                    System.out.println("*1- Iniciar Juego          *");
                    System.out.println("*2- Instrucciones          *");
                    System.out.println("*3- Salir                  *");
                    System.out.println("****************************");
                    System.out.print("Opc: ");
                    opc = lector.nextInt();

                    break;

                case 2: // INSTRUCCIONES

                    System.out.println(" ");
                    System.out.println("****CALABOZOS Y DRAGONES****");
                    System.out.println("Comandos: ");
                    System.out.println("mirar:      muestra descripción del cuarto actual, cantidad de enemigos y pociones.");
                    System.out.println("avanzar:    sale del cuarto por la salida norte y entra a un nuevo cuarto.");
                    System.out.println("retroceder: sale del cuarto por la salida sur y entra a un nuevo cuarto.");
                    System.out.println("derecha:    sale del cuarto por la salida este y entra a un nuevo cuarto.");
                    System.out.println("izquierda:  sale del cuarto por la salida oeste y entra a un nuevo cuarto.");
                    System.out.println("recoger:    recoge una pocion.");
                    System.out.println("curarse:    tomar pocion para restaurar 20 puntos de salud");
                    System.out.println("atacar:     atacar al enemigo.");
                    System.out.println("defender:   bloquear ataques enemigos por un turno.");
                    System.out.println("salir:      sale al menu principal del juego");

                    System.out.println(" ");

                    System.out.println("****CALABOZOS Y DRAGONES****");
                    System.out.println("*1- Iniciar Juego          *");
                    System.out.println("*2- Instrucciones          *");
                    System.out.println("*3- Salir                  *");
                    System.out.println("****************************");
                    System.out.print("Opc: ");
                    opc = lector.nextInt();

                    break;
            }
        }

        System.out.println(" ");
        System.out.println("\t Gracias por Jugar.");
    }
}