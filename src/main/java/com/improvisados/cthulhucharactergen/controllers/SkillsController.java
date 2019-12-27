/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.improvisados.cthulhucharactergen.controllers;

import com.improvisados.cthulhucharactergen.logic.Skill;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juacom99 <juacom04@gmail.com>
 */
public class SkillsController
{
    private List<Skill> skills;
    private static SkillsController instance;

    private SkillsController()
    {
        this.skills=new ArrayList<Skill>();
    }
    
    public void add(Skill s)
    {
        if(skills.contains(s))
        {
            skills.add(s);
        }
    }
    
    public void remove(Skill s)
    {
        if(skills.contains(s))
        {
            skills.remove(s);
        }
    }
    
    public static SkillsController getInstance()
    {
        if(instance==null)
        {
            instance=new SkillsController();
        }
        return instance;
    }
    
}
