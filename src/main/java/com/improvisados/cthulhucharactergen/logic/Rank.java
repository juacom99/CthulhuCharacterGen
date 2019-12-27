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
public class Rank implements Comparable<Rank>
{

    private int regular;
    private int minValue;

    public static final int CHECK_RESULT_FUMBLE = -2;
    public static final int CHECK_RESULT_FAILURE = -1;
    public static final int CHECK_RESULT_REGULAR = 1;
    public static final int CHECK_RESULT_HARD = 2;
    public static final int CHECK_RESULT_EXTREME = 3;
    public static final int CHECK_RESULT_CRITICAL_SUCCESS = 4;

    private static final int MIN_RANK_VALUE = 0;
    private static final int MAX_RANK_VALUE = 99;

    public Rank(int regularValue)
    {
        this(regularValue, Rank.MIN_RANK_VALUE);
    }

    public Rank(int regularValue, int minValue)
    {
        if (minValue >= Rank.MIN_RANK_VALUE)
        {
            if (regularValue >= minValue && regularValue <= Rank.MAX_RANK_VALUE)
            {

                this.regular = regularValue;
                this.minValue = minValue;
            }
            else
            {
                throw new InvalidParameterException("The regular value must be between " + minValue + " and " + Rank.MAX_RANK_VALUE);
            }
        }
        else
        {
            throw new InvalidParameterException("The Min value must be greater than " + Rank.MIN_RANK_VALUE);
        }
    }

    @Override
    public String toString()
    {
        String sRegular = String.format("%02d", this.regular);
        String sHard = String.format("%02d", this.regular / 2);
        String sExtreme = String.format("%02d", this.regular / 5);

        return sRegular + "/" + sHard + "/" + sExtreme;
    }

    public int getRegular() {
        return regular;
    }
    
    public int checkResult(int roll, int mod)
    {
        //check if roll between 1 and 100
        if (1 > roll || roll > 100)
        {
            throw new InvalidParameterException("The roll must be between 1 and 100");
        }

        int ret = 0;
        int hard = (int) (this.regular / 2);
        int extreme = (int) this.regular / 5;
        int total = roll + mod;

        if (roll == 1)
        {
            ret = Rank.CHECK_RESULT_CRITICAL_SUCCESS;
        }
        else if (total <= extreme)
        {
            ret = Rank.CHECK_RESULT_EXTREME;
        }
        else if (extreme < total && total <= hard)
        {
            ret = Rank.CHECK_RESULT_HARD;
        }
        else if (hard < total && total <= regular)
        {
            ret = Rank.CHECK_RESULT_REGULAR;
        }
        else if (total > regular)
        {
            ret = Rank.CHECK_RESULT_FAILURE;

            if (regular < 50)
            {
                if (96 <= roll && roll <= 100)
                {
                    ret = Rank.CHECK_RESULT_FUMBLE;
                }
            }
            else if (roll == 100)
            {
                ret = Rank.CHECK_RESULT_FUMBLE;
            }
        }
        return ret;
    }

    public int buy(int ammount)
    {

        if (ammount > 0)
        {
            int ret = ammount;

            if (this.regular + ammount > Rank.MAX_RANK_VALUE)
            {
                ret = Rank.MAX_RANK_VALUE - this.regular;
            }

            this.regular += ret;
            return ret;
        }
        else
        {
            throw new InvalidParameterException("The ammount to buy must be positive");
        }
    }

    public int sell(int ammount)
    {

        if (ammount > 0)
        {
            int ret = 0;

            if (this.regular - ammount >= this.minValue)
            {
                this.regular -= ammount;
                ret = ammount;
            }
            else
            {
                ret = this.regular- this.minValue;
                this.regular = this.minValue;
            }

            return ret;
        }
        else
        {
            throw new InvalidParameterException("The ammount to sell must be positive");
        }
    }

    @Override
    public int compareTo(Rank o)
    {
        int diff=this.regular-o.getRegular();
        int ret=0;
        if(diff!=0)
        {
            ret=diff/Math.abs(diff);
        }
        return  ret;
    }
}
