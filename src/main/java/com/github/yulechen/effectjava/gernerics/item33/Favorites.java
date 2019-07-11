package com.github.yulechen.effectjava.gernerics.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {

  private Map<Class<?>, Object> favorites = new HashMap<>();

  //
  public <T> void putFavorite(Class<T> type, T instance) {
    favorites.put(Objects.requireNonNull(type), instance);
  }

  public <T> T getFavorite(Class<T> type) {
      type.cast(favorites.get(type));
    return (T)favorites.get(type);
  }

  public static void main(String[] args) {
    Favorites f =new Favorites();
    f.putFavorite(Integer.class,1);
    Integer favorite = f.getFavorite(Integer.class);
  }
}