package by.bsu.fpmi.scdb.controller;

import by.bsu.fpmi.scdb.dao.ChessDAO;
import by.bsu.fpmi.scdb.entity.Category;
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
@RequestMapping(value = "/categories")
public class CategoryController {
    private static final String
            LIST_VIEW = "list/category",
            FORM_VIEW = "page/category",
            REDIRECT_TO = "redirect:/categories";

    private static final String
            ADD_ACTION = "/categories/add",
            EDIT_ACTION = "/categories/edit";

    @Autowired
    private ChessDAO chessDAO;

    @RequestMapping(method = GET)
    public String listCategories(Model model) {
        model.addAttribute("categories", chessDAO.listCategories());
        return LIST_VIEW;
    }

    // replace adding "action" attributes to aspect
    @RequestMapping(value = "/add", method = GET)
    public String addCategory(Model model) {
        model.addAttribute("action", ADD_ACTION);
        model.addAttribute("category", new Category());
        return FORM_VIEW;
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String editCategory(@PathVariable int id, Model model) {
        model.addAttribute("action", EDIT_ACTION);
        model.addAttribute("category", chessDAO.getCategory(id));
        return FORM_VIEW;
    }

    @RequestMapping(value = "/add", method = POST)
    public String addCategory(@Valid @ModelAttribute("category")
                              Category category, BindingResult result) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        chessDAO.addCategory(category);
        return REDIRECT_TO;
    }

    @RequestMapping(value = "/edit", method = POST)
    public String editCategory(@Valid @ModelAttribute("category")
                               Category category, BindingResult result) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        chessDAO.updateCategory(category);
        return REDIRECT_TO;
    }
}