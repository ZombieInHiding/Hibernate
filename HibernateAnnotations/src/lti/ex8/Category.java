package lti.ex8;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cate_1")
public class Category {
	@Id
	@GeneratedValue
	@Column(name = "cat_id")
	private int id;
	private String name;

	@ManyToOne
	@JoinColumn(name = "parent_id", nullable = true)
	private Category parentCategory; // self-association

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id")
	private Set<Category> childCategories; // self association one to many

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cat_item_1", joinColumns = { @JoinColumn(name = "cat_id") }, inverseJoinColumns = {
			@JoinColumn(name = "item_id") })
	private Set<Item> items; // many to many

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

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Set<Category> getChildCategories() {
		return childCategories == null ? new HashSet<Category>() : childCategories;
	}

	public void setChildCategories(Set<Category> childCategories) {
		this.childCategories = childCategories;
	}

	public Set<Item> getItems() {
		return items == null ? new HashSet<Item>() : items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Category [ id = " + id + ", name = " + name + " ]";
	}

}
