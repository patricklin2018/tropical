package com.zyt.tropical.dao;

import com.zyt.tropical.pojo.domain.EmpDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description: 员工数据仓库
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/3 13:34
 **/
@Repository
public interface EmpRepo extends JpaRepository<EmpDO, Integer> {

    /**
     * 根据工号获取员工信息
     * @param no 工号
     * @return 员工信息
     */
    EmpDO findByNo(String no);

}
