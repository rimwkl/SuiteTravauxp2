package com.example.jpa2_app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="USERS")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(name="USER_NAME",unique = true, length = 20) //index unique
    private String userName;
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY) //pour que mdp doit etre hashe
    private String password;
    //toujours si ya manytomany je dois mapper
    @ManyToMany(mappedBy = "users",fetch= FetchType.EAGER) // a chaque fois que je lui demander de charger un user il va charger auto les roles de cette user
    private List<Role> roles=new ArrayList<>();
}

