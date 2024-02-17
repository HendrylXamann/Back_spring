package Hendryl_Studies.FirstProjectSpringArtifact.Pets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Esta é a classe repositorio, que é a que vai se conectar com o BD e pegar os dados (CRUD)
extends (a PetsRepository herda da JpaRepository que oferece métodos para acesso ao bd)
só precsio passar pra ela, dentro do <> o tipo que o repository vai retornar/qual entidade de consulta desse repository
junto do tipo de identificador único que no meu caso foi long e pronto
*/
@Repository
public interface PetsRepository extends JpaRepository<PetsEntity,Integer> {
    //agr dentro do controller já posso usar esse repositorio pra consultar os dados
}
