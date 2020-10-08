package com.beyond233.his.entity;

import java.util.ArrayList;
import java.util.List;

public class GuideSymptomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuideSymptomExample() {
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

        public Criteria andSymptomIdIsNull() {
            addCriterion("symptom_id is null");
            return (Criteria) this;
        }

        public Criteria andSymptomIdIsNotNull() {
            addCriterion("symptom_id is not null");
            return (Criteria) this;
        }

        public Criteria andSymptomIdEqualTo(Integer value) {
            addCriterion("symptom_id =", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdNotEqualTo(Integer value) {
            addCriterion("symptom_id <>", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdGreaterThan(Integer value) {
            addCriterion("symptom_id >", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("symptom_id >=", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdLessThan(Integer value) {
            addCriterion("symptom_id <", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdLessThanOrEqualTo(Integer value) {
            addCriterion("symptom_id <=", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdIn(List<Integer> values) {
            addCriterion("symptom_id in", values, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdNotIn(List<Integer> values) {
            addCriterion("symptom_id not in", values, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdBetween(Integer value1, Integer value2) {
            addCriterion("symptom_id between", value1, value2, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("symptom_id not between", value1, value2, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomNameIsNull() {
            addCriterion("symptom_name is null");
            return (Criteria) this;
        }

        public Criteria andSymptomNameIsNotNull() {
            addCriterion("symptom_name is not null");
            return (Criteria) this;
        }

        public Criteria andSymptomNameEqualTo(String value) {
            addCriterion("symptom_name =", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameNotEqualTo(String value) {
            addCriterion("symptom_name <>", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameGreaterThan(String value) {
            addCriterion("symptom_name >", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameGreaterThanOrEqualTo(String value) {
            addCriterion("symptom_name >=", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameLessThan(String value) {
            addCriterion("symptom_name <", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameLessThanOrEqualTo(String value) {
            addCriterion("symptom_name <=", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameLike(String value) {
            addCriterion("symptom_name like", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameNotLike(String value) {
            addCriterion("symptom_name not like", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameIn(List<String> values) {
            addCriterion("symptom_name in", values, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameNotIn(List<String> values) {
            addCriterion("symptom_name not in", values, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameBetween(String value1, String value2) {
            addCriterion("symptom_name between", value1, value2, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameNotBetween(String value1, String value2) {
            addCriterion("symptom_name not between", value1, value2, "symptomName");
            return (Criteria) this;
        }

        public Criteria andBodypartIdIsNull() {
            addCriterion("bodypart_id is null");
            return (Criteria) this;
        }

        public Criteria andBodypartIdIsNotNull() {
            addCriterion("bodypart_id is not null");
            return (Criteria) this;
        }

        public Criteria andBodypartIdEqualTo(Integer value) {
            addCriterion("bodypart_id =", value, "bodypartId");
            return (Criteria) this;
        }

        public Criteria andBodypartIdNotEqualTo(Integer value) {
            addCriterion("bodypart_id <>", value, "bodypartId");
            return (Criteria) this;
        }

        public Criteria andBodypartIdGreaterThan(Integer value) {
            addCriterion("bodypart_id >", value, "bodypartId");
            return (Criteria) this;
        }

        public Criteria andBodypartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bodypart_id >=", value, "bodypartId");
            return (Criteria) this;
        }

        public Criteria andBodypartIdLessThan(Integer value) {
            addCriterion("bodypart_id <", value, "bodypartId");
            return (Criteria) this;
        }

        public Criteria andBodypartIdLessThanOrEqualTo(Integer value) {
            addCriterion("bodypart_id <=", value, "bodypartId");
            return (Criteria) this;
        }

        public Criteria andBodypartIdIn(List<Integer> values) {
            addCriterion("bodypart_id in", values, "bodypartId");
            return (Criteria) this;
        }

        public Criteria andBodypartIdNotIn(List<Integer> values) {
            addCriterion("bodypart_id not in", values, "bodypartId");
            return (Criteria) this;
        }

        public Criteria andBodypartIdBetween(Integer value1, Integer value2) {
            addCriterion("bodypart_id between", value1, value2, "bodypartId");
            return (Criteria) this;
        }

        public Criteria andBodypartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bodypart_id not between", value1, value2, "bodypartId");
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