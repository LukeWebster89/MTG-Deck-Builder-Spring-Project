drop table if exists `card_deck` CASCADE; 
create table `card_deck`(

`id` bigint primary key auto_increment, 
`abilities` varchar(255), 
`mana_cost` varchar(255), 
`name` varchar(255), 
`power` integer, 
`rarity` varchar(255), 
`toughness` integer, 
`type` varchar(255)
);