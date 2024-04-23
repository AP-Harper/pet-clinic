package andrew.bootstrap;

import andrew.model.Owner;
import andrew.model.Vet;
import andrew.services.OwnerService;
import andrew.services.VetService;
import andrew.services.map.OwnerServiceMap;
import andrew.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Andrew");
        owner1.setLastName("Weston");

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("John");
        owner2.setLastName("Jerry");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");


        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Mr");
        vet1.setLastName("Vetty");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jeff");
        vet2.setLastName("John-Boy");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");





    }
}