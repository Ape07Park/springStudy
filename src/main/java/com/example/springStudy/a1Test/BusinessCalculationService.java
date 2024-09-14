package com.example.springStudy.a1Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {
    @Autowired
    @Qualifier("MySQL") // 이걸로 @Primary가 있는 몽고db가 아닌 MySQL을 부를 수 있음
    private DataService dataService;

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
