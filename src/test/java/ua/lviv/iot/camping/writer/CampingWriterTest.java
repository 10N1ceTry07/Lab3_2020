package ua.lviv.iot.camping.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.camping.manager.BaseAbstractCampingTest;
import ua.lviv.iot.camping.writer.CampingWriter;

public class CampingWriterTest extends BaseAbstractCampingTest {
    CampingWriter campingWriter = new CampingWriter();

    @Test
    void writeToFileTest() throws IOException {
        Writer csvWriter = new FileWriter("CampingWriter.csv");
        campingWriter.setCsvWriter(csvWriter);
        campingWriter.writeToFile(things);
    }

}
