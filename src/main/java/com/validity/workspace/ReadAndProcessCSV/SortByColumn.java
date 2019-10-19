package com.validity.workspace.ReadAndProcessCSV;

import java.util.Comparator;

import com.validity.workspace.pojo.Person;

public class SortByColumn implements Comparator<Person> {
    public int compare(Person a, Person b){
        return a.getFirst_name().compareTo(b.getFirst_name());
    }
}