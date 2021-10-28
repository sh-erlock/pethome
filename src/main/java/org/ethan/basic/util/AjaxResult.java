package org.ethan.basic.util;

import lombok.Data;

@Data
public class AjaxResult {

    private Boolean success = true;

    private String message = "操作成功";

    private Object resultObj;

    public static AjaxResult me(){
        return new AjaxResult();
    }

   /* public AjaxResult setSuccess(Boolean success) {
        this.success = success;
        return this;
    }*/

    public AjaxResult setMessage(String message) {
        this.success = false;
        this.message = message;
        return this;
    }

    public AjaxResult setResultObj(Object resultObj) {
        this.resultObj = resultObj;
        return this;
    }
}
