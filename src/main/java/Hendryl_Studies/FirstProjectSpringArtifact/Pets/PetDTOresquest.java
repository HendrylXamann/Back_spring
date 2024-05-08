package Hendryl_Studies.FirstProjectSpringArtifact.Pets;

public record PetDTOresquest(String nomeItem, Integer qtditem, String descricao) {
    public PetDTOresquest(PetsEntity petEntity) {
        this(
                petEntity.getNomeitem(),
                petEntity.getQtditem(),
                petEntity.getDescricao()
        );
    }
}