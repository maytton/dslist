package com.maytton.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class BelongingPK {
	
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game id;
	
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GameList list;
	
	public BelongingPK() {
		
	}

	public BelongingPK(Game id, GameList list) {
		this.id = id;
		this.list = list;
	}

	public Game getId() {
		return id;
	}

	public void setId(Game id) {
		this.id = id;
	}

	public GameList getList() {
		return list;
	}
	

	public void setList(GameList List) {
		this.list = List;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(id, other.id) && Objects.equals(list, other.list);
	}
	
	
	
}
