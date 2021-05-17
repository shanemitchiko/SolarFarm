package learn.solar.data;

import learn.solar.domain.PanelResult;
import learn.solar.models.Panel;
import learn.solar.models.PanelType;

import java.util.ArrayList;
import java.util.List;

public class PanelRepositoryDouble implements PanelRepository {

    final static List<Panel> panelList = List.of(

            new Panel(2,"treeline",23,50,1977,true, PanelType.MULTI_SILICON.toString()));

    @Override
    public List<Panel> findAll() throws DataAccessException {
        return panelList;
    }

    @Override
    public Panel add(String section, int row, int column, int year, boolean tracking, String panelType) throws DataAccessException {
        return new Panel(2,"treeline",23,50,1977,true, PanelType.MULTI_SILICON.toString());
    }

    @Override
    public boolean deleteBySectionRowCol(String section, int row, int column) throws DataAccessException {
        return true;
    }

    @Override
    public List<Panel> findBySection(String section) throws DataAccessException {
        List<Panel> result = new ArrayList<>();
        for (Panel panel : panelList) {
            if (panel.getSection().equals(section)) {
                result.add(panel);
            }
        }
        return result;
    }

    @Override
    public boolean update(String section, int row, int column, int year, boolean tracking, String panelType) throws DataAccessException {
        return true;
    }
}
