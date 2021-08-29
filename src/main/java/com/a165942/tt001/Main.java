package com.a165942.tt001;

public class Main {

    public static void main(String[] args) {
//        ClienteDAO.getInstance().create("Cleisson", "Rua dos bobos", "999999999",;
//                "15132090", "@.com");

//        AnimalDAO.getInstance().create("TInoco","2003","m",1,2);
//        AnimalDAO.getInstance().create("Gudan","2003","m",1,2);;
//        AnimalDAO.getInstance().create("rex","2002","m",1,2);
//        Animal a2 = new Animal(2,"Tinoco",15,'m');
        
//        Cliente c1 = ClienteDAO.getInstance().retrieveById(1);
        
        System.out.println(ClienteDAO.getInstance().retrieveAll());
//        System.out.println(AnimalDAO.getInstance().retrieveAll());
//        System.out.println(AnimalDAO.getInstance().retrieveByOwnerId(2));
//        c1.addAnimal(a1);
//        c1.addAnimal(a2);
//        
//        System.out.println(c1.toString());

    }
}
