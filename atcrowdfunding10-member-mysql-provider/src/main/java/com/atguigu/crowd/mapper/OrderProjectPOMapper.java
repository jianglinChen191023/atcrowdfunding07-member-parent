package com.atguigu.crowd.mapper;

import com.atguigu.crowd.entity.po.OrderProjectPO;
import com.atguigu.crowd.entity.po.OrderProjectPOExample;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderProjectPOMapper {
    int countByExample(OrderProjectPOExample example);

    int deleteByExample(OrderProjectPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderProjectPO record);

    int insertSelective(OrderProjectPO record);

    List<OrderProjectPO> selectByExample(OrderProjectPOExample example);

    OrderProjectPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderProjectPO record, @Param("example") OrderProjectPOExample example);

    int updateByExample(@Param("record") OrderProjectPO record, @Param("example") OrderProjectPOExample example);

    int updateByPrimaryKeySelective(OrderProjectPO record);

    int updateByPrimaryKey(OrderProjectPO record);

    /**
     * 查询订单项目视图对象
     *
     * @param returnId 回报id
     * @return {@link OrderProjectVO}
     */
    OrderProjectVO selectOrderProjectVO(Integer returnId);
}