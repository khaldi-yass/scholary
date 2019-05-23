package com.yassir.scholary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yassir.scholary.models.enumeration.City;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A UserModel.
 */
@Entity
@Table(name = "user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull
    @Column(name = "jhi_password", nullable = false)
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
    private Boolean loginEnabled;

    @Column(name = "last_login")
    private LocalDate lastLogin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private MediaModel profilePicture;

    @OneToOne
    @JoinColumn(unique = true)
    private ItemModel pItemModel;

    @ManyToOne
    @JsonIgnoreProperties("")
    private AddressModel primaryAddressModel;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "user_user_groups", joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_groups_id", referencedColumnName = "id"))
    private Set<UserGroupModel> userGroupModels = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "user_addresses", joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "addresses_id", referencedColumnName = "id"))
    private Set<AddressModel> addressModels = new HashSet<>();

    public UserModel() {
    }

    public UserModel(@NotNull String username,
                     @NotNull String password,
                     @NotNull String primaryEmail,
                     @NotNull String firstName,
                     @NotNull String lastName,
                     @NotNull String gender,
                     @NotNull LocalDate birthDate) {
        this.username = username;
        this.password = password;
        this.primaryEmail = primaryEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
    }

}
