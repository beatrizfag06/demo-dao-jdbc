package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("Teste 2 - findbydepartment");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller s : list) {
            System.out.println(s);
        }

        System.out.println("Teste 3 - findAll");
        list = sellerDao.findAll();
        for (Seller s : list) {
            System.out.println(s);
        }

        System.out.println("Teste 4 - Seller Insert");
        Seller newSeler = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeler);
        System.out.println("Inserted! New id: " + newSeler.getId());

        System.out.println("Teste 5 - Seller update");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("update completed");

        System.out.println("Teste 6 - Seller delete");
        System.out.println("Enter id for delete: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("delete completed");

        sc.close();

    }
}