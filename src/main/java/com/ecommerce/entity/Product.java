package com.ecommerce.entity;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Product {
	@Id
	private int id;
	private String name;
	private Double prize;
	private String discription;
	private String mfg_date;
	private String exp_date;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, Double prize, String discription, String mfg_date, String exp_date) {
		super();
		this.id = id;
		this.name = name;
		this.prize = prize;
		this.discription = discription;
		this.mfg_date = mfg_date;
		this.exp_date = exp_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrize() {
		return prize;
	}

	public void setPrize(Double prize) {
		this.prize = prize;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getMfg_date() {
		return mfg_date;
	}

	public void setMfg_date(String mfg_date) {
		this.mfg_date = mfg_date;
	}

	public String getExp_date() {
		return exp_date;
	}

	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(discription, exp_date, id, mfg_date, name, prize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(discription, other.discription) && Objects.equals(exp_date, other.exp_date)
				&& id == other.id && Objects.equals(mfg_date, other.mfg_date) && Objects.equals(name, other.name)
				&& Objects.equals(prize, other.prize);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", prize=" + prize + ", discription=" + discription
				+ ", mfg_date=" + mfg_date + ", exp_date=" + exp_date + "]";
	}
	
	
	
}
