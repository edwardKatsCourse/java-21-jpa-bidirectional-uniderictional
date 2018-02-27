package com.company.repository;

import com.company.model.one_to_many_u.Team_U;
import com.company.model.one_to_many_u.User_U;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TeamRepository_U {

    @PersistenceContext
    private EntityManager entityManager;


    public Team_U save(Team_U team_u) {
        entityManager.persist(team_u);
        return team_u;
    }

    public Team_U update(Team_U team_u) {
        entityManager.merge(team_u);
        return team_u;
    }

    public List<Team_U> findAll() {
        return entityManager.createQuery("from Team_U").getResultList();
    }

    public List<Team_U> findByTeamName(String teamName) {
        return entityManager
                .createQuery("from Team_U t where t.teamName = :teamName")
                .setParameter("teamName", teamName)
                .getResultList();
    }

    public Team_U findTeamByUser(User_U user_u) {
        List team = entityManager.createQuery("select u.team from User_U u where u = :user").setParameter("user", user_u).getResultList();
        if (!team.isEmpty()) {
            return (Team_U) team.get(0);
        }
        return null;
    }

    public void deleteTeam(Integer teamId) {
        Team_U t = entityManager.find(Team_U.class, teamId);
        if (t != null) {

            entityManager.remove(t);
        }
    }
}
