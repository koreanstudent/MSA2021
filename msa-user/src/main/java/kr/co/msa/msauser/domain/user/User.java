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

    @Column(name="user_login_id")
    private String loginId;

    @Column(name="user_password")
    private String password;

    @Column(name="user_name")
    private String name;

    @Column(name="user_email")
    private String email;



}
