package com.example.restapicrudexample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.NumberFormat;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
//marcar uma classe como uma entidade persistente, representa uma tabela em um banco de dados relacional e os objetos dessa classe podem ser armazenados e recuperados no banco de dados.
@Data
//não ha necessidade de escrever getters, setters, construtores e métodos equals() e hashCode()
@AllArgsConstructor
//Ela adiciona um construtor com parâmetros que inicializa todos os campos da classe
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String marca;
    String cor;
    String modelo;
    Integer ano;
    @NumberFormat(pattern = "#.###")
    Double valor;
    @CPF
    String cpf;
}
