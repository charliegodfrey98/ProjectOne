package com.bae.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bae.domain.Loadout;

public interface LoadoutRepo extends JpaRepository<Loadout, Long> {

	Loadout findByName(String name);

}
