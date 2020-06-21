package com.company;
import java.util.Random;


public class Enemigos
{
    // ATRIBUTOS
    private int prob = 0;
    private String type;
    private int maxHealth = 0;
    private int health = 0;
    private int dammage = 0;
    private int potion = 0;


    // OBJETOS
    Random rnd = new Random();


    // CONSTRUCTOR
    public Enemigos(String tipoEnemigo)
    {
        type = tipoEnemigo;
        maxHealth = rnd.nextInt(20);
        health = maxHealth;
    }


    // GET y SET
    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getDammage()
    {
        return dammage;
    }

    public void setDammage(int dammage)
    {
        this.dammage = dammage;
    }


    // METODOS
    public int Atacar()
    {
        prob = Main.rnd.nextInt(2);

        if(prob == 1)
        {
            dammage = Main.rnd.nextInt(10);
        }else{
            dammage = 0;
            System.out.println("El enemigo no ataco");
        }

        return dammage;
    }

    public int dropPotion()
    {
        prob = Main.rnd.nextInt(2);
        if(prob == 1)
        {
            potion = 1;
        }else{
            potion = 0;
        }

        return potion;
    }
}
