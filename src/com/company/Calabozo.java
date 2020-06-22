package com.company;
import java.util.Random;


public class Calabozo
{
    // ATRIBUTOS
    private static int potion = 0;
    private static int habitacion = 0;
    private static int habitacionAnterior;
    private static Enemigos Enemy1;
    private static Enemigos Enemy2;
    private static String Dragon = "dragon";
    private static String Esqueleto = "esqueleto";
    private static String Zombie = "zombie";
    private static String Guerrero = "guerrero";
    private static String Asesino = "asesino";


    // LISTAS
    public static Enemigos[] enemigos = new Enemigos[7];


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

        potion = rnd.nextInt(2);
        habitacion = rnd.nextInt(40);
        Enemy1 = enemigos[rnd.nextInt(4)];
        Enemy2 = enemigos[rnd.nextInt(4)];
    }


    // GET y SET
    public static int getHabitacion()
    {
        return habitacion;
    }

    public static void setHabitacion(int habitacion)
    {
        Calabozo.habitacion = habitacion;
    }

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
        int prob = 0;
        int prob2 = 0;
        prob = Main.rnd.nextInt(2);
        prob2 = Main.rnd.nextInt(2);

        System.out.println("Estas en el cuarto " + habitacion);
        System.out.println("Hay " + potion + " pociones");

        if(prob == 1)
        {
            System.out.println("Hay un " + Enemy1.getType() + " con " + Enemy1.getMaxHealth() + "% de salud");
        }

        if(prob2 == 1)
        {
            System.out.println("Hay un " + Enemy2.getType() + " con " + Enemy2.getMaxHealth() + "% de salud");
        }

        if((prob == 0) & (prob2 == 0))
        {
            System.out.println("No hay enemigos en esta habitación");
        }
    }

    public void avanzar()
    {
        habitacionAnterior = habitacion;

        int nuevahabitacion = Main.rnd.nextInt(40);

        if(nuevahabitacion == habitacionAnterior)
        {
            nuevahabitacion = Main.rnd.nextInt(40);
        }
        else if(nuevahabitacion == habitacion)
        {
            nuevahabitacion = Main.rnd.nextInt(40);
        }else{
            habitacion = nuevahabitacion;
            potion = rnd.nextInt(2);
            Enemy1 = enemigos[rnd.nextInt(4)];
            Enemy2 = enemigos[rnd.nextInt(4)];
        }
    }

    public void retroceder()
    {
        int nuevahabitacion = habitacionAnterior;
    }

    public void derecha()
    {
        habitacionAnterior = habitacion;

        int nuevahabitacion = Main.rnd.nextInt(40);

        if(nuevahabitacion == habitacionAnterior)
        {
            nuevahabitacion = Main.rnd.nextInt(40);
        }
        else if(nuevahabitacion == habitacion)
        {
            nuevahabitacion = Main.rnd.nextInt(40);
        }else{
            habitacion = nuevahabitacion;
            potion = rnd.nextInt(2);
            Enemy1 = enemigos[rnd.nextInt(4)];
            Enemy2 = enemigos[rnd.nextInt(4)];
        }
    }

    public void izquierda()
    {
        habitacionAnterior = habitacion;

        int nuevahabitacion = Main.rnd.nextInt(40);

        if(nuevahabitacion == habitacionAnterior)
        {
            nuevahabitacion = Main.rnd.nextInt(40);
        }
        else if(nuevahabitacion == habitacion)
        {
            nuevahabitacion = Main.rnd.nextInt(40);
        }else{
            habitacion = nuevahabitacion;
            potion = rnd.nextInt(2);
            Enemy1 = enemigos[rnd.nextInt(4)];
            Enemy2 = enemigos[rnd.nextInt(4)];
        }
    }
}
