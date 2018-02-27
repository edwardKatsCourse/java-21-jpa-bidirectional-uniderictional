package com.company.repository;

import com.company.model.one_to_many_b.Team_B;
import com.company.model.one_to_many_b.User_B;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TeamRepository_B {
    @PersistenceContext
    private EntityManager entityManager;

    public Team_B save(Team_B team_b) {
        entityManager.persist(team_b);
        return team_b;
    }

    public Team_B update(Team_B team_b) {
        entityManager.merge(team_b);
        return team_b;
    }

    public List<Team_B> findAll() {
        return entityManager.createQuery("from Team_B t").getResultList();
    }

    public List<Team_B> findByTeamName(String teamName) {
        return entityManager
                .createQuery("from Team_B t where t.teamName =:teamName")
                .setParameter("teamName", teamName)
                .getResultList();
    }

    public Team_B findTeamByUser(User_B user_b) {
        List user = entityManager.createQuery("from Team_B t join t.users u where u =:user ").setParameter("user", user_b).getResultList();
        if (!user.isEmpty()) {
            return (Team_B) user.get(0);
        }
        return null;
    }

    public void deleteTeam(Integer teamId) {
        Team_B t = entityManager.find(Team_B.class, teamId);
        if (t != null) {

            entityManager.remove(t);
        }
    }
}
