package model.services;

public class PaypalService implements OnlinePaymentService{

    public PaypalService() {
    }

    @Override
    public double paymentFee(double amount) {
        return 0.02 * amount;
    }

    @Override
    public double interest(double amount, int months) {
        return 0.01 * amount * months;
    }
}
