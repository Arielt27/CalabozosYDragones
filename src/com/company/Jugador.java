package com.company;

import java.util.ArrayList;

public class Jugador
{
    // ATRIBUTOS
    int maxHealth = 100;
    int health = 0;
    int potion = 0;
    int exp = 0;
    int dammage = 0;
    int maxDefense = 20;
    int defense = 0;


    // CONSTRUCTOR
    public Jugador()
    {
        health = maxHealth;
        defense = maxDefense;
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

    public int getDefense()
    {
        return defense;
    }

    public void setDefense(int defense)
    {
        this.defense = defense;
    }


    // METODOS
    public void avanzar()
    {

    }

    public void pickUpPotion()
    {
        potion = potion + 1;
    }

    public void Heal()
    {
        if(health == 100)
        {
            System.out.println("Ya tienes el maximo de salud");
        }
        else{
            health = health + 20;
            if(health > 100)
            {
                health = 100;
                potion = potion - 1;
            }
        }
    }

    public int Attack()
    {
        dammage = Main.rnd.nextInt(15);

        return dammage;
    }

    public int Defend()
    {
        return defense;
    }
}
