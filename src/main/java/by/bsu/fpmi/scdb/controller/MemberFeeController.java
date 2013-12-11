package by.bsu.fpmi.scdb.controller;

import by.bsu.fpmi.scdb.dao.ChessDAO;
import by.bsu.fpmi.scdb.entity.Chessplayer;
import by.bsu.fpmi.scdb.entity.MemberFee;
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
@RequestMapping(value = "/memberFees")
@SessionAttributes(value = { "players" })
public class MemberFeeController {
    private static final String
            LIST_VIEW = "list/memberFee",
            FORM_VIEW = "page/memberFee",
            REDIRECT_TO = "redirect:/memberFees";

    private static final String
            ADD_ACTION = "/memberFees/add",
            EDIT_ACTION = "/memberFees/edit";

    @Autowired
    private ChessDAO chessDAO;

    @RequestMapping(method = GET)
    public String listMemberFees(Model model) {
        model.addAttribute("memberFees", chessDAO.listFees());
        return LIST_VIEW;
    }

    @RequestMapping(value = "/add", method = GET)
    public String addMemberFee(Model model) {
        model.addAttribute("action", ADD_ACTION);
        model.addAttribute("memberFee", new MemberFee());
        return FORM_VIEW;
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String editMemberFee(@PathVariable int id, Model model) {
        model.addAttribute("action", EDIT_ACTION);
        model.addAttribute("memberFee", chessDAO.getMemberFee(id));
        return FORM_VIEW;
    }

    @RequestMapping(value = "/add", method = POST)
    public String addMemberFee(@Valid @ModelAttribute("memberFee")
                               MemberFee memberFee, BindingResult result) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        chessDAO.addMemberFee(memberFee);
        return REDIRECT_TO;
    }

    @RequestMapping(value = "/edit", method = POST)
    public String editMemberFee(@Valid @ModelAttribute("memberFee")
                                MemberFee memberFee, BindingResult result) {
        if(result.hasErrors()) {
            return FORM_VIEW;
        }
        chessDAO.updateMemberFee(memberFee);
        return REDIRECT_TO;
    }

    @ModelAttribute("players")
    private List<Chessplayer> populatePlayers() {
        return chessDAO.listPlayers();
    }
}