package by.bsu.fpmi.scdb.dao.impl;

import by.bsu.fpmi.scdb.dao.ChessDAO;
import by.bsu.fpmi.scdb.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ChessDAOImpl implements ChessDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Game> getGameByPlayer(String surname) {
        TypedQuery<Game> query = em.createNamedQuery("Game.findByPlayersName",
                                                      Game.class);
        query.setParameter("surname", surname);
        return query.getResultList();
    }

    @Override
    public List<Chessplayer> getPlayersWithUnpaidFees() {
        TypedQuery<Chessplayer> query = em.createNamedQuery(
                                        "Chessplayer.findWithUnpaidFees",
                                         Chessplayer.class);
        return query.getResultList();
    }

    @Override
    public List<Chessplayer> getFiveOldestPlayers() {
        TypedQuery<Chessplayer> query = em.createNamedQuery(
                                        "Chessplayer.findFiveOldest",
                                         Chessplayer.class);
        return query.getResultList();
    }

    @Override
    public void addChessplayer(Chessplayer player) {
        em.persist(player);
    }

    @Override
    public void updateChessplayer(Chessplayer player) {
        em.merge(player);
    }

    @Override
    public void addTournament(Tournament tournament) {
        em.persist(tournament);
    }

    @Override
    public void updateTournament(Tournament tournament) {
        em.merge(tournament);
    }

    @Override
    public void addGame(Game game) {
        em.persist(game);
    }

    @Override
    public void updateGame(Game game) {
        em.merge(game);
    }

    @Override
    public List<Category> listCategories() {
        return em.createNamedQuery("Category.findAll", Category.class).getResultList();
    }

    @Override
    public List<Chessplayer> listPlayers() {
        List<Chessplayer> players = em.createNamedQuery("Chessplayer.findAll", Chessplayer.class).getResultList();
        return players;
    }

    @Override
    public List<Debut> listDebuts() {
        return em.createNamedQuery("Debut.findAll", Debut.class).getResultList();
    }

    @Override
    public List<Game> listGames() {
        return em.createNamedQuery("Game.findAll", Game.class).getResultList();
    }

    @Override
    public List<GameResult> listGameResults() {
        return em.createNamedQuery("GameResult.findAll", GameResult.class).getResultList();
    }

    @Override
    public List<Liberty> listLiberties() {
        return em.createNamedQuery("Liberty.findAll", Liberty.class).getResultList();
    }

    @Override
    public List<MemberFee> listFees() {
        return em.createNamedQuery("MemberFee.findAll", MemberFee.class).getResultList();
    }

    @Override
    public List<PlaySystem> listPlaySystems() {
        return em.createNamedQuery("PlaySystem.findAll", PlaySystem.class).getResultList();
    }

    @Override
    public List<Tournament> listTournaments() {
        return em.createNamedQuery("Tournament.findAll", Tournament.class).getResultList();
    }

    @Override
    public Category getCategory(int id) {
        return em.createNamedQuery("Category.getById", Category.class).getSingleResult();
    }

    @Override
    public Chessplayer getChessplayer(int id) {
        return em.createNamedQuery("Chessplayer.getById", Chessplayer.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public Debut getDebut(int id) {
        return em.createNamedQuery("Debut.getById", Debut.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public Game getGame(int id) {
        return em.createNamedQuery("Game.getById", Game.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public GameResult getGameResult(int id) {
        return em.createNamedQuery("GameResult.getById", GameResult.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public Liberty getLiberty(int id) {
        return em.createNamedQuery("Liberty.getById", Liberty.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public MemberFee getMemberFee(int id) {
        return em.createNamedQuery("MemberFee.getById", MemberFee.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public PlaySystem getPlaySystem(int id) {
        return em.createNamedQuery("PlaySystem.getById", PlaySystem.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public Tournament getTournament(int id) {
        return em.createNamedQuery("Tournament.getById", Tournament.class).setParameter("id", id).getSingleResult();
    }
}