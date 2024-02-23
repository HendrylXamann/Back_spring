package Hendryl_Studies.FirstProjectSpringArtifact.Pets;
//Data transfer object - privar alguns itens/dados de serem visualizados ou consultados?
/* criamos um record/dto quando estamos implementando uma classe que não vai ter nenhum método, pois um record gera automaticamente
um construtor com todos os métodos (getters, setters, equals(), hashCode(), ou toString()) para cada propridade da classe */
public record PetDTO(Integer id, String nomeItem, Integer qtditem) { //aqui declaro quais propriedades a classe vai ter
    public PetDTO(PetsEntity petEntity) {
        this(
                petEntity.getId(),
                petEntity.getNomeitem(),
                petEntity.getQtditem()
        );
    }
}
