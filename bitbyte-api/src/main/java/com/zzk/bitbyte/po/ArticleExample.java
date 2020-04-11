package com.zzk.bitbyte.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(String value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(String value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(String value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(String value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(String value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(String value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLike(String value) {
            addCriterion("article_id like", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotLike(String value) {
            addCriterion("article_id not like", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<String> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<String> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(String value1, String value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(String value1, String value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleUserIsNull() {
            addCriterion("article_user is null");
            return (Criteria) this;
        }

        public Criteria andArticleUserIsNotNull() {
            addCriterion("article_user is not null");
            return (Criteria) this;
        }

        public Criteria andArticleUserEqualTo(String value) {
            addCriterion("article_user =", value, "articleUser");
            return (Criteria) this;
        }

        public Criteria andArticleUserNotEqualTo(String value) {
            addCriterion("article_user <>", value, "articleUser");
            return (Criteria) this;
        }

        public Criteria andArticleUserGreaterThan(String value) {
            addCriterion("article_user >", value, "articleUser");
            return (Criteria) this;
        }

        public Criteria andArticleUserGreaterThanOrEqualTo(String value) {
            addCriterion("article_user >=", value, "articleUser");
            return (Criteria) this;
        }

        public Criteria andArticleUserLessThan(String value) {
            addCriterion("article_user <", value, "articleUser");
            return (Criteria) this;
        }

        public Criteria andArticleUserLessThanOrEqualTo(String value) {
            addCriterion("article_user <=", value, "articleUser");
            return (Criteria) this;
        }

        public Criteria andArticleUserLike(String value) {
            addCriterion("article_user like", value, "articleUser");
            return (Criteria) this;
        }

        public Criteria andArticleUserNotLike(String value) {
            addCriterion("article_user not like", value, "articleUser");
            return (Criteria) this;
        }

        public Criteria andArticleUserIn(List<String> values) {
            addCriterion("article_user in", values, "articleUser");
            return (Criteria) this;
        }

        public Criteria andArticleUserNotIn(List<String> values) {
            addCriterion("article_user not in", values, "articleUser");
            return (Criteria) this;
        }

        public Criteria andArticleUserBetween(String value1, String value2) {
            addCriterion("article_user between", value1, value2, "articleUser");
            return (Criteria) this;
        }

        public Criteria andArticleUserNotBetween(String value1, String value2) {
            addCriterion("article_user not between", value1, value2, "articleUser");
            return (Criteria) this;
        }

        public Criteria andArticleReadIsNull() {
            addCriterion("article_read is null");
            return (Criteria) this;
        }

        public Criteria andArticleReadIsNotNull() {
            addCriterion("article_read is not null");
            return (Criteria) this;
        }

        public Criteria andArticleReadEqualTo(Long value) {
            addCriterion("article_read =", value, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadNotEqualTo(Long value) {
            addCriterion("article_read <>", value, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadGreaterThan(Long value) {
            addCriterion("article_read >", value, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadGreaterThanOrEqualTo(Long value) {
            addCriterion("article_read >=", value, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadLessThan(Long value) {
            addCriterion("article_read <", value, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadLessThanOrEqualTo(Long value) {
            addCriterion("article_read <=", value, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadIn(List<Long> values) {
            addCriterion("article_read in", values, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadNotIn(List<Long> values) {
            addCriterion("article_read not in", values, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadBetween(Long value1, Long value2) {
            addCriterion("article_read between", value1, value2, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleReadNotBetween(Long value1, Long value2) {
            addCriterion("article_read not between", value1, value2, "articleRead");
            return (Criteria) this;
        }

        public Criteria andArticleStateIsNull() {
            addCriterion("article_state is null");
            return (Criteria) this;
        }

        public Criteria andArticleStateIsNotNull() {
            addCriterion("article_state is not null");
            return (Criteria) this;
        }

        public Criteria andArticleStateEqualTo(Integer value) {
            addCriterion("article_state =", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateNotEqualTo(Integer value) {
            addCriterion("article_state <>", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateGreaterThan(Integer value) {
            addCriterion("article_state >", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_state >=", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateLessThan(Integer value) {
            addCriterion("article_state <", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateLessThanOrEqualTo(Integer value) {
            addCriterion("article_state <=", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateIn(List<Integer> values) {
            addCriterion("article_state in", values, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateNotIn(List<Integer> values) {
            addCriterion("article_state not in", values, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateBetween(Integer value1, Integer value2) {
            addCriterion("article_state between", value1, value2, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateNotBetween(Integer value1, Integer value2) {
            addCriterion("article_state not between", value1, value2, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeIsNull() {
            addCriterion("article_publish_time is null");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeIsNotNull() {
            addCriterion("article_publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeEqualTo(Date value) {
            addCriterion("article_publish_time =", value, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeNotEqualTo(Date value) {
            addCriterion("article_publish_time <>", value, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeGreaterThan(Date value) {
            addCriterion("article_publish_time >", value, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("article_publish_time >=", value, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeLessThan(Date value) {
            addCriterion("article_publish_time <", value, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("article_publish_time <=", value, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeIn(List<Date> values) {
            addCriterion("article_publish_time in", values, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeNotIn(List<Date> values) {
            addCriterion("article_publish_time not in", values, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeBetween(Date value1, Date value2) {
            addCriterion("article_publish_time between", value1, value2, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticlePublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("article_publish_time not between", value1, value2, "articlePublishTime");
            return (Criteria) this;
        }

        public Criteria andArticleTagsIsNull() {
            addCriterion("article_tags is null");
            return (Criteria) this;
        }

        public Criteria andArticleTagsIsNotNull() {
            addCriterion("article_tags is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTagsEqualTo(String value) {
            addCriterion("article_tags =", value, "articleTags");
            return (Criteria) this;
        }

        public Criteria andArticleTagsNotEqualTo(String value) {
            addCriterion("article_tags <>", value, "articleTags");
            return (Criteria) this;
        }

        public Criteria andArticleTagsGreaterThan(String value) {
            addCriterion("article_tags >", value, "articleTags");
            return (Criteria) this;
        }

        public Criteria andArticleTagsGreaterThanOrEqualTo(String value) {
            addCriterion("article_tags >=", value, "articleTags");
            return (Criteria) this;
        }

        public Criteria andArticleTagsLessThan(String value) {
            addCriterion("article_tags <", value, "articleTags");
            return (Criteria) this;
        }

        public Criteria andArticleTagsLessThanOrEqualTo(String value) {
            addCriterion("article_tags <=", value, "articleTags");
            return (Criteria) this;
        }

        public Criteria andArticleTagsLike(String value) {
            addCriterion("article_tags like", value, "articleTags");
            return (Criteria) this;
        }

        public Criteria andArticleTagsNotLike(String value) {
            addCriterion("article_tags not like", value, "articleTags");
            return (Criteria) this;
        }

        public Criteria andArticleTagsIn(List<String> values) {
            addCriterion("article_tags in", values, "articleTags");
            return (Criteria) this;
        }

        public Criteria andArticleTagsNotIn(List<String> values) {
            addCriterion("article_tags not in", values, "articleTags");
            return (Criteria) this;
        }

        public Criteria andArticleTagsBetween(String value1, String value2) {
            addCriterion("article_tags between", value1, value2, "articleTags");
            return (Criteria) this;
        }

        public Criteria andArticleTagsNotBetween(String value1, String value2) {
            addCriterion("article_tags not between", value1, value2, "articleTags");
            return (Criteria) this;
        }

        public Criteria andArticlePartIsNull() {
            addCriterion("article_part is null");
            return (Criteria) this;
        }

        public Criteria andArticlePartIsNotNull() {
            addCriterion("article_part is not null");
            return (Criteria) this;
        }

        public Criteria andArticlePartEqualTo(Integer value) {
            addCriterion("article_part =", value, "articlePart");
            return (Criteria) this;
        }

        public Criteria andArticlePartNotEqualTo(Integer value) {
            addCriterion("article_part <>", value, "articlePart");
            return (Criteria) this;
        }

        public Criteria andArticlePartGreaterThan(Integer value) {
            addCriterion("article_part >", value, "articlePart");
            return (Criteria) this;
        }

        public Criteria andArticlePartGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_part >=", value, "articlePart");
            return (Criteria) this;
        }

        public Criteria andArticlePartLessThan(Integer value) {
            addCriterion("article_part <", value, "articlePart");
            return (Criteria) this;
        }

        public Criteria andArticlePartLessThanOrEqualTo(Integer value) {
            addCriterion("article_part <=", value, "articlePart");
            return (Criteria) this;
        }

        public Criteria andArticlePartIn(List<Integer> values) {
            addCriterion("article_part in", values, "articlePart");
            return (Criteria) this;
        }

        public Criteria andArticlePartNotIn(List<Integer> values) {
            addCriterion("article_part not in", values, "articlePart");
            return (Criteria) this;
        }

        public Criteria andArticlePartBetween(Integer value1, Integer value2) {
            addCriterion("article_part between", value1, value2, "articlePart");
            return (Criteria) this;
        }

        public Criteria andArticlePartNotBetween(Integer value1, Integer value2) {
            addCriterion("article_part not between", value1, value2, "articlePart");
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

        public Criteria andArticleSummaryIsNull() {
            addCriterion("article_summary is null");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryIsNotNull() {
            addCriterion("article_summary is not null");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryEqualTo(String value) {
            addCriterion("article_summary =", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryNotEqualTo(String value) {
            addCriterion("article_summary <>", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryGreaterThan(String value) {
            addCriterion("article_summary >", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("article_summary >=", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryLessThan(String value) {
            addCriterion("article_summary <", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryLessThanOrEqualTo(String value) {
            addCriterion("article_summary <=", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryLike(String value) {
            addCriterion("article_summary like", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryNotLike(String value) {
            addCriterion("article_summary not like", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryIn(List<String> values) {
            addCriterion("article_summary in", values, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryNotIn(List<String> values) {
            addCriterion("article_summary not in", values, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryBetween(String value1, String value2) {
            addCriterion("article_summary between", value1, value2, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryNotBetween(String value1, String value2) {
            addCriterion("article_summary not between", value1, value2, "articleSummary");
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