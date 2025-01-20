package autosalesmanager.model;

public class LoanCalculator {

    private double saldoCliente;

    public LoanCalculator(double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public double getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }
}
