package by.bsu.fpmi.scdb.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Assasin
 * Date: 11/17/13
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "member_fees", schema = "", catalog = "scdb_lab1")
@Entity
public class MemberFees {
    private int id;

    @javax.persistence.Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private float feeAmount;

    @javax.persistence.Column(name = "fee_amount")
    @Basic
    public float getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(float feeAmount) {
        this.feeAmount = feeAmount;
    }

    private Date year;

    @javax.persistence.Column(name = "year")
    @Basic
    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        MemberFees that = (MemberFees) o;

        if(Float.compare(that.feeAmount, feeAmount) != 0) {
            return false;
        }
        if(id != that.id) {
            return false;
        }
        if(year != null ? !year.equals(that.year) : that.year != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (feeAmount != +0.0f ? Float.floatToIntBits(feeAmount) : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
