package by.bsu.fpmi.scdb.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;


@Entity
@Table(name="chessplayer")
@NamedQueries({
    @NamedQuery(name = "Chessplayer.findAll",
            query = "SELECT c FROM Chessplayer c"),

    @NamedQuery(name = "Chessplayer.getById",
                query = "SELECT c FROM Chessplayer c WHERE c.id=:id"),

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
            "      AND t MEMBER OF c.tournaments GROUP BY c.id" +
            "      ORDER BY c.birthdate ASC"),

    @NamedQuery(name = "Chessplayer.findPlayersIn",
    query = "SELECT cp FROM Chessplayer cp WHERE cp.id IN(:ids)"),

    @NamedQuery(name="Chessplayer.findWithUnpaidFees",
    query = "SELECT c FROM Chessplayer c WHERE c.id NOT IN " +
              "(SELECT m.chessplayer.id FROM MemberFee m " +
                "WHERE m.year=YEAR(CURRENT_DATE))")
})

/*@NamedNativeQueries({
    @NamedNativeQuery(name="Chessplayer.findWithUnpaidFees",
        query="SELECT * FROM chessplayer WHERE id NOT IN " +
                "(SELECT chessplayer_id FROM member_fees WHERE year=YEAR(CURDATE()))",
        resultClass = Chessplayer.class)
})*/
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
    @MapKeyColumn(name = "id")
	private Map<Integer, Tournament> tournaments;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="whitePlayer")
    @MapKeyColumn(name = "id")
	private Map<Integer, Game> gamesAsWhite;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="blackPlayer")
    @MapKeyColumn(name = "id")
	private Map<Integer, Game> gamesAsBlack;

	//bi-directional many-to-one association to GameResult
	@OneToMany(mappedBy="winner")
    @MapKeyColumn(name = "id")
	private Map<Integer, GameResult> wonGames;

	//bi-directional many-to-one association to GameResult
	@OneToMany(mappedBy="loser")
    @MapKeyColumn(name = "id")
	private Map<Integer, GameResult> lostGames;

	//bi-directional many-to-one association to MemberFee
	@OneToMany(mappedBy="chessplayer")
    @MapKeyColumn(name = "id")
	private Map<Integer, MemberFee> memberFees;

    @OneToMany(mappedBy = "firstPlacePlayer")
    @MapKeyColumn(name = "id")
    private Map<Integer, Tournament> firstPlaceTournaments;

    @OneToMany(mappedBy = "secondPlacePlayer")
    @MapKeyColumn(name = "id")
    private Map<Integer, Tournament> secondPlaceTournaments;

    @OneToMany(mappedBy = "thirdPlacePlayer")
    @MapKeyColumn(name = "id")
    private Map<Integer, Tournament> thirdPlaceTournaments;

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

	public Map<Integer, Tournament> getTournaments() {
		return this.tournaments;
	}

	public void setTournaments(Map<Integer, Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public Map<Integer, Game> getGamesAsWhite() {
		return this.gamesAsWhite;
	}

	public void setGamesAsWhite(Map<Integer, Game> gamesAsWhite) {
		this.gamesAsWhite = gamesAsWhite;
	}

	public Game addGamesAsWhite(Game gameAsWhite) {
		getGamesAsWhite().put(gameAsWhite.getId(), gameAsWhite);
		gameAsWhite.setWhitePlayer(this);

		return gameAsWhite;
	}

	public Game removeGamesAsWhite(Game gamesAsWhite) {
		getGamesAsWhite().remove(gamesAsWhite.getId());
		gamesAsWhite.setWhitePlayer(null);

		return gamesAsWhite;
	}

	public Map<Integer, Game> getGamesAsBlack() {
		return this.gamesAsBlack;
	}

	public void setGamesAsBlack(Map<Integer, Game> gamesAsBlack) {
		this.gamesAsBlack = gamesAsBlack;
	}

	public Game addGamesAsBlack(Game gameAsBlack) {
		getGamesAsBlack().put(gameAsBlack.getId(), gameAsBlack);
		gameAsBlack.setBlackPlayer(this);

		return gameAsBlack;
	}

	public Game removeGamesAsBlack(Game gameAsBlack) {
		getGamesAsBlack().remove(gameAsBlack.getId());
		gameAsBlack.setBlackPlayer(null);

		return gameAsBlack;
	}

	public Map<Integer, GameResult> getWonGames() {
		return this.wonGames;
	}

	public void setWonGames(Map<Integer, GameResult> wonGames) {
		this.wonGames = wonGames;
	}

	public GameResult addWonGames(GameResult wonGames) {
		getWonGames().put(wonGames.getId(), wonGames);
		wonGames.setWinner(this);

		return wonGames;
	}

	public GameResult removeWonGames(GameResult wonGames) {
		getWonGames().remove(wonGames.getId());
		wonGames.setWinner(null);

		return wonGames;
	}

	public Map<Integer, GameResult> getLostGames() {
		return this.lostGames;
	}

	public void setLostGames(Map<Integer, GameResult> lostGames) {
		this.lostGames = lostGames;
	}

	public GameResult addLostGames(GameResult lostGames) {
		getLostGames().put(lostGames.getId(), lostGames);
		lostGames.setLoser(this);

		return lostGames;
	}

	public GameResult removeLostGames(GameResult lostGames) {
		getLostGames().remove(lostGames.getId());
		lostGames.setLoser(null);

		return lostGames;
	}

	public Map<Integer, MemberFee> getMemberFees() {
		return this.memberFees;
	}

	public void setMemberFees(Map<Integer, MemberFee> memberFees) {
		this.memberFees = memberFees;
	}

	public MemberFee addMemberFee(MemberFee memberFee) {
		getMemberFees().put(memberFee.getId(), memberFee);
		memberFee.setChessplayer(this);

		return memberFee;
	}

	public MemberFee removeMemberFee(MemberFee memberFee) {
		getMemberFees().remove(memberFee.getId());
		memberFee.setChessplayer(null);

		return memberFee;
	}

    public Map<Integer, Tournament> getFirstPlaceTournaments() {
        return firstPlaceTournaments;
    }

    public void setFirstPlaceTournaments(Map<Integer, Tournament> firstPlaceTournaments) {
        this.firstPlaceTournaments = firstPlaceTournaments;
    }

    public Tournament addFirstPlaceTournament(Tournament tournament) {
        getFirstPlaceTournaments().put(tournament.getId(), tournament);
        tournament.setFirstPlacePlayer(this);

        return tournament;
    }

    public Tournament removeFirstPlaceTournament(Tournament tournament) {
        getFirstPlaceTournaments().remove(tournament.getId());
        tournament.setFirstPlacePlayer(null);

        return tournament;
    }

    public Map<Integer, Tournament> getSecondPlaceTournaments() {
        return secondPlaceTournaments;
    }

    public void setSecondPlaceTournaments(Map<Integer, Tournament> secondPlaceTournaments) {
        this.secondPlaceTournaments = secondPlaceTournaments;
    }

    public Tournament addSecondPlaceTournament(Tournament tournament) {
        getSecondPlaceTournaments().put(tournament.getId(), tournament);
        tournament.setSecondPlacePlayer(this);

        return tournament;
    }

    public Tournament removeSecondPlaceTournament(Tournament tournament) {
        getSecondPlaceTournaments().remove(tournament.getId());
        tournament.setSecondPlacePlayer(null);

        return tournament;
    }

    public Map<Integer, Tournament> getThirdPlaceTournaments() {
        return thirdPlaceTournaments;
    }

    public void setThirdPlaceTournaments(Map<Integer, Tournament> thirdPlaceTournaments) {
        this.thirdPlaceTournaments = thirdPlaceTournaments;
    }

    public Tournament addThirdPlaceTournament(Tournament tournament) {
        getThirdPlaceTournaments().put(tournament.getId(), tournament);
        tournament.setThirdPlacePlayer(this);

        return tournament;
    }

    public Tournament removeThirdPlaceTournament(Tournament tournament) {
        getThirdPlaceTournaments().remove(tournament.getId());
        tournament.setThirdPlacePlayer(null);

        return tournament;
    }
}