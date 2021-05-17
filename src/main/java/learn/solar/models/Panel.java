package learn.solar.models;

import java.util.Objects;

public class Panel {
    private int id;
    private String section;
    private int row;
    private int column;
    private int yearInstalled;
    private boolean isTracking;
    private PanelType type;

    public Panel(){

    }

    public Panel(String section, int rows, int column) {
        this.section = section;
        this.row = row;
        this.column = column;
    }

    public Panel(int id, String section, int row, int column, int yearInstalled, boolean isTracking, String type) {
        this.id = id;
        this.section = section;
        this.row = row;
        this.column = column;
        this.yearInstalled = yearInstalled;
        this.isTracking = isTracking;
        this.type = PanelType.valueOf(type);
    }


    public int getid(){
        return id;
    }

    public void setid(int id){
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int rows) {
        this.row = rows;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int columns) {
        this.column = columns;
    }

    public int getYearInstalled() {
        return yearInstalled;
    }

    public void setYearInstalled(int yearInstalled) {
        this.yearInstalled = yearInstalled;
    }

    public boolean isTracking() {
        return isTracking;
    }

    public void setTracking(boolean tracking) {
        isTracking = tracking;
    }

    public PanelType getType() {
        return type;
    }

    public void setType(PanelType type) {
        this.type = type;
    }


    public boolean equals(Panel p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        Panel panel = (Panel) p;
        return id == panel.id &&
                Objects.equals(section, panel.section) &&
                row == panel.row &&
                column == panel.column &&
                yearInstalled == panel.yearInstalled &&
                isTracking == panel.isTracking &&
                type == panel.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,section,row,column,isTracking,type);
    }
}
