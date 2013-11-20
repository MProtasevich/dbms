package by.bsu.fpmi.scdb.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Assasin
 * Date: 11/17/13
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Liberties {
    private int id;

    @javax.persistence.Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String libertyDescr;

    @javax.persistence.Column(name = "liberty_descr")
    @Basic
    public String getLibertyDescr() {
        return libertyDescr;
    }

    public void setLibertyDescr(String libertyDescr) {
        this.libertyDescr = libertyDescr;
    }

    private float discount;

    @javax.persistence.Column(name = "discount")
    @Basic
    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        Liberties liberties = (Liberties) o;

        if(Float.compare(liberties.discount, discount) != 0) {
            return false;
        }
        if(id != liberties.id) {
            return false;
        }
        if(libertyDescr != null ? !libertyDescr.equals(liberties.libertyDescr) : liberties.libertyDescr != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (libertyDescr != null ? libertyDescr.hashCode() : 0);
        result = 31 * result + (discount != +0.0f ? Float.floatToIntBits(discount) : 0);
        return result;
    }
}
