package com.zzk.bitbyte.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andMsgIdIsNull() {
            addCriterion("msg_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNotNull() {
            addCriterion("msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIdEqualTo(String value) {
            addCriterion("msg_id =", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotEqualTo(String value) {
            addCriterion("msg_id <>", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThan(String value) {
            addCriterion("msg_id >", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThanOrEqualTo(String value) {
            addCriterion("msg_id >=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThan(String value) {
            addCriterion("msg_id <", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThanOrEqualTo(String value) {
            addCriterion("msg_id <=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLike(String value) {
            addCriterion("msg_id like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotLike(String value) {
            addCriterion("msg_id not like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdIn(List<String> values) {
            addCriterion("msg_id in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotIn(List<String> values) {
            addCriterion("msg_id not in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdBetween(String value1, String value2) {
            addCriterion("msg_id between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotBetween(String value1, String value2) {
            addCriterion("msg_id not between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNull() {
            addCriterion("msg_content is null");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNotNull() {
            addCriterion("msg_content is not null");
            return (Criteria) this;
        }

        public Criteria andMsgContentEqualTo(String value) {
            addCriterion("msg_content =", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotEqualTo(String value) {
            addCriterion("msg_content <>", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThan(String value) {
            addCriterion("msg_content >", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThanOrEqualTo(String value) {
            addCriterion("msg_content >=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThan(String value) {
            addCriterion("msg_content <", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThanOrEqualTo(String value) {
            addCriterion("msg_content <=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLike(String value) {
            addCriterion("msg_content like", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotLike(String value) {
            addCriterion("msg_content not like", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentIn(List<String> values) {
            addCriterion("msg_content in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotIn(List<String> values) {
            addCriterion("msg_content not in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentBetween(String value1, String value2) {
            addCriterion("msg_content between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotBetween(String value1, String value2) {
            addCriterion("msg_content not between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserIsNull() {
            addCriterion("msg_from_user is null");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserIsNotNull() {
            addCriterion("msg_from_user is not null");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserEqualTo(String value) {
            addCriterion("msg_from_user =", value, "msgFromUser");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserNotEqualTo(String value) {
            addCriterion("msg_from_user <>", value, "msgFromUser");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserGreaterThan(String value) {
            addCriterion("msg_from_user >", value, "msgFromUser");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserGreaterThanOrEqualTo(String value) {
            addCriterion("msg_from_user >=", value, "msgFromUser");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserLessThan(String value) {
            addCriterion("msg_from_user <", value, "msgFromUser");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserLessThanOrEqualTo(String value) {
            addCriterion("msg_from_user <=", value, "msgFromUser");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserLike(String value) {
            addCriterion("msg_from_user like", value, "msgFromUser");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserNotLike(String value) {
            addCriterion("msg_from_user not like", value, "msgFromUser");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserIn(List<String> values) {
            addCriterion("msg_from_user in", values, "msgFromUser");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserNotIn(List<String> values) {
            addCriterion("msg_from_user not in", values, "msgFromUser");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserBetween(String value1, String value2) {
            addCriterion("msg_from_user between", value1, value2, "msgFromUser");
            return (Criteria) this;
        }

        public Criteria andMsgFromUserNotBetween(String value1, String value2) {
            addCriterion("msg_from_user not between", value1, value2, "msgFromUser");
            return (Criteria) this;
        }

        public Criteria andMsgToUserIsNull() {
            addCriterion("msg_to_user is null");
            return (Criteria) this;
        }

        public Criteria andMsgToUserIsNotNull() {
            addCriterion("msg_to_user is not null");
            return (Criteria) this;
        }

        public Criteria andMsgToUserEqualTo(String value) {
            addCriterion("msg_to_user =", value, "msgToUser");
            return (Criteria) this;
        }

        public Criteria andMsgToUserNotEqualTo(String value) {
            addCriterion("msg_to_user <>", value, "msgToUser");
            return (Criteria) this;
        }

        public Criteria andMsgToUserGreaterThan(String value) {
            addCriterion("msg_to_user >", value, "msgToUser");
            return (Criteria) this;
        }

        public Criteria andMsgToUserGreaterThanOrEqualTo(String value) {
            addCriterion("msg_to_user >=", value, "msgToUser");
            return (Criteria) this;
        }

        public Criteria andMsgToUserLessThan(String value) {
            addCriterion("msg_to_user <", value, "msgToUser");
            return (Criteria) this;
        }

        public Criteria andMsgToUserLessThanOrEqualTo(String value) {
            addCriterion("msg_to_user <=", value, "msgToUser");
            return (Criteria) this;
        }

        public Criteria andMsgToUserLike(String value) {
            addCriterion("msg_to_user like", value, "msgToUser");
            return (Criteria) this;
        }

        public Criteria andMsgToUserNotLike(String value) {
            addCriterion("msg_to_user not like", value, "msgToUser");
            return (Criteria) this;
        }

        public Criteria andMsgToUserIn(List<String> values) {
            addCriterion("msg_to_user in", values, "msgToUser");
            return (Criteria) this;
        }

        public Criteria andMsgToUserNotIn(List<String> values) {
            addCriterion("msg_to_user not in", values, "msgToUser");
            return (Criteria) this;
        }

        public Criteria andMsgToUserBetween(String value1, String value2) {
            addCriterion("msg_to_user between", value1, value2, "msgToUser");
            return (Criteria) this;
        }

        public Criteria andMsgToUserNotBetween(String value1, String value2) {
            addCriterion("msg_to_user not between", value1, value2, "msgToUser");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeIsNull() {
            addCriterion("msg_send_time is null");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeIsNotNull() {
            addCriterion("msg_send_time is not null");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeEqualTo(Date value) {
            addCriterion("msg_send_time =", value, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeNotEqualTo(Date value) {
            addCriterion("msg_send_time <>", value, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeGreaterThan(Date value) {
            addCriterion("msg_send_time >", value, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("msg_send_time >=", value, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeLessThan(Date value) {
            addCriterion("msg_send_time <", value, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("msg_send_time <=", value, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeIn(List<Date> values) {
            addCriterion("msg_send_time in", values, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeNotIn(List<Date> values) {
            addCriterion("msg_send_time not in", values, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeBetween(Date value1, Date value2) {
            addCriterion("msg_send_time between", value1, value2, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("msg_send_time not between", value1, value2, "msgSendTime");
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

        public Criteria andUdpateatIsNull() {
            addCriterion("udpateAt is null");
            return (Criteria) this;
        }

        public Criteria andUdpateatIsNotNull() {
            addCriterion("udpateAt is not null");
            return (Criteria) this;
        }

        public Criteria andUdpateatEqualTo(Date value) {
            addCriterion("udpateAt =", value, "udpateat");
            return (Criteria) this;
        }

        public Criteria andUdpateatNotEqualTo(Date value) {
            addCriterion("udpateAt <>", value, "udpateat");
            return (Criteria) this;
        }

        public Criteria andUdpateatGreaterThan(Date value) {
            addCriterion("udpateAt >", value, "udpateat");
            return (Criteria) this;
        }

        public Criteria andUdpateatGreaterThanOrEqualTo(Date value) {
            addCriterion("udpateAt >=", value, "udpateat");
            return (Criteria) this;
        }

        public Criteria andUdpateatLessThan(Date value) {
            addCriterion("udpateAt <", value, "udpateat");
            return (Criteria) this;
        }

        public Criteria andUdpateatLessThanOrEqualTo(Date value) {
            addCriterion("udpateAt <=", value, "udpateat");
            return (Criteria) this;
        }

        public Criteria andUdpateatIn(List<Date> values) {
            addCriterion("udpateAt in", values, "udpateat");
            return (Criteria) this;
        }

        public Criteria andUdpateatNotIn(List<Date> values) {
            addCriterion("udpateAt not in", values, "udpateat");
            return (Criteria) this;
        }

        public Criteria andUdpateatBetween(Date value1, Date value2) {
            addCriterion("udpateAt between", value1, value2, "udpateat");
            return (Criteria) this;
        }

        public Criteria andUdpateatNotBetween(Date value1, Date value2) {
            addCriterion("udpateAt not between", value1, value2, "udpateat");
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