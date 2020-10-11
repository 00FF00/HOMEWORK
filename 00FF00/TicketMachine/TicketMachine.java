public class TicketMachine {

    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public  TicketMachine(int ticketCost){
        balance=0;
        total=0;
        if(ticketCost>0)
           price=ticketCost;
        else
            System.out.println("ticket must be positive!");
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void  insetMoney(int amount){
        if(amount<0)
            System.out.println("You must use a positive value!");
        else
            balance+=amount;
    }

    /**
     * Print a ticket if enough money has been inserted, and reduce the current balance by the ticket price.
     * Print an error message if more money is required.
     */
    void printTicket(){
        if(balance<price)
            System.out.println("Balance is not enough!You must insert at least: " + (price - balance) + " more cents.");
        else {
            // Simulate the printing of a ticket.
        System.out.println("----------*****----------");
        System.out.println("这是一个售票机");
        System.out.println("票价: "+price+"元");
        System.out.println("----------*****----------");
        // Reduce the balance by the price.
        balance-=price;
        // Update the total collected with the price.
        total+=price;
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance(){
        int amountRefunded=balance;
        balance=0;
        return amountRefunded;
    }

    /**
     *  Return the price of a ticket.
     */
    public  int getPrise(){
        return total;
    }
    public  void setPrice(int price){
        this.price=price;
    }

    /**
     * Return The amount of money already inserted for the next ticket.
     */
    public int getBalance(){
        return balance;
    }
    public int getTotal(){
        return total;
    }


    /**
     * Reset the ticket.
     */
    public  void reset(){
        balance = 0;
        total = 0;
    }
}