package trc.common.enums;

import java.util.Hashtable;

/**
 * 对账结果
 */
public enum RuleType implements EnumApp {
    MERCHANT("1", "收款单位"),
    PERSON("2", "对公账号");

    private String code = null;
    private String title = null;
    private static Hashtable<String, RuleType> aliasEnums;

    RuleType(String code, String title) {
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

    public static RuleType valueOfAlias(String alias) {
        return aliasEnums.get(alias);
    }

    public String getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }
}
