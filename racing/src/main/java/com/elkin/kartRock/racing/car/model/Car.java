package com.elkin.kartRock.racing.car.model;

import com.elkin.kartRock.racing.commons.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Data
@NoArgsConstructor
@SQLDelete(sql = "UPDATE cars SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@EqualsAndHashCode(callSuper = true)
@Table(name = "cars", indexes = {
        @Index(name = "idx_car", columnList = "code", unique = true)
})
public class Car extends BaseEntity {

    private static final long serialVersionUID = -7559358162306780250L;

    @NotBlank
    @Length(min = 2, max = 15)
    @Column(name = "name", length = 15, nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "lanes", length = 15, nullable = false)
    private Lanes lanes;


}
