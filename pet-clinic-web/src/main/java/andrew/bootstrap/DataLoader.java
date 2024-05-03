package andrew.bootstrap;

import andrew.model.*;
import andrew.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    private final SpecialityService specialityService;

    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }



    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);


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

        Visit jeffVisit = new Visit();
        jeffVisit.setPet(andrewPet);
        jeffVisit.setDate(LocalDate.now());
        jeffVisit.setDescription("Sore leg");
        visitService.save(jeffVisit);

        System.out.println("Loaded Owners...");


        Vet vet1 = new Vet();
        vet1.setFirstName("Mr");
        vet1.setLastName("Vetty");
        vet1.getSpecialities().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jeff");
        vet2.setLastName("John-Boy");
        vet2.getSpecialities().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
