package com.elkin.kartRock.racing.player.model;

import com.elkin.kartRock.racing.car.model.Car;
import com.elkin.kartRock.racing.commons.model.BaseEntity;
import com.elkin.kartRock.racing.player.model.Enum.TypePlayer;
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
@SQLDelete(sql = "UPDATE players SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@EqualsAndHashCode(callSuper = true)
@Table(name = "players")
public class Player extends BaseEntity {

    private static final long serialVersionUID = 6236999102773405979L;

    @NotBlank
    @Length(min = 2, max = 15)
    @Column(name = "name", length = 15, nullable = false)
    private String name;

    @NotNull
    @Column(name = "car", nullable = false)
    private Car car;

    @NotNull
    @Column(name = "typePlayer", nullable = false)
    private TypePlayer typePlayer;
}
