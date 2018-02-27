package com.company.model.one_to_many_b;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USER_BIDIRECTIONAL")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "team")
@Builder
public class User_B {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 50)
    private String email;

    @Column(name = "DISPLAY_NAME", unique = true, nullable = false, length = 100)
    private String displayName;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team_B team;
}
