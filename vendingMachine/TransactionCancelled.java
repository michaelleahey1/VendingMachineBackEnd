package org.vendingMachine;

public class TransactionCancelled implements State {
    private VendingMachine vendingMachine;

    TransactionCancelled(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        throw new RuntimeException("Unable to collect cash in a cancelled transaction");
    }

    @Override
    public void dispenseChange(String productCode) {
        throw new RuntimeException("Unable to dispense item in a cancelled transaction");
    }

    @Override
    public void dispenseItem(String productionCode) {
        throw new RuntimeException("Unable to dispense item in a cancelled transaction");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Returning collected cash" + vendingMachine.getCollectedCash());
        vendingMachine.setCollectedCash(0);
        vendingMachine.setState(new Ready(vendingMachine));
    }
}