package com.a165942.tt001;

import model.VeterinarioDAO;
import model.TratamentoDAO;
import model.ClienteDAO;
import model.ExameDAO;
import model.EspecieDAO;
import model.AnimalDAO;
import model.Cliente;
import model.ConsultaDAO;
import view.ClienteAnimal;

public class Main {

    public static void main(String[] args) {
             
        ClienteAnimal main = new ClienteAnimal();
        main.setVisible(true);
//        ClienteDAO.getInstance().create("Jorge", "Rua do zancaner", "15130000",
//                "jorge@email.com", "999999999");
//
//        ClienteDAO.getInstance().create("Marcos", "Rua Caesar", "15130000",
//                "marcos@email.com", "999999999");
//
//        System.out.println(ClienteDAO.getInstance().retrieveAll());
//        Cliente c1 = ClienteDAO.getInstance().retrieveById(3);
//        Cliente c2 = ClienteDAO.getInstance().retrieveById(4);
//        
//        EspecieDAO.getInstance().create("Cavalo");
//        System.out.println(EspecieDAO.getInstance().retrieveAll());
////
//        AnimalDAO.getInstance().create("Gudan", "2003", "m", 1, c1.getId());
//        AnimalDAO.getInstance().create("Blant", "2003", "m", 1, c1.getId());
//        AnimalDAO.getInstance().create("Rex", "2003", "m", 1, c1.getId());
//
//        AnimalDAO.getInstance().create("Linux", "2003", "m", 1, c2.getId());
//        AnimalDAO.getInstance().create("Thor", "2003", "m", 1, c2.getId());
//        AnimalDAO.getInstance().create("Tantan", "2003", "m", 1, c2.getId());
//        System.out.println(AnimalDAO.getInstance().retrieveByClientId(c1.getId()));
//        System.out.println(AnimalDAO.getInstance().retrieveByClientId(c2.getId()));
////        Cliente c1 = ClienteDAO.getInstance().retrieveById(1);
//
//        VeterinarioDAO.getInstance().create("jorge", "jorge@email.com", "18999999999");
//        VeterinarioDAO.getInstance().create("cleisson", "cleisson@email.com", "18999999999");
//        System.out.println(VeterinarioDAO.getInstance().retrieveAll());
//        System.out.println(VeterinarioDAO.getInstance().retrieveById(2));
//
//        ExameDAO.getInstance().create("Tratamento verminosa", 1);
//        ExameDAO.getInstance().create("Tratamento bacterial", 2);
//        System.out.println(ExameDAO.getInstance().retrieveAll());
//        System.out.println(ExameDAO.getInstance().retrieveById(2));
//
//        ConsultaDAO.getInstance().create("13/08/2021", "15:00", "Muita dor na pata",
//                1, 1, 1, 1);
//        System.out.println(ConsultaDAO.getInstance().retrieveAll());
//        System.out.println(ConsultaDAO.getInstance().retrieveById(2));
//
//        TratamentoDAO.getInstance().create(1, "Medicação", "15/11/2021", "18/11/2021", 0);
//        TratamentoDAO.getInstance().create(1, "Medicação", "15/08/2021", "18/08/2021", 1);
//        System.out.println(TratamentoDAO.getInstance().retrieveAll());
//        System.out.println(TratamentoDAO.getInstance().retrieveById(2));
    }
}
