package com.bruno.ordering.entities;

import com.bruno.ordering.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpfOrCnpj;

    private Integer type;

    @ElementCollection
    @CollectionTable(name = "tb_phone")
    private Set<String> phones = new HashSet<>();

    public CustomerType getType(){
        return CustomerType.toEnum(type);
    }

    public void setType(CustomerType type){
        this.type = type.getCode();
    }
}
