package com.credify.project.utils;

import com.credify.project.api_objects.states;
import java.util.ArrayList;
import java.util.List;

public class Helper {


    public Helper(){



    };

    public boolean stateValidator(states[] state){

        if (this.returnStatesList().containsAll(getStateListFromApiResponse(state))) return true;
        else return false;

    }



    public List<String> returnStatesList(){
        List<String> statesList = new ArrayList<String>();        
        statesList.add("Alabama");
        statesList.add("Alaska");
        statesList.add("Arizona");
        statesList.add("Arkansas");
        statesList.add("California");
        statesList.add("Colorado");
        statesList.add("Connecticut");
        statesList.add("Delaware");
        statesList.add("Florida");
        statesList.add("Georgia");
        statesList.add("Hawaii");
        statesList.add("Idaho");
        statesList.add("Illinois");
        statesList.add("Indiana");
        statesList.add("Iowa");
        statesList.add("Kansas");
        statesList.add("Kentucky");
        statesList.add("Louisiana");
        statesList.add("Maine");
        statesList.add("Maryland");
        statesList.add("Massachusetts");
        statesList.add("Michigan");
        statesList.add("Minnesota");
        statesList.add("Mississippi");
        statesList.add("Missouri");
        statesList.add("Montana");
        statesList.add("Nebraska");
        statesList.add("Nevada");
        statesList.add("New Hampshire");
        statesList.add("New Jersey");
        statesList.add("New Mexico");
        statesList.add("New York");
        statesList.add("North Carolina");
        statesList.add("North Dakota");
        statesList.add("Ohio");
        statesList.add("Oklahoma");
        statesList.add("Oregon");
        statesList.add("Pennsylvania");
        statesList.add("Rhode Island");
        statesList.add("South Carolina");
        statesList.add("South Dakota");
        statesList.add("Tennessee");
        statesList.add("Texas");
        statesList.add("Utah");
        statesList.add("Vermont");
        statesList.add("Virginia");
        statesList.add("Washington");
        statesList.add("West Virginia");
        statesList.add("Wisconsin");
        statesList.add("Wyoming");
        statesList.add("District of Columbia");
        return statesList;
    }

    private List<String> getStateListFromApiResponse(states[] state){
        List<String> statesFromApi = new ArrayList<String>();
        for (int i =0; i<state.length;i++){
            statesFromApi.add(state[i].getLabel());
        }
        return statesFromApi;
    }

    public List<String> returnStatesByMinAge(states[] stateFromApi, int minAge){
        List<String> statesWithMatchingAge = new ArrayList<String>();
        for (int i=0;i < stateFromApi.length; i++){
            if(stateFromApi[i].getMinAge() == minAge) statesWithMatchingAge.add(stateFromApi[i].getLabel());
        }
        return statesWithMatchingAge;
    }

    public List<String> returnStatesByMinLoanAmount(states[] stateFromApi, double minLoanAmount){
        List<String> statesWithMatchingMinLoanAmount = new ArrayList<String>();
        for (int i=0;i < stateFromApi.length; i++){
            if(stateFromApi[i].getMinLoanAmount() == minLoanAmount) statesWithMatchingMinLoanAmount.add(stateFromApi[i].getLabel());
        }
        return statesWithMatchingMinLoanAmount;
    }
}
