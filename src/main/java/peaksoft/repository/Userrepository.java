package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.entity.User;

public interface Userrepository extends JpaRepository<User,Long> {
    User getUserByEmail(String email);// JOK METODTORGO SPRINGDIN 'CH'NEN PODSKASKA ARKYLUU METOD TYZOBYZ

    @Query("select u from User u where u.email=:email") // HQL  =?1 BUL PARAMETRLERI KOP BOLGON UCHURDA JAZYLAT
//    @Query(value ="select * from users u where u.email=?1", nativeQuery=true)--> // BUL SQL
    User findUserWithEmail(String email,  String name);  // dayar emes metodtor ushunday Queriler menen jazylat;
}
