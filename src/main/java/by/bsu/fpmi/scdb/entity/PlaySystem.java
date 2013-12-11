package by.bsu.fpmi.scdb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;


/**
 * The persistent class for the play_system database table.
 * 
 */
@Entity
@Table(name="play_system")
@NamedQueries({
    @NamedQuery(name="PlaySystem.findAll", query="SELECT p FROM PlaySystem p"),
    @NamedQuery(name="PlaySystem.getById", query="SELECT p FROM PlaySystem p WHERE p.id=:id")
})
public class PlaySystem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="system_descr", length=128)
	private String systemDescr;

	//bi-directional many-to-one association to Tournament
	@OneToMany(mappedBy="playSystem")
    @MapKeyColumn(name = "id")
	private Map<Integer, Tournament> tournaments;

	public PlaySystem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSystemDescr() {
		return this.systemDescr;
	}

	public void setSystemDescr(String systemDescr) {
		this.systemDescr = systemDescr;
	}

	public Map<Integer, Tournament> getTournaments() {
		return this.tournaments;
	}

	public void setTournaments(Map<Integer, Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public Tournament addTournament(Tournament tournament) {
		getTournaments().put(tournament.getId(), tournament);
		tournament.setPlaySystem(this);

		return tournament;
	}

	public Tournament removeTournament(Tournament tournament) {
		getTournaments().remove(tournament.getId());
		tournament.setPlaySystem(null);

		return tournament;
	}
}