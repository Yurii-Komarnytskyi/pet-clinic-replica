package com.ykomarnytskyi2022.petclinic.services.map;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ykomarnytskyi2022.petclinic.model.Owner;
import com.ykomarnytskyi2022.petclinic.model.Pet;
import com.ykomarnytskyi2022.petclinic.services.OwnerService;
import com.ykomarnytskyi2022.petclinic.services.PetService;
import com.ykomarnytskyi2022.petclinic.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;
	static final Owner SPECIAL_CASE_OBJECT;
	static {
		SPECIAL_CASE_OBJECT = new Owner();
		SPECIAL_CASE_OBJECT.setId(Long.valueOf(-1));
		SPECIAL_CASE_OBJECT.setFirstName("specialCaseObject thus no name");
		SPECIAL_CASE_OBJECT.setLastName("specialCaseObject thus no surname");
		SPECIAL_CASE_OBJECT.setCity("specialCaseObject thus no city");
		SPECIAL_CASE_OBJECT.setAddress("specialCaseObject thus no address");
		SPECIAL_CASE_OBJECT.setTelephone("specialCaseObject thus no telephone");
		SPECIAL_CASE_OBJECT.setPets(Collections.emptySet());	
	}

	@Autowired
	public OwnerMapService(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner owner) {
		Optional<Owner> ownerOptional = Optional.of(owner);
		if (ownerOptional.isPresent()) {
			ownerOptional.get().getPets().stream().forEach(pet -> {
				if (pet.getPetType() != null && pet.getPetType().getId() == null) {
					pet.setPetType(petTypeService.save(pet.getPetType()));
				}
				if(pet.getId() == null) {
					Pet savedPet = petService.save(pet);
					pet.setId(savedPet.getId());
				}

			});
			return super.save(owner);
		} else {
			return SPECIAL_CASE_OBJECT;
		}
	}

	@Override
	public void delete(Owner owner) {
		super.delete(owner);
	}

	@Override
	public void deleteByID(Long id) {
		super.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return super.map.entrySet().stream().filter(e -> e.getValue().getLastName() == lastName).map(e -> e.getValue())
				.findFirst().get();
	}

	@Override
	protected Owner getSpecialCaseObject() {
		return SPECIAL_CASE_OBJECT;
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		System.out.println("dummy findAllByLastNameLike");
		return null;
	}
}
