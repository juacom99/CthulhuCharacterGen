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
            
    private Rank STR;
    private Rank CON;
    private Rank POW;
    private Rank DEX;
    private Rank APP;
    private Rank INT;
    private Rank EDU;
    private Rank SIZ;    
    private Rank LUK;
    
    private boolean hasMayorWound;
    private boolean isParsialyInsane;
    private boolean isIndefiniteInsane;
    
    
    private int TOTAL_HP;
    private int CURRENT_HP;
    
    private int TOTAL_SANITY;    
    private int CURRENT_SANITY;
    
    private int TOTAL_MP;
    private int CURRENT_MP;
    
    private int MOV;
    private Ocupation ocupation;
    private List<Skill> skills;

    public Character(String name, int STR, int CON,int SIZ,int DEX,int APP, int INT, int POW,int EDU, int LUK)
    {
        this.name = name;
        this.STR = new Rank(STR);
        this.CON = new Rank(CON);
        this.POW = new Rank(POW);
        this.DEX = new Rank(DEX);
        this.APP = new Rank(APP);
        this.INT = new Rank(INT);
        this.EDU = new Rank(EDU);
        this.SIZ = new Rank(SIZ);
        this.LUK = new Rank(LUK);
        this.skills = new ArrayList<>();
        
        
        if(this.STR.compareTo(this.SIZ)==-1 && this.DEX.compareTo(this.SIZ)==-1)
        {
            this.MOV=7;
        }
        else if(this.STR.compareTo(this.SIZ)==1 && this.DEX.compareTo(this.SIZ)==1)
        {
            this.MOV=9;
        }
        else if(this.STR.compareTo(this.SIZ)>=0 || this.DEX.compareTo(this.SIZ)>=0)
        {
            this.MOV=8;
        }
        
        this.TOTAL_HP=(CON+SIZ)/10;
        this.CURRENT_HP=this.TOTAL_HP;
    }

    public Character()
    {
    }

    
    
    @Override
    public String toString()
    {
        String lineBreak=System.lineSeparator();
        String ret=this.name+lineBreak;
        ret+="  STR: "+STR.toString()+"     APP: "+APP.toString()+lineBreak;
        ret+="  CON: "+CON.toString()+"     INT: "+INT.toString()+lineBreak;
        ret+="  SIZ: "+SIZ.toString()+"     POW: "+POW.toString()+lineBreak;
        ret+="  DEX: "+DEX.toString()+"     EDU: "+EDU.toString()+lineBreak;
        ret+="          LUCK: "+LUK.toString()+lineBreak;
        ret+="          MOV: "+this.MOV+lineBreak;
        ret+="          HP: "+this.TOTAL_HP+"/"+this.CURRENT_HP+lineBreak;
        return ret;
    }
    
    
    
    
    
}
