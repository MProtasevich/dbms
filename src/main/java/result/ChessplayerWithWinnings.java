package result;

import java.util.Date;

public class ChessplayerWithWinnings {
    private final int id;
    private final Date birthdate;

    private final String forename;
    private final String surname;

    private final String title;

    private final double winnings;

    /*SELECT NEW result.ChessplayerWithWinnings(c.forename, c.surname, c.title.typeOfCategory, c.birthdate, SUM((t.firstPlacePlayer.id=c.id)=true)) FROM Chessplayer c INNER JOIN c.tournaments t WHERE YEAR(t.dateOfCompletion)=YEAR(CURRENT_DATE ) ORDER BY c.birthdate ASC*/

    public ChessplayerWithWinnings(int id, String forename, String surname,
                                   Date birthdate, String title,
                                   double winnings) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;

        this.title = title;
        this.birthdate = birthdate;
        this.winnings = winnings;
    }

    @Override
    public String toString() {
        return getForename() + " " + getSurname() + " " + getBirthdate() + " " + getTitle() + " " + getWinnings();
    }

    public int getId() {
        return id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getTitle() {
        return title;
    }

    public double getWinnings() {
        return winnings;
    }
}