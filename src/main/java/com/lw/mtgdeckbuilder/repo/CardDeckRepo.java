package com.lw.mtgdeckbuilder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lw.mtgdeckbuilder.entity.CardDeck;

@Repository
public interface CardDeckRepo extends JpaRepository<CardDeck, Long>{

}
