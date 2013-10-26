package by.bsu.fpmi.scdb.controller;

import by.bsu.fpmi.scdb.dao.ChessDAO;
import by.bsu.fpmi.scdb.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/game")
public class GameController {
    @Autowired
    private ChessDAO chessDAO;

    @RequestMapping(value = "/", method = GET)
    public String game() {
        return "editGame";
    }

    @RequestMapping(value = "/add", method = POST)
    public String addPlayer() {
        return "addGame";
    }

    @RequestMapping(value = "/edit", method = POST)
    public String editPlayers() {
        return "editGame";
    }

    @RequestMapping(value = "/add/do", method = POST)
    public String addPlayer(@Valid @ModelAttribute("newGame")
                            Game game, BindingResult result) {
        chessDAO.addGame(game);
        return "addGame";
    }

    @RequestMapping(value = "/edit/do", method = POST)
    public String editPlayer(@Valid @ModelAttribute("editedGame")
                             Game game, BindingResult result) {
        chessDAO.updateGame(game);
        return "editGame";
    }
}