package com.github.yulechen.newcode.hw;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class PersonCacheManager {

  // 初始化容量
  private Map<String,Person> personIdCache = new ConcurrentHashMap<String,Person>();
  private Map<String,Person> personNameCache = new ConcurrentHashMap<String,Person>();

  private static PersonCacheManager instance = new PersonCacheManager();

  private PersonCacheManager(){

  }
  public static  PersonCacheManager getInstance(){
    return instance;
  }


  class Person{
    String id;
    String name;
    int age;
    boolean female;
  }

  public Optional<Person> getPersonById(String personId){
    if (personIdCache.containsKey(personId)) {
       return Optional.of(personIdCache.get(personId));
    }
    return Optional.empty();
  }

  public Optional<Person> getPersonByName(String personName){
    if (personIdCache.containsKey(personName)) {
      return Optional.of(personIdCache.get(personName));
    }
    return Optional.empty();
  }

  public void refreshPersons(List<Person> persons){
    // 缓存大小限制
    if(null == persons ){
       return ;
    }
    persons.forEach( p->{
      personIdCache.put(p.id,p);
      personNameCache.put(p.name,p);
    });
  }





}
