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
        System.out.println(" ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t****CALABOZOS Y DRAGONES****");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*1- Iniciar Juego          *");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*2- Instrucciones          *");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*3- Salir                  *");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t****************************");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOpc: ");
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
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t****CALABOZOS Y DRAGONES****");

                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ¡Bienvenido al Calabozo!");
                    System.out.println(" ");

                    boolean running = true;

                    while(running)
                    {
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
                        }

                        // AVANZAR
                        if(action.equals(forward))
                        {
                            dungeon.avanzar();
                        }

                        // RETROCEDER
                        if(action.equals(back))
                        {
                            dungeon.retroceder();
                        }

                        // DERECHA
                        if(action.equals(right))
                        {
                            dungeon.derecha();
                        }

                        // IZQUIERDA
                        if(action.equals(left))
                        {
                            dungeon.izquierda();
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
                        }

                        // ATACAR
                        if(action.equals(attack))
                        {
                            // JUGADOR ATACA

                            int atkPlayer = Player.Attack();
                            int healtEnemy = Calabozo.getEnemy1().getHealth();
                            int enemyHealth = healtEnemy - atkPlayer;

                            while(enemyHealth > 0)
                            {
                                System.out.println("Atacas al " + Calabozo.getEnemy1().getType() + " y le haces " + atkPlayer + " de daño");

                                if(enemyHealth < 0)
                                {
                                    int expActual = Player.getExp();
                                    int expObtenida = rnd.nextInt(10);
                                    int expTotal = expActual + expObtenida;
                                    Player.setExp(expTotal);

                                    int pocionesCalabozo = Calabozo.getPotion();
                                    int dropPocion = Calabozo.getEnemy1().dropPotion();

                                    if(dropPocion == 1)
                                    {
                                        int totalPocionesCalabozo = pocionesCalabozo + dropPocion;
                                        System.out.println("El enemigo solto " + totalPocionesCalabozo + " pocion");
                                    }

                                    System.out.println("Enemigo Derrotado");
                                    System.out.println("Experiencia obtenida: " + expObtenida);
                                }

                                // ENEMIGO ATACA
                                int ataqueEnemigo = Calabozo.getEnemy1().Atacar();
                                int playerMaxHealth = Player.getHealth();
                                int calculoDaño = playerMaxHealth - ataqueEnemigo;
                                Player.setHealth(calculoDaño);

                                System.out.println("El daño recibido es: " + ataqueEnemigo);
                                System.out.println("Tu salud es: " + Player.getHealth() + "%");



                                System.out.print("¿Que haces? ");
                                action = lector.next();
                                System.out.println(" ");

                                // ACTION ADELANTA BLOQUEADA
                                if(action.equals(forward))
                                {
                                    System.out.println("No puedes moverte en medio de una batalla");
                                }

                                // ACTION RETROCEDER BLOQUEADA
                                if(action.equals(back))
                                {
                                    System.out.println("No puedes moverte en medio de una batalla");
                                }

                                // ACTION DERECHA BLOQUEADA
                                if(action.equals(right))
                                {
                                    System.out.println("No puedes moverte en medio de una batalla");
                                }

                                // ACTION IZQUIERDA BLOQUEADA
                                if(action.equals(left))
                                {
                                    System.out.println("No puedes moverte en medio de una batalla");
                                }
                            }


                            //int ataque2 = Calabozo.getEnemy2().Atacar();
                        }

                        // DEFENDER
                        if(action.equals(defend))
                        {
                            int defensa = Player.Defend();
                            int ataque = Calabozo.Enemigo1.Atacar();
                            int calculoDefensa = defensa - ataque;

                            if(calculoDefensa <= 0)
                            {
                                calculoDefensa = 0;
                            }

                            Player.setDefense(calculoDefensa);

                            if(defensa == 0)
                            {
                                System.out.println("Ya no tienes puntos de defensa");
                            }else{
                                System.out.println("Ataque recibido: " + ataque);
                                System.out.println("Defensa: " + calculoDefensa);
                                System.out.println(" ");
                            }
                        }

                        // CODIGO SI EL JUGADOR NO INGRESA UN COMANDO VALIDO
                        /*if((action != look) & (action != forward) & (action != back) & (action != left) & (action != right) & (action != pick) & (action != attack) & (action != defend) & (action != heal))
                        {
                            System.out.println(" ");
                            System.out.println("\t\t\t\t\t*Comando no encontrado*");
                            System.out.println("\t*Escribe 'ayuda' para consultar los comandos del juego*");
                            System.out.println(" ");
                        }else{
                            System.out.println(" ");
                        }*/

                        // CODIGO SI EL JUGADOR ESCRIBE AYUDA
                        if(action.equals(help))
                        {
                            System.out.println(" ");
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  COMANDOS: ");
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   mirar");
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   avanzar");
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   retroceder");
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   derecha");
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   izquierda");
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   recoger");
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   curarse");
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   atacar");
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   defender");
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   salir");
                            System.out.println(" ");
                        }

                        // SALIR
                        if(action.equals(exit))
                        {
                            running = false;
                        }
                    }

                    System.out.println(" ");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t****CALABOZOS Y DRAGONES****");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*1- Iniciar Juego          *");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*2- Instrucciones          *");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*3- Salir                  *");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t****************************");
                    System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOpc: ");
                    opc = lector.nextInt();

                    break;

                case 2: // INSTRUCCIONES

                    System.out.println(" ");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t****CALABOZOS Y DRAGONES****");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  Comandos: ");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\tmirar:      muestra descripción del cuarto actual, cantidad de enemigos y pociones.");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\tavanzar:    sale del cuarto por la salida norte y entra a un nuevo cuarto.");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\tretroceder: sale del cuarto por la salida sur y entra a un nuevo cuarto.");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\tderecha:    sale del cuarto por la salida este y entra a un nuevo cuarto.");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\tizquierda:  sale del cuarto por la salida oeste y entra a un nuevo cuarto.");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\trecoger:    recoge una pocion.");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\tcurarse:    tomar pocion para restaurar 20 puntos de salud.");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\tatacar:     atacar al enemigo.");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\tdefender:   bloquear ataques enemigos por un turno.");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\tsalir:      sale al menu principal del juego.");

                    System.out.println(" ");

                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t****CALABOZOS Y DRAGONES****");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*1- Iniciar Juego          *");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*2- Instrucciones          *");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*3- Salir                  *");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t****************************");
                    System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOpc: ");
                    opc = lector.nextInt();

                    break;
            }
        }

        System.out.println(" ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ¡Gracias por Jugar!");
    }
}