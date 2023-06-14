package ro.pao.service.implementations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.application.csv.CsvWriter;
import ro.pao.model.Bill;
import ro.pao.service.BillService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class BillServiceImpl implements BillService {

    @Override
    public void writeCSVBill(List<String[]> bills) {
        List<String[]> lines = new ArrayList<>();
        bills.forEach(bill -> lines.add(new String[] {bill[0], bill[1]}));
        try {
            CsvWriter csvWriter = CsvWriter.getInstance();

            // Write line by line
            Path lineByLinePath = Paths.get("line_by_line.csv");

//          String lineByLineContentsPathDefined = csvWriter.executeLineByLine(lines);
            String lineByLineContents = csvWriter.writeLineByLine(lines, lineByLinePath);
            System.out.println("Contents of line_by_line.csv:");
            System.out.println(lineByLineContents);



            // Write all lines at once
            Path allLinesPath = Paths.get("all_lines.csv");
            //String allLinesContents = csvWriter.executeAllLines(lines);
            String allLinesContents = csvWriter.writeAllLines(lines, allLinesPath);
            System.out.println("Contents of all_lines.csv:");
            System.out.println(allLinesContents);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
