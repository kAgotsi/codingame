package com.atos.airfrance.codingame.services;

import com.atos.airfrance.codingame.entities.DatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * <pre>
 * Title: SequenceGeneratorService class
 * Description: Enables id auto increment generation.
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@Service
public class SequenceGeneratorService {
    @Autowired
    private MongoOperations mongoOperations;

    /**
     * Increment  sequence counter
     * @param seqName existing sequence name
     * @return new counter of sequence
     */
    public long generateSequence(String seqName) {
        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq", 1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}