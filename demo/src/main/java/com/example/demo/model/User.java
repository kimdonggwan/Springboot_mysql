
package com.example.demo.model;

import lombok.Data;

@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor를 자동으로 생성
public class User {
    private int id;
    private String userId;
    private String name;
    private String position;
    private String nickname;
    private String password;
    private String phone;
    private String address;
    private String birthday;
    private String note1;
    private String note2;
    private String fir_inp_date;
    private String fir_inp_usr;
    private String las_inp_date;
    private String las_inp_usr;
    
    // created_at 필드는 데이터베이스에서 자동으로 처리되므로, 여기서는 간단히 생략하거나 필요시 추가

}