package com.bae.service;

import java.util.List;

import com.bae.domain.Loadout;

public interface LoadoutService {

	Loadout createLoadout(Loadout loadout);

	List<Loadout> getLoadout();

	Loadout getLoadoutById(Long id);

	boolean removeLoadout(Long id);

	Loadout updateLoadout(Long id, Loadout newLoadout);

	Loadout getLoadoutByName(String name);

}
