public class Invoice {

    Customer customer;
    int id;
    String title;
    int amount;

    public enum Customer {
        ORACLE, NONORACLE
    }



    public Invoice(Customer customer, int id, String title, int amount) {
        this.customer = customer;
        this.id = id;
        this.title = title;
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String stringInvoice(){
        return id + " | " + customer + " | " + title + " | Rp" + amount;
    }
}
