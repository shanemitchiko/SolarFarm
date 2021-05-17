package learn.solar.data;

import learn.solar.models.Panel;
import learn.solar.models.PanelType;

import java.util.List;

public interface PanelRepository {
    List<Panel> findAll() throws DataAccessException;

    Panel add(String section, int row, int column, int year, boolean tracking, String panelType) throws DataAccessException;

    boolean deleteBySectionRowCol(String section, int row, int column) throws DataAccessException;

    List<Panel> findBySection(String section) throws DataAccessException;

    boolean update(String section, int row, int column, int year, boolean tracking, String panelType) throws DataAccessException;

}
