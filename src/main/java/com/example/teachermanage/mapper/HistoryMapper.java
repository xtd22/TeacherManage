package com.example.teachermanage.mapper;

import com.example.teachermanage.entity.History;

/**
* @author 24024
* @description 针对表【history】的数据库操作Mapper
* @createDate 2023-11-03 14:18:19
* @Entity com.example.teachermanage.entity.History
*/
public interface HistoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);

}
