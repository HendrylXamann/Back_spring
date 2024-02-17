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

/*	Controller onde vai ficar concentrado os request para pegar e add dados
 P/ Indicar pro Spring que essa classe é um controller é só usar a notação RestController
 O EndPoint deste controller é pet, e quando chamarem esse endpoint pet com método get
 ele vai chamar o getall por conta do getMapping
*/
@RestController
@RequiredArgsConstructor

//Determina pela uri qual controller ira representar as requisições
@RequestMapping("/pet") //Estou mapeando o request que vai cair aqui neste controller, todos os request para o endpoint pet
public class Controller {
    private final PetsRepository repository;
    @GetMapping // isso é pro spring entender que esse método é chamado qnd o endpoint for chamado com o get
    //Assinatura do método***
    public ResponseEntity<List<PetDTO>> getAllPet() {
        List<PetsEntity> petsEntityList = repository.findAll();
        List<PetDTO> petDTOS = new ArrayList<>();

        /* 5 formas de fazer a mesma coisa:
        for (PetsEntity petsEntity : petsEntityList) {
            petDTOS.add(new PetDTO(petsEntity));
        }

        for (int cont = 0; cont < petsEntityList.size(); cont ++) {
            petDTOS.add(new PetDTO(petsEntityList.get(cont)));
        }

        petsEntityList.forEach(petsEntity -> {
            petDTOS.add(new PetDTO(petsEntity));
        });

        ResponseEntity.ok(petsEntityList.stream().map(PetDTO::new).toList());

        petsEntityList.stream().forEach(PetDTO::new);
        */

        return ResponseEntity.ok(petsEntityList.stream().map(petsEntity -> new PetDTO(petsEntity)).toList());
    }

}
//P/Conseguir acessar o bd é criar a classe repository e a classe da entidade
//classe repository é de interface que oferece métodos abstratos p/manipular e gerenciar os dados(CRUD - criar, ler, atualizar e deletar os dados do BD)
//classe entidade é a que vai representar a tabela no bd, vai mapear todas as colunas que tem nas tabelas (ela vai representar uma tabela)