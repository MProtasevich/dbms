package by.bsu.fpmi.scdb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the game_result database table.
 * 
 */
@Entity
@Table(name="game_result")
@NamedQueries({
    @NamedQuery(name = "GameResult.findAll", query = "SELECT g FROM GameResult g"),
    @NamedQuery(name = "GameResult.getById", query = "SELECT g FROM GameResult g WHERE g.id=:id")
})
public class GameResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="gameResult")
	private List<Game> games;

	//bi-directional many-to-one association to Chessplayer
	@ManyToOne
	@JoinColumn(name="winner", nullable=false)
	private Chessplayer winner;

	//bi-directional many-to-one association to Chessplayer
	@ManyToOne
	@JoinColumn(name="looser", nullable=false)
	private Chessplayer loser;

	public GameResult() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Game addGame(Game game) {
		getGames().add(game);
		game.setGameResult(this);

		return game;
	}

	public Game removeGame(Game game) {
		getGames().remove(game);
		game.setGameResult(null);

		return game;
	}

	public Chessplayer getWinner() {
		return this.winner;
	}

	public void setWinner(Chessplayer winner) {
		this.winner = winner;
	}

	public Chessplayer getLoser() {
		return this.loser;
	}

	public void setLoser(Chessplayer loser) {
		this.loser = loser;
	}

}