package io.nebulas.dapp.pay.common.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Desc: RPC interface return
 * User: nathan
 * Date: 2018-02-07
 */
public class JsonResult implements Serializable {
    private static final long serialVersionUID = -6267859767710893271L;

    private static final Object EMPTY = new Object();

    private Integer code = 200;
    private String msg = "";
    private Object data = EMPTY;

    public JsonResult(StatCode statCode) {
        this.code = statCode.getCode();
        this.msg = statCode.getMsg();
    }

    public static JsonResult success() {
        return new JsonResult(StatCode.SUCCESS);
    }

    public static JsonResult success(Object bean) {
        return success().add(bean);
    }

    public static JsonResult success(String key, Object value) {
        return success().put(key, value);
    }

    public static JsonResult failed() {
        return new JsonResult(StatCode.FAILED);
    }

    public static JsonResult failed(String msg) {
        return failed().setMsg(msg);
    }

    public static JsonResult failed(Integer code, String msg) {
        return failed().setCode(code).setMsg(msg);
    }

    public JsonResult add(Object bean) {
        if (null == bean) {
            return this;
        }

        if (bean instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) bean;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                put(entry.getKey().toString(), entry.getValue());
            }
        } else if (bean instanceof Collection) {
            Collection<?> coll = (Collection<?>) bean;
            getDataAsList().addAll(coll);
        } else if (bean.getClass().isArray()) {
            List<Object> list = getDataAsList();
            int len = Array.getLength(bean);
            for (int i = 0; i < len; i++) {
                list.add(Array.get(bean, i));
            }
        } else if (bean instanceof Number || bean instanceof String || bean instanceof Boolean) {
            if (EMPTY == data) {
                data = bean;
            } else {
                throw new IllegalStateException("cannot add"
                        + bean.getClass().getSimpleName()
                        + " type data into "
                        + data.getClass().getSimpleName()
                        + " type entity");
            }
        } else {
            JSONObject o = (JSONObject) JSON.toJSON(bean);
            getDataAsMap().putAll(o);
        }
        return this;
    }

    @SuppressWarnings({"unchecked"})
    private Map<String, Object> getDataAsMap() {
        if (EMPTY == data) {
            data = new HashMap<String, Object>();
            return (Map<String, Object>) data;
        }
        if (data instanceof Map) {
            return (Map<String, Object>) data;
        }
        throw new IllegalStateException(data.getClass().getSimpleName() + " type is not compatible with Map");
    }

    @SuppressWarnings("unchecked")
    private List<Object> getDataAsList() {
        if (EMPTY == data) {
            data = new ArrayList<Object>();
            return (List<Object>) data;
        }
        if (data instanceof List) {
            return (List<Object>) data;
        }
        throw new IllegalStateException(data.getClass().getSimpleName() + " type is not compatible with List");
    }

    public JsonResult put(String key, Object value) {
        this.getDataAsMap().put(key, value);
        return this;
    }

    public JsonResult putAll(Map<String, Object> map) {
        this.getDataAsMap().putAll(map);
        return this;
    }

    public JsonResult setCode(Integer code) {
        this.code = code;
        return this;
    }

    public JsonResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    enum StatCode {
        SUCCESS(0, "success"), FAILED(1, "");
        private int code;
        private String msg;

        StatCode(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
