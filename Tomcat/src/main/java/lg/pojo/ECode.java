package lg.pojo;

/**
 * 状态码 枚举类
 */
public enum ECode implements OP {

    OK() {
        @Override
        public Integer code() {
            return 200;
        }
    },
    NOT_DATA {
        public Integer code() {
            return 203;
        }
    },

}

interface OP {
    Integer code();
}
