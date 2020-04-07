package com.zzk.bitbyte.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleLikeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleLikeExample() {
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

        public Criteria andLikeArticleIsNull() {
            addCriterion("like_article is null");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIsNotNull() {
            addCriterion("like_article is not null");
            return (Criteria) this;
        }

        public Criteria andLikeArticleEqualTo(String value) {
            addCriterion("like_article =", value, "likeArticle");
            return (Criteria) this;
        }

        public Criteria andLikeArticleNotEqualTo(String value) {
            addCriterion("like_article <>", value, "likeArticle");
            return (Criteria) this;
        }

        public Criteria andLikeArticleGreaterThan(String value) {
            addCriterion("like_article >", value, "likeArticle");
            return (Criteria) this;
        }

        public Criteria andLikeArticleGreaterThanOrEqualTo(String value) {
            addCriterion("like_article >=", value, "likeArticle");
            return (Criteria) this;
        }

        public Criteria andLikeArticleLessThan(String value) {
            addCriterion("like_article <", value, "likeArticle");
            return (Criteria) this;
        }

        public Criteria andLikeArticleLessThanOrEqualTo(String value) {
            addCriterion("like_article <=", value, "likeArticle");
            return (Criteria) this;
        }

        public Criteria andLikeArticleLike(String value) {
            addCriterion("like_article like", value, "likeArticle");
            return (Criteria) this;
        }

        public Criteria andLikeArticleNotLike(String value) {
            addCriterion("like_article not like", value, "likeArticle");
            return (Criteria) this;
        }

        public Criteria andLikeArticleIn(List<String> values) {
            addCriterion("like_article in", values, "likeArticle");
            return (Criteria) this;
        }

        public Criteria andLikeArticleNotIn(List<String> values) {
            addCriterion("like_article not in", values, "likeArticle");
            return (Criteria) this;
        }

        public Criteria andLikeArticleBetween(String value1, String value2) {
            addCriterion("like_article between", value1, value2, "likeArticle");
            return (Criteria) this;
        }

        public Criteria andLikeArticleNotBetween(String value1, String value2) {
            addCriterion("like_article not between", value1, value2, "likeArticle");
            return (Criteria) this;
        }

        public Criteria andLikeUserIsNull() {
            addCriterion("like_user is null");
            return (Criteria) this;
        }

        public Criteria andLikeUserIsNotNull() {
            addCriterion("like_user is not null");
            return (Criteria) this;
        }

        public Criteria andLikeUserEqualTo(String value) {
            addCriterion("like_user =", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserNotEqualTo(String value) {
            addCriterion("like_user <>", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserGreaterThan(String value) {
            addCriterion("like_user >", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserGreaterThanOrEqualTo(String value) {
            addCriterion("like_user >=", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserLessThan(String value) {
            addCriterion("like_user <", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserLessThanOrEqualTo(String value) {
            addCriterion("like_user <=", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserLike(String value) {
            addCriterion("like_user like", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserNotLike(String value) {
            addCriterion("like_user not like", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserIn(List<String> values) {
            addCriterion("like_user in", values, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserNotIn(List<String> values) {
            addCriterion("like_user not in", values, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserBetween(String value1, String value2) {
            addCriterion("like_user between", value1, value2, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserNotBetween(String value1, String value2) {
            addCriterion("like_user not between", value1, value2, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNull() {
            addCriterion("like_time is null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNotNull() {
            addCriterion("like_time is not null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeEqualTo(Date value) {
            addCriterion("like_time =", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotEqualTo(Date value) {
            addCriterion("like_time <>", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThan(Date value) {
            addCriterion("like_time >", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("like_time >=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThan(Date value) {
            addCriterion("like_time <", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThanOrEqualTo(Date value) {
            addCriterion("like_time <=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIn(List<Date> values) {
            addCriterion("like_time in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotIn(List<Date> values) {
            addCriterion("like_time not in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeBetween(Date value1, Date value2) {
            addCriterion("like_time between", value1, value2, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotBetween(Date value1, Date value2) {
            addCriterion("like_time not between", value1, value2, "likeTime");
            return (Criteria) this;
        }

        public Criteria andCreateatIsNull() {
            addCriterion("createat is null");
            return (Criteria) this;
        }

        public Criteria andCreateatIsNotNull() {
            addCriterion("createat is not null");
            return (Criteria) this;
        }

        public Criteria andCreateatEqualTo(Date value) {
            addCriterion("createat =", value, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatNotEqualTo(Date value) {
            addCriterion("createat <>", value, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatGreaterThan(Date value) {
            addCriterion("createat >", value, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatGreaterThanOrEqualTo(Date value) {
            addCriterion("createat >=", value, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatLessThan(Date value) {
            addCriterion("createat <", value, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatLessThanOrEqualTo(Date value) {
            addCriterion("createat <=", value, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatIn(List<Date> values) {
            addCriterion("createat in", values, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatNotIn(List<Date> values) {
            addCriterion("createat not in", values, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatBetween(Date value1, Date value2) {
            addCriterion("createat between", value1, value2, "createat");
            return (Criteria) this;
        }

        public Criteria andCreateatNotBetween(Date value1, Date value2) {
            addCriterion("createat not between", value1, value2, "createat");
            return (Criteria) this;
        }

        public Criteria andUpdateatIsNull() {
            addCriterion("updateat is null");
            return (Criteria) this;
        }

        public Criteria andUpdateatIsNotNull() {
            addCriterion("updateat is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateatEqualTo(Date value) {
            addCriterion("updateat =", value, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatNotEqualTo(Date value) {
            addCriterion("updateat <>", value, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatGreaterThan(Date value) {
            addCriterion("updateat >", value, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatGreaterThanOrEqualTo(Date value) {
            addCriterion("updateat >=", value, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatLessThan(Date value) {
            addCriterion("updateat <", value, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatLessThanOrEqualTo(Date value) {
            addCriterion("updateat <=", value, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatIn(List<Date> values) {
            addCriterion("updateat in", values, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatNotIn(List<Date> values) {
            addCriterion("updateat not in", values, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatBetween(Date value1, Date value2) {
            addCriterion("updateat between", value1, value2, "updateat");
            return (Criteria) this;
        }

        public Criteria andUpdateatNotBetween(Date value1, Date value2) {
            addCriterion("updateat not between", value1, value2, "updateat");
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