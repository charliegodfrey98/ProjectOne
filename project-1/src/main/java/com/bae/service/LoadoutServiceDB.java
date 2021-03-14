package com.bae.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bae.domain.Loadout;
import com.bae.repos.LoadoutRepo;

@Service
public class LoadoutServiceDB implements LoadoutService {

	private LoadoutRepo repo;

	public LoadoutServiceDB(LoadoutRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Loadout createLoadout(Loadout loadout) {
		Loadout saved = this.repo.save(loadout);
		return saved;

	}

	@Override
	public List<Loadout> getLoadout() {
		return this.repo.findAll();
	}

	@Override
	public Loadout getLoadoutByName(String name) {
		return this.repo.findByName(name);
	}

	@Override
	public boolean removeLoadout(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	@Override
	public Loadout updateLoadout(Long id, Loadout newLoadout) {
		Loadout existing = this.getLoadoutById(id);

		existing.setName(newLoadout.getName());
		existing.setPrimaryWeapon(newLoadout.getPrimaryWeapon());
		existing.setSecondaryWeapon(newLoadout.getSecondaryWeapon());
		existing.setLethal(newLoadout.getLethal());
		existing.setTactical(newLoadout.getTactical());
		existing.setPerk1(newLoadout.getPerk1());
		existing.setPerk2(newLoadout.getPerk2());
		existing.setPerk3(newLoadout.getPerk3());

		Loadout updated = this.repo.save(existing);
		return updated;

	}

	@Override
	public Loadout getLoadoutById(Long id) {
		Optional<Loadout> optLoadout = this.repo.findById(id);
		return optLoadout.get();
	}

}
