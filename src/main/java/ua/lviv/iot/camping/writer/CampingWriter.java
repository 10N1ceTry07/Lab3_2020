package ua.lviv.iot.camping.writer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import ua.lviv.iot.camping.model.*;

public class CampingWriter {
    
    public Writer csvWriter = new StringWriter();

    public Writer getCsvWriter() {
        return csvWriter;
    }

    public void setCsvWriter(Writer csvWriter) {
        this.csvWriter = csvWriter;
    }

    public void writeToFile(List<AbstractCamping> listOfThings) throws IOException {
        csvWriter.write(listOfThings.get(0).getHeaders());
        csvWriter.write("\n");
        for (AbstractCamping things : listOfThings) {
            csvWriter.write(things.toCSV());
            csvWriter.write("\n");
        }
        csvWriter.flush();
    }

    @Override
    public String toString() {
        return csvWriter.toString();
    }

}
