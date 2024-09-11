package com.example.springStudy.a1Test;

import java.util.Arrays;

public class BusinessCalculationService {

    public int findMax(){
        return Arrays.stream(dataService.retieveData()).max().orElse(0);
    }
}
