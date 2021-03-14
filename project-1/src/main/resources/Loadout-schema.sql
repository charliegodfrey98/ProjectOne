DROP TABLE IF EXISTS `loadout` CASCADE;
CREATE TABLE loadout (
	id BIGINT AUTO_INCREMENT,
	name VARCHAR(255),
	primary_weapon VARCHAR(255),
	secondary_weapon VARCHAR(255),
	lethal VARCHAR(255),
	tactical VARCHAR(255),
	perk1 VARCHAR(255),
	perk2 VARCHAR(255),
	perk3 VARCHAR(255),
	PRIMARY KEY (id)
);