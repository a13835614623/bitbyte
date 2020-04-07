package com.zzk.bitbyte.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubscribeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubscribeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andSubUserChildIsNull() {
            addCriterion("sub_user_child is null");
            return (Criteria) this;
        }

        public Criteria andSubUserChildIsNotNull() {
            addCriterion("sub_user_child is not null");
            return (Criteria) this;
        }

        public Criteria andSubUserChildEqualTo(String value) {
            addCriterion("sub_user_child =", value, "subUserChild");
            return (Criteria) this;
        }

        public Criteria andSubUserChildNotEqualTo(String value) {
            addCriterion("sub_user_child <>", value, "subUserChild");
            return (Criteria) this;
        }

        public Criteria andSubUserChildGreaterThan(String value) {
            addCriterion("sub_user_child >", value, "subUserChild");
            return (Criteria) this;
        }

        public Criteria andSubUserChildGreaterThanOrEqualTo(String value) {
            addCriterion("sub_user_child >=", value, "subUserChild");
            return (Criteria) this;
        }

        public Criteria andSubUserChildLessThan(String value) {
            addCriterion("sub_user_child <", value, "subUserChild");
            return (Criteria) this;
        }

        public Criteria andSubUserChildLessThanOrEqualTo(String value) {
            addCriterion("sub_user_child <=", value, "subUserChild");
            return (Criteria) this;
        }

        public Criteria andSubUserChildLike(String value) {
            addCriterion("sub_user_child like", value, "subUserChild");
            return (Criteria) this;
        }

        public Criteria andSubUserChildNotLike(String value) {
            addCriterion("sub_user_child not like", value, "subUserChild");
            return (Criteria) this;
        }

        public Criteria andSubUserChildIn(List<String> values) {
            addCriterion("sub_user_child in", values, "subUserChild");
            return (Criteria) this;
        }

        public Criteria andSubUserChildNotIn(List<String> values) {
            addCriterion("sub_user_child not in", values, "subUserChild");
            return (Criteria) this;
        }

        public Criteria andSubUserChildBetween(String value1, String value2) {
            addCriterion("sub_user_child between", value1, value2, "subUserChild");
            return (Criteria) this;
        }

        public Criteria andSubUserChildNotBetween(String value1, String value2) {
            addCriterion("sub_user_child not between", value1, value2, "subUserChild");
            return (Criteria) this;
        }

        public Criteria andSubUserParentIsNull() {
            addCriterion("sub_user_parent is null");
            return (Criteria) this;
        }

        public Criteria andSubUserParentIsNotNull() {
            addCriterion("sub_user_parent is not null");
            return (Criteria) this;
        }

        public Criteria andSubUserParentEqualTo(String value) {
            addCriterion("sub_user_parent =", value, "subUserParent");
            return (Criteria) this;
        }

        public Criteria andSubUserParentNotEqualTo(String value) {
            addCriterion("sub_user_parent <>", value, "subUserParent");
            return (Criteria) this;
        }

        public Criteria andSubUserParentGreaterThan(String value) {
            addCriterion("sub_user_parent >", value, "subUserParent");
            return (Criteria) this;
        }

        public Criteria andSubUserParentGreaterThanOrEqualTo(String value) {
            addCriterion("sub_user_parent >=", value, "subUserParent");
            return (Criteria) this;
        }

        public Criteria andSubUserParentLessThan(String value) {
            addCriterion("sub_user_parent <", value, "subUserParent");
            return (Criteria) this;
        }

        public Criteria andSubUserParentLessThanOrEqualTo(String value) {
            addCriterion("sub_user_parent <=", value, "subUserParent");
            return (Criteria) this;
        }

        public Criteria andSubUserParentLike(String value) {
            addCriterion("sub_user_parent like", value, "subUserParent");
            return (Criteria) this;
        }

        public Criteria andSubUserParentNotLike(String value) {
            addCriterion("sub_user_parent not like", value, "subUserParent");
            return (Criteria) this;
        }

        public Criteria andSubUserParentIn(List<String> values) {
            addCriterion("sub_user_parent in", values, "subUserParent");
            return (Criteria) this;
        }

        public Criteria andSubUserParentNotIn(List<String> values) {
            addCriterion("sub_user_parent not in", values, "subUserParent");
            return (Criteria) this;
        }

        public Criteria andSubUserParentBetween(String value1, String value2) {
            addCriterion("sub_user_parent between", value1, value2, "subUserParent");
            return (Criteria) this;
        }

        public Criteria andSubUserParentNotBetween(String value1, String value2) {
            addCriterion("sub_user_parent not between", value1, value2, "subUserParent");
            return (Criteria) this;
        }

        public Criteria andSubTimeIsNull() {
            addCriterion("sub_time is null");
            return (Criteria) this;
        }

        public Criteria andSubTimeIsNotNull() {
            addCriterion("sub_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubTimeEqualTo(Date value) {
            addCriterion("sub_time =", value, "subTime");
            return (Criteria) this;
        }

        public Criteria andSubTimeNotEqualTo(Date value) {
            addCriterion("sub_time <>", value, "subTime");
            return (Criteria) this;
        }

        public Criteria andSubTimeGreaterThan(Date value) {
            addCriterion("sub_time >", value, "subTime");
            return (Criteria) this;
        }

        public Criteria andSubTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sub_time >=", value, "subTime");
            return (Criteria) this;
        }

        public Criteria andSubTimeLessThan(Date value) {
            addCriterion("sub_time <", value, "subTime");
            return (Criteria) this;
        }

        public Criteria andSubTimeLessThanOrEqualTo(Date value) {
            addCriterion("sub_time <=", value, "subTime");
            return (Criteria) this;
        }

        public Criteria andSubTimeIn(List<Date> values) {
            addCriterion("sub_time in", values, "subTime");
            return (Criteria) this;
        }

        public Criteria andSubTimeNotIn(List<Date> values) {
            addCriterion("sub_time not in", values, "subTime");
            return (Criteria) this;
        }

        public Criteria andSubTimeBetween(Date value1, Date value2) {
            addCriterion("sub_time between", value1, value2, "subTime");
            return (Criteria) this;
        }

        public Criteria andSubTimeNotBetween(Date value1, Date value2) {
            addCriterion("sub_time not between", value1, value2, "subTime");
            return (Criteria) this;
        }

        public Criteria andCreateatIsNull() {
            addCriterion("createAt is null");
            return (Criteria) this;
        }

        public Criteria andCreateatIsNotNull() {
            addCriterion("createAt is not null");
            return (Criteria) this;
        }

        public Criteria andCreateatEqualTo(Date value) {
            addCriterion("createAt =", value, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatNotEqualTo(Date value) {
            addCriterion("createAt <>", value, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatGreaterThan(Date value) {
            addCriterion("createAt >", value, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatGreaterThanOrEqualTo(Date value) {
            addCriterion("createAt >=", value, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatLessThan(Date value) {
            addCriterion("createAt <", value, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatLessThanOrEqualTo(Date value) {
            addCriterion("createAt <=", value, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatIn(List<Date> values) {
            addCriterion("createAt in", values, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatNotIn(List<Date> values) {
            addCriterion("createAt not in", values, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatBetween(Date value1, Date value2) {
            addCriterion("createAt between", value1, value2, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatNotBetween(Date value1, Date value2) {
            addCriterion("createAt not between", value1, value2, "createat");
            return (Criteria) this;
        }

        public Criteria andUpdateatIsNull() {
            addCriterion("updateAt is null");
            return (Criteria) this;
        }

        public Criteria andUpdateatIsNotNull() {
            addCriterion("updateAt is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateatEqualTo(Date value) {
            addCriterion("updateAt =", value, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatNotEqualTo(Date value) {
            addCriterion("updateAt <>", value, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatGreaterThan(Date value) {
            addCriterion("updateAt >", value, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatGreaterThanOrEqualTo(Date value) {
            addCriterion("updateAt >=", value, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatLessThan(Date value) {
            addCriterion("updateAt <", value, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatLessThanOrEqualTo(Date value) {
            addCriterion("updateAt <=", value, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatIn(List<Date> values) {
            addCriterion("updateAt in", values, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatNotIn(List<Date> values) {
            addCriterion("updateAt not in", values, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatBetween(Date value1, Date value2) {
            addCriterion("updateAt between", value1, value2, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatNotBetween(Date value1, Date value2) {
            addCriterion("updateAt not between", value1, value2, "updateat");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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