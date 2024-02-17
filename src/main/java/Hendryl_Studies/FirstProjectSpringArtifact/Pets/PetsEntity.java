package Hendryl_Studies.FirstProjectSpringArtifact.Pets;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

//P/ falar pro spring que essa class indica uma tabela do banco usamos:
@Table(name="itens") //Dentro passamos o nome da tabela
@Entity(name = "itens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetsEntity {
    //Declaração de colunas dentro da tabela itens2:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definir a chave única como ID, colocar como autoincrement
    private Integer id;
    private String nomeitem;
//    private String imagem;
    private BigDecimal valoritem;
    private Integer qtditem;


}
