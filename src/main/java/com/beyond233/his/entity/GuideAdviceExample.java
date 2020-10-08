package com.beyond233.his.entity;

import java.util.ArrayList;
import java.util.List;

public class GuideAdviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuideAdviceExample() {
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

        public Criteria andAdviceIdIsNull() {
            addCriterion("advice_id is null");
            return (Criteria) this;
        }

        public Criteria andAdviceIdIsNotNull() {
            addCriterion("advice_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceIdEqualTo(Integer value) {
            addCriterion("advice_id =", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdNotEqualTo(Integer value) {
            addCriterion("advice_id <>", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdGreaterThan(Integer value) {
            addCriterion("advice_id >", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("advice_id >=", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdLessThan(Integer value) {
            addCriterion("advice_id <", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("advice_id <=", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdIn(List<Integer> values) {
            addCriterion("advice_id in", values, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdNotIn(List<Integer> values) {
            addCriterion("advice_id not in", values, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdBetween(Integer value1, Integer value2) {
            addCriterion("advice_id between", value1, value2, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("advice_id not between", value1, value2, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceContentIsNull() {
            addCriterion("advice_content is null");
            return (Criteria) this;
        }

        public Criteria andAdviceContentIsNotNull() {
            addCriterion("advice_content is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceContentEqualTo(String value) {
            addCriterion("advice_content =", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentNotEqualTo(String value) {
            addCriterion("advice_content <>", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentGreaterThan(String value) {
            addCriterion("advice_content >", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentGreaterThanOrEqualTo(String value) {
            addCriterion("advice_content >=", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentLessThan(String value) {
            addCriterion("advice_content <", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentLessThanOrEqualTo(String value) {
            addCriterion("advice_content <=", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentLike(String value) {
            addCriterion("advice_content like", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentNotLike(String value) {
            addCriterion("advice_content not like", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentIn(List<String> values) {
            addCriterion("advice_content in", values, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentNotIn(List<String> values) {
            addCriterion("advice_content not in", values, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentBetween(String value1, String value2) {
            addCriterion("advice_content between", value1, value2, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentNotBetween(String value1, String value2) {
            addCriterion("advice_content not between", value1, value2, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(Integer value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(Integer value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(Integer value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(Integer value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<Integer> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<Integer> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andAnsowersIsNull() {
            addCriterion("ansowers is null");
            return (Criteria) this;
        }

        public Criteria andAnsowersIsNotNull() {
            addCriterion("ansowers is not null");
            return (Criteria) this;
        }

        public Criteria andAnsowersEqualTo(String value) {
            addCriterion("ansowers =", value, "ansowers");
            return (Criteria) this;
        }

        public Criteria andAnsowersNotEqualTo(String value) {
            addCriterion("ansowers <>", value, "ansowers");
            return (Criteria) this;
        }

        public Criteria andAnsowersGreaterThan(String value) {
            addCriterion("ansowers >", value, "ansowers");
            return (Criteria) this;
        }

        public Criteria andAnsowersGreaterThanOrEqualTo(String value) {
            addCriterion("ansowers >=", value, "ansowers");
            return (Criteria) this;
        }

        public Criteria andAnsowersLessThan(String value) {
            addCriterion("ansowers <", value, "ansowers");
            return (Criteria) this;
        }

        public Criteria andAnsowersLessThanOrEqualTo(String value) {
            addCriterion("ansowers <=", value, "ansowers");
            return (Criteria) this;
        }

        public Criteria andAnsowersLike(String value) {
            addCriterion("ansowers like", value, "ansowers");
            return (Criteria) this;
        }

        public Criteria andAnsowersNotLike(String value) {
            addCriterion("ansowers not like", value, "ansowers");
            return (Criteria) this;
        }

        public Criteria andAnsowersIn(List<String> values) {
            addCriterion("ansowers in", values, "ansowers");
            return (Criteria) this;
        }

        public Criteria andAnsowersNotIn(List<String> values) {
            addCriterion("ansowers not in", values, "ansowers");
            return (Criteria) this;
        }

        public Criteria andAnsowersBetween(String value1, String value2) {
            addCriterion("ansowers between", value1, value2, "ansowers");
            return (Criteria) this;
        }

        public Criteria andAnsowersNotBetween(String value1, String value2) {
            addCriterion("ansowers not between", value1, value2, "ansowers");
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