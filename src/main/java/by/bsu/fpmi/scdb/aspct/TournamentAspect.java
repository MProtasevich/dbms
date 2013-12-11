package by.bsu.fpmi.scdb.aspct;

import by.bsu.fpmi.scdb.dao.ChessDAO;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Aspect
public class TournamentAspect {
    @Autowired
    ChessDAO chessDAO;

    @After(value = "execution " +
            "(@org.springframework.web.bind.annotation.RequestMapping " +
            "* by.bsu.fpmi.scdb.controller.GameController.*Tournament(..)) && " +
            "args(..,model) && @annotation(requestMapping)",
            argNames = "model,requestMapping")
    private void wireGameProperties(Model model, RequestMapping requestMapping) {
        List<RequestMethod> methods = Arrays.asList(requestMapping.method());
        if(methods.contains(RequestMethod.POST)) {
            refreshAttributes(model);
        }
    }

    private void refreshAttributes(Model model) {
        model.addAttribute("tournaments", chessDAO.listTournaments());
    }
}
