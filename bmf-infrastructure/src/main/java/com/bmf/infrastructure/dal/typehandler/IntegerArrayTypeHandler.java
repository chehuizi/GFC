package com.bmf.infrastructure.dal.typehandler;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.apache.ibatis.type.JdbcType.VARCHAR;

@MappedTypes(Integer[].class)
@MappedJdbcTypes(value = {VARCHAR})
public class IntegerArrayTypeHandler extends BaseTypeHandler<Integer[]> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Integer[] integers, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, JSON.toJSONString(integers));
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return (Integer[]) JSON.parseArray(resultSet.getString(s), Integer.class).toArray();
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return (Integer[]) JSON.parseArray(resultSet.getString(i), Integer.class).toArray();
    }

    @Override
    public Integer[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return (Integer[]) JSON.parseArray(callableStatement.getString(i), Integer.class).toArray();
    }
}
