package com.practice.vehiclebooking.orchestrator;

import com.practice.vehiclebooking.common.BranchList;
import com.practice.vehiclebooking.service.AssetManagementService;
import com.practice.vehiclebooking.entity.Branch;
import com.practice.vehiclebooking.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
public class RequestDispatcher {

    @Autowired
    private AssetManagementService assetManagement;

    @PostConstruct
    public void init(){
        Map<String, Branch> branchMap = BranchList.getInstance().getBranchMap();
    }

    public void identifyAndDispatchRequest(String input){
        System.out.println("Input ----> "+ input);
        String [] inputArgs = input.split(" ");
        if(inputArgs[0].equalsIgnoreCase("ADD_BRANCH")){

        }
        switch (inputArgs[0].toUpperCase()){
            case "ADD_BRANCH":
                addBranch(inputArgs);
                break;
            case "ADD_VEHICLE":
                addVehicle(inputArgs);
                break;
            case "DISPLAY_VEHICLES":
                displayVehicle(inputArgs);
                break;
            case "BOOK":
                book(inputArgs);
                break;
            default:
                System.out.println("Invalid querry");
                break;
        }
    }

    private void addBranch(String[] input){
        if(input.length!=3 || StringUtils.isEmpty(input[1]) || StringUtils.isEmpty(input[2])){
            System.out.println("Invalid Input");
            return;
        }

        String [] types = input[2].split(",");

        boolean result = assetManagement.addBranch(input[1],types);
        System.out.println("Output : "+result);
    }

    private void addVehicle(String [] input){
        if(input.length!=5 || StringUtils.isEmpty(input[4]) || StringUtils.isEmpty(input[1]) || StringUtils.isEmpty(input[2]) || StringUtils.isEmpty(input[3])){
            System.out.println("Invalid Input");
            return;
        }

        double price = -1.0;

        try{
            price = Double.valueOf(input[4]);
        } catch (Exception e){
            System.out.println("invalid price input");
            return;
        }

        boolean result = assetManagement.addVehicle(input[1],input[2],input[3], price);
        System.out.println("Output : "+result);
    }

    private void displayVehicle(String [] input){
        if(input.length!=4 || StringUtils.isEmpty(input[3]) || StringUtils.isEmpty(input[1]) || StringUtils.isEmpty(input[2])){
            System.out.println("Invalid Input");
            return;
        }

        int stHr = -1;
        int enHr = -1;

        try{
            stHr = Integer.parseInt(input[2]);
            enHr = Integer.parseInt(input[3]);
        } catch (Exception e){
            System.out.println("invalid time input");
            return;
        }

        if(stHr>enHr || stHr == 0){
            System.out.println("invalid time input");
            return;
        }

        List<Vehicle> vehicles = assetManagement.getAvailableVehicle( input[1], stHr, enHr);

        if(vehicles == null){
            System.out.println("No vehicle found for given branch and time slot");
            return;
        }
        System.out.print("Output : ");
        for(int i=0;i<vehicles.size();i++){
            System.out.print(vehicles.get(i).getVehicleId());
            if(i!=vehicles.size()-1)
                System.out.println(",");
        }
        System.out.println();
    }

    private void book(String [] input){
        if(input.length!=5 || StringUtils.isEmpty(input[3]) || StringUtils.isEmpty(input[1]) || StringUtils.isEmpty(input[2]) || StringUtils.isEmpty(input[4])){
            System.out.println("Invalid Input");
            return;
        }

        int stHr = -1;
        int enHr = -1;

        try{
            stHr = Integer.parseInt(input[3]);
            enHr = Integer.parseInt(input[4]);
        } catch (Exception e){
            System.out.println("invalid time input");
            return;
        }

        if(stHr>enHr || stHr == 0){
            System.out.println("invalid time input");
            return;
        }

        double price = assetManagement.bookVehicle(input[1], input[2], stHr, enHr);

        System.out.println("Output : "+price);
    }


}
