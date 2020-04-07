package com.zzk.bitbyte.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReadHistoryExample() {
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

        public Criteria andReadIdIsNull() {
            addCriterion("read_id is null");
            return (Criteria) this;
        }

        public Criteria andReadIdIsNotNull() {
            addCriterion("read_id is not null");
            return (Criteria) this;
        }

        public Criteria andReadIdEqualTo(String value) {
            addCriterion("read_id =", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdNotEqualTo(String value) {
            addCriterion("read_id <>", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdGreaterThan(String value) {
            addCriterion("read_id >", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdGreaterThanOrEqualTo(String value) {
            addCriterion("read_id >=", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdLessThan(String value) {
            addCriterion("read_id <", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdLessThanOrEqualTo(String value) {
            addCriterion("read_id <=", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdLike(String value) {
            addCriterion("read_id like", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdNotLike(String value) {
            addCriterion("read_id not like", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdIn(List<String> values) {
            addCriterion("read_id in", values, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdNotIn(List<String> values) {
            addCriterion("read_id not in", values, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdBetween(String value1, String value2) {
            addCriterion("read_id between", value1, value2, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdNotBetween(String value1, String value2) {
            addCriterion("read_id not between", value1, value2, "readId");
            return (Criteria) this;
        }

        public Criteria andReadArticleIsNull() {
            addCriterion("read_article is null");
            return (Criteria) this;
        }

        public Criteria andReadArticleIsNotNull() {
            addCriterion("read_article is not null");
            return (Criteria) this;
        }

        public Criteria andReadArticleEqualTo(String value) {
            addCriterion("read_article =", value, "readArticle");
            return (Criteria) this;
        }

        public Criteria andReadArticleNotEqualTo(String value) {
            addCriterion("read_article <>", value, "readArticle");
            return (Criteria) this;
        }

        public Criteria andReadArticleGreaterThan(String value) {
            addCriterion("read_article >", value, "readArticle");
            return (Criteria) this;
        }

        public Criteria andReadArticleGreaterThanOrEqualTo(String value) {
            addCriterion("read_article >=", value, "readArticle");
            return (Criteria) this;
        }

        public Criteria andReadArticleLessThan(String value) {
            addCriterion("read_article <", value, "readArticle");
            return (Criteria) this;
        }

        public Criteria andReadArticleLessThanOrEqualTo(String value) {
            addCriterion("read_article <=", value, "readArticle");
            return (Criteria) this;
        }

        public Criteria andReadArticleLike(String value) {
            addCriterion("read_article like", value, "readArticle");
            return (Criteria) this;
        }

        public Criteria andReadArticleNotLike(String value) {
            addCriterion("read_article not like", value, "readArticle");
            return (Criteria) this;
        }

        public Criteria andReadArticleIn(List<String> values) {
            addCriterion("read_article in", values, "readArticle");
            return (Criteria) this;
        }

        public Criteria andReadArticleNotIn(List<String> values) {
            addCriterion("read_article not in", values, "readArticle");
            return (Criteria) this;
        }

        public Criteria andReadArticleBetween(String value1, String value2) {
            addCriterion("read_article between", value1, value2, "readArticle");
            return (Criteria) this;
        }

        public Criteria andReadArticleNotBetween(String value1, String value2) {
            addCriterion("read_article not between", value1, value2, "readArticle");
            return (Criteria) this;
        }

        public Criteria andReadTimeIsNull() {
            addCriterion("read_time is null");
            return (Criteria) this;
        }

        public Criteria andReadTimeIsNotNull() {
            addCriterion("read_time is not null");
            return (Criteria) this;
        }

        public Criteria andReadTimeEqualTo(Date value) {
            addCriterion("read_time =", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotEqualTo(Date value) {
            addCriterion("read_time <>", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeGreaterThan(Date value) {
            addCriterion("read_time >", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("read_time >=", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeLessThan(Date value) {
            addCriterion("read_time <", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeLessThanOrEqualTo(Date value) {
            addCriterion("read_time <=", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeIn(List<Date> values) {
            addCriterion("read_time in", values, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotIn(List<Date> values) {
            addCriterion("read_time not in", values, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeBetween(Date value1, Date value2) {
            addCriterion("read_time between", value1, value2, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotBetween(Date value1, Date value2) {
            addCriterion("read_time not between", value1, value2, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadUserIsNull() {
            addCriterion("read_user is null");
            return (Criteria) this;
        }

        public Criteria andReadUserIsNotNull() {
            addCriterion("read_user is not null");
            return (Criteria) this;
        }

        public Criteria andReadUserEqualTo(String value) {
            addCriterion("read_user =", value, "readUser");
            return (Criteria) this;
        }

        public Criteria andReadUserNotEqualTo(String value) {
            addCriterion("read_user <>", value, "readUser");
            return (Criteria) this;
        }

        public Criteria andReadUserGreaterThan(String value) {
            addCriterion("read_user >", value, "readUser");
            return (Criteria) this;
        }

        public Criteria andReadUserGreaterThanOrEqualTo(String value) {
            addCriterion("read_user >=", value, "readUser");
            return (Criteria) this;
        }

        public Criteria andReadUserLessThan(String value) {
            addCriterion("read_user <", value, "readUser");
            return (Criteria) this;
        }

        public Criteria andReadUserLessThanOrEqualTo(String value) {
            addCriterion("read_user <=", value, "readUser");
            return (Criteria) this;
        }

        public Criteria andReadUserLike(String value) {
            addCriterion("read_user like", value, "readUser");
            return (Criteria) this;
        }

        public Criteria andReadUserNotLike(String value) {
            addCriterion("read_user not like", value, "readUser");
            return (Criteria) this;
        }

        public Criteria andReadUserIn(List<String> values) {
            addCriterion("read_user in", values, "readUser");
            return (Criteria) this;
        }

        public Criteria andReadUserNotIn(List<String> values) {
            addCriterion("read_user not in", values, "readUser");
            return (Criteria) this;
        }

        public Criteria andReadUserBetween(String value1, String value2) {
            addCriterion("read_user between", value1, value2, "readUser");
            return (Criteria) this;
        }

        public Criteria andReadUserNotBetween(String value1, String value2) {
            addCriterion("read_user not between", value1, value2, "readUser");
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