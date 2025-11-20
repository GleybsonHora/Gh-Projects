package model.domain;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        ProductCRUD productCRUD = new ProductCRUD();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n==== CRUD MENU ====");
            System.out.println("1. Criar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Atualizar produto");
            System.out.println("4. Deletar produto");
            System.out.println("5. Sair");
            System.out.println("Escolha: ");

            int option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.println("ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nome: "); String name = sc.nextLine();
                    System.out.println("Preço: "); double price = sc.nextDouble();
                    productCRUD.create(new Product(id, name, price));
                    break;

                case 2:
                    for (Product p : productCRUD.readAll())
                        System.out.println(p.getId() + ": " + p.getName() + " -- R$ " + p.getPrice());
                    break;
                case 3:
                    System.out.println("ID do produto: "); int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Novo Nome: "); String newName = sc.nextLine();
                    System.out.println("Novo Preço: "); double newPrice = sc.nextDouble();
                    productCRUD.update(uid, newName, newPrice);
                    break;
                case 4:
                    System.out.println("ID do produto a ser deletado: "); int did = sc.nextInt();
                    productCRUD.delete(did);
                    break;
                case 5:
                    System.out.println("Programa finalizado!");
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
