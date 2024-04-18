package andrew.services;
import andrew.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByID(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
