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
@SessionAttributes(value = { "tournaments", "tournaments" })
public class TournamentController {
    private static final String
            LIST_VIEW = "list/tournament",
            FORM_VIEW = "page/tournament",
            REDIRECT_TO = "redirect:/tournaments";

    private static final String
            ADD_ACTION = "/tournaments/add",
            EDIT_ACTION = "/tournaments/edit";

    @Autowired
    private ChessDAO chessDAO;

    @RequestMapping(method = GET)
    public String listPlaySystems(Model model) {
        model.addAttribute("tournaments", chessDAO.listTournaments());
        return LIST_VIEW;
    }

    @RequestMapping(value = "/add", method = GET)
    public String addPlayer(Model model) {
        model.addAttribute("action", ADD_ACTION);
        model.addAttribute("tournament", new Tournament());
        return FORM_VIEW;
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String editPlayers(Model model, @PathVariable int id) {
        model.addAttribute("action", EDIT_ACTION);
        model.addAttribute("tournament", chessDAO.getTournament(id));
        return FORM_VIEW;
    }

    @RequestMapping(value = "/add", method = POST)
    public String addPlayer(@Valid @ModelAttribute("tournament")
                            Tournament tournament, BindingResult result) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        chessDAO.addTournament(tournament);
        return REDIRECT_TO;
    }

    @RequestMapping(value = "/edit", method = POST)
    public String editPlayer(@Valid @ModelAttribute("tournament")
                             Tournament tournament, BindingResult result) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        chessDAO.updateTournament(tournament);
        return LIST_VIEW;
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