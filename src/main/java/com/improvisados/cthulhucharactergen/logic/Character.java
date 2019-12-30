/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.improvisados.cthulhucharactergen.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juacom99 <juacom04@gmail.com>
 */
public class Character
{
    private String name;
    private String player;
    private int age;
    private Sex sex;
    private String recidence;
    private String birthplace;
            
    private Rank strength;
    private Rank constitution;
    private Rank size;   
    private Rank dexterity;
    private Rank appearance;
    private Rank intelligence;    
    private Rank power;    
    private Rank education;
    
    private Rank luck;
    
    private boolean hasMayorWound;
    private boolean isParsialyInsane;
    private boolean isIndefiniteInsane;
    
    
    private int totalHP;
    private int currentHP;
    
    private int totalSanity;    
    private int currentSanity;
    
    private int totalMP;
    private int CurrentMP;
    
    private int movement;
    private int sanity;
    
    private int build;
    private String damagebonus;
    
    private Ocupation ocupation;
    private List<Skill> skills;

    public Character(String name,String player,int age,Sex sex,String recidence, String birthplace,int strength, int constitution,int size,int dexterity,int appearance, int intelligence, int power,int education, int luck)
    {
        //ATTRIBUTES
        this.name = name;
        this.player=player;
        this.age=age;
        this.sex=sex;
        this.recidence=recidence;
        this.birthplace=birthplace;
        
        this.strength = new Rank(strength);
        this.constitution = new Rank(constitution);
        this.size = new Rank(size);
        this.dexterity = new Rank(dexterity);
        this.appearance = new Rank(appearance);
        this.intelligence = new Rank(intelligence);
        this.power = new Rank(power);                
        this.education = new Rank(education);        
        this.luck = new Rank(luck);
        
        
        this.skills = new ArrayList<>();
        
                
        //DERIVATED ATTRIBUTES
        
        //HP
        this.totalHP=(constitution+size)/10;
        this.currentHP=this.totalHP;
        
        //SANITY
        this.totalSanity=power;
        this.currentSanity=this.totalSanity;
        
        //MP
        this.totalMP=power/5;
        this.CurrentMP=this.totalMP;
     
        //SANITY
        this.sanity=power;
        
        //MOV        
        if(this.strength.compareTo(this.size)==-1 && this.dexterity.compareTo(this.size)==-1)
        {
            this.movement=7;
        }
        else if(this.strength.compareTo(this.size)==1 && this.dexterity.compareTo(this.size)==1)
        {
            this.movement=9;
        }
        else if(this.strength.compareTo(this.size)>=0 || this.dexterity.compareTo(this.size)>=0)
        {
            this.movement=8;
        }
        
        //BUILD AND DAMAGE BONUS
        int strSiz=strength+size;
        
        if(2<=strSiz && strSiz<=64)
        {
             this.build=-2;
             this.damagebonus="-2";
        }
        else if(65<strSiz && strSiz<84)
        {
            this.build=-1;
             this.damagebonus="-1";
        }
        else if(85<strSiz && strSiz<124)
        {
            this.build=0;
             this.damagebonus="0";
        }
        else if(125<strSiz && strSiz<164)
        {
            this.build=1;
             this.damagebonus="1d4";
        }
        else if(165<strSiz && strSiz<204)
        {
            this.build=2;
             this.damagebonus="1d6";
        }
        else if(strSiz>=205)
        {
           
        }
       
            
    }
    
    @Override
    public String toString()
    {
        String lineBreak=System.lineSeparator();
        String ret=this.name+lineBreak;
        ret+="  STR: "+strength.toString()+"     APP: "+appearance.toString()+lineBreak;
        ret+="  CON: "+constitution.toString()+"     INT: "+intelligence.toString()+lineBreak;
        ret+="  SIZ: "+size.toString()+"     POW: "+power.toString()+lineBreak;
        ret+="  DEX: "+dexterity.toString()+"     EDU: "+education.toString()+lineBreak;
        ret+="          LUCK: "+luck.toString()+lineBreak;
        ret+="          MOV: "+this.movement+lineBreak;
        ret+="          HP: "+this.totalHP+"/"+this.currentHP+lineBreak;
        ret+="          MP: "+this.totalMP+"/"+this.CurrentMP+lineBreak;
        ret+="          SANITY: "+this.sanity+lineBreak;
        
        return ret;
    }
    
    
    
    
    
}
