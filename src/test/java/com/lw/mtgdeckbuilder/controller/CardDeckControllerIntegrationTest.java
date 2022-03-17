package com.lw.mtgdeckbuilder.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lw.mtgdeckbuilder.entity.CardDeck;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:card-schema.sql","classpath:card-data.sql"})
public class CardDeckControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void testCreate() throws Exception{
		CardDeck newCard = new CardDeck("Alesha, Who Smiles at Death", "2c,1red", "Legendary Creture - Human Warrior", 3, 2, "First Strike", "Rare");
		String newCardAsJSON = this.mapper.writeValueAsString(newCard);
		RequestBuilder req = post("/card_deck/create").content(newCardAsJSON).contentType(MediaType.APPLICATION_JSON);
		
		
		CardDeck savedCard = new CardDeck(2, "Alesha, Who Smiles at Death", "2c,1red", "Legendary Creture - Human Warrior", 3, 2, "First Strike", "Rare");
		String savedCardAsJSON = this.mapper.writeValueAsString(savedCard);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(savedCardAsJSON);
		
		this.mvc.perform(req).andExpect(checkBody).andExpect(checkStatus);
	}
	
	@Test
	public void testReadAll() throws Exception{
		CardDeck  deck = new CardDeck (1L, "luke", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
		List<CardDeck > cards = new ArrayList<>();
		cards.add(deck);
		String cardsOutputAsJSON = this.mapper.writeValueAsString(cards); 
		
		this.mvc.perform(get("/card_deck/readAll").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(cardsOutputAsJSON)); 
	} 
	 
	@Test
	public void testReadById() throws Exception {
		RequestBuilder req = get("/card_deck/readById/1"); 
				
		CardDeck savedCard = new CardDeck(1L, "luke", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
		String savedCardAsJSON = this.mapper.writeValueAsString(savedCard);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(savedCardAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test
	public void testDelete() throws Exception{
		RequestBuilder req = delete("/card_deck/delete/1");
		
		ResultMatcher checkstatus = status().isNoContent();
		
		
		this.mvc.perform(req).andExpect(checkstatus);
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		CardDeck cardUpdate = new CardDeck(1L, "Luke Webster", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
		String cardUpdateAsJSON = this.mapper.writeValueAsString(cardUpdate);
		
		CardDeck cardChange = new CardDeck (1L, "Luke Webster", "3c,1blue", "Legendary Planeswalker - Human", 6, 6, "Double Strike", "Mythic Rare");
		String cardChangeAsJSON = this.mapper.writeValueAsString(cardChange);
		
		RequestBuilder req = put("/card_deck/update/1").content(cardUpdateAsJSON).contentType(MediaType.APPLICATION_JSON);
				
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(cardChangeAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody); 
	}  

}   
