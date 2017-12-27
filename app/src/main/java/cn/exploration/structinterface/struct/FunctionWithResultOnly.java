package cn.exploration.structinterface.struct;

/**
 * 无参无结果
 * Created by JackDeng on 2017/12/25.
 */

public abstract class FunctionWithResultOnly<Result> extends Function {
    public FunctionWithResultOnly(String functionName) {
        super(functionName);
    }

    public abstract Result function();
}
