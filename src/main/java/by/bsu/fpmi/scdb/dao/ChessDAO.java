package by.bsu.fpmi.scdb.dao;

import by.bsu.fpmi.scdb.entity.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ChessDAO {
    public List<Game> getGameByPlayer(String surname);
    public List<Chessplayer> getPlayersWithUnpaidFees();
    public List getFiveOldestPlayers();

    public void addCategory(Category category);
    public void updateCategory(Category category);

    public void addDebut(Debut debut);
    public void updateDebut(Debut debut);

    public void addGame(Game game);
    public void updateGame(Game game);

    public void addLiberty(Liberty liberty);
    public void updateLiberty(Liberty liberty);

    public void addMemberFee(MemberFee memberFee);
    public void updateMemberFee(MemberFee memberFee);
    
    public void addChessplayer(Chessplayer player);
    public void updateChessplayer(Chessplayer player);

    public void addPlaySystem(PlaySystem playSystem);
    public void updatePlaySystem(PlaySystem playSystem);

    public void addTournament(Tournament tournament);
    public void updateTournament(Tournament tournament);

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