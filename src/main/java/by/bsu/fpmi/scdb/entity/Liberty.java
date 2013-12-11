package by.bsu.fpmi.scdb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;


/**
 * The persistent class for the liberties database table.
 * 
 */
@Entity
@Table(name="liberties")
@NamedQueries({
    @NamedQuery(name= "Liberty.findAll", query="SELECT l FROM Liberty l"),
    @NamedQuery(name= "Liberty.getById", query="SELECT l FROM Liberty l WHERE l.id=:id")
})
public class Liberty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private float discount;

	@Column(name="liberty_descr", nullable=false, length=128)
	private String libertyDescr;

	//bi-directional many-to-one association to Chessplayer
	@OneToMany(mappedBy="liberty")
    @MapKeyColumn(name = "id")
	private Map<Integer, Chessplayer> chessplayers;

	public Liberty() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getDiscount() {
		return this.discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getLibertyDescr() {
		return this.libertyDescr;
	}

	public void setLibertyDescr(String libertyDescr) {
		this.libertyDescr = libertyDescr;
	}

	public Map<Integer, Chessplayer> getChessplayers() {
		return this.chessplayers;
	}

	public void setChessplayers(Map<Integer, Chessplayer> chessplayers) {
		this.chessplayers = chessplayers;
	}

	public Chessplayer addChessplayer(Chessplayer chessplayer) {
		getChessplayers().put(chessplayer.getId(), chessplayer);
		chessplayer.setLiberty(this);

		return chessplayer;
	}

	public Chessplayer removeChessplayer(Chessplayer chessplayer) {
		getChessplayers().remove(chessplayer.getId());
		chessplayer.setLiberty(null);

		return chessplayer;
	}
}