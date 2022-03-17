package com.lw.mtgdeckbuilder.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.lw.mtgdeckbuilder.entity.CardDeck;
import com.lw.mtgdeckbuilder.service.CardDeckService;

@SpringBootTest
public class CardDeckControllerUnitTest {
	
	@Autowired
	private CardDeckController controller;
	
	@MockBean
	private CardDeckService service;
	
	@Test
	public void createCardTest() {
		CardDeck card = new CardDeck(1L, "luke", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
		
		Mockito.when(this.service.create(card)).thenReturn(card);
		
		ResponseEntity<CardDeck> response = new ResponseEntity<CardDeck>(card, HttpStatus.CREATED);
		
		assertThat(response).isEqualTo(this.controller.createCard(card));
		
		Mockito.verify(this.service, times(1)).create(card);
	}
	
	@Test
	public void readAllTest() {
		CardDeck card = new CardDeck(1L, "luke", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
		List<CardDeck> cards = new ArrayList<>();
		cards.add(card);
		
		Mockito.when(this.service.readAll()).thenReturn(cards);
		
		ResponseEntity<List<CardDeck>> response = new ResponseEntity<List<CardDeck>>(cards, HttpStatus.OK);
		
		assertThat(response).isEqualTo(this.controller.readAllCards());
		
		Mockito.verify(this.service, times(1)).readAll();
	}
	
	@Test
	public void readByIdTest() {
		CardDeck card = new CardDeck(1L, "luke", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
		
		Mockito.when(this.service.readById(1)).thenReturn(card);
		
		ResponseEntity<CardDeck> response = new ResponseEntity<CardDeck>(card, HttpStatus.OK);
		
		assertThat(response).isEqualTo(this.controller.readById(1));
		
		Mockito.verify(this.service, times(1)).readById(1);
		
	}
	
	@Test
	public void updateTest() {
		CardDeck cardUpdate = new CardDeck(1L, "Luke Webster", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
		CardDeck cardChange = new CardDeck(1L, "Luke Webster", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
		
		Mockito.when(this.service.update(1, cardUpdate)).thenReturn(cardChange);
		
		ResponseEntity<CardDeck> response = new ResponseEntity<CardDeck>(cardChange, HttpStatus.ACCEPTED);
		
		assertThat(response).isEqualTo(this.controller.updateCard(1, cardUpdate));
		
		Mockito.verify(this.service, times(1)).update(1, cardUpdate);
	}
	
	@Test
	public void deleteTrueTest() {
		Mockito.when(this.service.delete(1)).thenReturn(true);
		
		ResponseEntity<CardDeck> response = new ResponseEntity<CardDeck>(HttpStatus.NO_CONTENT);
		
		assertThat(response).isEqualTo(this.controller.deleteCard(1));
				
		Mockito.verify(this.service, times(1)).delete(1);
	}
	
	@Test
	public void deleteFalseTest() {
		Mockito.when(this.service.delete(2)).thenReturn(false);
		
		ResponseEntity<CardDeck> response = new ResponseEntity<CardDeck>(HttpStatus.NOT_FOUND);
		
		assertThat(response).isEqualTo(this.controller.deleteCard(2));
		
		Mockito.verify(this.service, times(1)).delete(2);
	}
	
	

}
