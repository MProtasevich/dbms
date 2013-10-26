package by.bsu.fpmi.scdb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the game database table.
 * 
 */
@Entity
@Table(name="game")
@NamedQueries ({
    @NamedQuery(name = "Game.getById",
                query = "SELECT g FROM Game g WHERE g.id=:id"),
    @NamedQuery(name = "Game.findByPlayersName",
                query = "SELECT g FROM Game g WHERE g.whitePlayer.surname=:surname OR g.blackPlayer.surname=:surname"),
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g")
})
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="num_of_turns")
	private int numOfTurns;

	//bi-directional many-to-one association to Chessplayer
	@ManyToOne
	@JoinColumn(name="white_player_id")
	private Chessplayer whitePlayer;

	//bi-directional many-to-one association to Chessplayer
	@ManyToOne
	@JoinColumn(name="black_player_id")
	private Chessplayer blackPlayer;

	//bi-directional many-to-one association to Debut
	@ManyToOne
	@JoinColumn(name="white_debut_id")
	private Debut whiteDebut;

	//bi-directional many-to-one association to Debut
	@ManyToOne
	@JoinColumn(name="black_debut_id")
	private Debut blackDebut;

	//bi-directional many-to-one association to GameResult
	@ManyToOne
	@JoinColumn(name="result_id")
	private GameResult gameResult;

	//bi-directional many-to-one association to Tournament
	@ManyToOne
	@JoinColumn(name="tournament_id")
	private Tournament tournament;

	public Game() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNumOfTurns() {
		return this.numOfTurns;
	}

	public void setNumOfTurns(int numOfTurns) {
		this.numOfTurns = numOfTurns;
	}

	public Chessplayer getWhitePlayer() {
		return this.whitePlayer;
	}

	public void setWhitePlayer(Chessplayer whitePlayer) {
		this.whitePlayer = whitePlayer;
	}

	public Chessplayer getBlackPlayer() {
		return this.blackPlayer;
	}

	public void setBlackPlayer(Chessplayer blackPlayer) {
		this.blackPlayer = blackPlayer;
	}

	public Debut getWhiteDebut() {
		return this.whiteDebut;
	}

	public void setWhiteDebut(Debut whiteDebut) {
		this.whiteDebut = whiteDebut;
	}

	public Debut getBlackDebut() {
		return this.blackDebut;
	}

	public void setBlackDebut(Debut blackDebut) {
		this.blackDebut = blackDebut;
	}

	public GameResult getGameResult() {
		return this.gameResult;
	}

	public void setGameResult(GameResult gameResult) {
		this.gameResult = gameResult;
	}

	public Tournament getTournament() {
		return this.tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

}