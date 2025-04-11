package com.example.QuizApp.Respository;

import com.example.QuizApp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

    List<Question> findBycategory(String cat);

   /* @Query(value = "SELECT * FROM question q where q.category = : category order by random() limit : noOfq", nativeQuery = true)
   @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :noOfq", nativeQuery = true)
   List<Question> findRandomQuestionByCategory(String category, int noOfq);
*/
   @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :noOfq", nativeQuery = true)
   List<Question> findRandomQuestionByCategory(@Param("category") String category, @Param("noOfq") int noOfq);

}

