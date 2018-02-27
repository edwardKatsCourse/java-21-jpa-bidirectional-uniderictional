package com.company.model.one_to_many_b;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEAM_BIDIRECTIONAL")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Team_B {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TEAM_NAME", unique = true, nullable = false, length = 100)
    private String teamName;

    @OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST)
    private List<User_B> users;
}
