package hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "ctx")
//@Table(name="chequetxper")
public class ChequeTx extends Tx {
	
	private int chequeNo;

	public int getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}

	public ChequeTx(double amount,int chequeNo) {
		super(amount);
		this.chequeNo = chequeNo;
	}

	public ChequeTx() {
	}

	@Override
	public String toString() {
		return "ChequeTx [chequeNo=" + chequeNo + ", getId()=" + getId() + ", getAmount()=" + getAmount() + "]";
	}

	

	

}
