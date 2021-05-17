package learn.solar.data;

import learn.solar.models.PanelType;
import learn.solar.models.Panel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PanelFileRepository implements PanelRepository {

    private static final String DELIMITER = ",";
    private static final String DELIMITER_REPLACEMENT = "";
    private static final String HEADER = "id,section,column,year,tracking,type";
    private final String filePath;

    public PanelFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Panel> findAll() throws DataAccessException {

        ArrayList<Panel> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            reader.readLine();

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                Panel panel = deserialize(line);
                if (panel != null) {
                    result.add(panel);
                }
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        }

        return result;
    }


    public List<Panel> findBySection(String section) throws DataAccessException {
        List<Panel> result = new ArrayList<>();
        for (Panel panel : findAll()) {
            if (panel.getSection().equals(section)) {
                result.add(panel);
            }
        }
        return result;
    }


    public Panel add(String section, int row, int column, int year, boolean tracking, String panelType) throws DataAccessException {
        Panel panel = new Panel(section, row, column);
        panel.setYearInstalled(year);
        panel.setTracking(tracking);
        panel.setType(PanelType.valueOf(panelType));

        List<Panel> all = findAll();
        panel.setid(getNextId(all));
        all.add(panel);
        writeAll(all);
        return panel;

    }


    @Override
    public boolean deleteBySectionRowCol(String section, int row, int column) throws DataAccessException {
        List<Panel> all = findAll();
        for (Panel panel : findAll()) {
            if (panel.getSection().equals(section)) {
                if ((panel.getRow() == row))
                    if ((panel.getColumn() == column)) {
                        all.remove(panel);
                        writeAll(all);
                        return true;
                    }
            }
        }
        return false;
    }

    @Override
    public boolean update(String section, int row, int column, int year, boolean tracking, String panelType) throws DataAccessException {
        List<Panel> all = findAll();
        for (Panel panel : findAll()) {
            if (panel.getSection().equals(section)) {
                if (panel.getRow() == row) {
                    if (panel.getColumn() == column) {
                        panel.setYearInstalled(year);
                        panel.setTracking(tracking);
                        panel.setType(PanelType.valueOf(panelType));
                        all.add(panel);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int getNextId(List<Panel> allPanels) {
        int nextId = 0;
        for (Panel p : allPanels) {
            nextId = Math.max(nextId, p.getid());
        }
        return nextId + 1;
    }

    private void writeAll(List<Panel> panels) throws DataAccessException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.println(HEADER);
            for (Panel p : panels) {
                writer.println(serialize(p));
            }
        } catch (IOException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        }
    }

    private String serialize(Panel panel) {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                panel.getid(),
                clean(panel.getSection()),
                panel.getRow(),
                panel.getColumn(),
                panel.getYearInstalled(),
                panel.isTracking(),
                panel.getType());

    }

    private Panel deserialize(String line) {
        String[] fields = line.split(DELIMITER, -1);
        if (fields.length == 7) {
            Panel panel = new Panel();
            panel.setid(Integer.parseInt(fields[0]));
            panel.setSection((fields[1]));
            panel.setRow(Integer.parseInt(fields[2]));
            panel.setColumn(Integer.parseInt(fields[3]));
            panel.setYearInstalled(Integer.parseInt(fields[4]));
            panel.setTracking(fields[5].equals("y"));
            panel.setType(PanelType.valueOf(fields[6]));
            return panel;
        }
        return null;
    }

    private String clean(String value) {
        return value.replace(DELIMITER, DELIMITER_REPLACEMENT);
    }

    private String restore(String value) {
        return value.replace(DELIMITER_REPLACEMENT, DELIMITER);
    }
}



