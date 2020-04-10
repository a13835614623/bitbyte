package com.zzk.bitbyte.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FavoriteGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FavoriteGroupExample() {
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

        public Criteria andFavoriteGroupIdIsNull() {
            addCriterion("favorite_group_id is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIdIsNotNull() {
            addCriterion("favorite_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIdEqualTo(String value) {
            addCriterion("favorite_group_id =", value, "favoriteGroupId");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIdNotEqualTo(String value) {
            addCriterion("favorite_group_id <>", value, "favoriteGroupId");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIdGreaterThan(String value) {
            addCriterion("favorite_group_id >", value, "favoriteGroupId");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("favorite_group_id >=", value, "favoriteGroupId");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIdLessThan(String value) {
            addCriterion("favorite_group_id <", value, "favoriteGroupId");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIdLessThanOrEqualTo(String value) {
            addCriterion("favorite_group_id <=", value, "favoriteGroupId");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIdLike(String value) {
            addCriterion("favorite_group_id like", value, "favoriteGroupId");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIdNotLike(String value) {
            addCriterion("favorite_group_id not like", value, "favoriteGroupId");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIdIn(List<String> values) {
            addCriterion("favorite_group_id in", values, "favoriteGroupId");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIdNotIn(List<String> values) {
            addCriterion("favorite_group_id not in", values, "favoriteGroupId");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIdBetween(String value1, String value2) {
            addCriterion("favorite_group_id between", value1, value2, "favoriteGroupId");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIdNotBetween(String value1, String value2) {
            addCriterion("favorite_group_id not between", value1, value2, "favoriteGroupId");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserIsNull() {
            addCriterion("favorite_user is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserIsNotNull() {
            addCriterion("favorite_user is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserEqualTo(String value) {
            addCriterion("favorite_user =", value, "favoriteUser");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserNotEqualTo(String value) {
            addCriterion("favorite_user <>", value, "favoriteUser");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserGreaterThan(String value) {
            addCriterion("favorite_user >", value, "favoriteUser");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserGreaterThanOrEqualTo(String value) {
            addCriterion("favorite_user >=", value, "favoriteUser");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserLessThan(String value) {
            addCriterion("favorite_user <", value, "favoriteUser");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserLessThanOrEqualTo(String value) {
            addCriterion("favorite_user <=", value, "favoriteUser");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserLike(String value) {
            addCriterion("favorite_user like", value, "favoriteUser");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserNotLike(String value) {
            addCriterion("favorite_user not like", value, "favoriteUser");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserIn(List<String> values) {
            addCriterion("favorite_user in", values, "favoriteUser");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserNotIn(List<String> values) {
            addCriterion("favorite_user not in", values, "favoriteUser");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserBetween(String value1, String value2) {
            addCriterion("favorite_user between", value1, value2, "favoriteUser");
            return (Criteria) this;
        }

        public Criteria andFavoriteUserNotBetween(String value1, String value2) {
            addCriterion("favorite_user not between", value1, value2, "favoriteUser");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameIsNull() {
            addCriterion("favorite_group_name is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameIsNotNull() {
            addCriterion("favorite_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameEqualTo(String value) {
            addCriterion("favorite_group_name =", value, "favoriteGroupName");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameNotEqualTo(String value) {
            addCriterion("favorite_group_name <>", value, "favoriteGroupName");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameGreaterThan(String value) {
            addCriterion("favorite_group_name >", value, "favoriteGroupName");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("favorite_group_name >=", value, "favoriteGroupName");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameLessThan(String value) {
            addCriterion("favorite_group_name <", value, "favoriteGroupName");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameLessThanOrEqualTo(String value) {
            addCriterion("favorite_group_name <=", value, "favoriteGroupName");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameLike(String value) {
            addCriterion("favorite_group_name like", value, "favoriteGroupName");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameNotLike(String value) {
            addCriterion("favorite_group_name not like", value, "favoriteGroupName");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameIn(List<String> values) {
            addCriterion("favorite_group_name in", values, "favoriteGroupName");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameNotIn(List<String> values) {
            addCriterion("favorite_group_name not in", values, "favoriteGroupName");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameBetween(String value1, String value2) {
            addCriterion("favorite_group_name between", value1, value2, "favoriteGroupName");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNameNotBetween(String value1, String value2) {
            addCriterion("favorite_group_name not between", value1, value2, "favoriteGroupName");
            return (Criteria) this;
        }

        public Criteria andFavoriteCreateTimeIsNull() {
            addCriterion("favorite_create_time is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteCreateTimeIsNotNull() {
            addCriterion("favorite_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteCreateTimeEqualTo(Date value) {
            addCriterion("favorite_create_time =", value, "favoriteCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteCreateTimeNotEqualTo(Date value) {
            addCriterion("favorite_create_time <>", value, "favoriteCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteCreateTimeGreaterThan(Date value) {
            addCriterion("favorite_create_time >", value, "favoriteCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("favorite_create_time >=", value, "favoriteCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteCreateTimeLessThan(Date value) {
            addCriterion("favorite_create_time <", value, "favoriteCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("favorite_create_time <=", value, "favoriteCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteCreateTimeIn(List<Date> values) {
            addCriterion("favorite_create_time in", values, "favoriteCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteCreateTimeNotIn(List<Date> values) {
            addCriterion("favorite_create_time not in", values, "favoriteCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteCreateTimeBetween(Date value1, Date value2) {
            addCriterion("favorite_create_time between", value1, value2, "favoriteCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("favorite_create_time not between", value1, value2, "favoriteCreateTime");
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