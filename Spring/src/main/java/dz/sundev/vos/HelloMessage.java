package dz.sundev.vos;

public class HelloMessage {
    private String msg = "null msg";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "HelloMessage{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
