package com.maytton.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maytton.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList,Long>{
	

}
