package com.highettmetal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;
import com.highettmetal.jsonviews.Views;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by rodmccutcheon on 21/7/17.
 */
@Entity
@Table(name = "clientcategorydiscounts")
public class ClientCategoryDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    @JsonView(Views.Client.class)
    @JsonUnwrapped
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productcategoryid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProductCategory productCategory;

    @JsonView(Views.Client.class)
    @JsonUnwrapped
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clienttypeid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ClientType clientType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    @Override
    public String toString() {
        return "ClientCategoryDiscount{" +
                "id=" + id +
                ", productCategory=" + productCategory +
                ", clientType=" + clientType +
                '}';
    }
}
