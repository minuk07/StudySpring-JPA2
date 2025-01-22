package com.example.memorydb.user.db;

import com.example.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //query method
    // select * from user where score >=[??]
    public List<UserEntity> findAllByScoreGreaterThanEqual(int score);
    //By 뒤로는 Where 절에 해당

    //select * from user where score >= ?? AND score <= ??
    public List<UserEntity>  findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);
    //JPA 키워드들 모두 제거하면 첫 번째 Score에 min 매칭, 두 번째 Score에 max 매칭

    //Native Query (ORM사용)
    //직접 query문을 사용
    @Query(
            value = "select * from user as u where u.score >= :min AND u.score <= :max", //직접 쿼리문 작성
            nativeQuery = true
            //u -> Entity
    )
    List<UserEntity> score(
            @Param(value = "min") int min, //named Parameter로 매칭
            @Param(value = "max") int max
    );
}
