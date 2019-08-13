package com.zyt.tropical.pojo.dto;

import com.zyt.tropical.pojo.domain.EmpDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * @Description: 授权信息DTO对象
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/26 15:41
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthInfoDTO {

    private Integer id;

    private String no;

    private String username;

    public AuthInfoDTO(EmpDO empDO) {
        this.id = empDO.getId();
        this.no = empDO.getNo();
        this.username = empDO.getName();
    }

    public boolean validate() {
        if (id == null || StringUtils.isEmpty(no) || StringUtils.isEmpty(username)) {
            return false;
        }
        return true;
    }
}
