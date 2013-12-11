package by.bsu.fpmi.scdb.controller;

import by.bsu.fpmi.scdb.dao.ChessDAO;
import by.bsu.fpmi.scdb.entity.Liberty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/liberties")
public class LibertyController {
    private static final String
            LIST_VIEW = "list/liberty",
            FORM_VIEW = "page/liberty",
            REDIRECT_TO = "redirect:/liberties";

    private static final String
            ADD_ACTION = "/liberties/add",
            EDIT_ACTION = "/liberties/edit";

    @Autowired
    private ChessDAO chessDAO;

    @RequestMapping(method = GET)
    public String listLiberties(Model model) {
        model.addAttribute("liberties", chessDAO.listLiberties());
        return LIST_VIEW;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addLiberty(Model model) {
        model.addAttribute("action", ADD_ACTION);
        model.addAttribute("liberty", new Liberty());
        return FORM_VIEW;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editLiberty(@PathVariable int id, Model model) {
        model.addAttribute("action", EDIT_ACTION);
        model.addAttribute("liberty", chessDAO.getLiberty(id));
        return FORM_VIEW;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addLiberty(@Valid @ModelAttribute("newLiberty")
                             Liberty liberty, BindingResult result) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        chessDAO.addLiberty(liberty);
        return REDIRECT_TO;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editLiberty(@Valid @ModelAttribute("editLiberty")
                              Liberty liberty, BindingResult result) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        chessDAO.updateLiberty(liberty);
        return REDIRECT_TO;
    }
}