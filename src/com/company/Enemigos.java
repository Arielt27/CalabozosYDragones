package com.company;
import java.util.Random;


public class Enemigos
{
    // ATRIBUTOS
    private String type;
    private int maxHealth = 0;
    private int health = 0;
    private int dammage = 0;
    private boolean potion = true;


    // OBJETOS
    Random rnd = new Random();


    // CONSTRUCTOR
    public Enemigos(String tipoEnemigo)
    {
        type = tipoEnemigo;
        maxHealth = rnd.nextInt(20);
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
        dammage = Main.rnd.nextInt(10);

        return dammage;
    }



}
