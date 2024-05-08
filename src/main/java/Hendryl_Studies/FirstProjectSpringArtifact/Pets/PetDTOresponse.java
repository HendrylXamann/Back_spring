package Hendryl_Studies.FirstProjectSpringArtifact.Pets;

public record PetDTOresponse(Integer id, String nomeItem, Integer qtditem,String descricao, String valoritem) { //aqui declaro quais propriedades a classe vai ter
    public PetDTOresponse(PetsEntity petEntity) {
        this(
                petEntity.getId(),
                petEntity.getNomeitem(),
                petEntity.getQtditem(),
                petEntity.getDescricao(),
                petEntity.getValoritem()
        );
    }
}
