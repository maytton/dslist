package com.maytton.dslist.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maytton.dslist.dto.GameListDTO;
import com.maytton.dslist.dto.GameMinDTO;
import com.maytton.dslist.entities.Game;
import com.maytton.dslist.entities.GameList;
import com.maytton.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		gameListRepository.findAll();
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
}
