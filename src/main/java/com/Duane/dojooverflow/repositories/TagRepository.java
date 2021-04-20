package com.Duane.dojooverflow.repositories;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Duane.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	public Optional <Tag> findBySubject (String subject);
}
