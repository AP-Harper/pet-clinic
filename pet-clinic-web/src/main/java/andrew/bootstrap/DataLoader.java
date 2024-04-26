package andrew.bootstrap;

import andrew.model.Owner;
import andrew.model.Pet;
import andrew.model.PetType;
import andrew.model.Vet;
import andrew.services.OwnerService;
import andrew.services.PetTypeService;
import andrew.services.VetService;
import andrew.services.map.OwnerServiceMap;
import andrew.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Andrew");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Sauchiehall Street");
        owner1.setCity("Glasgow");
        owner1.setTelephone("0141 667 6767");

        Pet andrewPet = new Pet();
        andrewPet.setPetType(savedDogPetType);
        andrewPet.setOwner(owner1);
        andrewPet.setBirthDate(LocalDate.now());
        andrewPet.setName("Jeff");
        owner1.getPets().add(andrewPet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("John");
        owner2.setLastName("Jerry");
        owner1.setAddress("123 Buchanan Street");
        owner1.setCity("Glasgow");
        owner1.setTelephone("0141 667 4422");

        Pet JohnCat = new Pet();
        JohnCat.setName("Brian");
        JohnCat.setPetType(savedCatPetType);
        JohnCat.setBirthDate(LocalDate.now());
        JohnCat.setOwner(owner2);
        owner1.getPets().add(JohnCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");


        Vet vet1 = new Vet();
        vet1.setFirstName("Mr");
        vet1.setLastName("Vetty");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jeff");
        vet2.setLastName("John-Boy");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");





    }
}
