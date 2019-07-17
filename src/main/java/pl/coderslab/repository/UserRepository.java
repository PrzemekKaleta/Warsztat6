package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByEmail(String email);

    @Query("select u.password from User u where u.email = :email")
    String findPasswordByEmail(@Param("email") String email);
    //dobrze jest zwracać tylko te informacje które są nam poterzebne a nie zwracać całych obiektów

    User findUserByEmail(String email);


}
