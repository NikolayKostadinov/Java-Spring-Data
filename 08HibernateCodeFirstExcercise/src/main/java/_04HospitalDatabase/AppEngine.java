package _04HospitalDatabase;

import _04HospitalDatabase.common.Utilities;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.services.Service;
import _04HospitalDatabase.services.ServiceFactory;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.stream.Collectors;

import static _04HospitalDatabase.common.Utilities.printMessage;
import static _04HospitalDatabase.common.Utilities.printRedMessage;

public class AppEngine implements Runnable {
    private final ServiceFactory serviceFactory;

    public AppEngine(EntityManager dbManager) {
        this.serviceFactory = new ServiceFactory(dbManager);
    }

    @Override
    public void run() {
        printMainMenu();
        int operation = 0;
        try {
            operation = Utilities.readIntFromConsole("Choose operation: ");
        } catch (IOException e) {
            printRedMessage(e.getMessage());
        }

        while (operation != 0) {
            Service service = serviceFactory.getService(operation);
            try {
                if (operation <= 5) {
                    service.create();
                } else {
                    printMessage(
                            service.getAll()
                                    .stream()
                                    .map(x -> x.toString())
                                    .collect(Collectors.joining(System.lineSeparator())).toString());
                }
                printMainMenu();
                operation = Utilities.readIntFromConsole("Choose operation: ");

            } catch (ValidationException | DateTimeParseException | NumberFormatException | IOException e) {
                printRedMessage(e.getMessage());
            }
        }
    }

    private void printMainMenu() {
        StringBuilder stringBuilder = new StringBuilder().append(System.lineSeparator());
        stringBuilder.append("Operations menu").append(System.lineSeparator());
        stringBuilder.append("----------------").append(System.lineSeparator());
        stringBuilder.append("1. Create visitation").append(System.lineSeparator());
        stringBuilder.append("2. Create town").append(System.lineSeparator());
        stringBuilder.append("3. Create address").append(System.lineSeparator());
        stringBuilder.append("4. Create Patient").append(System.lineSeparator());
        stringBuilder.append("5. Create Medicament").append(System.lineSeparator());
        stringBuilder.append("6. List visitation").append(System.lineSeparator());
        stringBuilder.append("7. List town").append(System.lineSeparator());
        stringBuilder.append("8. List address").append(System.lineSeparator());
        stringBuilder.append("9. List Patient").append(System.lineSeparator());
        stringBuilder.append("10. List Medicament").append(System.lineSeparator());
        stringBuilder.append("0. Exit").append(System.lineSeparator());

        System.out.println(stringBuilder);

    }
}
