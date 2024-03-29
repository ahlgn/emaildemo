package com.bb.emaildemo.dao;

import com.bb.emaildemo.model.Email;
import com.bb.emaildemo.model.EmailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    int countByExample(EmailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    int deleteByExample(EmailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer eId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    int insert(Email record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    int insertSelective(Email record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    List<Email> selectByExampleWithBLOBs(EmailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    List<Email> selectByExample(EmailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    Email selectByPrimaryKey(Integer eId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Email record, @Param("example") EmailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") Email record, @Param("example") EmailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Email record, @Param("example") EmailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Email record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Email record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Email record);
}