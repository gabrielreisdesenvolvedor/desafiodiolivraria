package com.biblioteca.livraria.dtos;

import com.biblioteca.livraria.models.ClientModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

import java.util.UUID;

public class ClientDto {

    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String address;
    @NonNull
    private Double accountBalance;

    public ClientDto(){}

    public ClientDto(ClientModel clientModel){
        id = clientModel.getId();
        name = clientModel.getName();
        email = clientModel.getEmail();
        address = clientModel.getAddress();
        accountBalance = clientModel.getAccountBalance();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
