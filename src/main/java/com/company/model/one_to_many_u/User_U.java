package com.company.model.one_to_many_u;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USER_UNIDIRECTIONAL")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User_U {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 50)
    private String email;

    @Column(name = "DISPLAY_NAME", unique = true, nullable = false, length = 100)
    private String displayName;

    @JoinColumn(name = "TEAM_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Team_U team;
}
