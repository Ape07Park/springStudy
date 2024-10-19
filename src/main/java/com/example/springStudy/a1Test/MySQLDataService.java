package com.example.springStudy.a1Test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Qualifier("MySQL")
//@Component
@Repository // DB와 통신해서 CRUD 작업을 수행하는 클래스임을 나타냄
public class MySQLDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[] {1, 2, 3, 4, 5};
    }
}
