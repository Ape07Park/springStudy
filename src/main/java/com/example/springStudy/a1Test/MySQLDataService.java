package com.example.springStudy.a1Test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Qualifier("MySQL")
@Component
public class MySQLDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[] {1, 2, 3, 4, 5};
    }
}
