import com.sun.org.apache.xml.internal.security.utils.resolver.implementations.ResolverAnonymous;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Refactor {
    public static void main(String[] args){
        List<Invoice> invoice = new ArrayList<>();
        List<Invoice> oracleAndTrainingInvoices = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        List<Integer> firstFiveIds = new ArrayList<>();

        invoice = initialize();

        //add sorted oracle invoice
        oracleAndTrainingInvoices = invoice.stream()
                .filter(inv -> inv.getCustomer() == Invoice.Customer.ORACLE)
                .filter(inv -> inv.getTitle().contains("Training"))
                .sorted(Comparator.comparing(Invoice::getAmount))
                .collect(Collectors.toList());
        System.out.println("Oracle invoice: " + oracleAndTrainingInvoices.size());
        printInvoice(oracleAndTrainingInvoices);

        //id list
        ids = oracleAndTrainingInvoices.stream()
                .map(inv -> inv.getId())
                .collect(Collectors.toList());
        System.out.println(ids);

        //first 5 ids
        firstFiveIds = ids.stream()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(firstFiveIds);
    }

    private static List<Invoice> initialize(){
        List<Invoice> list = new ArrayList<>();
        Invoice inv;
        int n = 0;

        while(n<=20){
            if(n % 2 == 0) {
                inv = new Invoice(Invoice.Customer.ORACLE, n, "Training Staff", 1000 + new Random().nextInt(10000));
            }else{
                inv = new Invoice(Invoice.Customer.NONORACLE, n, "Workshop", 3000 + new Random().nextInt(5000));
            }
            list.add(inv);
//            System.out.println(inv.stringInvoice());
            n++;
        }

        System.out.println("Initial data: " + list.size());

        return list;
    }

    private static void printInvoice(List<Invoice> list){
        for(Invoice i: list){
            System.out.println(i.stringInvoice());
        }
    }
}
