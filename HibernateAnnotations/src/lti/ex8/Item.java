package lti.ex8;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="item_1")
public class Item {
	@Id
	@GeneratedValue
	@Column(name="item_id")
	private int id;
	private String name;
	private String description;
	private double initialPrice;
	private Double totalBids; //used for formula property & is not saved in sql but is fetched during fetch commands
	private Double maxBidAmount; //used for formula property & is not saved in sql but is fetched during fetch commands
	private double reservePrice;
	private Date validTill;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cat_item_1", joinColumns = { @JoinColumn(name = "item_id") }, inverseJoinColumns = {
			@JoinColumn(name = "cat_id") })
	private Set<Category> categories; // many to many
	
	@OneToMany(mappedBy="item", cascade = CascadeType.ALL)
	private Set<Bid> bids; // one to many

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}

	public Double getTotalBids() {
		return totalBids;
	}

	public void setTotalBids(Double totalBids) {
		this.totalBids = totalBids;
	}

	public Double getMaxBidAmount() {
		return maxBidAmount;
	}

	public void setMaxBidAmount(Double maxBidAmount) {
		this.maxBidAmount = maxBidAmount;
	}

	public double getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(double reservePrice) {
		this.reservePrice = reservePrice;
	}

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public Set<Category> getCategories() {
		return categories == null ? new HashSet<Category>() : categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<Bid> getBids() {
		return bids == null ? new HashSet<Bid>() : bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	@Override
	public String toString() {
		return "Item [ id = " + id + ", name = " + name + ", description = " + description + ", initialPrice = "
				+ initialPrice + ", totalBids = " + totalBids + ", maxBidAmount = " + maxBidAmount + ", reservePrice = "
				+ reservePrice + ", validTill = " + validTill + " ]";
	}

}
