package andrew.services;


import java.util.Set;

public interface VetService {

    Vet findByID(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
