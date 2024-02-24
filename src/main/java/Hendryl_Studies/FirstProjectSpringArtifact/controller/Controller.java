package Hendryl_Studies.FirstProjectSpringArtifact.controller; //Tive que add o .controller no fim e mover para um package separado

//import Hendryl_Studies.FirstProjectSpringArtifact.Pets.Pets;
import Hendryl_Studies.FirstProjectSpringArtifact.Pets.PetDTOresponse;
import Hendryl_Studies.FirstProjectSpringArtifact.Pets.PetDTOresquest;
import Hendryl_Studies.FirstProjectSpringArtifact.Pets.PetsEntity;
import Hendryl_Studies.FirstProjectSpringArtifact.Pets.PetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor //Elimina necessidade de um Autowired
@RequestMapping("/pet")
public class Controller {

    private final PetsRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void comentarioUsuario(@RequestBody PetDTOresquest data ){
        PetsEntity petsData = new PetsEntity(data);
        repository.save(petsData);
        return;

    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<PetDTOresponse>> getAllPet() {

        List<PetsEntity> petsEntityList = repository.findAll();
       return ResponseEntity.ok(petsEntityList.stream().map(PetDTOresponse::new).toList());

    }

}
