package com.company.model.one_to_many_u;

import com.company.model.one_to_many_b.User_B;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEAM_UNIDIRECTIONAL")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Team_U {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TEAM_NAME", unique = true, nullable = false, length = 100)
    private String teamName;


}
