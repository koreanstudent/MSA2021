package kr.co.msa.msauser.domain.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="user_id")
    private Long id;

    @Column(name="user_name")
    private String name;

}
