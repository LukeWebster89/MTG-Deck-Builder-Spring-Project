package com.lw.mtgdeckbuilder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.lw.mtgdeckbuilder.entity.CardDeck;
import com.lw.mtgdeckbuilder.repo.CardDeckRepo;

@Service
public class CardDeckService implements ServiceMethods<CardDeck>{
	
	private CardDeckRepo repo;
	
	public CardDeckService(CardDeckRepo repo) {
		this.repo = repo;
	}

	@Override
	public CardDeck create(CardDeck card) {
		
		return this.repo.save(card);
		
	}

	@Override
	public List<CardDeck> readAll() {
		
		return this.repo.findAll();
	}

	@Override
	public CardDeck readById(long id) {
		Optional<CardDeck> getCard = this.repo.findById(id);
		if(getCard.isPresent()) {
			
			return getCard.get();
		}
		
		return null;

	}

	@Override
	public CardDeck update(long id, CardDeck card) {
		Optional<CardDeck> existingCard = this.repo.findById(id);
		if(existingCard.isPresent()) {
			CardDeck exists = existingCard.get();
			exists.setName(card.getName());
			exists.setManaCost(card.getManaCost());
			exists.setType(card.getType());
			exists.setPower(card.getPower());
			exists.setToughness(card.getToughness());
			exists.setAbilities(card.getAbilities());
			exists.setRarity(card.getRarity());
			
			return this.repo.saveAndFlush(exists);
		}
		
		return null;
		
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
		
	}
	

}
