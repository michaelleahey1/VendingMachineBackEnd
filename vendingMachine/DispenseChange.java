package org.vendingMachine;

public class DispenseChange implements State{
    private final VendingMachine vendingMachine;
    DispenseChange(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void collectCash(int cash){
        throw new RuntimeException("Dispensing Change. Unable to collect cash");
    }


    @Override
    public void dispenseChange(String productCode){
        int change = this.vendingMachine.calculateChange(productCode);
        System.out.println("change of " + change + " returned");
        this.vendingMachine.setState( new DispenseItem(this.vendingMachine));
        this.vendingMachine.dispenseItem(productCode);
    }
    @Override
    public void dispenseItem(String productionCode){
        throw new RuntimeException( "Dispensing change. Unable to dispense Item" );
    }
    @Override
    public void cancelTransaction(){
        throw new RuntimeException( "Dispensing change. Unable to cancel transaction" );
    }

}
