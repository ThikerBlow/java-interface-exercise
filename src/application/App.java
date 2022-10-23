package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter contract data:");

        System.out.print("\nNumber: ");
        int contractNumber = sc.nextInt();

        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate localDate = LocalDate.parse(sc.next(), dateTimeFormatter);

        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();

        Contract contract = new Contract(contractNumber, localDate, contractValue);

        ContractService contractService = new ContractService(new PaypalService());

        System.out.print("Enter number of installments: ");
        int numberOfInstallments = sc.nextInt();

        contractService.processContract(contract, numberOfInstallments);

        System.out.println("\nInstallments:");

        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }
        sc.close();
    }
}
