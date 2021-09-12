package com.a165942.tt001;

public class Main {

    public static void main(String[] args) {

//        ClienteDAO.getInstance().create("Jorge", "Rua do zancaner", "15130000",
//        "jorge@email.com","999999999");
//                
//        ClienteDAO.getInstance().create("Marcos", "Rua Caesar", "15130000",
//        "marcos@email.com","999999999");
//        
//        System.out.println(ClienteDAO.getInstance().retrieveAll());
//        Cliente c1 = ClienteDAO.getInstance().retrieveById(3);
//        Cliente c2 = ClienteDAO.getInstance().retrieveById(4);
//           EspecieDAO.getInstance().create("Cavalo");
//           Especie e1 = EspecieDAO.getInstance().retrieveById(2);
        Especie e1 = EspecieDAO.getInstance().retrieveById(2);
        EspecieDAO.getInstance().delete(e1);
        System.out.println(EspecieDAO.getInstance().retrieveAll());
//
//        AnimalDAO.getInstance().create("Gudan","2003","m",1,c1.getId());
//        AnimalDAO.getInstance().create("Blant","2003","m",1,c1.getId());
//        AnimalDAO.getInstance().create("Rex","2003","m",1,c1.getId());
//        
//        AnimalDAO.getInstance().create("Linux","2003","m",1,c2.getId());
//        AnimalDAO.getInstance().create("Thor","2003","m",1,c2.getId());
//        AnimalDAO.getInstance().create("Tantan","2003","m",1,c2.getId());

//        System.out.println(AnimalDAO.getInstance().retrieveByClientId(c1.getId()));
//        System.out.println(AnimalDAO.getInstance().retrieveByClientId(c2.getId()));
//        Cliente c1 = ClienteDAO.getInstance().retrieveById(1);
//        c1.addAnimal(a1);
//        c1.addAnimal(a2);
//        
//        System.out.println(c1.toString());
    }
}
