package ru.arkhipov.MySpringBoot2Dbase.dao;

import org.springframework.stereotype.Repository;
import ru.arkhipov.MySpringBoot2Dbase.entity.Disc;

import java.util.List;

@Repository
public interface DiscDAO {
    List<Disc> getAllDiscs();
    Disc saveDisc (Disc disc);
    Disc getDisc(int id);
    void deleteDisc (int id);
}
