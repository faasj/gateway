package com.faasj.gateway.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "functions")
@TypeDef(name = "json", typeClass = JsonType.class)
public class FunctionEntity {

    @Id
    private UUID functionId;
    private String functionName;
    private String code;
    private String description;
    private String image;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private UUID projectId;

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    private Map<String, String> tags;

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    private Map<String, String> environmentVariables;

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    private Map<String, String> limits;

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    private Map<String, String> requests;
}
