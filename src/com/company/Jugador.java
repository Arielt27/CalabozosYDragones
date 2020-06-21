package com.company;

import java.util.ArrayList;

public class Jugador
{
    // ATRIBUTOS
    int maxHealth = 0;
    int health = 0;
    int potion = 0;
    int exp = 0;
    int dammage = 0;


    // CONSTRUCTOR
    public Jugador()
    {
        maxHealth = 100;
        potion = 3;
        exp = 0;
    }


    // GET Y SET
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

    public int getPotion()
    {
        return potion;
    }

    public void setPotion(int potion)
    {
        this.potion = potion;
    }

    public int getExp()
    {
        return exp;
    }

    public void setExp(int exp)
    {
        this.exp = exp;
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
        dammage = Main.rnd.nextInt(15);

        return dammage;
    }






}
