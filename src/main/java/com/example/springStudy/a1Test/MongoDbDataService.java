package com.example.springStudy.a1Test;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository // DB와 통신해서 CRUD 작업을 수행하는 클래스임을 나타냄
@Primary
public class MongoDbDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[] {11, 22, 33, 44, 55};
    }


}
