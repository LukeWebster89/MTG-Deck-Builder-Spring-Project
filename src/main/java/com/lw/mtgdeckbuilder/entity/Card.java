package com.lw.mtgdeckbuilder.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String manaCost;
	
	@Column
	private String type;
	
	@Column
	private int power;
	
	@Column
	private int toughness;
	
	@Column
	private String abilities;
	
	@Column
	private String rarity;

	public Card() {
		super();
	}

	public Card(String name, String manaCost, String type, int power, int toughness, String abilities, String rarity) {
		super();
		this.name = name;
		this.manaCost = manaCost;
		this.type = type;
		this.power = power;
		this.toughness = toughness;
		this.abilities = abilities;
		this.rarity = rarity;
	}

	public Card(long id, String name, String manaCost, String type, int power, int toughness, String abilities,
			String rarity) {
		super();
		this.id = id;
		this.name = name;
		this.manaCost = manaCost;
		this.type = type;
		this.power = power;
		this.toughness = toughness;
		this.abilities = abilities;
		this.rarity = rarity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManaCost() {
		return manaCost;
	}

	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getToughness() {
		return toughness;
	}

	public void setToughness(int toughness) {
		this.toughness = toughness;
	}

	public String getAbilities() {
		return abilities;
	}

	public void setAbilities(String abilities) {
		this.abilities = abilities;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", manaCost=" + manaCost + ", type=" + type + ", power=" + power
				+ ", toughness=" + toughness + ", abilities=" + abilities + ", rarity=" + rarity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(abilities, manaCost, name, power, rarity, toughness, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(abilities, other.abilities) && Objects.equals(manaCost, other.manaCost)
				&& Objects.equals(name, other.name) && power == other.power && Objects.equals(rarity, other.rarity)
				&& toughness == other.toughness && Objects.equals(type, other.type);
	}

	
	
	
	

}
