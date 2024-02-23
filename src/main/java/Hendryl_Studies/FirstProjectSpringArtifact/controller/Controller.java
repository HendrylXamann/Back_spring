package Hendryl_Studies.FirstProjectSpringArtifact.controller; //Tive que add o .controller no fim e mover para um package separado

//import Hendryl_Studies.FirstProjectSpringArtifact.Pets.Pets;
import Hendryl_Studies.FirstProjectSpringArtifact.Pets.PetDTO;
import Hendryl_Studies.FirstProjectSpringArtifact.Pets.PetsEntity;
import Hendryl_Studies.FirstProjectSpringArtifact.Pets.PetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@RestController
@RequiredArgsConstructor
@RequestMapping("/pet")
public class Controller {

//    @Autowired -- Ver se tem necessidade de usar
    private final PetsRepository repository;
    @GetMapping
    public ResponseEntity<List<PetDTO>> getAllPet() {

        List<PetsEntity> petsEntityList = repository.findAll();

        ResponseEntity.ok(petsEntityList.stream().map(PetDTO::new).toList());
//            return ResponseEntity;
        return ResponseEntity.ok(petsEntityList.stream().map(petsEntity -> new PetDTO(petsEntity)).toList());


    }

}
