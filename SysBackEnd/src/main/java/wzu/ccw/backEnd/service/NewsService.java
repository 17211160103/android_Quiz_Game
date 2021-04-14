package wzu.ccw.backEnd.service;

import wzu.ccw.backEnd.dataobject.NewsDO;

import java.util.List;

public interface NewsService {
    NewsDO selectDetailById(long id);

    List<NewsDO> selectDetailByTitle(String title);

    List<NewsDO> selectAll();
}
