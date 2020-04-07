package com.zzk.bitbyte.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCommentFloorIsNull() {
            addCriterion("comment_floor is null");
            return (Criteria) this;
        }

        public Criteria andCommentFloorIsNotNull() {
            addCriterion("comment_floor is not null");
            return (Criteria) this;
        }

        public Criteria andCommentFloorEqualTo(Long value) {
            addCriterion("comment_floor =", value, "commentFloor");
            return (Criteria) this;
        }

        public Criteria andCommentFloorNotEqualTo(Long value) {
            addCriterion("comment_floor <>", value, "commentFloor");
            return (Criteria) this;
        }

        public Criteria andCommentFloorGreaterThan(Long value) {
            addCriterion("comment_floor >", value, "commentFloor");
            return (Criteria) this;
        }

        public Criteria andCommentFloorGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_floor >=", value, "commentFloor");
            return (Criteria) this;
        }

        public Criteria andCommentFloorLessThan(Long value) {
            addCriterion("comment_floor <", value, "commentFloor");
            return (Criteria) this;
        }

        public Criteria andCommentFloorLessThanOrEqualTo(Long value) {
            addCriterion("comment_floor <=", value, "commentFloor");
            return (Criteria) this;
        }

        public Criteria andCommentFloorIn(List<Long> values) {
            addCriterion("comment_floor in", values, "commentFloor");
            return (Criteria) this;
        }

        public Criteria andCommentFloorNotIn(List<Long> values) {
            addCriterion("comment_floor not in", values, "commentFloor");
            return (Criteria) this;
        }

        public Criteria andCommentFloorBetween(Long value1, Long value2) {
            addCriterion("comment_floor between", value1, value2, "commentFloor");
            return (Criteria) this;
        }

        public Criteria andCommentFloorNotBetween(Long value1, Long value2) {
            addCriterion("comment_floor not between", value1, value2, "commentFloor");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIsNull() {
            addCriterion("comment_article is null");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIsNotNull() {
            addCriterion("comment_article is not null");
            return (Criteria) this;
        }

        public Criteria andCommentArticleEqualTo(String value) {
            addCriterion("comment_article =", value, "commentArticle");
            return (Criteria) this;
        }

        public Criteria andCommentArticleNotEqualTo(String value) {
            addCriterion("comment_article <>", value, "commentArticle");
            return (Criteria) this;
        }

        public Criteria andCommentArticleGreaterThan(String value) {
            addCriterion("comment_article >", value, "commentArticle");
            return (Criteria) this;
        }

        public Criteria andCommentArticleGreaterThanOrEqualTo(String value) {
            addCriterion("comment_article >=", value, "commentArticle");
            return (Criteria) this;
        }

        public Criteria andCommentArticleLessThan(String value) {
            addCriterion("comment_article <", value, "commentArticle");
            return (Criteria) this;
        }

        public Criteria andCommentArticleLessThanOrEqualTo(String value) {
            addCriterion("comment_article <=", value, "commentArticle");
            return (Criteria) this;
        }

        public Criteria andCommentArticleLike(String value) {
            addCriterion("comment_article like", value, "commentArticle");
            return (Criteria) this;
        }

        public Criteria andCommentArticleNotLike(String value) {
            addCriterion("comment_article not like", value, "commentArticle");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIn(List<String> values) {
            addCriterion("comment_article in", values, "commentArticle");
            return (Criteria) this;
        }

        public Criteria andCommentArticleNotIn(List<String> values) {
            addCriterion("comment_article not in", values, "commentArticle");
            return (Criteria) this;
        }

        public Criteria andCommentArticleBetween(String value1, String value2) {
            addCriterion("comment_article between", value1, value2, "commentArticle");
            return (Criteria) this;
        }

        public Criteria andCommentArticleNotBetween(String value1, String value2) {
            addCriterion("comment_article not between", value1, value2, "commentArticle");
            return (Criteria) this;
        }

        public Criteria andCommentUserIsNull() {
            addCriterion("comment_user is null");
            return (Criteria) this;
        }

        public Criteria andCommentUserIsNotNull() {
            addCriterion("comment_user is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUserEqualTo(String value) {
            addCriterion("comment_user =", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserNotEqualTo(String value) {
            addCriterion("comment_user <>", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserGreaterThan(String value) {
            addCriterion("comment_user >", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserGreaterThanOrEqualTo(String value) {
            addCriterion("comment_user >=", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserLessThan(String value) {
            addCriterion("comment_user <", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserLessThanOrEqualTo(String value) {
            addCriterion("comment_user <=", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserLike(String value) {
            addCriterion("comment_user like", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserNotLike(String value) {
            addCriterion("comment_user not like", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserIn(List<String> values) {
            addCriterion("comment_user in", values, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserNotIn(List<String> values) {
            addCriterion("comment_user not in", values, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserBetween(String value1, String value2) {
            addCriterion("comment_user between", value1, value2, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserNotBetween(String value1, String value2) {
            addCriterion("comment_user not between", value1, value2, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameIsNull() {
            addCriterion("comment_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameIsNotNull() {
            addCriterion("comment_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameEqualTo(String value) {
            addCriterion("comment_user_name =", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameNotEqualTo(String value) {
            addCriterion("comment_user_name <>", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameGreaterThan(String value) {
            addCriterion("comment_user_name >", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("comment_user_name >=", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameLessThan(String value) {
            addCriterion("comment_user_name <", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameLessThanOrEqualTo(String value) {
            addCriterion("comment_user_name <=", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameLike(String value) {
            addCriterion("comment_user_name like", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameNotLike(String value) {
            addCriterion("comment_user_name not like", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameIn(List<String> values) {
            addCriterion("comment_user_name in", values, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameNotIn(List<String> values) {
            addCriterion("comment_user_name not in", values, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameBetween(String value1, String value2) {
            addCriterion("comment_user_name between", value1, value2, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameNotBetween(String value1, String value2) {
            addCriterion("comment_user_name not between", value1, value2, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNull() {
            addCriterion("comment_content is null");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNotNull() {
            addCriterion("comment_content is not null");
            return (Criteria) this;
        }

        public Criteria andCommentContentEqualTo(String value) {
            addCriterion("comment_content =", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotEqualTo(String value) {
            addCriterion("comment_content <>", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThan(String value) {
            addCriterion("comment_content >", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("comment_content >=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThan(String value) {
            addCriterion("comment_content <", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThanOrEqualTo(String value) {
            addCriterion("comment_content <=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLike(String value) {
            addCriterion("comment_content like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotLike(String value) {
            addCriterion("comment_content not like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentIn(List<String> values) {
            addCriterion("comment_content in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotIn(List<String> values) {
            addCriterion("comment_content not in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentBetween(String value1, String value2) {
            addCriterion("comment_content between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotBetween(String value1, String value2) {
            addCriterion("comment_content not between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNull() {
            addCriterion("comment_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNotNull() {
            addCriterion("comment_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeEqualTo(Date value) {
            addCriterion("comment_time =", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotEqualTo(Date value) {
            addCriterion("comment_time <>", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThan(Date value) {
            addCriterion("comment_time >", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_time >=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThan(Date value) {
            addCriterion("comment_time <", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_time <=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIn(List<Date> values) {
            addCriterion("comment_time in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotIn(List<Date> values) {
            addCriterion("comment_time not in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeBetween(Date value1, Date value2) {
            addCriterion("comment_time between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_time not between", value1, value2, "commentTime");
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

        public Criteria andCommentUserPicIsNull() {
            addCriterion("comment_user_pic is null");
            return (Criteria) this;
        }

        public Criteria andCommentUserPicIsNotNull() {
            addCriterion("comment_user_pic is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUserPicEqualTo(String value) {
            addCriterion("comment_user_pic =", value, "commentUserPic");
            return (Criteria) this;
        }

        public Criteria andCommentUserPicNotEqualTo(String value) {
            addCriterion("comment_user_pic <>", value, "commentUserPic");
            return (Criteria) this;
        }

        public Criteria andCommentUserPicGreaterThan(String value) {
            addCriterion("comment_user_pic >", value, "commentUserPic");
            return (Criteria) this;
        }

        public Criteria andCommentUserPicGreaterThanOrEqualTo(String value) {
            addCriterion("comment_user_pic >=", value, "commentUserPic");
            return (Criteria) this;
        }

        public Criteria andCommentUserPicLessThan(String value) {
            addCriterion("comment_user_pic <", value, "commentUserPic");
            return (Criteria) this;
        }

        public Criteria andCommentUserPicLessThanOrEqualTo(String value) {
            addCriterion("comment_user_pic <=", value, "commentUserPic");
            return (Criteria) this;
        }

        public Criteria andCommentUserPicLike(String value) {
            addCriterion("comment_user_pic like", value, "commentUserPic");
            return (Criteria) this;
        }

        public Criteria andCommentUserPicNotLike(String value) {
            addCriterion("comment_user_pic not like", value, "commentUserPic");
            return (Criteria) this;
        }

        public Criteria andCommentUserPicIn(List<String> values) {
            addCriterion("comment_user_pic in", values, "commentUserPic");
            return (Criteria) this;
        }

        public Criteria andCommentUserPicNotIn(List<String> values) {
            addCriterion("comment_user_pic not in", values, "commentUserPic");
            return (Criteria) this;
        }

        public Criteria andCommentUserPicBetween(String value1, String value2) {
            addCriterion("comment_user_pic between", value1, value2, "commentUserPic");
            return (Criteria) this;
        }

        public Criteria andCommentUserPicNotBetween(String value1, String value2) {
            addCriterion("comment_user_pic not between", value1, value2, "commentUserPic");
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