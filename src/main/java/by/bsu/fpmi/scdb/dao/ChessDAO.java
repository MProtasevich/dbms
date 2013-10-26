package by.bsu.fpmi.scdb.dao;

import by.bsu.fpmi.scdb.entity.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ChessDAO {
    public List<Game> getGameByPlayer(String surname);
    public List<Chessplayer> getPlayersWithUnpaidFees();
    public List<Chessplayer> getFiveOldestPlayers();

    public void addChessplayer(Chessplayer player);
    public void updateChessplayer(Chessplayer player);

    public void addTournament(Tournament tournament);
    public void updateTournament(Tournament tournament);

    public void addGame(Game game);
    public void updateGame(Game game);

    public List<Category> listCategories();
    public List<Chessplayer> listPlayers();
    public List<Debut> listDebuts();
    public List<Game> listGames();
    public List<GameResult> listGameResults();
    public List<Liberty> listLiberties();
    public List<MemberFee> listFees();
    public List<PlaySystem> listPlaySystems();
    public List<Tournament> listTournaments();

    public Category getCategory(int id);
    public Chessplayer getChessplayer(int id);
    public Debut getDebut(int id);
    public Game getGame(int id);
    public GameResult getGameResult(int id);
    public Liberty getLiberty(int id);
    public MemberFee getMemberFee(int id);
    public PlaySystem getPlaySystem(int id);
    public Tournament getTournament(int id);
}
