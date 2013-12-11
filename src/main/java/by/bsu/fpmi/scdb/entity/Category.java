package by.bsu.fpmi.scdb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;


@Entity
@Table(name="category")
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
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

	@OneToMany(mappedBy="category")
    @MapKeyColumn(name = "id")
	private Map<Integer, Chessplayer> chessplayers;

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

	public Map<Integer, Chessplayer> getChessplayers() {
		return this.chessplayers;
	}

	public void setChessplayers(Map<Integer, Chessplayer> chessplayers) {
		this.chessplayers = chessplayers;
	}

	public Chessplayer addChessplayer(Chessplayer chessplayer) {
		getChessplayers().put(chessplayer.getId(), chessplayer);
		chessplayer.setCategory(this);

		return chessplayer;
	}

	public Chessplayer removeChessplayer(Chessplayer chessplayer) {
		getChessplayers().remove(chessplayer.getId());
		chessplayer.setCategory(null);

		return chessplayer;
	}
}