package dao;

import entity.User;

import java.util.Optional;

public interface Dao <K, T>{

    Optional<T> findByEmailAndPass(String email, String password);

    boolean checkedEmail(String email);

    T save (T entity);

    User updateCountWinGame(Integer userId);

    User updateCountLoseGame(Integer userId);

}
