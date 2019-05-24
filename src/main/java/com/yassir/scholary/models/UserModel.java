package com.yassir.scholary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yassir.scholary.models.enumeration.City;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import uk.co.jemos.podam.common.PodamCollection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * A UserModel.
 */
@Entity
@Table(name = "users")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public @Data
class UserModel extends ItemModel {

    @NotNull
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull
    @Column(name = "psswd", nullable = false)
    private String password;

    @NotNull
    @Column(name = "primary_email", nullable = false)
    private String primaryEmail;

    @Column(name = "primary_phone")
    private String primaryPhone;

    @Column(name = "password_question")
    private String passwordQuestion;

    @Column(name = "password_answer")
    private String passwordAnswer;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "gender", nullable = false)
    private String gender;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "birth_city")
    private City birthCity;

    @Column(name = "former_password")
    private String formerPassword;

    @Column(name = "login_expiration_date")
    private LocalDate loginExpirationDate;

    @Column(name = "login_enabled")
    private boolean loginEnabled;

    @Column(name = "last_login")
    private LocalDate lastLogin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private MediaModel profilePicture;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("")
    private AddressModel primaryAddress;

    @PodamCollection(nbrElements = 3)
    @ManyToMany(cascade = CascadeType.ALL)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "user_user_groups", joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_groups_id", referencedColumnName = "id"))
    private List<UserGroupModel> userGroups;

    @PodamCollection(nbrElements = 3)
    @ManyToMany(cascade = CascadeType.ALL)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "user_addresses", joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "addresses_id", referencedColumnName = "id"))
    private List<AddressModel> otherAddresses;

}
