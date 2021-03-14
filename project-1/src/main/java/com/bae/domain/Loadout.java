package com.bae.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loadout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String primaryWeapon;

	private String secondaryWeapon;

	private String lethal;

	private String tactical;

	private String perk1;

	private String perk2;

	private String perk3;

	public Loadout(Long id, String name, String primaryWeapon, String secondaryWeapon, String lethal, String tactical,
			String perk1, String perk2, String perk3) {
		super();
		this.id = id;
		this.name = name;
		this.primaryWeapon = primaryWeapon;
		this.secondaryWeapon = secondaryWeapon;
		this.lethal = lethal;
		this.tactical = tactical;
		this.perk1 = perk1;
		this.perk2 = perk2;
		this.perk3 = perk3;
	}

	public Loadout(String name, String primaryWeapon, String secondaryWeapon, String lethal, String tactical,
			String perk1, String perk2, String perk3) {
		super();
		this.name = name;
		this.primaryWeapon = primaryWeapon;
		this.secondaryWeapon = secondaryWeapon;
		this.lethal = lethal;
		this.tactical = tactical;
		this.perk1 = perk1;
		this.perk2 = perk2;
		this.perk3 = perk3;
	}

	public Loadout() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimaryWeapon() {
		return primaryWeapon;
	}

	public void setPrimaryWeapon(String primaryWeapon) {
		this.primaryWeapon = primaryWeapon;
	}

	public String getSecondaryWeapon() {
		return secondaryWeapon;
	}

	public void setSecondaryWeapon(String secondaryWeapon) {
		this.secondaryWeapon = secondaryWeapon;
	}

	public String getLethal() {
		return lethal;
	}

	public void setLethal(String lethal) {
		this.lethal = lethal;
	}

	public String getTactical() {
		return tactical;
	}

	public void setTactical(String tactical) {
		this.tactical = tactical;
	}

	public String getPerk1() {
		return perk1;
	}

	public void setPerk1(String perk1) {
		this.perk1 = perk1;
	}

	public String getPerk2() {
		return perk2;
	}

	public void setPerk2(String perk2) {
		this.perk2 = perk2;
	}

	public String getPerk3() {
		return perk3;
	}

	public void setPerk3(String perk3) {
		this.perk3 = perk3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lethal == null) ? 0 : lethal.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((perk1 == null) ? 0 : perk1.hashCode());
		result = prime * result + ((perk2 == null) ? 0 : perk2.hashCode());
		result = prime * result + ((perk3 == null) ? 0 : perk3.hashCode());
		result = prime * result + ((primaryWeapon == null) ? 0 : primaryWeapon.hashCode());
		result = prime * result + ((secondaryWeapon == null) ? 0 : secondaryWeapon.hashCode());
		result = prime * result + ((tactical == null) ? 0 : tactical.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loadout other = (Loadout) obj;
		if (id != other.id)
			return false;
		if (lethal == null) {
			if (other.lethal != null)
				return false;
		} else if (!lethal.equals(other.lethal))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (perk1 == null) {
			if (other.perk1 != null)
				return false;
		} else if (!perk1.equals(other.perk1))
			return false;
		if (perk2 == null) {
			if (other.perk2 != null)
				return false;
		} else if (!perk2.equals(other.perk2))
			return false;
		if (perk3 == null) {
			if (other.perk3 != null)
				return false;
		} else if (!perk3.equals(other.perk3))
			return false;
		if (primaryWeapon == null) {
			if (other.primaryWeapon != null)
				return false;
		} else if (!primaryWeapon.equals(other.primaryWeapon))
			return false;
		if (secondaryWeapon == null) {
			if (other.secondaryWeapon != null)
				return false;
		} else if (!secondaryWeapon.equals(other.secondaryWeapon))
			return false;
		if (tactical == null) {
			if (other.tactical != null)
				return false;
		} else if (!tactical.equals(other.tactical))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Loadout [id=" + id + ", name=" + name + ", primaryWeapon=" + primaryWeapon + ", secondaryWeapon="
				+ secondaryWeapon + ", lethal=" + lethal + ", tactical=" + tactical + ", perk1=" + perk1 + ", perk2="
				+ perk2 + ", perk3=" + perk3 + "]";
	}

}
