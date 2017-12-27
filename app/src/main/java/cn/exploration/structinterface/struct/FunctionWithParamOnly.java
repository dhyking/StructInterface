package cn.exploration.structinterface.struct;

/**
 * 无参无结果
 * Created by JackDeng on 2017/12/25.
 */

public abstract class FunctionWithParamOnly<Param> extends Function {
    public FunctionWithParamOnly(String functionName) {
        super(functionName);
    }

    public abstract void function(Param param);
}
