package com.highettmetal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.highettmetal.jsonviews.Views;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rodmccutcheon on 12/7/17.
 */
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    @JsonView(Views.Client.class)
    @JsonProperty("client_code")
    private String code;

    @JsonView(Views.Client.class)
    @JsonProperty("client_name")
    private String name;

    @JsonIgnore
    private String businessName;

    @JsonView(Views.Client.class)
    @JsonProperty("client_email")
    private String email;

    @JsonIgnore
    private String phone;

    @JsonIgnore
    private String mobile;

    @JsonIgnore
    private String address;

    @JsonIgnore
    private String suburb;

    @JsonIgnore
    private String state;

    @JsonIgnore
    private String postcode;

    @JsonIgnore
    private String username;

    @JsonIgnore
    private String password;

    @JsonView(Views.Client.class)
    @JsonProperty("client_discount")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientid", nullable = false)
    private List<ClientCategoryDiscount> clientCategoryDiscounts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ClientCategoryDiscount> getClientCategoryDiscounts() {
        return clientCategoryDiscounts;
    }

    public void setClientCategoryDiscounts(List<ClientCategoryDiscount> clientCategoryDiscounts) {
        this.clientCategoryDiscounts = clientCategoryDiscounts;
    }
}
