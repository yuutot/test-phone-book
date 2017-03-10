package com.work.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by yuuto on 3/10/17.
 */

@Entity
@Table(name = Phone.TABLE_NAME)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    public static final String TABLE_NAME = "phones";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull private Long id;

    @NonNull private String name;
    @NonNull private String surname;
    @NonNull private String patronymic;
    @NonNull private String mobilePhone;
    private String homePhone;
    private String address;
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
