package by.bsu.fpmi.scdb.controller;

import by.bsu.fpmi.scdb.dao.ChessDAO;
import by.bsu.fpmi.scdb.entity.PlaySystem;
import by.bsu.fpmi.scdb.entity.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/tournaments")
@SessionAttributes(value = { "tournaments", "playSystems" })
public class TournamentController {
    @Autowired
    private ChessDAO chessDAO;

    @RequestMapping(value = "/add", method = GET)
    public String addPlayer(Model model) {
        model.addAttribute("newTournament", new Tournament());
        return "addTournament";
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String editPlayers(Model model, @PathVariable int id) {
        model.addAttribute("editTournament", chessDAO.getTournament(id));
        return "editTournament";
    }

    @RequestMapping(value = "/add", method = POST)
    public String addPlayer(@Valid @ModelAttribute("newTournament")
                            Tournament tournament, BindingResult result) {
        if(result.hasErrors()) {
            return "addTournament";
        }
        chessDAO.addTournament(tournament);
        return "redirect:/tournaments/add";
    }

    @RequestMapping(value = "/edit", method = POST)
    public String editPlayer(@Valid @ModelAttribute("editTournament")
                             Tournament tournament, BindingResult result) {
        if(result.hasErrors()) {
            return "addTournament";
        }
        chessDAO.updateTournament(tournament);
        return "redirect:/tournaments/add";
    }

    @ModelAttribute("tournaments")
    public List<Tournament> populateTournament() {
        return chessDAO.listTournaments();
    }

    @ModelAttribute("playSystems")
    public List<PlaySystem> populatePlaySystem() {
        return chessDAO.listPlaySystems();
    }
}