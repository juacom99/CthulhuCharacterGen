/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.improvisados.cthulhucharactergen;

import com.improvisados.cthulhucharactergen.logic.Character;
import com.improvisados.cthulhucharactergen.logic.Sex;
import com.improvisados.jdiceroller.JDiceRoller;
/**
 * 
 * @author juacom99 <juacom04@gmail.com>
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        JDiceRoller roller=new JDiceRoller();
        
        //JDiceRoller.add( roller.roll(3,6))
        
        int STR=50;//JDiceRoller.add( roller.roll(3,6));
        int CON=JDiceRoller.add( roller.roll(3,6))*5;
        int SIZ=50;//JDiceRoller.add( roller.roll(2,6))+6;
        int DEX=50;//JDiceRoller.add( roller.roll(3,6));
        int APP=JDiceRoller.add( roller.roll(3,6))*5;
        int INT=(JDiceRoller.add( roller.roll(2,6))+6)*5;
        int POW=JDiceRoller.add( roller.roll(3,6))*5;
        int EDU=(JDiceRoller.add( roller.roll(2,6))+6)*5;
        int LUK=JDiceRoller.add( roller.roll(3,6))*5;
        
        Character cha=new Character("Prueba","juacom99",45,Sex.MALE,"Montevideo","Montevideo",STR,CON,SIZ,DEX,APP,INT,POW,EDU,LUK);
        System.out.println(cha);
           
    }
    
}
