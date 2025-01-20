package autosalesmanager.util;
import java.util.ArrayList;
import java.util.Scanner;
import autosalesmanager.model.AutoMobile;
import autosalesmanager.service.LoanProcessingService;

public class ClientInterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista de carros disponíveis
        ArrayList<AutoMobile> carros = new ArrayList<>();
        carros.add(new AutoMobile("Civic", "Honda", 2022, 150000.0));
        carros.add(new AutoMobile("Corolla", "Toyota", 2023, 160000.0));
        carros.add(new AutoMobile("Onix", "Chevrolet", 2021, 90000.0));
        carros.add(new AutoMobile("Gol", "Volkswagen", 2020, 50000.0));

        System.out.println("===============================");
        System.out.println("Bem-vindo ao AutoSalesManager! =");
        System.out.println("===============================");
        System.out.println("Escolha um serviço: ");
        System.out.println("1 - Carros disponíveis");
        System.out.println("2 - Simular financiamento");
        System.out.println("===============================");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Lista de carros disponíveis:");
                for (int i = 0; i < carros.size(); i++) {
                    System.out.println((i + 1) + " -");
                    carros.get(i).ShowDetails();
                }
                break;

            case 2:
                System.out.println("Digite o saldo disponível para entrada:");
                double saldo = scanner.nextDouble();

                System.out.println("Escolha o número do carro desejado:");
                for (int i = 0; i < carros.size(); i++) {
                    System.out.println((i + 1) + " -");
                    carros.get(i).ShowDetails();
                }

                int numeroCarro = scanner.nextInt();
                if (numeroCarro < 1 || numeroCarro > carros.size()) {
                    System.out.println("Carro inválido. Tente novamente.");
                } else {
                    AutoMobile carroEscolhido = carros.get(numeroCarro - 1);
                    System.out.println("Digite o número de parcelas:");
                    int meses = scanner.nextInt();

                    LoanProcessingService loanService = new LoanProcessingService(saldo, carroEscolhido.getPreco());
                    loanService.LoanSimulator(meses);
                }
                break;

            default:
                System.out.println("Opção inválida. Escolha entre 1 e 2.");
                break;
        }

        scanner.close();
    }
}
