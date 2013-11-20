package result;

import java.util.Date;

public class ChessplayerWithWinnings {
    public final Date birthdate;

    public final String forename;
    public final String surname;

    public final String category;

    public final double winnings;

    public ChessplayerWithWinnings(String forename, String surname,
                                   String category, Date birthdate,
                                   double winnings) {
        this.forename = forename;
        this.surname = surname;

        this.category = category;
        this.birthdate = birthdate;
        this.winnings = winnings;
    }
}