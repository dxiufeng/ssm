package com.itheima.dao;

import com.itheima.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {


    /**
     * @Author dxf
     * @Description  通过id查询member对象
     *
    */
    @Select("select * from member where id=#{id}")
    public Member findById(String id);
}
