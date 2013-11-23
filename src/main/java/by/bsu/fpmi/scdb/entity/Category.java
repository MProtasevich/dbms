package by.bsu.fpmi.scdb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the title database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query="SELECT c FROM Category c"),
    @NamedQuery(name = "Category.getById", query = "SELECT c FROM Category c WHERE c.id=:id")
})
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="type_of_category", length=32)
	private String typeOfCategory;

	//bi-directional many-to-one association to Chessplayer
	@OneToMany(mappedBy="category")
	private List<Chessplayer> chessplayers;

	public Category() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeOfCategory() {
		return this.typeOfCategory;
	}

	public void setTypeOfCategory(String typeOfCategory) {
		this.typeOfCategory = typeOfCategory;
	}

	public List<Chessplayer> getChessplayers() {
		return this.chessplayers;
	}

	public void setChessplayers(List<Chessplayer> chessplayers) {
		this.chessplayers = chessplayers;
	}

	public Chessplayer addChessplayer(Chessplayer chessplayer) {
		getChessplayers().add(chessplayer);
		chessplayer.setCategory(this);

		return chessplayer;
	}

	public Chessplayer removeChessplayer(Chessplayer chessplayer) {
		getChessplayers().remove(chessplayer);
		chessplayer.setCategory(null);

		return chessplayer;
	}

}