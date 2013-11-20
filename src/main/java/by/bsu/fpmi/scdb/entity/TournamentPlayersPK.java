package by.bsu.fpmi.scdb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Assasin
 * Date: 11/17/13
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class TournamentPlayersPK implements Serializable {
    private int playerId;

    @Id
    @Column(name = "player_id")
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    private int tournamentId;

    @Id
    @Column(name = "tournament_id")
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

        TournamentPlayersPK that = (TournamentPlayersPK) o;

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
