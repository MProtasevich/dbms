package by.bsu.fpmi.scdb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


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
	private List<Chessplayer> chessplayers;

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

	public List<Chessplayer> getChessplayers() {
		return this.chessplayers;
	}

	public void setChessplayers(List<Chessplayer> chessplayers) {
		this.chessplayers = chessplayers;
	}

	public Chessplayer addChessplayer(Chessplayer chessplayer) {
		getChessplayers().add(chessplayer);
		chessplayer.setLiberty(this);

		return chessplayer;
	}

	public Chessplayer removeChessplayer(Chessplayer chessplayer) {
		getChessplayers().remove(chessplayer);
		chessplayer.setLiberty(null);

		return chessplayer;
	}

}