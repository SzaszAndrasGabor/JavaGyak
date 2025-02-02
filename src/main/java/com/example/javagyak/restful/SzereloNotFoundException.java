package com.example.javagyak.restful;

public class SzereloNotFoundException extends RuntimeException{
    SzereloNotFoundException(long id){
        super("Szerelo "+id+" nem található");
    }
}
