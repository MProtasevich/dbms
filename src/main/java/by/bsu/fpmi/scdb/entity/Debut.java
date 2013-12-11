package by.bsu.fpmi.scdb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;


/**
 * The persistent class for the debut database table.
 * 
 */
@Entity
@Table(name="debut")
@NamedQueries({
    @NamedQuery(name = "Debut.findAll", query = "SELECT d FROM Debut d"),
    @NamedQuery(name = "Debut.getById", query = "SELECT d FROM Debut d WHERE d.id=:id")
})
public class Debut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="debut_descr", length=128)
	private String debutDescr;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="whiteDebut")
    @MapKeyColumn(name = "id")
	private Map<Integer, Game> gamesAsWhite;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="blackDebut")
    @MapKeyColumn(name = "id")
	private Map<Integer, Game> gamesAsBlack;

	public Debut() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDebutDescr() {
		return this.debutDescr;
	}

	public void setDebutDescr(String debutDescr) {
		this.debutDescr = debutDescr;
	}

	public Map<Integer, Game> getGamesAsWhite() {
		return this.gamesAsWhite;
	}

	public void setGamesAsWhite(Map<Integer, Game> gamesAsWhite) {
		this.gamesAsWhite = gamesAsWhite;
	}

	public Game addGamesAsWhite(Game gamesAsWhite) {
		getGamesAsWhite().put(gamesAsWhite.getId(), gamesAsWhite);
		gamesAsWhite.setWhiteDebut(this);

		return gamesAsWhite;
	}

	public Game removeGamesAsWhite(Game gamesAsWhite) {
		getGamesAsWhite().remove(gamesAsWhite.getId());
		gamesAsWhite.setWhiteDebut(null);

		return gamesAsWhite;
	}

	public Map<Integer, Game> getGamesAsBlack() {
		return this.gamesAsBlack;
	}

	public void setGamesAsBlack(Map<Integer, Game> gamesAsBlack) {
		this.gamesAsBlack = gamesAsBlack;
	}

	public Game addGamesAsBlack(Game gamesAsBlack) {
		getGamesAsBlack().put(gamesAsBlack.getId(), gamesAsBlack);
		gamesAsBlack.setBlackDebut(this);

		return gamesAsBlack;
	}

	public Game removeGamesAsBlack(Game gamesAsBlack) {
		getGamesAsBlack().remove(gamesAsBlack.getId());
		gamesAsBlack.setBlackDebut(null);

		return gamesAsBlack;
	}
}