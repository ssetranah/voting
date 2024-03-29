/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.CandidateDao;
import com.dao.PartyDao;
import com.model.Candidate;
import com.model.Party;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CandidateController {
    @Autowired
    CandidateDao c;
    
    
    @RequestMapping("/addCandidate")
    public String addCandidate(Model m) throws SQLException{
       
        PartyDao partydao = new PartyDao();
        List<Party> parties = partydao.getParty();
        
        m.addAttribute("party", parties);
        
        m.addAttribute("command", new Candidate());
        return "addcandidateform";
    }
    
    @RequestMapping(value="/addCandidateAction", method=RequestMethod.POST)
        public String saveCandidate(@ModelAttribute ("ca") Candidate ca){
        c.save(ca);
        return "redirect:/viewCandidate";
    }
    
    @RequestMapping(value="/viewCandidate")
        public String viewCandidate(Model m) throws SQLException{
            List <Candidate> list= c.getCandidate();
            m.addAttribute("list", list);
        return "viewCandidate";
    }
}
