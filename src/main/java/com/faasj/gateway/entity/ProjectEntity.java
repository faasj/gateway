package com.faasj.gateway.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "projects")
@TypeDef(name = "json", typeClass = JsonType.class)
public class ProjectEntity {

    @Id
    private UUID projectId;
    private String projectName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private UUID ownerId;

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    private Map<String, String> tags;
}
