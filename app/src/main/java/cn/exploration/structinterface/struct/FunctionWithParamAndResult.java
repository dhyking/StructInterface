package cn.exploration.structinterface.struct;

/**
 * 无参无结果
 * Created by JackDeng on 2017/12/25.
 */

public abstract class FunctionWithParamAndResult<Result,Param> extends Function {
    public FunctionWithParamAndResult(String functionName) {
        super(functionName);
    }

    public abstract Result function(Param param);
}
