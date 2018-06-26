package com.zenpanda.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Topic {

    @Id
    private String id;
    private String name;
    private String description;
}
