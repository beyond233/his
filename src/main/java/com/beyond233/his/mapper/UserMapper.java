package com.beyond233.his.mapper;

import com.beyond233.his.entity.User;
import com.beyond233.his.entity.UserExample;

import java.util.List;

import com.beyond233.his.vo.UserOrderRecord;
import com.beyond233.his.vo.UserRegisterRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author BEYOND
 */
@Mapper
public interface UserMapper {
    User pickOneUserById(Integer userId);
    String selectDemo(@Param("id") Integer userId, @Param("sex") String userSex);

    /**
     * 查询患者全部挂号记录
     *
     * @param usrId 用户id
     * @return java.util.List<com.beyond233.his.vo.UserRegisterRecord>
     * @since 2020/3/22 9:45
     */
    List<UserRegisterRecord> selectAllUserRegisterRecords(Integer usrId);

    /**
     * 查询患者全部就诊记录
     *
     * @param userId 用户id
     * @return java.util.List<com.beyond233.his.vo.UserOrderRecord>
     * @since 2020/3/22 9:46
     */
    List<UserOrderRecord> selectAllUserOrderRecords(Integer userId);

    /**
     * 通过手机号查询用户
     *
     * @param phone 手机号
     * @return com.beyond233.his.entity.User
     * @since 2020/3/22 10:58
     */
    User selectUserByUserPhone(String phone);

    void updateUserPassword(Integer userId, String password);

    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}