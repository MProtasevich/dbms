package by.bsu.fpmi.scdb.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="chessplayer")
@NamedQueries({
    /*@NamedQuery(name = "Chessplayer.findAll",
            query = "SELECT c FROM Chessplayer c"),
    @NamedQuery(name = "Chessplayer.getById",
                query = "SELECT c FROM Chessplayer c WHERE c.id=:id")*/
    /*@NamedQuery(name = "Chessplayer.findFiveOldest",
                query =
    "SELECT NEW " +
       "result.ChessplayerWithWinnings" +
          "(c.forename, c.surname, c.title.typeOfCategory, c.birthdate, t.firstPlaceWinnings * (t.firstPlacePlayer=c.id)) " +

    "FROM Chessplayer c JOIN Tournament t")*/
    @NamedQuery(name = "Chessplayer.findFiveOldest",
    query = "\n" +
            "SELECT NEW result.ChessplayerWithWinnings(c.id, c.forename, c.surname, c.birthdate, t.title, SUM(\n" +
            "    CASE WHEN t.firstPlacePlayer.id=c.id\n" +
            "      THEN t.firstPlaceWinnings" +
            "      ELSE 0.0" +
            "    END +\n" +
            "    CASE WHEN t.secondPlacePlayer.id=c.id\n" +
            "      THEN t.secondPlaceWinnings" +
            "      ELSE 0.0" +
            "    END +\n" +
            "    CASE WHEN t.thirdPlacePlayer.id=c.id\n" +
            "      THEN t.thirdPlaceWinnings" +
            "      ELSE 0.0" +
            "    END))\n" +

            "  FROM Tournament t INNER JOIN t.chessplayers c" +
            "    WHERE YEAR(t.dateOfCompletion)=YEAR(CURRENT_DATE)" +
            "      AND t MEMBER OF c.tournaments GROUP BY c.id ORDER BY c.birthdate ASC")
})

@NamedNativeQueries({
    @NamedNativeQuery(name = "Chessplayer.findAll",
        query = "SELECT * FROM chessplayer",
        resultClass = Chessplayer.class),

    @NamedNativeQuery(name = "Chessplayer.getById",
        query = "SELECT * FROM chessplayer  WHERE id=:id",
        resultClass = Chessplayer.class),

    @NamedNativeQuery(name="Chessplayer.findWithUnpaidFees",
        query="SELECT * FROM chessplayer WHERE id NOT IN " +
                "(SELECT chessplayer_id FROM member_fees WHERE year=YEAR(CURDATE()))",
        resultClass = Chessplayer.class),

    /*@NamedNativeQuery(name="Chessplayer.findFiveOldest",
        query=
          "SELECT c.forename, c.surname, c.birthdate, t.title," +
          "  YEAR(t.date_of_completion) as year," +
          "  SUM((t.first_place_winnings * (t.first_place_player=c.id) +" +
          "  t.second_place_winnings * (t.second_place_player=c.id) +" +
          "  t.third_place_winnings * (t.third_place_player=c.id))) AS winnings" +

          "FROM tournament t " +

          "JOIN chessplayer c ON YEAR(t.date_of_completion)=YEAR(CURDATE()) " +
                  "GROUP BY c.id ORDER BY birthdate ASC LIMIT 5;")*/
})
public class Chessplayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date birthdate = new Date();

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="club_entry_date")
	private Date clubEntryDate = new Date();

    @Size(min = 2, max = 128)
	@Column(length=128)
	private String forename;

    @Size(min = 2, max = 128)
	@Column(length=128)
	private String surname;

    @Size(min = 2, max = 128)
	@Column(name="middle_name", length=128)
	private String middleName;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	//bi-directional many-to-one association to Liberty
	@ManyToOne
	@JoinColumn(name="liberties_id")
	private Liberty liberty;

	//bi-directional many-to-many association to Tournament
	@ManyToMany
	@JoinTable(
		name="tournament_players",
		joinColumns={ @JoinColumn(name="player_id", nullable=false) },
		inverseJoinColumns={ @JoinColumn(name="tournament_id", nullable=false) }
	)
	private List<Tournament> tournaments;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="whitePlayer")
	private List<Game> gamesAsWhite;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="blackPlayer")
	private List<Game> gamesAsBlack;

	//bi-directional many-to-one association to GameResult
	@OneToMany(mappedBy="winner")
	private List<GameResult> wonGames;

	//bi-directional many-to-one association to GameResult
	@OneToMany(mappedBy="loser")
	private List<GameResult> lostGames;

	//bi-directional many-to-one association to MemberFee
	@OneToMany(mappedBy="chessplayer")
	private List<MemberFee> memberFees;

    @OneToMany(mappedBy = "firstPlacePlayer")
    private List<Tournament> firstPlaceTournaments;

    @OneToMany(mappedBy = "secondPlacePlayer")
    private List<Tournament> secondPlaceTournaments;

    @OneToMany(mappedBy = "thirdPlacePlayer")
    private List<Tournament> thirdPlaceTournaments;

	public Chessplayer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getClubEntryDate() {
		return this.clubEntryDate;
	}

	public void setClubEntryDate(Date clubEntryDate) {
		this.clubEntryDate = clubEntryDate;
	}

	public String getForename() {
		return this.forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Liberty getLiberty() {
		return this.liberty;
	}

	public void setLiberty(Liberty liberty) {
		this.liberty = liberty;
	}

	public List<Tournament> getTournaments() {
		return this.tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public List<Game> getGamesAsWhite() {
		return this.gamesAsWhite;
	}

	public void setGamesAsWhite(List<Game> gamesAsWhite) {
		this.gamesAsWhite = gamesAsWhite;
	}

	public Game addGamesAsWhite(Game gamesAsWhite) {
		getGamesAsWhite().add(gamesAsWhite);
		gamesAsWhite.setWhitePlayer(this);

		return gamesAsWhite;
	}

	public Game removeGamesAsWhite(Game gamesAsWhite) {
		getGamesAsWhite().remove(gamesAsWhite);
		gamesAsWhite.setWhitePlayer(null);

		return gamesAsWhite;
	}

	public List<Game> getGamesAsBlack() {
		return this.gamesAsBlack;
	}

	public void setGamesAsBlack(List<Game> gamesAsBlack) {
		this.gamesAsBlack = gamesAsBlack;
	}

	public Game addGamesAsBlack(Game gamesAsBlack) {
		getGamesAsBlack().add(gamesAsBlack);
		gamesAsBlack.setBlackPlayer(this);

		return gamesAsBlack;
	}

	public Game removeGamesAsBlack(Game gamesAsBlack) {
		getGamesAsBlack().remove(gamesAsBlack);
		gamesAsBlack.setBlackPlayer(null);

		return gamesAsBlack;
	}

	public List<GameResult> getWonGames() {
		return this.wonGames;
	}

	public void setWonGames(List<GameResult> wonGames) {
		this.wonGames = wonGames;
	}

	public GameResult addWonGames(GameResult wonGames) {
		getWonGames().add(wonGames);
		wonGames.setWinner(this);

		return wonGames;
	}

	public GameResult removeWonGames(GameResult wonGames) {
		getWonGames().remove(wonGames);
		wonGames.setWinner(null);

		return wonGames;
	}

	public List<GameResult> getLostGames() {
		return this.lostGames;
	}

	public void setLostGames(List<GameResult> lostGames) {
		this.lostGames = lostGames;
	}

	public GameResult addLostGames(GameResult lostGames) {
		getLostGames().add(lostGames);
		lostGames.setLoser(this);

		return lostGames;
	}

	public GameResult removeLostGames(GameResult lostGames) {
		getLostGames().remove(lostGames);
		lostGames.setLoser(null);

		return lostGames;
	}

	public List<MemberFee> getMemberFees() {
		return this.memberFees;
	}

	public void setMemberFees(List<MemberFee> memberFees) {
		this.memberFees = memberFees;
	}

	public MemberFee addMemberFee(MemberFee memberFee) {
		getMemberFees().add(memberFee);
		memberFee.setChessplayer(this);

		return memberFee;
	}

	public MemberFee removeMemberFee(MemberFee memberFee) {
		getMemberFees().remove(memberFee);
		memberFee.setChessplayer(null);

		return memberFee;
	}

    public List<Tournament> getFirstPlaceTournaments() {
        return firstPlaceTournaments;
    }

    public void setFirstPlaceTournaments(List<Tournament> firstPlaceTournaments) {
        this.firstPlaceTournaments = firstPlaceTournaments;
    }

    public List<Tournament> getSecondPlaceTournaments() {
        return secondPlaceTournaments;
    }

    public void setSecondPlaceTournaments(List<Tournament> secondPlaceTournaments) {
        this.secondPlaceTournaments = secondPlaceTournaments;
    }

    public List<Tournament> getThirdPlaceTournaments() {
        return thirdPlaceTournaments;
    }

    public void setThirdPlaceTournaments(List<Tournament> thirdPlaceTournaments) {
        this.thirdPlaceTournaments = thirdPlaceTournaments;
    }
}