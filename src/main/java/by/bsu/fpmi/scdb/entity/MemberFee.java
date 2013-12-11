package by.bsu.fpmi.scdb.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the member_fees database table.
 * 
 */
@Entity
@Table(name="member_fees")
@NamedQueries({
    @NamedQuery(name="MemberFee.findAll", query="SELECT m FROM MemberFee m ORDER BY year DESC"),
    @NamedQuery(name="MemberFee.getById", query="SELECT m FROM MemberFee m WHERE m.id=:id")
})
public class MemberFee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="fee_amount")
	private float feeAmount;

	private int year;

	//bi-directional many-to-one association to Chessplayer
	@ManyToOne
	@JoinColumn(name="chessplayer_id", nullable=false)
	private Chessplayer chessplayer;

	public MemberFee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getFeeAmount() {
		return this.feeAmount;
	}

	public void setFeeAmount(float feeAmount) {
		this.feeAmount = feeAmount;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Chessplayer getChessplayer() {
		return this.chessplayer;
	}

	public void setChessplayer(Chessplayer chessplayer) {
		this.chessplayer = chessplayer;
	}

}