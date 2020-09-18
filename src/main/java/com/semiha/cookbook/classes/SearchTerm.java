package com.semiha.cookbook.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchTerm {
	private String searchTerm;

	public SearchTerm(String searchTerm) {
		super();
		this.searchTerm = searchTerm;
	}
	
	
}
