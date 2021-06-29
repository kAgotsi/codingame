package com.atos.airfrance.codingame.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <pre>
 * Title: DatabaseSequence class
 * Description: POJO to handle id auto increment generation  for user.
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@Data
@Builder
@Document(collection = "database_sequences")
public class DatabaseSequence {
    @Id
    private String id;
    private long seq;
}