package learn.solar.data;

import learn.solar.models.Panel;
import learn.solar.models.PanelType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PanelFileRepositoryTest {

    static final String SEED_PATH = "./data/panels-seed.csv";
    static final String TEST_PATH = "./data/panels-test.csv";


    private PanelFileRepository repository = new PanelFileRepository(TEST_PATH);


    @BeforeEach
    void setup() throws IOException {
        Files.copy(Paths.get(SEED_PATH), Paths.get(TEST_PATH), StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void findAll() throws DataAccessException {
        List<Panel> actual = repository.findAll();

        assertNotNull(actual);
        assertEquals(5, actual.size());
    }

//    @Test
//    void shouldAddPanel(int id, String section, int row, int column, int year, boolean tracking, String panelType) throws DataAccessException {
//        Panel panel = new Panel(id, section, row, column,year,tracking,panelType);
//        panel.setid(6);
//        panel.setSection("Treeline");
//        panel.setRow(10);
//        panel.setColumn(29);
//        panel.setYearInstalled(2011);
//        panel.setTracking(true);
//        panel.setType(PanelType.MONO_SILICON);
//
//        Panel actual = repository.add(panel);
//        assertNotNull(actual);
//        assertEquals(6, actual.getid());
//    }
}