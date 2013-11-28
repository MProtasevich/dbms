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
public class PlayersController {
    @Autowired
    private ChessDAO chessDAO;

    @RequestMapping(value = "/add", method = GET)
    public String addPlayer(Model model) {
        model.addAttribute("newPlayer", new Chessplayer());
        return "addPlayer";
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String editPlayers(Model model,
                              @PathVariable int id) {
        model.addAttribute("editPlayer", chessDAO.getChessplayer(id));
        return "editPlayer";
    }

    @RequestMapping(value = "/add", method = POST)
    public String addPlayer(@Valid @ModelAttribute("newPlayer")
                            Chessplayer player, BindingResult result) {
        if(result.hasErrors()) {
            return "addPlayer";
        }
        player.setClubEntryDate(new Date());
        chessDAO.addChessplayer(player);
        return "redirect:/players/add";
    }

    @RequestMapping(value = "/edit", method = POST)
    public String editPlayer(@Valid @ModelAttribute("editPlayer")
                             Chessplayer player, BindingResult result) {
        if(result.hasErrors()) {
            return "editPlayer";
        }
        chessDAO.updateChessplayer(player);
        return "redirect:/players/add";
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