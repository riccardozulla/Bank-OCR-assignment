package dssc.assignment.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Path;

public class BankOcrAcceptanceTest {

    @Test
    public void parseFileWithSingleAllZeroesEntryAndShowActualAccountNumberOnConsole() throws Exception {
        URL allZerosSingleEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("allZerosEntry");
        ApplicationRunner application = new ApplicationRunner();

        application.parseFile(Path.of(allZerosSingleEntry.toURI()));

        application.showsAccountNumber("000000000" + System.lineSeparator());
    }

    @Test
    public void parseFileWithSingleAllOnesEntryAndShowActualAccountNumberOnConsole() throws Exception {
        URL allOnesSingleEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("allOnesEntry");
        ApplicationRunner application = new ApplicationRunner();

        application.parseFile(Path.of(allOnesSingleEntry.toURI()));

        application.showsAccountNumber(String.format("111111111 ERR%n"));
    }

    @Test
    void parseFileWithSingleOneToNineDigitsAndShowActualAccountNumberOnConsole() throws Exception {
        URL allOneToNineDigitsEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("allOneToNineDigitEntry");
        ApplicationRunner application = new ApplicationRunner();

        application.parseFile(Path.of(allOneToNineDigitsEntry.toURI()));

        application.showsAccountNumber(String.format("123456789%n"));
    }

    @Test
    void parseFileWithMultipleEntriesAndShowActualAccountNumbersOnConsole() throws Exception {
        URL multipleEntries = BankOcrAcceptanceTest.class.getClassLoader().getResource("multipleEntries");
        ApplicationRunner application = new ApplicationRunner();

        application.parseFile(Path.of(multipleEntries.toURI()));

        application.showsAccountNumber(String.format("200800000%n999999999 ERR%n490867713 ERR%n"));
    }
}
