package by.bsu.fpmi.scdb.controller;

import by.bsu.fpmi.scdb.dao.ChessDAO;
import by.bsu.fpmi.scdb.entity.PlaySystem;
import by.bsu.fpmi.scdb.entity.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/tournaments")
@SessionAttributes(value = {"newTournament", "tournaments", "playSystems"})
public class TournamentController {
    @Autowired
    private ChessDAO chessDAO;

    @RequestMapping(value = "/add", method = GET)
    public String addPlayer(Model model) {
        model.addAttribute("tournaments", chessDAO.listTournaments());
        model.addAttribute("newTournament", new Tournament());
        model.addAttribute("playSystems", chessDAO.listPlaySystems());
        return "addTournament";
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String editPlayers(Model model,
                              @PathVariable int id) {
        model.addAttribute("playSystems", chessDAO.listPlaySystems());
        model.addAttribute("editTournament", chessDAO.getTournament(id));
        return "editTournament";
    }

    @RequestMapping(value = "/add/do", method = POST)
    public String addPlayer(@Valid @ModelAttribute("newTournament")
                            Tournament tournament, BindingResult result) {
        if(result.hasErrors()) {
            return "addTournament";
        }
        chessDAO.addTournament(tournament);
        return "redirect:/tournaments/add";
    }

    @RequestMapping(value = "/edit/do", method = POST)
    public String editPlayer(@Valid @ModelAttribute("editTournament")
                             Tournament tournament, BindingResult result) {
        if(result.hasErrors()) {
            return "addTournament";
        }
        chessDAO.updateTournament(tournament);
        return "redirect:/tournaments/add";
    }
}