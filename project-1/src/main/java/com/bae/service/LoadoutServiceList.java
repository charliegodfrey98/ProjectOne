package com.bae.service;

import java.util.List;

import com.bae.domain.Loadout;

public class LoadoutServiceList implements LoadoutService {

	private List<Loadout> loadout;

	public LoadoutServiceList(List<Loadout> loadout) {
		super();
		this.loadout = loadout;
	}

	@Override
	public Loadout createLoadout(Loadout loadout) {
		this.loadout.add(loadout);
		Loadout added = this.loadout.get(this.loadout.size() - 1);
		return added;
	}

	@Override
	public Loadout getLoadoutById(Long id) {
		return this.loadout.get(id.intValue());
	}

	@Override
	public List<Loadout> getLoadout() {
		return this.loadout;
	}

	@Override
	public boolean removeLoadout(Long id) {
		// TODO Auto-generated method stub
		Loadout loadout = this.loadout.get(id.intValue());
		this.loadout.remove(id.intValue());
		return !this.loadout.contains(loadout);
	}

	@Override
	public Loadout updateLoadout(Long id, Loadout newLoadout) {
		// TODO Auto-generated method stub
		this.removeLoadout(id);
		this.loadout.add(id.intValue(), newLoadout);
		return this.loadout.get(id.intValue());
	}

	@Override
	public Loadout getLoadoutByName(String name) {
		// TODO Auto-generated method stub
		for (Loadout p : this.loadout) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

}
