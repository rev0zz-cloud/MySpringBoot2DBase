package ru.arkhipov.MySpringBoot2Dbase.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.arkhipov.MySpringBoot2Dbase.entity.Disc;

import java.util.List;

@Slf4j
@Repository
public class DiscDAOImpl implements DiscDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Disc> getAllDiscs() {
        Query query = entityManager.createQuery("from Disc");
        List<Disc> allDiscs = query.getResultList();
        log.info("getAllDiscs: " + allDiscs);
        return allDiscs;
    }
    @Override
    public Disc saveDisc(Disc disc) {
        return entityManager.merge(disc);
    }
    @Override
    public Disc getDisc(int id) {
        return entityManager.find(Disc.class, id);
    }
    @Override
    public void deleteDisc(int id) {
        Query query = entityManager.createQuery("delete from Disc " + " where id =:discId");
        query.setParameter("discId", id);
        query.executeUpdate();
    }
}