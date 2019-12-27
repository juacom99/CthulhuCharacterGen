/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.improvisados.cthulhucharactergen.logic;

import java.security.InvalidParameterException;

/**
 *
 * @author juacom99 <juacom04@gmail.com>
 */
public class Skill
{
    private String name;
    private Rank ranks;
    private int defaultValue;
    private boolean isFromProfession;
    private boolean isFromModernEra;

    public Skill(String name, int defaultValue,boolean isFromProfession, boolean isFromModernEra) throws InvalidParameterException
    {
            if(name!=null && name.trim().length()>0)
            {
                this.name = name;
                this.defaultValue=defaultValue;
                this.ranks = new Rank(defaultValue);
                this.isFromProfession=isFromProfession;
                this.isFromModernEra = isFromModernEra;
            }
            else
            {
                throw new InvalidParameterException("The skill name can't be blank");
            }
    }
    
    public Skill(String name, int defaultValue,int minValue, boolean isFromProfession, boolean isFromModernEra) throws InvalidParameterException
    {
            if(name!=null && name.trim().length()>0)
            {
                this.name = name;
                this.defaultValue=defaultValue;
                this.ranks = new Rank(defaultValue,minValue);
                this.isFromProfession=isFromProfession;
                this.isFromModernEra = isFromModernEra;
            }
            else
            {
                throw new InvalidParameterException("The skill name can't be blank");
            }
    }
    
    public int buy(int ammount)
    {
        return ranks.buy(ammount);
    }
    
    public int sell(int ammount)
    {
        return ranks.sell(ammount);
    }

    @Override
    public String toString()
    {
        String ret="";
        
        if(this.isFromProfession)
        {
            ret+="● ";
        }
        else
        {
            ret+="○ ";
        }
        ret+=this.name+"      "+ranks.toString();
        
        if(isFromModernEra)
        {
            ret+=" ₪";
        }
        return ret;
    }    
}
