Desrevendo tudo / Documentando:

Controller:
 - Controller onde vai ficar concentrado os request para pegar e add dados
 P/ Indicar pro Spring que essa classe é um controller é só usar a notação RestController
 O EndPoint deste controller é pet, e quando chamarem esse endpoint pet com método get
 ele vai chamar o getall por conta do getMapping

P/Conseguir acessar o bd é criar a classe repository e a classe da entidade
classe repository é de interface que oferece métodos abstratos p/manipular e gerenciar os dados(CRUD - criar, ler, atualizar e deletar os dados do BD)
classe entidade é a que vai representar a tabela no bd, vai mapear todas as colunas que tem nas tabelas (ela vai representar uma tabela)

@RestController indica que a classe é um controlador REST
@RequiredArgsConstructor - gera automaticamente um construtor que recebe todos os campos marcados como final
@GetMapping --isso é pro spring entender que esse método é chamado qnd o endpoint for chamado com o get
@RequestMapping -- Determina pela url qual controller irá representar as requisições, nele que criamos o endpoint
para acessar o end point no bruno e testar: http://localhost:8080/pet

public class Controller {
    private final PetsRepository repository;
    @CrossOrigin(origins = "*", allowedHeaders = "*") -- Permite todos os acessos (se quiser restringit o endpoint é aqui)
    @PostMapping -- Definindo método
    public void comentarioUsuario(@RequestBody PetDTOresquest data ){ -- requisição que permite 'publicar'
    /*
    Ele recebe um objeto PetDTOrequest como parâmetro, que é obtido do corpo da requisição HTTP usando a anotação @RequestBody.
    Isso significa que o corpo da solicitação será convertido automaticamente em um objeto PetDTOrequest pelo Spring. */
    PetsEntity petsData = new PetsEntity(data); -- cria uma nova instância da classe PetsEntity
    repository.save(petsData); -- repository é uma instância de um repositório Spring Data JPA então save ta salvando no BD
    return; -- por ser void o retorno é vazio
    }

    @GetMapping
    Assinatura do método(seu nome, lista de parâmetros e o tipo de retorno, se houver):
    public ResponseEntity<List<PetDTO>> getAllPet() {
            List<PetsEntity> petsEntityList = repository.findAll(); Aqui é uma lista de petsentity que é chamada de petsEntityList que acessa a repository que foi instanciada mais acima
            e com o findall ele pega todos os dados que tem na tabela especificada no bd
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
            //método ok() indica que é a operação assincrona deu certo e que o resultado está disponível, ou seja, que a response é 200 -- no caso deu bom
            //método stream pega o contéudo e transforma num funil que pode ser usado para N finalidades (map, filtragem, redução, classificação e etc) sem alterar o valor original (ex: se fosse uma lista.stream(), a lista original permance intacta).
            // Então aqui estou pegando o contéudo de petsEntityList, que é uma lista, sequenciando ele (funilando) e em seguida mapeando ele (map)
            // método map aplica uma função a cada elemento de uma sequencia(lista| iterável) e retorna uma nova lista com os resultados(um stram que precisa ser convertido para um novo List), sua sintaxe é map(function, list)
            // Então aqui o contéudo do stream é mapeado, logo para objeto do DTO ele aplica a função(PetDTO::new) que é um método construtor da classe PetDTO e assim ele cria um novo objeto dele mesmo p/ cada elementod o stream e por fim converte novamente em lista
            //(então se entendi muito bem, validar dps, todos os itens da entidade vai ter esse corre)

            petsEntityList.stream().forEach(PetDTO::new);
            */

            return ResponseEntity.ok(petsEntityList.stream().map(petsEntity -> new PetDTO(petsEntity)).toList());
        }

Entidade| Entity:
// P/ falar pro spring que essa class indica uma tabela do banco usamos:
@Table(name="itens") //Dentro passamos o nome da tabela
@Entity(name = "itens")
Para conseguir pegar os valores no DTO:
@Getter //in real time gera um método get para todas as propriedades que a classe tem
@Setter
@AllArgsConstructor //declara um constructor que recebe todos os argumentos
@NoArgsConstructor //declara um constructor que não recebe nenhum argumento
@EqualsAndHashCode(of = "id") //indicar que o id é a representação única dessa classe
public class PetsEntity {
    //Declaração de colunas dentro da tabela itens:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definir a chave única como ID, colocar como autoincrement
    private Integer id;
    private String nomeitem;
    private String valoritem;
    private Integer qtditem;
    private String descricao;

    public PetsEntity(PetDTOresquest data){
    this.nomeitem = data.nomeItem();
    this.qtditem = data.qtditem();
    this.descricao = data.descricao();
    }
}


DTO:
Data transfer object - privar alguns itens/dados de serem visualizados ou consultados?
/* criamos um record/dto quando estamos implementando uma classe que não vai ter nenhum método, pois um record gera automaticamente
um construtor com todos os métodos (getters, setters, equals(), hashCode(), ou toString()) para cada propridade da classe */

public record PetDTO(Integer id, String nomeItem, Integer qtditem) { //aqui declaro quais propriedades a classe vai ter
    public PetDTO(PetsEntity petEntity) {
        this(
                petEntity.getId(), o get só funciona pois lá na entidade setamos o getters
                petEntity.getNomeitem(),
                petEntity.getQtditem()
        );
    }
}