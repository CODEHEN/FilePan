package com.chenlh.mapper;

import com.chenlh.pojo.ClhUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: CHENLH
 * @Description:
 * @Date: Create in 18:23 2020/5/25
 */
@Repository
public interface ClhUserDao {

    List<ClhUser> findAll();
}
