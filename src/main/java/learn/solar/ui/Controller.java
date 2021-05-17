//package learn.solar.ui;
//
//import learn.solar.data.DataAccessException;
//import learn.solar.domain.PanelResult;
//import learn.solar.domain.PanelService;
//import learn.solar.models.Panel;
//
//import java.util.List;
//
//public class Controller {
//
//    private final PanelService service;
//    private final View view;
//
//    public Controller(PanelService service, View view) {
//        this.service = service;
//        this.view = view;
//    }
//
//    public void run() {
//        view.printHeader("Welcome To Unexplained Encounters.");
//
//        try {
//            runMenuLoop();
//        } catch (DataAccessException ex) {
//            view.printHeader("CRITICAL ERROR:" + ex.getMessage());
//        }
//
//        view.printHeader("Goodbye");
//    }
//
//    private void runMenuLoop() throws DataAccessException {
//        MenuOption option;
//        do {
//            option = view.displayMenuGetOption();
//            switch (option) {
//                case FIND_BY_SECTION:
//                    displayBySection();
//                    break;
//                case ADD:
//                    addPanel();
//                    break;
//                case UPDATE:
//                    updatePanel();
//                    break;
//                case DELETE:
//                    deletePanel();
//                    break;
//            }
//        } while (option != MenuOption.EXIT);
//    }
//
//
//    private void displayBySection() throws DataAccessException {
//        Panel section = view.readSection(MenuOption.FIND_BY_SECTION.getMessage());
//        List<Panel> panels = service.findBySection(section);
//        view.printPanels(null, panels);
//    }
//
//    private void addPanel() throws DataAccessException {
//        Panel panel = view.readPanel(MenuOption.UPDATE.getMessage());
//        Panel panel = ;
//        view.printResult(result);
//    }
//
//    private void updatePanel() throws DataAccessException {
//        List<Panel> panels = service.findBySection(section);
//        Panel panel = view.choosePanel(panels);
//        if (panel == null) {
//            return;
//        }
//        panel = view.update(panel);
//        PanelResult result = service.update(panel);
//        view.printResult(result);
//    }
//
//    }
////}
