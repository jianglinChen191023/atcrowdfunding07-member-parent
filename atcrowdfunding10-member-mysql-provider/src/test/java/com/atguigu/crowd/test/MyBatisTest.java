package com.atguigu.crowd.test;

import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.entity.vo.DetailProjectVO;
import com.atguigu.crowd.entity.vo.PortalProjectVO;
import com.atguigu.crowd.entity.vo.PortalTypeVO;
import com.atguigu.crowd.mapper.MemberPOMapper;
import com.atguigu.crowd.mapper.ProjectPOMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 陈江林
 * @date 2022/8/19 05:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {

    @Autowired
    private DataSource dataSource;

    private Logger logger = LoggerFactory.getLogger(MyBatisTest.class);

    @Autowired
    private MemberPOMapper memberPOMapper;

    @Autowired
    private ProjectPOMapper projectPOMapper;

    /**
     * 测试 首页 > 项目详情页面 数据
     */
    @Test
    public void testSelectDetailProjectVO() {
        DetailProjectVO detailProjectVO = projectPOMapper.selectDetailProjectVO(20);
        logger.info(detailProjectVO.getProjectId() + "");
        logger.info(detailProjectVO.getProjectName() + "");
        logger.info(detailProjectVO.getProjectDesc() + "");
        logger.info(detailProjectVO.getFollowerCount() + "");
        logger.info(detailProjectVO.getStatus() + "");
        logger.info(detailProjectVO.getMoney() + "");
        logger.info(detailProjectVO.getSupportMoney() + "");
        logger.info(detailProjectVO.getPercentage() + "");
        logger.info(detailProjectVO.getDeployDate() + "");
        logger.info(detailProjectVO.getLastDay() + "");
        logger.info(detailProjectVO.getSupporterCount() + "");
        logger.info(detailProjectVO.getHeaderPicturePath() + "");

        detailProjectVO.getDetailPicturePathList().forEach(detailPicturePath -> logger.info("详情图片路径: " + detailPicturePath));
        detailProjectVO.getDetailReturnVOList().forEach(detailReturnVO -> {
            logger.info("" + detailReturnVO.getReturnId());
            logger.info("" + detailReturnVO.getSupportMoney());
            logger.info("" + detailReturnVO.getSignalPurchase());
            logger.info("" + detailReturnVO.getPurchase());
            logger.info("" + detailReturnVO.getSupporterCount());
            logger.info("" + detailReturnVO.getFreight());
            logger.info("" + detailReturnVO.getReturnDate());
            logger.info("" + detailReturnVO.getContent());
        });
    }

    /**
     * 测试首页数据
     */
    @Test
    public void testPortData() {
        List<PortalTypeVO> typeVOList = projectPOMapper.selectPortalTypeVOList();
        typeVOList.forEach(portalTypeVO -> {
            String name = portalTypeVO.getName();
            String remark = portalTypeVO.getRemark();
            logger.info("name = " + name + " remark = " + remark);

            List<PortalProjectVO> portalProjectVOList = portalTypeVO.getPortalProjectVO();
            portalProjectVOList.forEach(portalProjectVO -> {
                logger.info(portalProjectVO.toString());
            });
        });
    }

    @Test
    public void test() throws SQLException {
        Connection connection = dataSource.getConnection();
        logger.debug("connection: " + connection.toString());
    }

    @Test
    public void testMember() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String source = "123123";
        String encode = bCryptPasswordEncoder.encode(source);
        MemberPO memberPO = new MemberPO(null, "jack", encode, "杰克", "jack@qq.com", 1, 1, "杰克", "430626220104045821", 2);
        memberPOMapper.insert(memberPO);
    }

}
