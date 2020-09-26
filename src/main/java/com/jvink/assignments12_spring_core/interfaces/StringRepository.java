package com.jvink.assignments12_spring_core.interfaces;

import com.jvink.assignments12_spring_core.models.StringDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StringRepository extends CrudRepository<StringDTO, String> {
}
