package com.company;
import java.util.Random;


public class Calabozo
{
    // ATRIBUTOS
    public static String Dragon = "dragon";
    public static String Esqueleto = "esqueleto";
    public static String Zombie = "zombie";
    public static String Guerrero = "guerrero";
    public static String Asesino = "asesino";


    // LISTAS
    public static int[] Cuartos = new int[40];
    public static Enemigos[] enemigos = new Enemigos[5];


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

        for(int i = 0; i<Cuartos.length-1; i++)
        {
            
        }
    }


    // GET y SET


    // METODOS

}
