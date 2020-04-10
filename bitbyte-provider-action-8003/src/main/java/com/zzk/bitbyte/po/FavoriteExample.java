package com.zzk.bitbyte.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FavoriteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FavoriteExample() {
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

        public Criteria andFavoriteIdIsNull() {
            addCriterion("favorite_id is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdIsNotNull() {
            addCriterion("favorite_id is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdEqualTo(String value) {
            addCriterion("favorite_id =", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdNotEqualTo(String value) {
            addCriterion("favorite_id <>", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdGreaterThan(String value) {
            addCriterion("favorite_id >", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdGreaterThanOrEqualTo(String value) {
            addCriterion("favorite_id >=", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdLessThan(String value) {
            addCriterion("favorite_id <", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdLessThanOrEqualTo(String value) {
            addCriterion("favorite_id <=", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdLike(String value) {
            addCriterion("favorite_id like", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdNotLike(String value) {
            addCriterion("favorite_id not like", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdIn(List<String> values) {
            addCriterion("favorite_id in", values, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdNotIn(List<String> values) {
            addCriterion("favorite_id not in", values, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdBetween(String value1, String value2) {
            addCriterion("favorite_id between", value1, value2, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdNotBetween(String value1, String value2) {
            addCriterion("favorite_id not between", value1, value2, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleIsNull() {
            addCriterion("favorite_article is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleIsNotNull() {
            addCriterion("favorite_article is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleEqualTo(String value) {
            addCriterion("favorite_article =", value, "favoriteArticle");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleNotEqualTo(String value) {
            addCriterion("favorite_article <>", value, "favoriteArticle");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleGreaterThan(String value) {
            addCriterion("favorite_article >", value, "favoriteArticle");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleGreaterThanOrEqualTo(String value) {
            addCriterion("favorite_article >=", value, "favoriteArticle");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleLessThan(String value) {
            addCriterion("favorite_article <", value, "favoriteArticle");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleLessThanOrEqualTo(String value) {
            addCriterion("favorite_article <=", value, "favoriteArticle");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleLike(String value) {
            addCriterion("favorite_article like", value, "favoriteArticle");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleNotLike(String value) {
            addCriterion("favorite_article not like", value, "favoriteArticle");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleIn(List<String> values) {
            addCriterion("favorite_article in", values, "favoriteArticle");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleNotIn(List<String> values) {
            addCriterion("favorite_article not in", values, "favoriteArticle");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleBetween(String value1, String value2) {
            addCriterion("favorite_article between", value1, value2, "favoriteArticle");
            return (Criteria) this;
        }

        public Criteria andFavoriteArticleNotBetween(String value1, String value2) {
            addCriterion("favorite_article not between", value1, value2, "favoriteArticle");
            return (Criteria) this;
        }

        public Criteria andFavoriteTimeIsNull() {
            addCriterion("favorite_time is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteTimeIsNotNull() {
            addCriterion("favorite_time is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteTimeEqualTo(Date value) {
            addCriterion("favorite_time =", value, "favoriteTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteTimeNotEqualTo(Date value) {
            addCriterion("favorite_time <>", value, "favoriteTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteTimeGreaterThan(Date value) {
            addCriterion("favorite_time >", value, "favoriteTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("favorite_time >=", value, "favoriteTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteTimeLessThan(Date value) {
            addCriterion("favorite_time <", value, "favoriteTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteTimeLessThanOrEqualTo(Date value) {
            addCriterion("favorite_time <=", value, "favoriteTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteTimeIn(List<Date> values) {
            addCriterion("favorite_time in", values, "favoriteTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteTimeNotIn(List<Date> values) {
            addCriterion("favorite_time not in", values, "favoriteTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteTimeBetween(Date value1, Date value2) {
            addCriterion("favorite_time between", value1, value2, "favoriteTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteTimeNotBetween(Date value1, Date value2) {
            addCriterion("favorite_time not between", value1, value2, "favoriteTime");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIsNull() {
            addCriterion("favorite_group is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIsNotNull() {
            addCriterion("favorite_group is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupEqualTo(String value) {
            addCriterion("favorite_group =", value, "favoriteGroup");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNotEqualTo(String value) {
            addCriterion("favorite_group <>", value, "favoriteGroup");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupGreaterThan(String value) {
            addCriterion("favorite_group >", value, "favoriteGroup");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupGreaterThanOrEqualTo(String value) {
            addCriterion("favorite_group >=", value, "favoriteGroup");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupLessThan(String value) {
            addCriterion("favorite_group <", value, "favoriteGroup");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupLessThanOrEqualTo(String value) {
            addCriterion("favorite_group <=", value, "favoriteGroup");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupLike(String value) {
            addCriterion("favorite_group like", value, "favoriteGroup");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNotLike(String value) {
            addCriterion("favorite_group not like", value, "favoriteGroup");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupIn(List<String> values) {
            addCriterion("favorite_group in", values, "favoriteGroup");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNotIn(List<String> values) {
            addCriterion("favorite_group not in", values, "favoriteGroup");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupBetween(String value1, String value2) {
            addCriterion("favorite_group between", value1, value2, "favoriteGroup");
            return (Criteria) this;
        }

        public Criteria andFavoriteGroupNotBetween(String value1, String value2) {
            addCriterion("favorite_group not between", value1, value2, "favoriteGroup");
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