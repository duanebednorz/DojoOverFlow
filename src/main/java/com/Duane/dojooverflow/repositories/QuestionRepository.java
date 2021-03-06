package com.Duane.dojooverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Duane.dojooverflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{

}
