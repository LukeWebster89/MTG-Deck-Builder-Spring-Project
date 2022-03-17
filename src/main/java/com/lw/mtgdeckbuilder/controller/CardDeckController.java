package com.lw.mtgdeckbuilder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lw.mtgdeckbuilder.entity.CardDeck;
import com.lw.mtgdeckbuilder.service.CardDeckService;

@RestController
@RequestMapping("/card_deck")
public class CardDeckController {
	
	private CardDeckService service;
	
	@Autowired
	public CardDeckController(CardDeckService service) {
		this.service = service;
	}
	
	//create
	@PostMapping("/create")
	public ResponseEntity<CardDeck> createCard(@RequestBody CardDeck card){
		return new ResponseEntity<CardDeck>(this.service.create(card), HttpStatus.CREATED);
	}
	
	//read all
	@GetMapping("/readAll")
	public ResponseEntity<List<CardDeck>> readAllCards(){
		return new ResponseEntity<List<CardDeck>>(this.service.readAll(), HttpStatus.OK);
	}
	
	//read by id
	@GetMapping("/readById/{id}")
	public ResponseEntity<CardDeck> readById(@PathVariable long id){
		return new ResponseEntity<CardDeck>(this.service.readById(id), HttpStatus.OK);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<CardDeck> updateCard(@PathVariable long id, @RequestBody CardDeck card){
		return new ResponseEntity<CardDeck>(this.service.update(id, card), HttpStatus.ACCEPTED);
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteCard(@PathVariable long id){
		return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT):
			new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
