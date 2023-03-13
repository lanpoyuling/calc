package org.example;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;
import org.exception.DataException;

import java.util.Iterator;

/**
 * 四则运算式子解析器
 */
public class Parser {
    /**
     * 加操作符
     */
    public static final String ADD_SYMBOL = "+";
    /**
     * 减操作符
     */
    public static final String SUBTRACT_SYMBOL = "-";
    /**
     * 乘操作符
     */
    public static final String MULTIPLY_SYMBOL = "*";
    /**
     * 除操作符
     */
    public static final String DIVIDE_SYMBOL = "/";

    /**
     * 解析方法
     *
     * @param input 待解析字符
     * @return 左操作数 操作符 右操作数
     */
    public static String[] parseStr(String input) {
        String[] result = new String[3];
        if (StringUtils.isBlank(input)) {
            throw new DataException("输入信息为空");
        }
        //除去前后空格
        String trim = StringUtils.trim(input);
        Iterable<String> split = Splitter.on(" ").split(trim);
        Iterator<String> iterator = split.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            result[i] = iterator.next();
            i++;
            //处理下标越界
            if (2 == i) {
                result[i] = iterator.next();
                break;
            }
        }

        return result;
    }
}
