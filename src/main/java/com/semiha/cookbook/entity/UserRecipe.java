package com.semiha.cookbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "user_recipe")
@EqualsAndHashCode
public class UserRecipe {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("recipeId")
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;
	
	@Column(name = "isSaved")
	private boolean isSaved;

	public UserRecipe(long id, boolean isSaved) {
		super();
		this.id = id;
		this.isSaved = isSaved;
	}

}
