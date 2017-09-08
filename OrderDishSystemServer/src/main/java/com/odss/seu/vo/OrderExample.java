package com.odss.seu.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
     */
    public OrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
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
     * This method corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTableIsNull() {
            addCriterion("`Table` is null");
            return (Criteria) this;
        }

        public Criteria andTableIsNotNull() {
            addCriterion("`Table` is not null");
            return (Criteria) this;
        }

        public Criteria andTableEqualTo(Integer value) {
            addCriterion("`Table` =", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableNotEqualTo(Integer value) {
            addCriterion("`Table` <>", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableGreaterThan(Integer value) {
            addCriterion("`Table` >", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableGreaterThanOrEqualTo(Integer value) {
            addCriterion("`Table` >=", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableLessThan(Integer value) {
            addCriterion("`Table` <", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableLessThanOrEqualTo(Integer value) {
            addCriterion("`Table` <=", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableIn(List<Integer> values) {
            addCriterion("`Table` in", values, "table");
            return (Criteria) this;
        }

        public Criteria andTableNotIn(List<Integer> values) {
            addCriterion("`Table` not in", values, "table");
            return (Criteria) this;
        }

        public Criteria andTableBetween(Integer value1, Integer value2) {
            addCriterion("`Table` between", value1, value2, "table");
            return (Criteria) this;
        }

        public Criteria andTableNotBetween(Integer value1, Integer value2) {
            addCriterion("`Table` not between", value1, value2, "table");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("`Time` is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("`Time` is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("`Time` =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("`Time` <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("`Time` >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`Time` >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("`Time` <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("`Time` <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("`Time` in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("`Time` not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("`Time` between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("`Time` not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`State` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`State` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("`State` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("`State` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("`State` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("`State` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("`State` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("`State` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("`State` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("`State` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("`State` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("`State` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDishqualityIsNull() {
            addCriterion("DishQuality is null");
            return (Criteria) this;
        }

        public Criteria andDishqualityIsNotNull() {
            addCriterion("DishQuality is not null");
            return (Criteria) this;
        }

        public Criteria andDishqualityEqualTo(Integer value) {
            addCriterion("DishQuality =", value, "dishquality");
            return (Criteria) this;
        }

        public Criteria andDishqualityNotEqualTo(Integer value) {
            addCriterion("DishQuality <>", value, "dishquality");
            return (Criteria) this;
        }

        public Criteria andDishqualityGreaterThan(Integer value) {
            addCriterion("DishQuality >", value, "dishquality");
            return (Criteria) this;
        }

        public Criteria andDishqualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("DishQuality >=", value, "dishquality");
            return (Criteria) this;
        }

        public Criteria andDishqualityLessThan(Integer value) {
            addCriterion("DishQuality <", value, "dishquality");
            return (Criteria) this;
        }

        public Criteria andDishqualityLessThanOrEqualTo(Integer value) {
            addCriterion("DishQuality <=", value, "dishquality");
            return (Criteria) this;
        }

        public Criteria andDishqualityIn(List<Integer> values) {
            addCriterion("DishQuality in", values, "dishquality");
            return (Criteria) this;
        }

        public Criteria andDishqualityNotIn(List<Integer> values) {
            addCriterion("DishQuality not in", values, "dishquality");
            return (Criteria) this;
        }

        public Criteria andDishqualityBetween(Integer value1, Integer value2) {
            addCriterion("DishQuality between", value1, value2, "dishquality");
            return (Criteria) this;
        }

        public Criteria andDishqualityNotBetween(Integer value1, Integer value2) {
            addCriterion("DishQuality not between", value1, value2, "dishquality");
            return (Criteria) this;
        }

        public Criteria andCookspeedIsNull() {
            addCriterion("CookSpeed is null");
            return (Criteria) this;
        }

        public Criteria andCookspeedIsNotNull() {
            addCriterion("CookSpeed is not null");
            return (Criteria) this;
        }

        public Criteria andCookspeedEqualTo(Integer value) {
            addCriterion("CookSpeed =", value, "cookspeed");
            return (Criteria) this;
        }

        public Criteria andCookspeedNotEqualTo(Integer value) {
            addCriterion("CookSpeed <>", value, "cookspeed");
            return (Criteria) this;
        }

        public Criteria andCookspeedGreaterThan(Integer value) {
            addCriterion("CookSpeed >", value, "cookspeed");
            return (Criteria) this;
        }

        public Criteria andCookspeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("CookSpeed >=", value, "cookspeed");
            return (Criteria) this;
        }

        public Criteria andCookspeedLessThan(Integer value) {
            addCriterion("CookSpeed <", value, "cookspeed");
            return (Criteria) this;
        }

        public Criteria andCookspeedLessThanOrEqualTo(Integer value) {
            addCriterion("CookSpeed <=", value, "cookspeed");
            return (Criteria) this;
        }

        public Criteria andCookspeedIn(List<Integer> values) {
            addCriterion("CookSpeed in", values, "cookspeed");
            return (Criteria) this;
        }

        public Criteria andCookspeedNotIn(List<Integer> values) {
            addCriterion("CookSpeed not in", values, "cookspeed");
            return (Criteria) this;
        }

        public Criteria andCookspeedBetween(Integer value1, Integer value2) {
            addCriterion("CookSpeed between", value1, value2, "cookspeed");
            return (Criteria) this;
        }

        public Criteria andCookspeedNotBetween(Integer value1, Integer value2) {
            addCriterion("CookSpeed not between", value1, value2, "cookspeed");
            return (Criteria) this;
        }

        public Criteria andServeattitudeIsNull() {
            addCriterion("ServeAttitude is null");
            return (Criteria) this;
        }

        public Criteria andServeattitudeIsNotNull() {
            addCriterion("ServeAttitude is not null");
            return (Criteria) this;
        }

        public Criteria andServeattitudeEqualTo(Integer value) {
            addCriterion("ServeAttitude =", value, "serveattitude");
            return (Criteria) this;
        }

        public Criteria andServeattitudeNotEqualTo(Integer value) {
            addCriterion("ServeAttitude <>", value, "serveattitude");
            return (Criteria) this;
        }

        public Criteria andServeattitudeGreaterThan(Integer value) {
            addCriterion("ServeAttitude >", value, "serveattitude");
            return (Criteria) this;
        }

        public Criteria andServeattitudeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ServeAttitude >=", value, "serveattitude");
            return (Criteria) this;
        }

        public Criteria andServeattitudeLessThan(Integer value) {
            addCriterion("ServeAttitude <", value, "serveattitude");
            return (Criteria) this;
        }

        public Criteria andServeattitudeLessThanOrEqualTo(Integer value) {
            addCriterion("ServeAttitude <=", value, "serveattitude");
            return (Criteria) this;
        }

        public Criteria andServeattitudeIn(List<Integer> values) {
            addCriterion("ServeAttitude in", values, "serveattitude");
            return (Criteria) this;
        }

        public Criteria andServeattitudeNotIn(List<Integer> values) {
            addCriterion("ServeAttitude not in", values, "serveattitude");
            return (Criteria) this;
        }

        public Criteria andServeattitudeBetween(Integer value1, Integer value2) {
            addCriterion("ServeAttitude between", value1, value2, "serveattitude");
            return (Criteria) this;
        }

        public Criteria andServeattitudeNotBetween(Integer value1, Integer value2) {
            addCriterion("ServeAttitude not between", value1, value2, "serveattitude");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ods_order
     *
     * @mbg.generated do_not_delete_during_merge Fri Sep 08 14:07:18 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ods_order
     *
     * @mbg.generated Fri Sep 08 14:07:18 CST 2017
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