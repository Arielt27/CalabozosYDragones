package com.company;
import java.util.Random;


public class Calabozo
{
    // ATRIBUTOS
    private static int potion = 0;
    private static int habitacion = 0;
    private static Enemigos Enemy1;
    private static Enemigos Enemy2;
    private static String Dragon = "dragon";
    private static String Esqueleto = "esqueleto";
    private static String Zombie = "zombie";
    private static String Guerrero = "guerrero";
    private static String Asesino = "asesino";


    // LISTAS
    private static Enemigos[] enemigos = new Enemigos[7];


    // OBJETOS
    public static Enemigos Enemigo1 = new Enemigos(Dragon);
    public static Enemigos Enemigo2 = new Enemigos(Esqueleto);
    public static Enemigos Enemigo3 = new Enemigos(Zombie);
    public static Enemigos Enemigo4 = new Enemigos(Guerrero);
    public static Enemigos Enemigo5 = new Enemigos(Asesino);


    // OBJETOS
    Random rnd = new Random();


    // CONSTRUCTOR
    public Calabozo()
    {
        enemigos[0] = Enemigo1;
        enemigos[1] = Enemigo2;
        enemigos[2] = Enemigo3;
        enemigos[3] = Enemigo4;
        enemigos[4] = Enemigo5;

        Enemy1 = enemigos[rnd.nextInt(4)];
        Enemy2 = enemigos[rnd.nextInt(4)];

        habitacion = rnd.nextInt(40);

        potion = rnd.nextInt(2);
    }


    // GET y SET
    public static int getPotion()
    {
        return potion;
    }

    public static void setPotion(int potion)
    {
        Calabozo.potion = potion;
    }

    public static Enemigos getEnemy1()
    {
        return Enemy1;
    }

    public static void setEnemy1(Enemigos enemy1)
    {
        Enemy1 = enemy1;
    }

    public static Enemigos getEnemy2()
    {
        return Enemy2;
    }

    public static void setEnemy2(Enemigos enemy2)
    {
        Enemy2 = enemy2;
    }


    // METODOS
    public void verHabitacion()
    {
        System.out.println("Estas en el cuarto " + habitacion);
        System.out.println("Hay " + potion + " pociones");
        System.out.println("Hay un " + Enemy1.getType() + " con " + Enemy1.getMaxHealth() + "% de salud");
        System.out.println("Hay un " + Enemy2.getType() + " con " + Enemy2.getMaxHealth() + "% de salud");
    }

}
