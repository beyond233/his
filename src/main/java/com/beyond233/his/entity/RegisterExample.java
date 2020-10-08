package com.beyond233.his.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RegisterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegisterExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRegisterIdIsNull() {
            addCriterion("register_id is null");
            return (Criteria) this;
        }

        public Criteria andRegisterIdIsNotNull() {
            addCriterion("register_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterIdEqualTo(Integer value) {
            addCriterion("register_id =", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdNotEqualTo(Integer value) {
            addCriterion("register_id <>", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdGreaterThan(Integer value) {
            addCriterion("register_id >", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("register_id >=", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdLessThan(Integer value) {
            addCriterion("register_id <", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdLessThanOrEqualTo(Integer value) {
            addCriterion("register_id <=", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdIn(List<Integer> values) {
            addCriterion("register_id in", values, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdNotIn(List<Integer> values) {
            addCriterion("register_id not in", values, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdBetween(Integer value1, Integer value2) {
            addCriterion("register_id between", value1, value2, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("register_id not between", value1, value2, "registerId");
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

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(Integer value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(Integer value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(Integer value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(Integer value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<Integer> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<Integer> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNull() {
            addCriterion("register_date is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNotNull() {
            addCriterion("register_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateEqualTo(Date value) {
            addCriterionForJDBCDate("register_date =", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("register_date <>", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThan(Date value) {
            addCriterionForJDBCDate("register_date >", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("register_date >=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThan(Date value) {
            addCriterionForJDBCDate("register_date <", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("register_date <=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIn(List<Date> values) {
            addCriterionForJDBCDate("register_date in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("register_date not in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("register_date between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("register_date not between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterPriceIsNull() {
            addCriterion("register_price is null");
            return (Criteria) this;
        }

        public Criteria andRegisterPriceIsNotNull() {
            addCriterion("register_price is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterPriceEqualTo(Double value) {
            addCriterion("register_price =", value, "registerPrice");
            return (Criteria) this;
        }

        public Criteria andRegisterPriceNotEqualTo(Double value) {
            addCriterion("register_price <>", value, "registerPrice");
            return (Criteria) this;
        }

        public Criteria andRegisterPriceGreaterThan(Double value) {
            addCriterion("register_price >", value, "registerPrice");
            return (Criteria) this;
        }

        public Criteria andRegisterPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("register_price >=", value, "registerPrice");
            return (Criteria) this;
        }

        public Criteria andRegisterPriceLessThan(Double value) {
            addCriterion("register_price <", value, "registerPrice");
            return (Criteria) this;
        }

        public Criteria andRegisterPriceLessThanOrEqualTo(Double value) {
            addCriterion("register_price <=", value, "registerPrice");
            return (Criteria) this;
        }

        public Criteria andRegisterPriceIn(List<Double> values) {
            addCriterion("register_price in", values, "registerPrice");
            return (Criteria) this;
        }

        public Criteria andRegisterPriceNotIn(List<Double> values) {
            addCriterion("register_price not in", values, "registerPrice");
            return (Criteria) this;
        }

        public Criteria andRegisterPriceBetween(Double value1, Double value2) {
            addCriterion("register_price between", value1, value2, "registerPrice");
            return (Criteria) this;
        }

        public Criteria andRegisterPriceNotBetween(Double value1, Double value2) {
            addCriterion("register_price not between", value1, value2, "registerPrice");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountIsNull() {
            addCriterion("register_amount is null");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountIsNotNull() {
            addCriterion("register_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountEqualTo(Integer value) {
            addCriterion("register_amount =", value, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountNotEqualTo(Integer value) {
            addCriterion("register_amount <>", value, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountGreaterThan(Integer value) {
            addCriterion("register_amount >", value, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("register_amount >=", value, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountLessThan(Integer value) {
            addCriterion("register_amount <", value, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountLessThanOrEqualTo(Integer value) {
            addCriterion("register_amount <=", value, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountIn(List<Integer> values) {
            addCriterion("register_amount in", values, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountNotIn(List<Integer> values) {
            addCriterion("register_amount not in", values, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountBetween(Integer value1, Integer value2) {
            addCriterion("register_amount between", value1, value2, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("register_amount not between", value1, value2, "registerAmount");
            return (Criteria) this;
        }

        public Criteria andRegisterBalanceIsNull() {
            addCriterion("register_balance is null");
            return (Criteria) this;
        }

        public Criteria andRegisterBalanceIsNotNull() {
            addCriterion("register_balance is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterBalanceEqualTo(Integer value) {
            addCriterion("register_balance =", value, "registerBalance");
            return (Criteria) this;
        }

        public Criteria andRegisterBalanceNotEqualTo(Integer value) {
            addCriterion("register_balance <>", value, "registerBalance");
            return (Criteria) this;
        }

        public Criteria andRegisterBalanceGreaterThan(Integer value) {
            addCriterion("register_balance >", value, "registerBalance");
            return (Criteria) this;
        }

        public Criteria andRegisterBalanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("register_balance >=", value, "registerBalance");
            return (Criteria) this;
        }

        public Criteria andRegisterBalanceLessThan(Integer value) {
            addCriterion("register_balance <", value, "registerBalance");
            return (Criteria) this;
        }

        public Criteria andRegisterBalanceLessThanOrEqualTo(Integer value) {
            addCriterion("register_balance <=", value, "registerBalance");
            return (Criteria) this;
        }

        public Criteria andRegisterBalanceIn(List<Integer> values) {
            addCriterion("register_balance in", values, "registerBalance");
            return (Criteria) this;
        }

        public Criteria andRegisterBalanceNotIn(List<Integer> values) {
            addCriterion("register_balance not in", values, "registerBalance");
            return (Criteria) this;
        }

        public Criteria andRegisterBalanceBetween(Integer value1, Integer value2) {
            addCriterion("register_balance between", value1, value2, "registerBalance");
            return (Criteria) this;
        }

        public Criteria andRegisterBalanceNotBetween(Integer value1, Integer value2) {
            addCriterion("register_balance not between", value1, value2, "registerBalance");
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