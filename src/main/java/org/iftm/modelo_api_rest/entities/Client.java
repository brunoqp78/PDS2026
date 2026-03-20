package org.iftm.modelo_api_rest.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

//anotação que informa ao JPA que a classe Client deverá persistir os seus dados no banco de dados.
@Entity
// anotação que informa ao JPA o nome da tabela no banco de dados.
@Table(name = "tb_cliente")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    // anotação que informa ao JPA que o campo abaixo será a chave primária no banco
    // de dados
    @Id
    // anotação que informa ao JPA a regra de geração da chave, neste caso
    // auto-incremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // anotação que informa ao JPA as caracteristicas de cada campo
    @Column(name = "nome", length = 100, nullable = false)
    private String name;
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;
    @Column(name = "salario", nullable = false)
    private Double income;
    @Column(name = "data_aniversario", nullable = false)
    private Instant birthDate;
    @Column(name = "num_filhos", nullable = false)
    private Integer children;

    @OneToOne
    @JoinColumn(name = "fk_endereco", referencedColumnName = "id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "fk_categoria", referencedColumnName = "id")
    private Category category;

    @ManyToMany
    @JoinTable(name = "tb_cliente_produto", // Nome da terceira tabela que será criada
            joinColumns = @JoinColumn(name = "cliente_id"), // A coluna que aponta para o Cliente
            inverseJoinColumns = @JoinColumn(name = "produto_id") // A coluna que aponta para o Produto
    )
    private Set<Product> products = new HashSet<>();

    // anotação que indica ao JPA que o atributo não deve existir no banco de dados
    @Transient
    private int idade;

    public Client() {
    }

    public Client(Long id, String name, String cpf, Double income, Instant birthDate, Integer children, Address address,
            Category category) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
        this.address = address;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", cpf=" + cpf + ", income=" + income + ", birthDate="
                + birthDate + ", children=" + children + "]";
    }

}
