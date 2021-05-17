package learn.solar.domain;

import learn.solar.data.DataAccessException;
import learn.solar.data.PanelRepository;
import learn.solar.models.Panel;

import java.util.List;
import java.util.Objects;

public class PanelService {

    private final PanelRepository repository;

    public PanelService(PanelRepository repository) {
        this.repository = repository;
    }

    public List<Panel> findAll() throws DataAccessException {
        return repository.findAll();
    }


    public List<Panel> findBySection(String section) throws DataAccessException {
        return repository.findBySection(section);
    }

    public PanelResult add(String section, int row, int column, int year, boolean tracking, String panelType) throws DataAccessException {
        Panel panel = repository.add(section, row, column, year, tracking, panelType);
        PanelResult panelResult = setPayloadToFile(panel);
        return panelResult;
    }


    public PanelResult setPayloadToFile(Panel panel) throws DataAccessException {
        PanelResult result = validate(panel);
        if (!result.isSuccess()) {
            return result;
        }

        result.setPayload(panel);
        return result;
    }

    public boolean deleteBySectionRowCol(String section, int row, int column) throws DataAccessException {
        return repository.deleteBySectionRowCol(section, row, column);
    }

    public boolean update(String section, int row, int column, int year, boolean tracking, String panelType) throws DataAccessException {
        return  repository.update(section, row, column, year, tracking, panelType);
    }


    private PanelResult validate(Panel panel) throws DataAccessException {
        PanelResult result = new PanelResult();
        if (panel == null) {
            result.addErrorMessage("panel cannot be null");
        }

        if (panel.getSection() == null || panel.getSection().trim().length() == 0) {
            result.addErrorMessage("section is required");
        }

        if (panel.getRow() >= 250 && panel.getRow() <= 0) {
            result.addErrorMessage("Rows between 1-250 is required");
        }

        if (panel.getColumn() >= 250 && panel.getColumn() <= 0) {
            result.addErrorMessage("Columns between 1 - 250 is required");
        }

        if (panel.getYearInstalled() <= 1 && panel.getYearInstalled() >= 2021) {
            result.addErrorMessage("Not valid year for solar panel");
        }

        if (!result.isSuccess()) {
            return result;
        }

        List<Panel> panels = repository.findAll();
        for (Panel p : panels) {
            if (Objects.equals(panel.getSection(), p.getSection())
                    && panel.getRow() == p.getRow()
                    && panel.getColumn() == p.getColumn()) {
                result.addErrorMessage("duplicate encounter is not allowed");
                return result;
            }
        }
        return result;
    }
}

