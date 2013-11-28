package by.bsu.fpmi.scdb.controller;

import by.bsu.fpmi.scdb.dao.ChessDAO;
import by.bsu.fpmi.scdb.entity.Chessplayer;
import by.bsu.fpmi.scdb.entity.Debut;
import by.bsu.fpmi.scdb.entity.Game;
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
@RequestMapping(value = "/games")
@SessionAttributes(value = { "debuts", "players", "tournaments", "games" })
public class GameController {
    @Autowired
    private ChessDAO chessDAO;

    @RequestMapping(value = "/", method = GET)
    public String game() {
        return "editGame";
    }

    @RequestMapping(value = "/add", method = GET)
    public String addPlayer(Model model) {
        model.addAttribute("newGame", new Game());
        return "addGame";
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String editPlayers(Model model, @PathVariable int id) {
        model.addAttribute("editGame", chessDAO.getGame(id));
        return "editGame";
    }

    @RequestMapping(value = "/add", method = POST)
    public String addPlayer(@Valid @ModelAttribute("newGame")
                            Game game, BindingResult result) {
        if(result.hasErrors()) {
            return "addGame";
        }
        chessDAO.addGame(game);
        return "addGame";
    }

    @RequestMapping(value = "/edit", method = POST)
    public String editPlayer(@Valid @ModelAttribute("editGame")
                             Game game, BindingResult result) {
        if(result.hasErrors()) {
            return "editGame";
        }
        chessDAO.updateGame(game);
        return "editGame";
    }

    @ModelAttribute("debuts")
    public List<Debut> populateDebuts() {
        return chessDAO.listDebuts();
    }

    @ModelAttribute("players")
    public List<Chessplayer> populatePlayers() {
        return chessDAO.listPlayers();
    }

    @ModelAttribute("tournaments")
    public List<Tournament> populateTournament() {
        return chessDAO.listTournaments();
    }

    @ModelAttribute("games")
    public List<Game> populateGames() {
        return chessDAO.listGames();
    }
}