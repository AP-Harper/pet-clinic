package andrew.services.map;

import andrew.model.Pet;
import andrew.model.PetType;
import andrew.services.PetTypeService;
import andrew.services.map.AbstractMapService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType petType) {
        return super.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        super.delete(petType);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteByID(id);
    }
}
