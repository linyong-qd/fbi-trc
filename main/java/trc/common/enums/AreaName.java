package trc.common.enums;

import java.util.Hashtable;

/**
 * 对账结果
 */
public enum AreaName implements EnumApp {
    LEFT("01", "生活缴费"),
    EDUCATION("02", "行政教育类"),
    FINANCE("03","金融理财类"),
    ORGANIZACTION("04","第三方支付机构类"),
    OTHER("99","其他");

    private String code = null;
    private String title = null;
    private static Hashtable<String, AreaName> aliasEnums;

    AreaName(String code, String title) {
        this.init(code, title);
    }

    @SuppressWarnings("unchecked")
    private void init(String code, String title) {
        this.code = code;
        this.title = title;
        synchronized (this.getClass()) {
            if (aliasEnums == null) {
                aliasEnums = new Hashtable();
            }
        }
        aliasEnums.put(code, this);
        aliasEnums.put(title, this);
    }

    public static AreaName valueOfAlias(String alias) {
        return aliasEnums.get(alias);
    }

    public String getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }
}
