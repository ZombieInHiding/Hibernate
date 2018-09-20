package lti.ex8;

import java.util.HashSet;
import java.util.Set;

public class Category {

	private int id;
	private String name;
	private Category parentCategory; // self-association
	private Set<Category> childCategories; // self association one to many
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
