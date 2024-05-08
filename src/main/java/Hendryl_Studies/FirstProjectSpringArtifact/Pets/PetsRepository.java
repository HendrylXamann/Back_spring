package Hendryl_Studies.FirstProjectSpringArtifact.Pets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends JpaRepository<PetsEntity,Integer> {
}
