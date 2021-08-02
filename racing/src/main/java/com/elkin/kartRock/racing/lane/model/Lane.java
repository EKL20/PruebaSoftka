package com.elkin.kartRock.racing.lane.model;

import com.elkin.kartRock.racing.commons.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@SQLDelete(sql = "UPDATE lanes SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@EqualsAndHashCode(callSuper = true)
@Table(name = "lanes")

public class Lane extends BaseEntity {

    private static final long serialVersionUID = 4231074131488762910L;

    @NotBlank
    @Length(min = 2, max = 15)
    @Column(name = "name", length = 15, nullable = false)
    private String name;

    @NotNull
    @Column(name = "distance", nullable = false)
    private int distance;
}
