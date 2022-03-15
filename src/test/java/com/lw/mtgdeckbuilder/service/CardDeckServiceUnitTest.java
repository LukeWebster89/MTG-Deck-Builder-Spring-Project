package com.lw.mtgdeckbuilder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.lw.mtgdeckbuilder.entity.CardDeck;
import com.lw.mtgdeckbuilder.repo.CardDeckRepo;



@SpringBootTest
public class CardDeckServiceUnitTest {
	
	@Autowired
	private CardDeckService service;
	
	@MockBean
	private CardDeckRepo repo;
	
	@Test
	public void createCardTest() {
		CardDeck input = new CardDeck("luke", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
		CardDeck output = new CardDeck(1L,"luke", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
		
		Mockito.when(this.repo.save(input)).thenReturn(output);
		
		assertEquals(output, this.service.create(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	
	@Test
	public void updateTest() {
		Optional<CardDeck> optionalUpdate = Optional.of(new CardDeck(1L,"luke", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare"));
		CardDeck cardChange = new CardDeck(1L,"Luke Webster", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
		
		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalUpdate);
		
		Mockito.when(this.repo.saveAndFlush(cardChange)).thenReturn(cardChange);
		
		assertEquals(cardChange, this.service.update(Mockito.anyLong(), cardChange));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(cardChange);
		
	}
	
	@Test
	public void readByIdTest() {
		Optional<CardDeck> optionalOutput = Optional.of(new CardDeck(1L,"luke", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare"));
		CardDeck output = new CardDeck(1L,"luke", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
		
		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutput);
		
		assertEquals(output, this.service.readById(Mockito.anyLong()));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
	}
	
	@Test
	public void readAllTest() {
		CardDeck card = new CardDeck(1L,"luke", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
			List<CardDeck> input = new ArrayList<>();
			input.add(card);
			List<CardDeck> output = new ArrayList<>(input);
			
			Mockito.when(this.repo.findAll()).thenReturn(output);
			
			assertEquals(output, this.service.readAll());
			
			Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test 
	public void deleteTrueTest() {
		
		Mockito.when(this.repo.existsById(Mockito.anyLong())).thenReturn(false);
		
		assertTrue(this.service.delete(Mockito.anyLong()));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(Mockito.anyLong());
		Mockito.verify(this.repo, Mockito.times(1)).existsById(Mockito.anyLong());
	}
	
	@Test 
	public void deleteFalseTest() {
		
		Mockito.when(this.repo.existsById(Mockito.anyLong())).thenReturn(true);
		
		assertFalse(this.service.delete(Mockito.anyLong()));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(Mockito.anyLong());
		Mockito.verify(this.repo, Mockito.times(1)).existsById(Mockito.anyLong());
	}

}
