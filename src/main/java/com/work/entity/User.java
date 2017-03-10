package com.work.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by yuuto on 3/10/17.
 */
@Entity
@Table(name = User.TABLE_NAME)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public static final String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull private Long id;

    @NonNull private String login;
    @NonNull private String pass;

    @NonNull private String name;
    @NonNull private String surname;
    @NonNull private String patronymic;


}
