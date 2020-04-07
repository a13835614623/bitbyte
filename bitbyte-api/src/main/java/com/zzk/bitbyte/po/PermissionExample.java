package com.zzk.bitbyte.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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

        public Criteria andPermIdIsNull() {
            addCriterion("perm_id is null");
            return (Criteria) this;
        }

        public Criteria andPermIdIsNotNull() {
            addCriterion("perm_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermIdEqualTo(String value) {
            addCriterion("perm_id =", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotEqualTo(String value) {
            addCriterion("perm_id <>", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThan(String value) {
            addCriterion("perm_id >", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThanOrEqualTo(String value) {
            addCriterion("perm_id >=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThan(String value) {
            addCriterion("perm_id <", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThanOrEqualTo(String value) {
            addCriterion("perm_id <=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLike(String value) {
            addCriterion("perm_id like", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotLike(String value) {
            addCriterion("perm_id not like", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdIn(List<String> values) {
            addCriterion("perm_id in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotIn(List<String> values) {
            addCriterion("perm_id not in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdBetween(String value1, String value2) {
            addCriterion("perm_id between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotBetween(String value1, String value2) {
            addCriterion("perm_id not between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andPermStrIsNull() {
            addCriterion("perm_str is null");
            return (Criteria) this;
        }

        public Criteria andPermStrIsNotNull() {
            addCriterion("perm_str is not null");
            return (Criteria) this;
        }

        public Criteria andPermStrEqualTo(String value) {
            addCriterion("perm_str =", value, "permStr");
            return (Criteria) this;
        }

        public Criteria andPermStrNotEqualTo(String value) {
            addCriterion("perm_str <>", value, "permStr");
            return (Criteria) this;
        }

        public Criteria andPermStrGreaterThan(String value) {
            addCriterion("perm_str >", value, "permStr");
            return (Criteria) this;
        }

        public Criteria andPermStrGreaterThanOrEqualTo(String value) {
            addCriterion("perm_str >=", value, "permStr");
            return (Criteria) this;
        }

        public Criteria andPermStrLessThan(String value) {
            addCriterion("perm_str <", value, "permStr");
            return (Criteria) this;
        }

        public Criteria andPermStrLessThanOrEqualTo(String value) {
            addCriterion("perm_str <=", value, "permStr");
            return (Criteria) this;
        }

        public Criteria andPermStrLike(String value) {
            addCriterion("perm_str like", value, "permStr");
            return (Criteria) this;
        }

        public Criteria andPermStrNotLike(String value) {
            addCriterion("perm_str not like", value, "permStr");
            return (Criteria) this;
        }

        public Criteria andPermStrIn(List<String> values) {
            addCriterion("perm_str in", values, "permStr");
            return (Criteria) this;
        }

        public Criteria andPermStrNotIn(List<String> values) {
            addCriterion("perm_str not in", values, "permStr");
            return (Criteria) this;
        }

        public Criteria andPermStrBetween(String value1, String value2) {
            addCriterion("perm_str between", value1, value2, "permStr");
            return (Criteria) this;
        }

        public Criteria andPermStrNotBetween(String value1, String value2) {
            addCriterion("perm_str not between", value1, value2, "permStr");
            return (Criteria) this;
        }

        public Criteria andPermDescIsNull() {
            addCriterion("perm_desc is null");
            return (Criteria) this;
        }

        public Criteria andPermDescIsNotNull() {
            addCriterion("perm_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPermDescEqualTo(String value) {
            addCriterion("perm_desc =", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescNotEqualTo(String value) {
            addCriterion("perm_desc <>", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescGreaterThan(String value) {
            addCriterion("perm_desc >", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescGreaterThanOrEqualTo(String value) {
            addCriterion("perm_desc >=", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescLessThan(String value) {
            addCriterion("perm_desc <", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescLessThanOrEqualTo(String value) {
            addCriterion("perm_desc <=", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescLike(String value) {
            addCriterion("perm_desc like", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescNotLike(String value) {
            addCriterion("perm_desc not like", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescIn(List<String> values) {
            addCriterion("perm_desc in", values, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescNotIn(List<String> values) {
            addCriterion("perm_desc not in", values, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescBetween(String value1, String value2) {
            addCriterion("perm_desc between", value1, value2, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescNotBetween(String value1, String value2) {
            addCriterion("perm_desc not between", value1, value2, "permDesc");
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