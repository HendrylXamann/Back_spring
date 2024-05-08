package Hendryl_Studies.FirstProjectSpringArtifact.Pets;
//Data transfer object - privar alguns itens/dados de serem visualizados ou consultados?
/* criamos um record/dto quando estamos implementando uma classe que não vai ter nenhum método, pois um record gera automaticamente
um construtor com todos os métodos (getters, setters, equals(), hashCode(), ou toString()) para cada propridade da classe */
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
