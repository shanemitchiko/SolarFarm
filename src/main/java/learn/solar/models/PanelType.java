package learn.solar.models;

public enum PanelType {
    MULTI_SILICON("Multicrystalline Silicon"),
    MONO_SILICON("Monocrystalline Silicon"),
    A_SILICON("Amorphous Silicon"),
    CAD_TELL("Cadmium Telluride"),
    COP_IND_GAL_SEL("Copper Indium Gallium Selenide");

    private final String panelType;

    PanelType(String PanelType) {
        this.panelType = PanelType;
    }

    public String getPanelType() {
        return panelType;
    }
}
