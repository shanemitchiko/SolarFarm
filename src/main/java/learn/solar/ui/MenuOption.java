package learn.solar.ui;

public enum MenuOption {
    EXIT("Exit"),
    FIND_BY_SECTION("Find Panels by Section"),
    ADD("Add a Panel"),
    UPDATE("Update a Panel"),
    DELETE("Remove a Panel");

    private String message;

    MenuOption(String name) {
        this.message = name;
    }

    public String getMessage() {
        return message;
    }
}
