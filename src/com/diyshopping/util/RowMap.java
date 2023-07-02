package com.diyshopping.util;

import java.sql.ResultSet;

public interface RowMap<T> {
    T rowMapping(ResultSet rs);
}
