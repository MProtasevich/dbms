package by.bsu.fpmi.scdb.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;


/**
 * The persistent class for the tournament database table.
 */
@Entity
@Table(name="tournament")
@NamedQueries({
    @NamedQuery(name="Tournament.findAll", query="SELECT t FROM Tournament t"),
    @NamedQuery(name="Tournament.getById", query="SELECT t FROM Tournament t WHERE t.id=:id")
})
@SuppressWarnings("unused")
public class Tournament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_completion")
	private Date dateOfCompletion;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_start")
	private Date dateOfStart;

    @Min(value = 0)
	@Column(name="first_place_winnings")
	private float firstPlaceWinnings;

    @Min(value = 0)
	@Column(name="second_place_winnings")
	private float secondPlaceWinnings;

    @Min(value = 0)
	@Column(name="third_place_winnings")
	private float thirdPlaceWinnings;

    @Min(value = 0)
    @Column(name="registration_fee")
    private float registrationFee;

	@Column(length=128)
    @Size(min = 2, max = 128)
	private String title;

	//bi-directional many-to-many association to Chessplayer
	@ManyToMany(mappedBy="tournaments")
    @MapKeyColumn(name = "id")
	private Map<Integer, Chessplayer> chessplayers;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="tournament")
    @MapKeyColumn(name = "id")
	private Map<Integer, Game> games;

	//bi-directional many-to-one association to PlaySystem
	@ManyToOne
	@JoinColumn(name="play_system_id")
	private PlaySystem playSystem;

    @ManyToOne
    @JoinColumn(name = "first_place_player")
    private Chessplayer firstPlacePlayer;

    @ManyToOne
    @JoinColumn(name = "second_place_player")
    private Chessplayer secondPlacePlayer;

    @ManyToOne
    @JoinColumn(name = "third_place_player")
    private Chessplayer thirdPlacePlayer;

	public Tournament() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfCompletion() {
		return this.dateOfCompletion;
	}

	public void setDateOfCompletion(Date dateOfCompletion) {
		this.dateOfCompletion = dateOfCompletion;
	}

	public Date getDateOfStart() {
		return this.dateOfStart;
	}

	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public float getFirstPlaceWinnings() {
		return this.firstPlaceWinnings;
	}

	public void setFirstPlaceWinnings(float firstPlaceFactor) {
		this.firstPlaceWinnings = firstPlaceFactor;
	}

	public float getRegistrationFee() {
		return this.registrationFee;
	}

	public void setRegistrationFee(float registrationFee) {
		this.registrationFee = registrationFee;
	}

	public float getSecondPlaceWinnings() {
		return this.secondPlaceWinnings;
	}

	public void setSecondPlaceWinnings(float secondPlaceFactor) {
		this.secondPlaceWinnings = secondPlaceFactor;
	}

	public float getThirdPlaceWinnings() {
		return this.thirdPlaceWinnings;
	}

	public void setThirdPlaceWinnings(float thirdPlaceFactor) {
		this.thirdPlaceWinnings = thirdPlaceFactor;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Map<Integer, Chessplayer> getChessplayers() {
		return this.chessplayers;
	}

	public void setChessplayers(Map<Integer, Chessplayer> chessplayers) {
		this.chessplayers = chessplayers;
	}

    /*public Chessplayer addChessplayer(Chessplayer player) {
        getGames().put(player.getId(), player);
        player.addTournaments(this);

        return player;
    }

    public Game removeChessplayer(Game game) {
        getGames().remove(game.getId());
        game.setTournament(null);

        return game;
    }*/

	public Map<Integer, Game> getGames() {
		return this.games;
	}

	public void setGames(Map<Integer, Game> games) {
		this.games = games;
	}

	public Game addGame(Game game) {
		getGames().put(game.getId(), game);
		game.setTournament(this);

		return game;
	}

	public Game removeGame(Game game) {
		getGames().remove(game.getId());
		game.setTournament(null);

		return game;
	}

	public PlaySystem getPlaySystem() {
		return this.playSystem;
	}

	public void setPlaySystem(PlaySystem playSystem) {
		this.playSystem = playSystem;
	}

    public Chessplayer getFirstPlacePlayer() {
        return firstPlacePlayer;
    }

    public void setFirstPlacePlayer(Chessplayer firstPlacePlayer) {
        this.firstPlacePlayer = firstPlacePlayer;
    }

    public Chessplayer getSecondPlacePlayer() {
        return secondPlacePlayer;
    }

    public void setSecondPlacePlayer(Chessplayer secondPlacePlayer) {
        this.secondPlacePlayer = secondPlacePlayer;
    }

    public Chessplayer getThirdPlacePlayer() {
        return thirdPlacePlayer;
    }

    public void setThirdPlacePlayer(Chessplayer thirdPlacePlayer) {
        this.thirdPlacePlayer = thirdPlacePlayer;
    }
}