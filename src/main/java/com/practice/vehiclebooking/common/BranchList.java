package com.practice.vehiclebooking.common;

import com.practice.vehiclebooking.entity.Branch;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BranchList {

    private Map<String, Branch> branchMap;

    private static BranchList branchList = null;

    private BranchList(){
        branchMap = new HashMap<>();
    }

    public static BranchList getInstance(){
        if(branchList == null){
            branchList = new BranchList();
        }
        return branchList;
    }
}
