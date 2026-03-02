package java.com.derek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.com.derek.entity.Singers;

public interface SingersRepository extends JpaRepository<Singers, Integer> {

}
