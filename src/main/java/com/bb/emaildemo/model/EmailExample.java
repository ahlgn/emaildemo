package com.bb.emaildemo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmailExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table email
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table email
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table email
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    public EmailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table email
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table email
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andEIdIsNull() {
            addCriterion("e_id is null");
            return (Criteria) this;
        }

        public Criteria andEIdIsNotNull() {
            addCriterion("e_id is not null");
            return (Criteria) this;
        }

        public Criteria andEIdEqualTo(Integer value) {
            addCriterion("e_id =", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotEqualTo(Integer value) {
            addCriterion("e_id <>", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThan(Integer value) {
            addCriterion("e_id >", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_id >=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThan(Integer value) {
            addCriterion("e_id <", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThanOrEqualTo(Integer value) {
            addCriterion("e_id <=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdIn(List<Integer> values) {
            addCriterion("e_id in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotIn(List<Integer> values) {
            addCriterion("e_id not in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdBetween(Integer value1, Integer value2) {
            addCriterion("e_id between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotBetween(Integer value1, Integer value2) {
            addCriterion("e_id not between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andEThemeIsNull() {
            addCriterion("e_theme is null");
            return (Criteria) this;
        }

        public Criteria andEThemeIsNotNull() {
            addCriterion("e_theme is not null");
            return (Criteria) this;
        }

        public Criteria andEThemeEqualTo(String value) {
            addCriterion("e_theme =", value, "eTheme");
            return (Criteria) this;
        }

        public Criteria andEThemeNotEqualTo(String value) {
            addCriterion("e_theme <>", value, "eTheme");
            return (Criteria) this;
        }

        public Criteria andEThemeGreaterThan(String value) {
            addCriterion("e_theme >", value, "eTheme");
            return (Criteria) this;
        }

        public Criteria andEThemeGreaterThanOrEqualTo(String value) {
            addCriterion("e_theme >=", value, "eTheme");
            return (Criteria) this;
        }

        public Criteria andEThemeLessThan(String value) {
            addCriterion("e_theme <", value, "eTheme");
            return (Criteria) this;
        }

        public Criteria andEThemeLessThanOrEqualTo(String value) {
            addCriterion("e_theme <=", value, "eTheme");
            return (Criteria) this;
        }

        public Criteria andEThemeLike(String value) {
            addCriterion("e_theme like", value, "eTheme");
            return (Criteria) this;
        }

        public Criteria andEThemeNotLike(String value) {
            addCriterion("e_theme not like", value, "eTheme");
            return (Criteria) this;
        }

        public Criteria andEThemeIn(List<String> values) {
            addCriterion("e_theme in", values, "eTheme");
            return (Criteria) this;
        }

        public Criteria andEThemeNotIn(List<String> values) {
            addCriterion("e_theme not in", values, "eTheme");
            return (Criteria) this;
        }

        public Criteria andEThemeBetween(String value1, String value2) {
            addCriterion("e_theme between", value1, value2, "eTheme");
            return (Criteria) this;
        }

        public Criteria andEThemeNotBetween(String value1, String value2) {
            addCriterion("e_theme not between", value1, value2, "eTheme");
            return (Criteria) this;
        }

        public Criteria andESendpeopleIsNull() {
            addCriterion("e_sendpeople is null");
            return (Criteria) this;
        }

        public Criteria andESendpeopleIsNotNull() {
            addCriterion("e_sendpeople is not null");
            return (Criteria) this;
        }

        public Criteria andESendpeopleEqualTo(Integer value) {
            addCriterion("e_sendpeople =", value, "eSendpeople");
            return (Criteria) this;
        }

        public Criteria andESendpeopleNotEqualTo(Integer value) {
            addCriterion("e_sendpeople <>", value, "eSendpeople");
            return (Criteria) this;
        }

        public Criteria andESendpeopleGreaterThan(Integer value) {
            addCriterion("e_sendpeople >", value, "eSendpeople");
            return (Criteria) this;
        }

        public Criteria andESendpeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_sendpeople >=", value, "eSendpeople");
            return (Criteria) this;
        }

        public Criteria andESendpeopleLessThan(Integer value) {
            addCriterion("e_sendpeople <", value, "eSendpeople");
            return (Criteria) this;
        }

        public Criteria andESendpeopleLessThanOrEqualTo(Integer value) {
            addCriterion("e_sendpeople <=", value, "eSendpeople");
            return (Criteria) this;
        }

        public Criteria andESendpeopleIn(List<Integer> values) {
            addCriterion("e_sendpeople in", values, "eSendpeople");
            return (Criteria) this;
        }

        public Criteria andESendpeopleNotIn(List<Integer> values) {
            addCriterion("e_sendpeople not in", values, "eSendpeople");
            return (Criteria) this;
        }

        public Criteria andESendpeopleBetween(Integer value1, Integer value2) {
            addCriterion("e_sendpeople between", value1, value2, "eSendpeople");
            return (Criteria) this;
        }

        public Criteria andESendpeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("e_sendpeople not between", value1, value2, "eSendpeople");
            return (Criteria) this;
        }

        public Criteria andEReceiveIsNull() {
            addCriterion("e_receive is null");
            return (Criteria) this;
        }

        public Criteria andEReceiveIsNotNull() {
            addCriterion("e_receive is not null");
            return (Criteria) this;
        }

        public Criteria andEReceiveEqualTo(Integer value) {
            addCriterion("e_receive =", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveNotEqualTo(Integer value) {
            addCriterion("e_receive <>", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveGreaterThan(Integer value) {
            addCriterion("e_receive >", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_receive >=", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveLessThan(Integer value) {
            addCriterion("e_receive <", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveLessThanOrEqualTo(Integer value) {
            addCriterion("e_receive <=", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveIn(List<Integer> values) {
            addCriterion("e_receive in", values, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveNotIn(List<Integer> values) {
            addCriterion("e_receive not in", values, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveBetween(Integer value1, Integer value2) {
            addCriterion("e_receive between", value1, value2, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveNotBetween(Integer value1, Integer value2) {
            addCriterion("e_receive not between", value1, value2, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEOrreadIsNull() {
            addCriterion("e_orread is null");
            return (Criteria) this;
        }

        public Criteria andEOrreadIsNotNull() {
            addCriterion("e_orread is not null");
            return (Criteria) this;
        }

        public Criteria andEOrreadEqualTo(String value) {
            addCriterion("e_orread =", value, "eOrread");
            return (Criteria) this;
        }

        public Criteria andEOrreadNotEqualTo(String value) {
            addCriterion("e_orread <>", value, "eOrread");
            return (Criteria) this;
        }

        public Criteria andEOrreadGreaterThan(String value) {
            addCriterion("e_orread >", value, "eOrread");
            return (Criteria) this;
        }

        public Criteria andEOrreadGreaterThanOrEqualTo(String value) {
            addCriterion("e_orread >=", value, "eOrread");
            return (Criteria) this;
        }

        public Criteria andEOrreadLessThan(String value) {
            addCriterion("e_orread <", value, "eOrread");
            return (Criteria) this;
        }

        public Criteria andEOrreadLessThanOrEqualTo(String value) {
            addCriterion("e_orread <=", value, "eOrread");
            return (Criteria) this;
        }

        public Criteria andEOrreadLike(String value) {
            addCriterion("e_orread like", value, "eOrread");
            return (Criteria) this;
        }

        public Criteria andEOrreadNotLike(String value) {
            addCriterion("e_orread not like", value, "eOrread");
            return (Criteria) this;
        }

        public Criteria andEOrreadIn(List<String> values) {
            addCriterion("e_orread in", values, "eOrread");
            return (Criteria) this;
        }

        public Criteria andEOrreadNotIn(List<String> values) {
            addCriterion("e_orread not in", values, "eOrread");
            return (Criteria) this;
        }

        public Criteria andEOrreadBetween(String value1, String value2) {
            addCriterion("e_orread between", value1, value2, "eOrread");
            return (Criteria) this;
        }

        public Criteria andEOrreadNotBetween(String value1, String value2) {
            addCriterion("e_orread not between", value1, value2, "eOrread");
            return (Criteria) this;
        }

        public Criteria andEOrsendIsNull() {
            addCriterion("e_orsend is null");
            return (Criteria) this;
        }

        public Criteria andEOrsendIsNotNull() {
            addCriterion("e_orsend is not null");
            return (Criteria) this;
        }

        public Criteria andEOrsendEqualTo(String value) {
            addCriterion("e_orsend =", value, "eOrsend");
            return (Criteria) this;
        }

        public Criteria andEOrsendNotEqualTo(String value) {
            addCriterion("e_orsend <>", value, "eOrsend");
            return (Criteria) this;
        }

        public Criteria andEOrsendGreaterThan(String value) {
            addCriterion("e_orsend >", value, "eOrsend");
            return (Criteria) this;
        }

        public Criteria andEOrsendGreaterThanOrEqualTo(String value) {
            addCriterion("e_orsend >=", value, "eOrsend");
            return (Criteria) this;
        }

        public Criteria andEOrsendLessThan(String value) {
            addCriterion("e_orsend <", value, "eOrsend");
            return (Criteria) this;
        }

        public Criteria andEOrsendLessThanOrEqualTo(String value) {
            addCriterion("e_orsend <=", value, "eOrsend");
            return (Criteria) this;
        }

        public Criteria andEOrsendLike(String value) {
            addCriterion("e_orsend like", value, "eOrsend");
            return (Criteria) this;
        }

        public Criteria andEOrsendNotLike(String value) {
            addCriterion("e_orsend not like", value, "eOrsend");
            return (Criteria) this;
        }

        public Criteria andEOrsendIn(List<String> values) {
            addCriterion("e_orsend in", values, "eOrsend");
            return (Criteria) this;
        }

        public Criteria andEOrsendNotIn(List<String> values) {
            addCriterion("e_orsend not in", values, "eOrsend");
            return (Criteria) this;
        }

        public Criteria andEOrsendBetween(String value1, String value2) {
            addCriterion("e_orsend between", value1, value2, "eOrsend");
            return (Criteria) this;
        }

        public Criteria andEOrsendNotBetween(String value1, String value2) {
            addCriterion("e_orsend not between", value1, value2, "eOrsend");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteIsNull() {
            addCriterion("e_ordelete is null");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteIsNotNull() {
            addCriterion("e_ordelete is not null");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteEqualTo(String value) {
            addCriterion("e_ordelete =", value, "eOrdelete");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteNotEqualTo(String value) {
            addCriterion("e_ordelete <>", value, "eOrdelete");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteGreaterThan(String value) {
            addCriterion("e_ordelete >", value, "eOrdelete");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteGreaterThanOrEqualTo(String value) {
            addCriterion("e_ordelete >=", value, "eOrdelete");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteLessThan(String value) {
            addCriterion("e_ordelete <", value, "eOrdelete");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteLessThanOrEqualTo(String value) {
            addCriterion("e_ordelete <=", value, "eOrdelete");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteLike(String value) {
            addCriterion("e_ordelete like", value, "eOrdelete");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteNotLike(String value) {
            addCriterion("e_ordelete not like", value, "eOrdelete");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteIn(List<String> values) {
            addCriterion("e_ordelete in", values, "eOrdelete");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteNotIn(List<String> values) {
            addCriterion("e_ordelete not in", values, "eOrdelete");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteBetween(String value1, String value2) {
            addCriterion("e_ordelete between", value1, value2, "eOrdelete");
            return (Criteria) this;
        }

        public Criteria andEOrdeleteNotBetween(String value1, String value2) {
            addCriterion("e_ordelete not between", value1, value2, "eOrdelete");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionIsNull() {
            addCriterion("e_orcollection is null");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionIsNotNull() {
            addCriterion("e_orcollection is not null");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionEqualTo(String value) {
            addCriterion("e_orcollection =", value, "eOrcollection");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionNotEqualTo(String value) {
            addCriterion("e_orcollection <>", value, "eOrcollection");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionGreaterThan(String value) {
            addCriterion("e_orcollection >", value, "eOrcollection");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionGreaterThanOrEqualTo(String value) {
            addCriterion("e_orcollection >=", value, "eOrcollection");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionLessThan(String value) {
            addCriterion("e_orcollection <", value, "eOrcollection");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionLessThanOrEqualTo(String value) {
            addCriterion("e_orcollection <=", value, "eOrcollection");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionLike(String value) {
            addCriterion("e_orcollection like", value, "eOrcollection");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionNotLike(String value) {
            addCriterion("e_orcollection not like", value, "eOrcollection");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionIn(List<String> values) {
            addCriterion("e_orcollection in", values, "eOrcollection");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionNotIn(List<String> values) {
            addCriterion("e_orcollection not in", values, "eOrcollection");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionBetween(String value1, String value2) {
            addCriterion("e_orcollection between", value1, value2, "eOrcollection");
            return (Criteria) this;
        }

        public Criteria andEOrcollectionNotBetween(String value1, String value2) {
            addCriterion("e_orcollection not between", value1, value2, "eOrcollection");
            return (Criteria) this;
        }

        public Criteria andESendtimeIsNull() {
            addCriterion("e_sendtime is null");
            return (Criteria) this;
        }

        public Criteria andESendtimeIsNotNull() {
            addCriterion("e_sendtime is not null");
            return (Criteria) this;
        }

        public Criteria andESendtimeEqualTo(Date value) {
            addCriterion("e_sendtime =", value, "eSendtime");
            return (Criteria) this;
        }

        public Criteria andESendtimeNotEqualTo(Date value) {
            addCriterion("e_sendtime <>", value, "eSendtime");
            return (Criteria) this;
        }

        public Criteria andESendtimeGreaterThan(Date value) {
            addCriterion("e_sendtime >", value, "eSendtime");
            return (Criteria) this;
        }

        public Criteria andESendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("e_sendtime >=", value, "eSendtime");
            return (Criteria) this;
        }

        public Criteria andESendtimeLessThan(Date value) {
            addCriterion("e_sendtime <", value, "eSendtime");
            return (Criteria) this;
        }

        public Criteria andESendtimeLessThanOrEqualTo(Date value) {
            addCriterion("e_sendtime <=", value, "eSendtime");
            return (Criteria) this;
        }

        public Criteria andESendtimeIn(List<Date> values) {
            addCriterion("e_sendtime in", values, "eSendtime");
            return (Criteria) this;
        }

        public Criteria andESendtimeNotIn(List<Date> values) {
            addCriterion("e_sendtime not in", values, "eSendtime");
            return (Criteria) this;
        }

        public Criteria andESendtimeBetween(Date value1, Date value2) {
            addCriterion("e_sendtime between", value1, value2, "eSendtime");
            return (Criteria) this;
        }

        public Criteria andESendtimeNotBetween(Date value1, Date value2) {
            addCriterion("e_sendtime not between", value1, value2, "eSendtime");
            return (Criteria) this;
        }

        public Criteria andEFileurlIsNull() {
            addCriterion("e_fileurl is null");
            return (Criteria) this;
        }

        public Criteria andEFileurlIsNotNull() {
            addCriterion("e_fileurl is not null");
            return (Criteria) this;
        }

        public Criteria andEFileurlEqualTo(String value) {
            addCriterion("e_fileurl =", value, "eFileurl");
            return (Criteria) this;
        }

        public Criteria andEFileurlNotEqualTo(String value) {
            addCriterion("e_fileurl <>", value, "eFileurl");
            return (Criteria) this;
        }

        public Criteria andEFileurlGreaterThan(String value) {
            addCriterion("e_fileurl >", value, "eFileurl");
            return (Criteria) this;
        }

        public Criteria andEFileurlGreaterThanOrEqualTo(String value) {
            addCriterion("e_fileurl >=", value, "eFileurl");
            return (Criteria) this;
        }

        public Criteria andEFileurlLessThan(String value) {
            addCriterion("e_fileurl <", value, "eFileurl");
            return (Criteria) this;
        }

        public Criteria andEFileurlLessThanOrEqualTo(String value) {
            addCriterion("e_fileurl <=", value, "eFileurl");
            return (Criteria) this;
        }

        public Criteria andEFileurlLike(String value) {
            addCriterion("e_fileurl like", value, "eFileurl");
            return (Criteria) this;
        }

        public Criteria andEFileurlNotLike(String value) {
            addCriterion("e_fileurl not like", value, "eFileurl");
            return (Criteria) this;
        }

        public Criteria andEFileurlIn(List<String> values) {
            addCriterion("e_fileurl in", values, "eFileurl");
            return (Criteria) this;
        }

        public Criteria andEFileurlNotIn(List<String> values) {
            addCriterion("e_fileurl not in", values, "eFileurl");
            return (Criteria) this;
        }

        public Criteria andEFileurlBetween(String value1, String value2) {
            addCriterion("e_fileurl between", value1, value2, "eFileurl");
            return (Criteria) this;
        }

        public Criteria andEFileurlNotBetween(String value1, String value2) {
            addCriterion("e_fileurl not between", value1, value2, "eFileurl");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table email
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table email
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}