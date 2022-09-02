package com.atguigu.crowd.mapper;

import com.atguigu.crowd.entity.po.ProjectItemPicPO;
import com.atguigu.crowd.entity.po.ProjectItemPicPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectItemPicPOMapper {
    int countByExample(ProjectItemPicPOExample example);

    int deleteByExample(ProjectItemPicPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectItemPicPO record);

    int insertSelective(ProjectItemPicPO record);

    List<ProjectItemPicPO> selectByExample(ProjectItemPicPOExample example);

    ProjectItemPicPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectItemPicPO record, @Param("example") ProjectItemPicPOExample example);

    int updateByExample(@Param("record") ProjectItemPicPO record, @Param("example") ProjectItemPicPOExample example);

    int updateByPrimaryKeySelective(ProjectItemPicPO record);

    int updateByPrimaryKey(ProjectItemPicPO record);

    /**
     * 保存 项目表项目详情图片表 数据
     *
     * @param detailPicturePathList
     * @param projectId
     */
    void insertPathList(
            @Param("detailPicturePathList") List<String> detailPicturePathList,
            @Param("projectId") Integer projectId
    );
}