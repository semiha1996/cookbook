package com.semiha.cookbook.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "recipe")
@EqualsAndHashCode
public class Recipe {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recipeId;

	@Column(name = "name")
	private String recipeName;

	@Column(name = "imgUrl")
	private String imgUrl;

	@Column(name = "ingredients")
	private String ingredients;

	@Column(name = "instructions")
	private String instructions;

	@Column(name = "cookingTime")
	private String cookingTime;

	@Column(name = "source")
	private String source;

	public Recipe(Long recipeId, String recipeName, String imgUrl, String ingredients, String instructions,
			String cookingTime, String source, String quantity) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.imgUrl = imgUrl;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.cookingTime = cookingTime;
		this.source = source;
	}

	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<UserRecipe> users;

	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments;

}
