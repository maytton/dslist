package com.maytton.dslist.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maytton.dslist.dto.GameDTO;
import com.maytton.dslist.dto.GameMinDTO;
import com.maytton.dslist.entities.Game;
import com.maytton.dslist.projections.GameMinProjection;
import com.maytton.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		gameRepository.findAll();
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		gameRepository.findAll();
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		
	}
}
