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
        TypedQuery<Game> query = em.createNamedQuery(
                "Game.findByPlayersName", Game.class);
        query.setParameter("surname", surname);
        return query.getResultList();
    }

    @Override
    public List<Chessplayer> getPlayersWithUnpaidFees() {
        TypedQuery<Chessplayer> query = em.createNamedQuery(
                "Chessplayer.findWithUnpaidFees", Chessplayer.class);

        return query.getResultList();
    }

    @Override
    public List getFiveOldestPlayers() {
        return em.createNamedQuery("Chessplayer.findFiveOldest")
                .setMaxResults(5).getResultList();
    }

    @Override
    public void addCategory(Category category) {
        em.persist(category);
    }

    @Override
    public void updateCategory(Category category) {
        em.merge(category);
    }

    @Override
    public void addDebut(Debut debut) {
        em.persist(debut);
    }

    @Override
    public void updateDebut(Debut debut) {
        em.merge(debut);
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
    public void addPlaySystem(PlaySystem playSystem) {
        em.persist(playSystem);
    }

    @Override
    public void updatePlaySystem(PlaySystem playSystem) {
        em.merge(playSystem);
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
    public void addLiberty(Liberty liberty) {
        em.persist(liberty);
    }

    @Override
    public void updateLiberty(Liberty liberty) {
        em.merge(liberty);
    }

    @Override
    public void addMemberFee(MemberFee memberFee) {
        em.persist(memberFee);
    }

    @Override
    public void updateMemberFee(MemberFee memberFee) {
        em.merge(memberFee);
    }

    @Override
    public List<Category> listCategories() {
        return em.createNamedQuery("Category.findAll", Category.class)
                .getResultList();
    }

    @Override
    public List<Chessplayer> listPlayers() {
        return em.createNamedQuery("Chessplayer.findAll", Chessplayer.class)
                .getResultList();
    }

    @Override
    public List<Debut> listDebuts() {
        return em.createNamedQuery("Debut.findAll", Debut.class)
                .getResultList();
    }

    @Override
    public List<Game> listGames() {
        return em.createNamedQuery("Game.findAll", Game.class).getResultList();
    }

    @Override
    public List<GameResult> listGameResults() {
        return em.createNamedQuery("GameResult.findAll", GameResult.class)
                .getResultList();
    }

    @Override
    public List<Liberty> listLiberties() {
        return em.createNamedQuery("Liberty.findAll", Liberty.class)
                .getResultList();
    }

    @Override
    public List<MemberFee> listFees() {
        return em.createNamedQuery("MemberFee.findAll", MemberFee.class)
                .getResultList();
    }

    @Override
    public List<PlaySystem> listPlaySystems() {
        return em.createNamedQuery("PlaySystem.findAll", PlaySystem.class)
                .getResultList();
    }

    @Override
    public List<Tournament> listTournaments() {
        return em.createNamedQuery("Tournament.findAll", Tournament.class)
                .getResultList();
    }

    // get(\w*)\(\w*int id\)\s\{\s*return
    @Override
    public Category getCategory(int id) {
        return em.createNamedQuery("Category.getById", Category.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public Chessplayer getChessplayer(int id) {
        return em.createNamedQuery("Chessplayer.getById", Chessplayer.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public Debut getDebut(int id) {
        return em.createNamedQuery("Debut.getById", Debut.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public Game getGame(int id) {
        return em.createNamedQuery("Game.getById", Game.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public GameResult getGameResult(int id) {
        return em.createNamedQuery("GameResult.getById", GameResult.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public Liberty getLiberty(int id) {
        return em.createNamedQuery("Liberty.getById", Liberty.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public MemberFee getMemberFee(int id) {
        return em.createNamedQuery("MemberFee.getById", MemberFee.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public PlaySystem getPlaySystem(int id) {
        return em.createNamedQuery("PlaySystem.getById", PlaySystem.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public Tournament getTournament(int id) {
        return em.createNamedQuery("Tournament.getById", Tournament.class)
                .setParameter("id", id).getSingleResult();
    }
}