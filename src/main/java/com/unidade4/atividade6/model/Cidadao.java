package com.unidade4.atividade6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cidadao")
public class Cidadao {
    @Id
    private String id;

    private String nome;

    private String cpf;

    private String logradouro;

    private String cidade;

    private String cep;

    private String bairro;

    private String estado;

    private String sexo;
}
