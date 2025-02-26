
package hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Account {
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "accseq")
	@SequenceGenerator(name="accseq",allocationSize = 1,sequenceName = "acc_seq")
	private int id ;
	private double balance;
	private String type;
	@OneToMany(targetEntity = Tx.class,mappedBy = "account",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	private Set<Tx> txs;
	@ManyToMany(targetEntity = Customer.class, fetch =FetchType.LAZY,mappedBy = "accounts")
	private Set<Customer> customers;
	//helper methods  
	public void addTx(Tx tx) {
		if(txs==null) txs=new HashSet<Tx>();
		txs.add(tx);
		tx.setAccount(this);
	}
	public void removeTx(Tx tx) {
		txs.remove(tx);
		tx.setAccount(null);
		
	}
	
	public Account() {
	}
	public Account( double balance, String type) {
		this.balance = balance;
		this.type = type;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<Tx> getTxs() {
		return txs;
	}public void setTxs(Set<Tx> txs) {
		this.txs = txs;
	}
	public Set<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", type=" + type + "]";
	}
	
	
	
	
	
	

}
