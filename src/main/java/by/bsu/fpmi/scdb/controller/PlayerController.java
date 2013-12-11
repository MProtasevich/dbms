package by.bsu.fpmi.scdb.controller;

import by.bsu.fpmi.scdb.dao.ChessDAO;
import by.bsu.fpmi.scdb.entity.Category;
import by.bsu.fpmi.scdb.entity.Chessplayer;
import by.bsu.fpmi.scdb.entity.Liberty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/players")
@SessionAttributes(value = { "newPlayer", "categories", "liberties", "players" })
public class PlayerController {
    private static final String
            LIST_VIEW = "list/player",
            FORM_VIEW = "page/player",
            REDIRECT_TO = "redirect:players";

    private static final String
            ADD_ACTION = "/players/add",
            EDIT_ACTION = "/players/edit";

    @Autowired
    private ChessDAO chessDAO;

    @RequestMapping(method = GET)
    public String listPlayers() {
        return LIST_VIEW;
    }

    @RequestMapping(value = "/add", method = GET)
    public String addPlayer(Model model) {
        model.addAttribute("action", ADD_ACTION);
        model.addAttribute("player", new Chessplayer());
        return FORM_VIEW;
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String editPlayer(Model model, @PathVariable int id) {
        model.addAttribute("action", EDIT_ACTION);
        model.addAttribute("player", chessDAO.getChessplayer(id));
        return FORM_VIEW;
    }

    @RequestMapping(value = "/add", method = POST)
    public String addPlayer(@Valid @ModelAttribute("player")
                            Chessplayer player, BindingResult result,
                            Model model) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        player.setClubEntryDate(new Date());
        chessDAO.addChessplayer(player);
        return REDIRECT_TO;
    }

    @RequestMapping(value = "/edit", method = POST)
    public String editPlayer(@Valid @ModelAttribute("player")
                             Chessplayer player, BindingResult result,
                             Model model) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        chessDAO.updateChessplayer(player);
        return REDIRECT_TO;
    }

    @ModelAttribute("categories")
    public List<Category> populateCategories() {
        return chessDAO.listCategories();
    }

    @ModelAttribute("players")
    public List<Chessplayer> populatePlayers() {
        return chessDAO.listPlayers();
    }

    @ModelAttribute("liberties")
    public List<Liberty> populateLiberties() {
        return chessDAO.listLiberties();
    }
}