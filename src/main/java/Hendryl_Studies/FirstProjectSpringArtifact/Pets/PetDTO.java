package Hendryl_Studies.FirstProjectSpringArtifact.Pets;
//Data transfer object - privar alguns itens/dados
public record PetDTO(String nomeItem, Integer qtditem) {
    public PetDTO(PetsEntity petEntity) {
        this(
                petEntity.getNomeitem(),
                petEntity.getQtditem()
        );
    }
}
