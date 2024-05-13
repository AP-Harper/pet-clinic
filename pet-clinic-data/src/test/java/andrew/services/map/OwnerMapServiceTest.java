package andrew.services.map;

import andrew.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
    final Long ownerID = 1L;
    final String lastName = "Mingus";
    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerID).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());

    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerID);
        assertEquals(ownerID, owner.getId());
    }

    @Test
    void saveWithID() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id, owner2.getId());
    }

    @Test
    void saveWithoutID() {
        Owner owner3 = new Owner();
        Owner savedOwner = ownerMapService.save(owner3);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        Long id = 4L;
        Owner owner4 = Owner.builder().id(id).build();
        ownerMapService.save(owner4);
        ownerMapService.delete(owner4);
        assertNull(ownerMapService.findById(4L));


    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerID);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner mingus = ownerMapService.findByLastName(lastName);
        assertNotNull(mingus);
        assertEquals(ownerID, mingus.getId());

    }

    @Test
    void LastNameNotFound() {
        Owner mingus = ownerMapService.findByLastName("Not Mingus");
        assertNull(mingus);
    }
}
