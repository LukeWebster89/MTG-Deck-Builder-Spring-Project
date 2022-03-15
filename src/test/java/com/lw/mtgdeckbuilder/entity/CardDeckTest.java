package com.lw.mtgdeckbuilder.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CardDeckTest {
	
	@Test
	public void testEquals(){
		EqualsVerifier.forClass(CardDeck.class).usingGetClass().verify();
	}
	
	@Test
	public void testGetAndSet() {
		CardDeck card = new CardDeck();
		
		card.setId(1L);
		card.setAbilities("Double Strike");
		card.setManaCost("1c,1green");
		card.setName("Tree");
		card.setPower(4);
		card.setToughness(4);
		card.setRarity("Rare");
		card.setType("Tree creature");
		
		
		assertNotNull(card.getAbilities());
		assertNotNull(card.getManaCost());
		assertNotNull(card.getName());
		assertNotNull(card.getPower());
		assertNotNull(card.getToughness());
		assertNotNull(card.getRarity());
		assertNotNull(card.getType());
		assertNotNull(card.getId());
		
		assertEquals(card.getId(), 1L);
		assertEquals(card.getAbilities(), "Double Strike");
		assertEquals(card.getManaCost(), "1c,1green");
		assertEquals(card.getName(), "Tree");
		assertEquals(card.getPower(), 4);
		assertEquals(card.getToughness(), 4);
		assertEquals(card.getRarity(), "Rare");
		assertEquals(card.getType(), "Tree creature");
		
	}
	
	@Test
	public void allArgsConstructor() {
		CardDeck card = new CardDeck(1L,"Tree", "1c,1green", "Tree Creature", 4, 4, "Double Strike", "Rare");
		
		assertNotNull(card.getAbilities());
		assertNotNull(card.getManaCost());
		assertNotNull(card.getName());
		assertNotNull(card.getPower());
		assertNotNull(card.getToughness());
		assertNotNull(card.getRarity());
		assertNotNull(card.getType());
		assertNotNull(card.getId());
		
		assertEquals(card.getId(), 1L);
		assertEquals(card.getAbilities(), "Double Strike");
		assertEquals(card.getManaCost(), "1c,1green");
		assertEquals(card.getName(), "Tree");
		assertEquals(card.getPower(), 4);
		assertEquals(card.getToughness(), 4);
		assertEquals(card.getRarity(), "Rare");
		assertEquals(card.getType(), "Tree Creature");
		
	}
	
	@Test
	public void noIdConstructor() {
		CardDeck card = new CardDeck("Tree", "1c,1green", "Tree Creature", 4, 4, "Double Strike", "Rare");
		
		assertNotNull(card.getAbilities());
		assertNotNull(card.getManaCost());
		assertNotNull(card.getName());
		assertNotNull(card.getPower());
		assertNotNull(card.getToughness());
		assertNotNull(card.getRarity());
		assertNotNull(card.getType());
		
		assertEquals(card.getAbilities(), "Double Strike");
		assertEquals(card.getManaCost(), "1c,1green");
		assertEquals(card.getName(), "Tree");
		assertEquals(card.getPower(), 4);
		assertEquals(card.getToughness(), 4);
		assertEquals(card.getRarity(), "Rare");
		assertEquals(card.getType(), "Tree Creature");
	}

}
