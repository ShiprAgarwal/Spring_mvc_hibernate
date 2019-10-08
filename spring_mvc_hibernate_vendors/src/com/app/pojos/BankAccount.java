package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "bank_accts")
public class BankAccount {
	private Integer acctId;
	private AcType type;
	private double balance;
	private Vendor owner;

	public BankAccount() {
		System.out.println("in constr of " + getClass().getName());
	}

	
	public BankAccount(AcType type, double balance) {
		super();
		
		this.type = type;
		this.balance = balance;
		
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="acct_id")
	public Integer getAcctId() {
		return acctId;
	}

	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="ac_type")
	public AcType getType() {
		return type;
	}


	public void setType(AcType type) {
		this.type = type;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	@ManyToOne
	@JoinColumn(name="vendor_id")
	public Vendor getOwner() {
		return owner;
	}

	public void setOwner(Vendor owner) {
		this.owner = owner;
	}


	@Override
	public String toString() {
		return "BankAccount [acctId=" + acctId + ", type=" + type + ", balance=" + balance + "]";
	}

	

}
