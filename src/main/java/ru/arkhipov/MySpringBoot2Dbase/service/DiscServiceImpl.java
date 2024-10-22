package ru.arkhipov.MySpringBoot2Dbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.arkhipov.MySpringBoot2Dbase.dao.DiscDAO;
import ru.arkhipov.MySpringBoot2Dbase.entity.Disc;

import java.util.List;

@Service
public class DiscServiceImpl implements DiscService {

    @Autowired
    private DiscDAO discDAO;

    @Override
    @Transactional
    public List<Disc> getAllDiscs() {
        return discDAO.getAllDiscs();
    }

    @Override
    @Transactional
    public Disc saveDisc(Disc disc) {
        return discDAO.saveDisc(disc);
    }

    @Override
    @Transactional
    public Disc getDisc(int id) {
        return discDAO.getDisc(id);
    }

    @Override
    @Transactional
    public void deleteDisc(int id) {
        discDAO.deleteDisc(id);
    }
}
