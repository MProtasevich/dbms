package by.bsu.fpmi.scdb.entity.result;

import java.util.Date;

public class ChessplayerWithWinnings {
    public final int id;

    public final Date birthdate;
    public final Date clubEntryDate;

    public final String forename;
    public final String surname;
    public final String middleName;

    public final String category;

    public final float winnings;

    public ChessplayerWithWinnings(int id, Date birthdate, Date clubEntryDate,
                                    String forename, String surname,
                                    String middleName, String category,
                                    float winnings) {

        this.id = id;

        this.birthdate = birthdate;
        this.clubEntryDate = birthdate;

        this.forename = forename;
        this.surname = surname;
        this.middleName = middleName;

        this.category = category;

        this.winnings = winnings;
    }
}