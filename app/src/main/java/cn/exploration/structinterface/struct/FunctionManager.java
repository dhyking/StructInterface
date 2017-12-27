package cn.exploration.structinterface.struct;

import android.text.TextUtils;

import java.util.HashMap;

/**
 * Created by JackDeng on 2017/12/25.
 */

public class FunctionManager {
    private static FunctionManager instance;

    public FunctionManager() {
        noParamNoResultHashMap = new HashMap<>();
        withParamOnlyHashMap = new HashMap<>();
        withResultOnlyHashMap = new HashMap<>();
        functionWithParamAndResultHashMap = new HashMap<>();
    }

    public static FunctionManager getInstance(){
        if (instance == null) {
            instance = new FunctionManager();
        }
        return instance;
    }

    private HashMap<String,FunctionNoParamNoResult> noParamNoResultHashMap;
    private HashMap<String,FunctionWithParamOnly> withParamOnlyHashMap;
    private HashMap<String,FunctionWithResultOnly> withResultOnlyHashMap;
    private HashMap<String,FunctionWithParamAndResult> functionWithParamAndResultHashMap;

    public FunctionManager addFunction(FunctionNoParamNoResult function) {
        noParamNoResultHashMap.put(function.functionName,function);
        return this;
    }

    public FunctionManager addFunction(FunctionWithResultOnly function) {
        withResultOnlyHashMap.put(function.functionName,function);
        return this;
    }

    public FunctionManager addFunction(FunctionWithParamOnly function) {
        withParamOnlyHashMap.put(function.functionName,function);
        return this;
    }

    public FunctionManager addFunction(FunctionWithParamAndResult function) {
        functionWithParamAndResultHashMap.put(function.functionName,function);
        return this;
    }

    public void invokeFunction(String functionName) {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }
        if (noParamNoResultHashMap != null) {
            FunctionNoParamNoResult functionNoParamNoResult = noParamNoResultHashMap.get(functionName);
            if (functionNoParamNoResult != null) {
                functionNoParamNoResult.function();
            } else {
                try {
                    throw new FunctionException("Has no function:"+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public <Result> Result invokeFunction(String functionName,Class<Result> cls) {
        if (TextUtils.isEmpty(functionName)) {
            return null;
        }

        if (withResultOnlyHashMap != null) {
            FunctionWithResultOnly functionWithResultOnly = withResultOnlyHashMap.get(functionName);
            if (functionWithResultOnly != null) {
                if (cls != null) {
                    return cls.cast(functionWithResultOnly.function());
                } else {
                    return (Result) functionWithResultOnly.function();
                }
            } else {
                try {
                    throw new FunctionException("Has no function:"+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public <Param> void invokeFunction(String functionName,Param param) {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }

        if (withParamOnlyHashMap != null) {
            FunctionWithParamOnly functionWithParamOnly = withParamOnlyHashMap.get(functionName);
            if (functionWithParamOnly != null) {
                functionWithParamOnly.function(param);
            } else {
                try {
                    throw new FunctionException("Has no function:"+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public <Param,Result> Result invokeFunction(String functionName,Param param,Class<Result> cls) {
        if (TextUtils.isEmpty(functionName)) {
            return null;
        }
        if (functionWithParamAndResultHashMap != null) {
            FunctionWithParamAndResult functionWithParamAndResult = functionWithParamAndResultHashMap.get(functionName);
            if (functionWithParamAndResult != null) {
                if (cls != null) {
                    return cls.cast(functionWithParamAndResult.function(param));
                } else {
                    return (Result) functionWithParamAndResult.function(param);
                }
            } else {
                try {
                    throw new FunctionException("Has no function:"+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
