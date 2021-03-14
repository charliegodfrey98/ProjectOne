package com.bae.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.bae.domain.Loadout;
import com.bae.repos.LoadoutRepo;

@SpringBootTest
@ActiveProfiles("test")
public class LoadoutServiceDBUnitTest {

	@Autowired
	private LoadoutServiceDB service;

	@MockBean
	private LoadoutRepo repo;

	@Test
	void testCreate() {
		Loadout newLoadout = new Loadout("test", "test primary weapon", "test secondary weapon", "test lethal",
				"test tactical", "test perk1", "test perk2", "test perk3");
		Loadout savedLoadout = new Loadout(2L, "test", "test primary weapon", "test secondary weapon", "test lethal",
				"test tactical", "test perk1", "test perk2", "test perk3");

		Mockito.when(this.repo.save(newLoadout)).thenReturn(savedLoadout);

		assertThat(this.service.createLoadout(newLoadout)).isEqualTo(savedLoadout);

		Mockito.verify(this.repo, Mockito.times(1)).save(newLoadout);

	}

	@Test
	void testUpdate() {
		Long id = 1L;

		Loadout newLoadout = new Loadout("test2", "test2 primary weapon2", "test2 secondary weapon", "test2 lethal",
				"test2 tactical", "test2 perk1", "test2 perk2", "test2 perk3");

		Optional<Loadout> optionalLoadout = Optional.of(new Loadout(id, "test", "test primary weapon",
				"test secondary weapon", "test lethal", "test tactical", "test perk1", "test perk2", "test perk3"));

		Loadout updatedLoadout = new Loadout(id, newLoadout.getName(), newLoadout.getPrimaryWeapon(),
				newLoadout.getSecondaryWeapon(), newLoadout.getLethal(), newLoadout.getTactical(),
				newLoadout.getPerk1(), newLoadout.getPerk2(), newLoadout.getPerk3());

		Mockito.when(this.repo.findById(id)).thenReturn(optionalLoadout);

		Mockito.when(this.repo.save(updatedLoadout)).thenReturn(updatedLoadout);

		assertThat(this.service.updateLoadout(id, newLoadout)).isEqualTo(updatedLoadout);

	}

	@Test
	void testRead() {

		List<Loadout> loadoutList = new ArrayList<>();
		loadoutList.add(new Loadout("test", "test", "test", "test", "test", "test", "test", "test"));

		when(this.repo.findAll()).thenReturn(loadoutList);

		assertThat(this.service.getLoadout()).isEqualTo(loadoutList);

		verify(this.repo, times(1)).findAll();
	}

	@Test
	void testDelete() {
		Long id = 1L;

		Mockito.when(this.repo.existsById(id)).thenReturn(true, false);

		assertThat(this.service.removeLoadout(id)).isFalse();

		verify(this.repo, times(1)).deleteById(id);
		verify(this.repo, times(1)).existsById(id);
	}

}
