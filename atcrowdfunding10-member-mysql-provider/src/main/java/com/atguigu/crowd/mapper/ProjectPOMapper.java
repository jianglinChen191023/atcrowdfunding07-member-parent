package com.atguigu.crowd.mapper;

import com.atguigu.crowd.entity.po.ProjectPO;
import com.atguigu.crowd.entity.po.ProjectPOExample;
import com.atguigu.crowd.entity.vo.DetailProjectVO;
import com.atguigu.crowd.entity.vo.DetailReturnVO;
import com.atguigu.crowd.entity.vo.PortalTypeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectPOMapper {
    int countByExample(ProjectPOExample example);

    int deleteByExample(ProjectPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPO record);

    int insertSelective(ProjectPO record);

    List<ProjectPO> selectByExample(ProjectPOExample example);

    ProjectPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByExample(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByPrimaryKeySelective(ProjectPO record);

    int updateByPrimaryKey(ProjectPO record);

    /**
     * 保存 项目分类中间表 数据
     *
     * @param typeIdList
     * @param projectId
     */
    void insertTypeRelationship(
            @Param("typeIdList") List<Integer> typeIdList,
            @Param("projectId") Integer projectId
    );

    /**
     * 保存 项目标签中间表 数据
     *
     * @param tagIdList
     * @param projectId
     */
    void insertTagRelationship(
            @Param("tagIdList") List<Integer> tagIdList,
            @Param("projectId") Integer projectId
    );

    /**
     * 查询首页数据
     *
     * @return
     */
    List<PortalTypeVO> selectPortalTypeVOList();

    /**
     * 查询首页 > 项目详情页面数据
     *
     * @param projectId
     * @return
     */
    DetailProjectVO selectDetailProjectVO(Integer projectId);

    /**
     * 首页 > 项目详情中 > 详情图片
     *
     * @param projectId
     * @return
     */
    List<String> selectDetailPicturePathList(Integer projectId);

    /**
     * 首页 > 项目详情中 > 回报数据
     *
     * @param projectId
     * @return
     */
    List<DetailReturnVO> selectDetailReturnVOList(Integer projectId);

}