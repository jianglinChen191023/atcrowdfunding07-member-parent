package com.atguigu.crowd.factory;

import com.atguigu.crowd.api.MySQLRemoteService;
import com.atguigu.crowd.entity.po.AddressPO;
import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.entity.vo.*;
import com.atguigu.crowd.util.ResultEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/9/9 11:06
 */
@Component
public class MySQLFallBackFactory implements FallbackFactory<MySQLRemoteService> {

    @Override
    public MySQLRemoteService create(Throwable cause) {
        return new MySQLRemoteService() {
            @Override
            public ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(String loginacct) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<String> saveMember(MemberPO memberPO) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<String> saveProjectVORemote(ProjectVO projectVO, Integer memberId) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote() {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<DetailProjectVO> getDetailProjectVORemote(Integer projectId) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<OrderProjectVO> getOrderProjectVORemote(Integer returnId) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<List<AddressVO>> getAddressVOListRemote(Integer memberId) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<AddressPO> saveAddressPORemote(AddressPO addressPO) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<String> saveOrderRemote(OrderVO orderVO) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }
        };
    }

}
