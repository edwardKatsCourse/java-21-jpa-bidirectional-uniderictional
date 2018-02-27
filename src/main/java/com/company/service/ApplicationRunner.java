package com.company.service;

import com.company.model.one_to_many_b.Team_B;
import com.company.model.one_to_many_b.User_B;
import com.company.model.one_to_many_u.Team_U;
import com.company.model.one_to_many_u.User_U;
import com.company.repository.TeamRepository_B;
import com.company.repository.TeamRepository_U;
import com.company.repository.UserRepository_B;
import com.company.repository.UserRepository_U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ApplicationRunner {

    @Autowired
    private UserRepository_B userRepository_b;

    @Autowired
    private UserRepository_U userRepository_u;

    @Autowired
    private TeamRepository_B teamRepository_b;

    @Autowired
    private TeamRepository_U teamRepository_u;

    @Transactional
    public void run_U() {
        Team_U team_u = new Team_U();
        team_u.setTeamName("Unidirectional Team");

        teamRepository_u.save(team_u);
        System.out.println("Unidirectional teams: " + teamRepository_u.findAll().size());

        User_U user_u_1 = User_U.builder()
                .email("u1@site.com")
                .team(team_u)
                .displayName("User U 1")
                .build();
        User_U user_u_2 = User_U.builder()
                .email("u2@site.com")
                .team(team_u)
                .displayName("User U 2")
                .build();
        User_U user_u_3 = User_U.builder()
                .email("u3@site.com")
                .team(team_u)
                .displayName("User U 3")
                .build();
        User_U user_u_4 = User_U.builder()
                .email("u4@site.com")
                .team(team_u)
                .displayName("User U 4")
                .build();

        userRepository_u.save(user_u_1);
        userRepository_u.save(user_u_2);
        userRepository_u.save(user_u_3);
        userRepository_u.save(user_u_4);



        System.out.println("Team name: " + team_u.getTeamName());

        teamRepository_u.deleteTeam(team_u.getId());

        System.out.println("Users count: " + userRepository_u.findAll().size());
    }

    @Transactional
    public void run_B() {
        Team_B team_b = Team_B.builder()
                .teamName("team B")
                .build();
        teamRepository_b.save(team_b);

        User_B user_b_1 = User_B.builder()
                .displayName("User B 1")
                .email("u1@site.com")
                .build();

        User_B user_b_2 = User_B.builder()
                .displayName("User B 2")
                .email("u2@site.com")
                .build();

        User_B user_b_3 = User_B.builder()
                .displayName("User B 3")
                .email("u3@site.com")
                .build();

        User_B user_b_4 = User_B.builder()
                .displayName("User B 4")
                .email("u4@site.com")
                .build();

        userRepository_b.save(user_b_1);
        userRepository_b.save(user_b_2);
        userRepository_b.save(user_b_3);
        userRepository_b.save(user_b_4);

        List<User_B> userBList = new ArrayList<User_B>();
        userBList.add(user_b_1);
        userBList.add(user_b_2);
        userBList.add(user_b_3);
        userBList.add(user_b_4);

        team_b.setUsers(userBList);
        team_b.setTeamName("another team");
        teamRepository_b.update(team_b);

        System.out.println("Team: " + team_b.toString());
        System.out.println("Team of user 4: " + teamRepository_b.findTeamByUser(user_b_4));
        System.out.println(String.format("Users in team %s: %s", team_b, team_b.getUsers()));

    }
}
