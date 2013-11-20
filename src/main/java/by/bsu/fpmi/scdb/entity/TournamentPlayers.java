package by.bsu.fpmi.scdb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Assasin
 * Date: 11/17/13
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(by.bsu.fpmi.scdb.entity.TournamentPlayersPK.class)
@javax.persistence.Table(name = "tournament_players", schema = "", catalog = "scdb_lab1")
@Entity
public class TournamentPlayers {
    private int playerId;

    @javax.persistence.Column(name = "player_id")
    @Id
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    private int tournamentId;

    @javax.persistence.Column(name = "tournament_id")
    @Id
    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        TournamentPlayers that = (TournamentPlayers) o;

        if(playerId != that.playerId) {
            return false;
        }
        if(tournamentId != that.tournamentId) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = playerId;
        result = 31 * result + tournamentId;
        return result;
    }
}
