package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class DepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepartmentExample() {
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

        public Criteria andDeIdIsNull() {
            addCriterion("DE_Id is null");
            return (Criteria) this;
        }

        public Criteria andDeIdIsNotNull() {
            addCriterion("DE_Id is not null");
            return (Criteria) this;
        }

        public Criteria andDeIdEqualTo(Integer value) {
            addCriterion("DE_Id =", value, "deId");
            return (Criteria) this;
        }

        public Criteria andDeIdNotEqualTo(Integer value) {
            addCriterion("DE_Id <>", value, "deId");
            return (Criteria) this;
        }

        public Criteria andDeIdGreaterThan(Integer value) {
            addCriterion("DE_Id >", value, "deId");
            return (Criteria) this;
        }

        public Criteria andDeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DE_Id >=", value, "deId");
            return (Criteria) this;
        }

        public Criteria andDeIdLessThan(Integer value) {
            addCriterion("DE_Id <", value, "deId");
            return (Criteria) this;
        }

        public Criteria andDeIdLessThanOrEqualTo(Integer value) {
            addCriterion("DE_Id <=", value, "deId");
            return (Criteria) this;
        }

        public Criteria andDeIdIn(List<Integer> values) {
            addCriterion("DE_Id in", values, "deId");
            return (Criteria) this;
        }

        public Criteria andDeIdNotIn(List<Integer> values) {
            addCriterion("DE_Id not in", values, "deId");
            return (Criteria) this;
        }

        public Criteria andDeIdBetween(Integer value1, Integer value2) {
            addCriterion("DE_Id between", value1, value2, "deId");
            return (Criteria) this;
        }

        public Criteria andDeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DE_Id not between", value1, value2, "deId");
            return (Criteria) this;
        }

        public Criteria andDeNameIsNull() {
            addCriterion("DE_Name is null");
            return (Criteria) this;
        }

        public Criteria andDeNameIsNotNull() {
            addCriterion("DE_Name is not null");
            return (Criteria) this;
        }

        public Criteria andDeNameEqualTo(String value) {
            addCriterion("DE_Name =", value, "deName");
            return (Criteria) this;
        }

        public Criteria andDeNameNotEqualTo(String value) {
            addCriterion("DE_Name <>", value, "deName");
            return (Criteria) this;
        }

        public Criteria andDeNameGreaterThan(String value) {
            addCriterion("DE_Name >", value, "deName");
            return (Criteria) this;
        }

        public Criteria andDeNameGreaterThanOrEqualTo(String value) {
            addCriterion("DE_Name >=", value, "deName");
            return (Criteria) this;
        }

        public Criteria andDeNameLessThan(String value) {
            addCriterion("DE_Name <", value, "deName");
            return (Criteria) this;
        }

        public Criteria andDeNameLessThanOrEqualTo(String value) {
            addCriterion("DE_Name <=", value, "deName");
            return (Criteria) this;
        }

        public Criteria andDeNameLike(String value) {
            addCriterion("DE_Name like", value, "deName");
            return (Criteria) this;
        }

        public Criteria andDeNameNotLike(String value) {
            addCriterion("DE_Name not like", value, "deName");
            return (Criteria) this;
        }

        public Criteria andDeNameIn(List<String> values) {
            addCriterion("DE_Name in", values, "deName");
            return (Criteria) this;
        }

        public Criteria andDeNameNotIn(List<String> values) {
            addCriterion("DE_Name not in", values, "deName");
            return (Criteria) this;
        }

        public Criteria andDeNameBetween(String value1, String value2) {
            addCriterion("DE_Name between", value1, value2, "deName");
            return (Criteria) this;
        }

        public Criteria andDeNameNotBetween(String value1, String value2) {
            addCriterion("DE_Name not between", value1, value2, "deName");
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