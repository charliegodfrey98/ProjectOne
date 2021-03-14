package com.bae.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.domain.Loadout;
import com.bae.service.LoadoutService;

@RestController
@CrossOrigin
public class LoadoutController {

	private LoadoutService service;

	public LoadoutController(LoadoutService service) {
		super();
		this.service = service;

	}

	@PostMapping("/createLoadout")
	public ResponseEntity<Loadout> createLoadout(@RequestBody Loadout loadout) {
		return new ResponseEntity<Loadout>(this.service.createLoadout(loadout), HttpStatus.CREATED);
	}

	@GetMapping("/getLoadout")
	public ResponseEntity<List<Loadout>> getLoadout() {
		return ResponseEntity.ok(this.service.getLoadout());
	}

	@GetMapping("/getLoadout/{id}")
	public Loadout getLoadoutByName(@PathVariable Long id) {
		return this.service.getLoadoutById(id);
	}

	@GetMapping("/getLoadoutByName/{name}")
	public Loadout getLoadoutByName(@PathVariable String name) {
		return this.service.getLoadoutByName(name);

	}

	@DeleteMapping("/removeLoadout/{id}")
	public boolean removeLoadout(@PathVariable Long id) {
		return this.service.removeLoadout(id);

	}

	@PutMapping("/updateLoadout/{id}")
	public Loadout updateLoadout(@PathVariable Long id, @RequestBody Loadout newLoadout) {
		return this.service.updateLoadout(id, newLoadout);
	}

}
