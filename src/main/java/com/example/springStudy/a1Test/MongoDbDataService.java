package com.example.springStudy.a1Test;

public class MongoDbDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[] {11, 22, 33, 44, 55};
    }
}
