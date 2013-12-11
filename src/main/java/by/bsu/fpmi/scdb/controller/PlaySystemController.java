package by.bsu.fpmi.scdb.controller;

import by.bsu.fpmi.scdb.dao.ChessDAO;
import by.bsu.fpmi.scdb.entity.Chessplayer;
import by.bsu.fpmi.scdb.entity.PlaySystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/playSystems")
public class PlaySystemController {
    private static final String
            LIST_VIEW = "list/playSystem",
            FORM_VIEW = "page/playSystem",
            REDIRECT_TO = "redirect:/playSystems";

    private static final String
            ADD_ACTION = "/playSystems/add",
            EDIT_ACTION = "/playSystems/edit";

    @Autowired
    private ChessDAO chessDAO;

    @RequestMapping(method = GET)
    public String listPlaySystems(Model model) {
        model.addAttribute("playSystems", chessDAO.listFees());
        return LIST_VIEW;
    }

    @RequestMapping(value = "/add", method = GET)
    public String addPlaySystem(Model model) {
        model.addAttribute("action", ADD_ACTION);
        model.addAttribute("playSystem", new PlaySystem());
        return FORM_VIEW;
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String editPlaySystem(@PathVariable int id, Model model) {
        model.addAttribute("action", EDIT_ACTION);
        model.addAttribute("playSystem", chessDAO.getPlaySystem(id));
        return FORM_VIEW;
    }

    @RequestMapping(value = "/add", method = POST)
    public String addPlaySystem(@Valid @ModelAttribute("playSystem")
                               PlaySystem playSystem, BindingResult result) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        chessDAO.addPlaySystem(playSystem);
        return REDIRECT_TO;
    }

    @RequestMapping(value = "/edit", method = POST)
    public String editPlaySystem(@Valid @ModelAttribute("playSystem")
                                PlaySystem playSystem, BindingResult result) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        chessDAO.updatePlaySystem(playSystem);
        return REDIRECT_TO;
    }

    @ModelAttribute("players")
    private List<Chessplayer> populatePlayers() {
        return chessDAO.listPlayers();
    }
}