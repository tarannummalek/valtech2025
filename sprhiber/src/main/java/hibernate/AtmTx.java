package hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "atx")
//@Table(name="atmtxper")
public class AtmTx extends Tx {
	

	@Override
	public String toString() {
		return "AtmTx [atm=" + atm + ", getId()=" + getId() + ", getAmount()=" + getAmount() + "]";
	}

	private int atm;

	public AtmTx() {
	}

	

	public AtmTx(double amount, int atm) {
		super(amount);
		this.atm=atm;
		// TODO Auto-generated constructor stub
	}



	public int getAtm() {
		return atm;
	}

	public void setAtm(int atm) {
		this.atm = atm;
	}
	
	

}
