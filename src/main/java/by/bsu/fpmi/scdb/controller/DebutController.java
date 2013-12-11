package by.bsu.fpmi.scdb.controller;

import by.bsu.fpmi.scdb.dao.ChessDAO;
import by.bsu.fpmi.scdb.entity.Debut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/debuts")
public class DebutController {
    private static final String
            LIST_VIEW = "list/debut",
            FORM_VIEW = "page/debut",
            REDIRECT_TO = "redirect:/debuts";

    private static final String
            ADD_ACTION = "/debuts/add",
            EDIT_ACTION = "/debuts/edit";

    @Autowired
    private ChessDAO chessDAO;

    @RequestMapping(method = GET)
    public String listDebuts(Model model) {
        model.addAttribute("debuts", chessDAO.listDebuts());
        return LIST_VIEW;
    }

    @RequestMapping(value = "/add", method = GET)
    public String addDebut(Model model) {
        model.addAttribute("action", ADD_ACTION);
        model.addAttribute("debut", new Debut());
        return FORM_VIEW;
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String editDebut(@PathVariable int id, Model model) {
        model.addAttribute("action", EDIT_ACTION);
        model.addAttribute("debut", chessDAO.getDebut(id));
        return FORM_VIEW;
    }

    @RequestMapping(value = "/add", method = POST)
    public String addDebut(@Valid @ModelAttribute("debut")
                           Debut debut, BindingResult result) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        chessDAO.addDebut(debut);
        return REDIRECT_TO;
    }

    @RequestMapping(value = "/edit", method = POST)
    public String editDebut(@Valid @ModelAttribute("debut")
                            Debut debut, BindingResult result) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        chessDAO.updateDebut(debut);
        return REDIRECT_TO;
    }

    /*@ModelAttribute("entity")
    public String populateEntity() {
        return "debuts";
    }*/
}