package by.bsu.fpmi.scdb.controller;

import by.bsu.fpmi.scdb.dao.ChessDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {
    @Autowired
    private ChessDAO chessDAO;

	@RequestMapping(value = "/", method = GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		return "home";
	}

    @RequestMapping(value = "/getGameByPlayer/{surname}", method = GET)
    public String getGameByPlayer(@PathVariable String surname, Model model) {
        model.addAttribute("games", chessDAO.getGameByPlayer(surname));
        return "getBySurname";
    }

    @RequestMapping(value = "/getUnpaid", method = GET)
    public String getUnpaid(Model model) {
        model.addAttribute("players", chessDAO.getPlayersWithUnpaidFees());
        return "getUnpaid";
    }

    @RequestMapping(value = "/getFiveOldest", method = GET)
    public String getFiveOldest(Model model) {
        model.addAttribute("players", chessDAO.getFiveOldestPlayers());
        return "getFiveOldest";
    }
}