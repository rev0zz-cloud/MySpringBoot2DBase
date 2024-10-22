package ru.arkhipov.MySpringBoot2Dbase.service;

import org.springframework.stereotype.Service;
import ru.arkhipov.MySpringBoot2Dbase.entity.Disc;
import ru.arkhipov.MySpringBoot2Dbase.entity.Disc;

import java.util.List;

@Service
public interface DiscService {
    List<Disc> getAllDiscs() ;
    Disc saveDisc (Disc disc );
    Disc getDisc (int id);
    void deleteDisc (int id);
}

